package com.partner.finder.Partner.Finder.dao;

import com.partner.finder.Partner.Finder.model.Participant;
import com.partner.finder.Partner.Finder.model.Project;
import com.partner.finder.Partner.Finder.model.Skill;

import java.util.List;

public interface ParticipantDao {

    int addProject(Project project);

    void addParticipant(int projectID, Participant participant);

    public List<Participant> getParticipants(int projectID, List<Integer> skills);

    List<Skill> getSkills(int projectID);

    int deleteParticipant(int projectID, int participantID, String hashedPassword);


}