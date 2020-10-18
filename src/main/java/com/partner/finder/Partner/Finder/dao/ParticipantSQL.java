package com.partner.finder.Partner.Finder.dao;

import com.partner.finder.Partner.Finder.model.Participant;
import com.partner.finder.Partner.Finder.model.Project;
import com.partner.finder.Partner.Finder.model.Skill;
import org.springframework.stereotype.Repository;

import javax.servlet.http.Part;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

@Repository("sqlDao")
public class ParticipantSQL implements ParticipantDao {
    private Connection conn;

    // For add project
    private static final String ADD_PROJECT = "INSERT INTO Projects VALUES(?, ?)";
    private static final String GET_PROJECT_COUNT = "SELECT COUNT(*) FROM Projects";
    private static final String ADD_SKILL = "INSERT INTO Skills(projectID, name) VALUES(?,?)";
    private PreparedStatement addProjectStatement;
    private PreparedStatement getProjectCountStatement;
    private PreparedStatement addSkillStatement;

    // For add participant
    private static final String ADD_PARTICIPANT = "INSERT INTO Participants(projectID, name, contact, skills, " +
            "message, hashed_password, salt) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private PreparedStatement addParticipantStatement;

    // For get participant
    private static final String GET_PARTICIPANT = "SELECT * FROM Participants AS P WHERE P.projectID = ?";
    private static final String GET_SKILL = "SELECT * FROM Skills AS S WHERE S.id = ?";
    private PreparedStatement getParticipantStatement;
    private PreparedStatement getSkillStatement;

    // For get skill
    private static final String GET_PROJECT_SKILLS = "SELECT * FROM Skills AS S WHERE S.projectID = ?";
    private PreparedStatement getProjectSkillsStatement;

    // For delete participant
    private static final String DELETE_PARTICIPANT = "DELETE FROM Participants WHERE id = ?";
    private static final String GET_PARTICIPANT_BY_ID = "SELECT * FROM Participants WHERE id = ?";
    private PreparedStatement deleteParticipantStatement;
    private PreparedStatement getParticipantByIDStatement;

    public ParticipantSQL() throws SQLException, IOException {
        this(null, null, null, null);
    }

    protected ParticipantSQL(String serverURL, String dbName, String adminName, String password)
            throws SQLException, IOException {
        conn = serverURL == null ? openConnectionFromDbConn()
                : openConnectionFromCredential(serverURL, dbName, adminName, password);

        prepareStatements();
    }

    protected static Connection openConnectionFromCredential(String serverURL, String dbName,
                                                             String adminName, String password) throws SQLException {
        String connectionUrl =
                String.format("jdbc:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s", serverURL,
                        dbName, adminName, password);
        Connection conn = DriverManager.getConnection(connectionUrl);

        // By default, automatically commit after each statement
        conn.setAutoCommit(true);

        // By default, set the transaction isolation level to serializable
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

        return conn;
    }

    public static Connection openConnectionFromDbConn() throws SQLException, IOException {
        // Connect to the database with the provided connection configuration
        Properties configProps = new Properties();
        configProps.load(new FileInputStream("src/main/resources/dbconn.properties"));
        String serverURL = configProps.getProperty("finderapp.server_url");
        String dbName = configProps.getProperty("finderapp.database_name");
        String adminName = configProps.getProperty("finderapp.username");
        String password = configProps.getProperty("finderapp.password");
        return openConnectionFromCredential(serverURL, dbName, adminName, password);
    }

    private void prepareStatements() throws SQLException {
        addProjectStatement = conn.prepareStatement(ADD_PROJECT);
        getProjectCountStatement = conn.prepareStatement(GET_PROJECT_COUNT);
        addSkillStatement = conn.prepareStatement(ADD_SKILL);
        addParticipantStatement = conn.prepareStatement(ADD_PARTICIPANT);
        getParticipantStatement = conn.prepareStatement(GET_PARTICIPANT);
        getSkillStatement = conn.prepareStatement(GET_SKILL);
        getProjectSkillsStatement = conn.prepareStatement(GET_PROJECT_SKILLS);
        deleteParticipantStatement = conn.prepareStatement(DELETE_PARTICIPANT);
        getParticipantByIDStatement = conn.prepareStatement(GET_PARTICIPANT_BY_ID);
    }

    @Override
    public int addProject(Project project) {
        try {
            ResultSet results = getProjectCountStatement.executeQuery();
            results.next();
            int id = results.getInt(1);
            results.close();

            addProjectStatement.clearParameters();
            addProjectStatement.setInt(1, id);
            addProjectStatement.setString(2, project.getName());
            addProjectStatement.execute();

            for(Skill skill : project.getSkills()) {
                addSkillStatement.clearParameters();
                addSkillStatement.setInt(1, id);
                System.out.println(skill.name);
                addSkillStatement.setString(2, skill.name);
                addSkillStatement.execute();
            }

            return id;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void addParticipant(int projectID, Participant participant) {
        try {
            String skills = "";
            for(Skill skill : participant.getSkills()) {
                skills = skills + " [" + skill.id + "]";
            }

            addParticipantStatement.clearParameters();
            addParticipantStatement.setInt(1, projectID);
            addParticipantStatement.setString(2, participant.getName());
            addParticipantStatement.setString(3, participant.getContact());
            addParticipantStatement.setString(4, skills);
            addParticipantStatement.setString(5, participant.getMessage());
            addParticipantStatement.setString(6, participant.getHashedPassword());
            addParticipantStatement.setString(7, participant.getSalt());

            addParticipantStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Skill> getSkills(String skills) throws SQLException {
        List<String> strArr = new ArrayList<>();
        Scanner scan = new Scanner(skills);
        while (scan.hasNext()) {
            String str = scan.next();
            str = str.substring(1, str.length() - 1);
            strArr.add(str);
        }
        List<Skill> skillList = new ArrayList<>();
        for (String skillIDStr : strArr) {
            int skillID = Integer.parseInt(skillIDStr);
            getSkillStatement.clearParameters();
            getSkillStatement.setInt(1, skillID);

            ResultSet result = getSkillStatement.executeQuery();
            if (! result.next()) {
                throw new IllegalStateException("Skill does not exist!");
            }
            String skillName = result.getString("name");
            int projectID = result.getInt("projectID");
            skillList.add(new Skill(skillID, projectID, skillName));
        }
        return skillList;
    }

    @Override
    public List<Participant> getParticipants(int projectID, List<Integer> skills) {
        List<Participant> participants = new ArrayList<>();
        try {
            getParticipantStatement.clearParameters();
            getParticipantStatement.setInt(1, projectID);
            ResultSet results = getParticipantStatement.executeQuery();
            // id, project id, name, contact, skills, message, hashed password, salt
            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                String contact = results.getString("contact");
                List<Skill> skillList = getSkills(results.getString("skills"));
                String message = results.getString("message");
                String salt = results.getString("salt");
                boolean isValid = true;
                if (skills != null) {
                    for (int skill : skills) {
                        boolean contains = false;
                        for (Skill s : skillList) {
                            if (s.id == skill) {
                                contains = true;
                                break;
                            }
                        }
                        if (!contains) {
                            isValid = false;
                            break;
                        }
                    }
                }
                if (isValid) {
                    participants.add(new Participant(id, name, contact, skillList, message, salt));
                }
            }
            return participants;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Skill> getSkills(int projectID) {
        // id, projectID, name
        List<Skill> skills = new ArrayList<>();
        try {
            getProjectSkillsStatement.clearParameters();
            getProjectSkillsStatement.setInt(2, projectID);
            ResultSet results = getProjectSkillsStatement.executeQuery();

            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                skills.add(new Skill(id, projectID, name));
            }
            return skills;
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return null;
    }

    @Override
    public int deleteParticipant(int participantID, String hashedPassword) {
        try {
            getParticipantByIDStatement.clearParameters();
            getParticipantByIDStatement.setInt(1, participantID);
            ResultSet result = getParticipantByIDStatement.executeQuery();

            if (result.getString("hashed_password").equals(hashedPassword)) {
                deleteParticipantStatement.clearParameters();
                deleteParticipantStatement.setInt(1, participantID);
                deleteParticipantStatement.execute();
                return 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return 0;
    }
}