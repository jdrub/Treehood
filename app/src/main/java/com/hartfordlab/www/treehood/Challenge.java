package com.hartfordlab.www.treehood;

import java.io.Serializable;

public class Challenge implements Serializable {
    private static final long serialVersionUID = -1842602681461211027L;

    public static final int COMPLETED = 0;
    public static final int IN_PROGRESS = 1;
    public static final int NOT_STARTED = 2;

    private String name;
    private int progress;
    private String description;


    public Challenge(String nameIn, int progressIn, String descriptionIn){
        //TODO: take in an image as a parameter maybe
        name = nameIn;
        progress = progressIn;
        description = descriptionIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
