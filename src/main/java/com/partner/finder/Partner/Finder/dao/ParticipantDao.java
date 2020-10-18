package com.partner.finder.Partner.Finder.dao;

import com.partner.finder.Partner.Finder.model.Participant;
import java.util.List;

public interface ParticipantDao {

    boolean addParticipant(Participant participant);

    List<Participant> selectAllParticipants();

    public List<Participant> getParticipants(int projectID, List<Integer> skills);
}