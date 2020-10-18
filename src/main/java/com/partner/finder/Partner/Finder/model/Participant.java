package com.partner.finder.Partner.Finder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.partner.finder.Partner.Finder.Skill;

import java.util.*;

public class Participant {
    private final int id;
    private final String name;
    private final String email;
    private final List<Skill> skills;
    private final String message;

    public Participant(@JsonProperty("id") int id,
                       @JsonProperty("name") String name,
                       @JsonProperty("email") String email,
                       @JsonProperty("skills") List<Skill> skills,
                       @JsonProperty("message") String message) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.skills = skills;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public String getMessage() {
        return message;
    }

    public int getID() {
        return id;
    }
}
