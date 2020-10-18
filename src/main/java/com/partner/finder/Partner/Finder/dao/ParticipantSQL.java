package com.partner.finder.Partner.Finder.dao;

import com.partner.finder.Partner.Finder.model.Participant;
import com.partner.finder.Partner.Finder.model.Project;
import com.partner.finder.Partner.Finder.model.Skill;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Repository("sqlDao")
public class ParticipantSQL implements ParticipantDao {
    private Connection conn;

    private static final String ADD_PROJECT = "INSERT INTO Projects VALUES(?, ?)";
    private static final String GET_PROJECT_COUNT = "SELECT COUNT(*) FROM Projects";
    private static final String ADD_SKILL = "INSERT INTO Skills(projectID, name) VALUES(?,?)";
    private PreparedStatement addProjectStatement;
    private PreparedStatement getProjectCountStatement;
    private PreparedStatement addSkillStatement;

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
                addSkillStatement.setString(2, skill.skill);
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

    }

    @Override
    public List<Participant> getParticipants(int projectID, List<Integer> skills) {
        return null;
    }

    @Override
    public List<Skill> getSkills(int projectID) {
        return null;
    }

    @Override
    public int deleteParticipant(int projectID, int participantID, String hashedPassword) {
        return 1;
    }

//    private static List<Participant> DB = new ArrayList<>();
//
//    @Override
//    public boolean addParticipant(Participant participant) {
//        DB.add(participant);
//        return true;
//    }
//
//    @Override
//    public List<Participant> selectAllParticipants() {
//        return DB;
//    }
//
//    @Override
//    public List<Participant> getParticipants(int projectID, List<Integer> skills) {
//        return DB;
//    }


}