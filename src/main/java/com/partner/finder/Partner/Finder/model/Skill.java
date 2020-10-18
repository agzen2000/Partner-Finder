package com.partner.finder.Partner.Finder.model;

public class Skill {
    public int id;
    public int projectID;
    public String name;

    public Skill(int id, int projectID, String name) {
        this.projectID = projectID;
        this.name = name;
        this.id = id;
    }
}
