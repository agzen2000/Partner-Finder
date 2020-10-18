package com.partner.finder.Partner.Finder.dao;

import com.partner.finder.Partner.Finder.model.Participant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("sqlDao")
public class ParticipantSQL implements ParticipantDao {

    private static List<Participant> DB = new ArrayList<>();

    @Override
    public boolean addParticipant(Participant participant) {
        DB.add(participant);
        return true;
    }

    @Override
    public List<Participant> selectAllParticipants() {
        return DB;
    }

    @Override
    public List<Participant> getParticipants(int projectID, List<Integer> skills) {
        return DB;
    }
}