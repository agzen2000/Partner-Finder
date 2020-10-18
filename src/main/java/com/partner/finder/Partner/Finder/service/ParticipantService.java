package com.partner.finder.Partner.Finder.service;

import com.partner.finder.Partner.Finder.Skill;
import com.partner.finder.Partner.Finder.dao.ParticipantDao;
import com.partner.finder.Partner.Finder.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    private final ParticipantDao participantDao;

    @Autowired
    public ParticipantService(@Qualifier("sqlDao") ParticipantDao participantDao) {
        this.participantDao = participantDao;
    }

    public boolean addParticipant(String firstName, String lastName, String email, List<Skill> skills, String message) {
        return participantDao.addParticipant(new Participant(participantIDCounter, firstName, lastName, email, skills, message));
    }

    public List<Participant> getAllParticipants() {
        return participantDao.selectAllParticipants();
    }
}