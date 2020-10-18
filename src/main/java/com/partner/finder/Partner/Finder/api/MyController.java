package com.partner.finder.Partner.Finder.api;

import com.partner.finder.Partner.Finder.dao.ParticipantDao;
import com.partner.finder.Partner.Finder.model.Skill;
import com.partner.finder.Partner.Finder.model.Participant;
import com.partner.finder.Partner.Finder.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RequestMapping("api")
@RestController
public class MyController {

    private final ParticipantDao participantDao;

    @Autowired
    public MyController(@Qualifier("sqlDao") ParticipantDao participantDao) {
        this.participantDao = participantDao;
    }

    @PostMapping(path = "/project")
    public int createProject(@RequestBody Project project) {
        return 1;
    }

    @GetMapping(path = "/skills")
    public List<Skill> getSkills(@RequestParam int projectID) {
        LinkedList<Skill> dummyList = new LinkedList<>();
        dummyList.add(new Skill(1, 1 , "Java"));
        dummyList.add(new Skill(2, 1, "C"));
        return dummyList;
    }

    @PostMapping(path = "/add")
    public void addParticipant(@RequestParam int projectID, @RequestBody Participant participant) {
        participantDao.addParticipant(participant);
    }

    @GetMapping(path = "/participants")
    public List<Participant> getParticipants(@RequestParam int projectID,
                                             @RequestParam(required = false) List<Integer> skills) {
        System.out.println(projectID);
        System.out.println(skills);
        return participantDao.getParticipants(projectID, skills);
    }
}