package com.partner.finder.Partner.Finder.dao;

import com.partner.finder.Partner.Finder.Skill;
import com.partner.finder.Partner.Finder.model.Participant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("sqlDao")
public class ParticipantSQL implements ParticipantDao {

    private static int participantIDCounter = 0;
    private static List<Participant> DB = new ArrayList<>();

    @Override
    public boolean addParticipant(String firstName, String lastName, String email, List<Skill> skills, String message) {
        DB.add(new Participant(participantIDCounter, firstName, lastName, email, skills, message));
        participantIDCounter += 1;
        return true;
    }

    @Override
    public List<Participant> selectAllParticipants() {
        return DB;
    }
}