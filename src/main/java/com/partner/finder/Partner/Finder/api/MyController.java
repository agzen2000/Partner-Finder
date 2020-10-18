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
        return participantDao.addProject(project);
    }

    @GetMapping(path = "/skills")
    public List<Skill> getSkills(@RequestParam int projectID) {
        return participantDao.getSkills(projectID);
    }

    @PostMapping(path = "/add")
    public void addParticipant(@RequestParam int projectID, @RequestBody Participant participant) {
        participantDao.addParticipant(projectID, participant);
    }

    @GetMapping(path = "/participants")
    public List<Participant> getParticipants(@RequestParam int projectID,
                                             @RequestParam(required = false) List<Integer> skills) {
        return participantDao.getParticipants(projectID, skills);
    }

    @DeleteMapping(path = "/delete")
    public int deleteParticipant(@RequestParam int projectID,
                                 @RequestParam int participantID,
                                 @RequestParam String hashedPassword) {
        return participantDao.deleteParticipant(projectID, participantID, hashedPassword);
    }

}