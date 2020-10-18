package com.partner.finder.Partner.Finder.api;

import com.partner.finder.Partner.Finder.model.Participant;
import com.partner.finder.Partner.Finder.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MyController {

    private final ParticipantService participantService;

    public MyController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    public void addParticipant(Participant participant) {
        participant.addParticipant(participant);
    }

    public List<Participant> getAllParticipants() {
        return participantService.getAllParticipants();
    }
}

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }
}