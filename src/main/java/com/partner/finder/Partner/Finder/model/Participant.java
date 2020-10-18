package com.partner.finder.Partner.Finder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Participant {
    private final int id;
    private final String name;
    private final String contact;
    private final List<Skill> skills;
    private final String message;

    private final String hashedPassword;
    private final String salt;

    public Participant(@JsonProperty("id") int id,
                       @JsonProperty("name") String name,
                       @JsonProperty("contact") String contact,
                       @JsonProperty("skills") List<Skill> skills,
                       @JsonProperty("message") String message,
                       @JsonProperty("password") String password,
                       @JsonProperty("salt") String salt) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.skills = skills;
        this.message = message;
        this.hashedPassword = password;
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
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

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getSalt() {
        return salt;
    }
}
