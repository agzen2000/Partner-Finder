package com.partner.finder.Partner.Finder.model;

public class Skill {
    public int id;
    public int projectID;
    public String skill;

    public Skill(int id, int projectID, String skill) {
        this.projectID = projectID;
        this.skill = skill;
        this.id = id;
    }
}
