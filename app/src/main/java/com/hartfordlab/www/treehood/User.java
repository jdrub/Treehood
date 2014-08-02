package com.hartfordlab.www.treehood;


import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private static final long serialVersionUID = -1320487862009050313L;
    private String treeName; // the group/neighborhood that they live in
    private String name;
    private String address;
    private int score;
    private ArrayList<Challenge> challenges;
    private String password;

    public User(String treeNameIn, String nameIn,String passwordIn, String addressIn, int scoreIn,
                ArrayList<Challenge> challengesIn){
        treeName = treeNameIn;
        name = nameIn;
        address = addressIn;
        score = scoreIn;
        challenges = challengesIn;
        password = passwordIn;

    }

    public User clone(){
        return new User(treeName, name, password, address, score, new ArrayList<Challenge>(challenges));
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addChallenge(Challenge c){
        challenges.add(c);
    }

    public void addToScore(int toAdd){
        score += toAdd;
    }

    public ArrayList<Challenge> returnChallenges(){
        return challenges;
    }







}
