package com.partner.finder.Partner.Finder.api;

import com.partner.finder.Partner.Finder.Skill;
import com.partner.finder.Partner.Finder.model.Participant;
import com.partner.finder.Partner.Finder.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/participant")
@RestController
public class MyController {

    private final ParticipantService participantService;

    @Autowired
    public MyController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping
    public void addParticipant(@RequestBody Participant participant) {
        participantService.addParticipant(participant);
    }
//    @PostMapping
//    public void addParticipant(String firs, String email, List<Skill> skills, String message) {
//        participantService.addParticipant(firstName, lastName, email, skills, message);
//    }
    @GetMapping
    public List<Participant> getAllParticipants() {
        return participantService.getAllParticipants();
    }
}