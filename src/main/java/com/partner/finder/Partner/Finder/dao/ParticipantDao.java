package com.partner.finder.Partner.Finder.dao;

import com.partner.finder.Partner.Finder.Skill;
import com.partner.finder.Partner.Finder.model.Participant;

import java.util.List;
import java.util.UUID;

public interface ParticipantDao {

//    public static int idCounter = 0;

    boolean addParticipant(Participant participant);
//    boolean addParticipant(String firstName, String lastName, String email, List<Skill> skills, String message);

    List<Participant> selectAllParticipants();
}