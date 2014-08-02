package com.hartfordlab.www.treehood;

// A 'Tree' is a group == neighborhood

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Tree implements Serializable{
    private static final long serialVersionUID = 4935962796334302233L;

    private String name;
    private ArrayList<User> users;
    private ArrayList<Challenge> challenges;
    private int score;

    public Tree(String nameIn){
        name = nameIn;
        users = new ArrayList<User>();
        challenges = new ArrayList<Challenge>();
        score = 0;
    }

    public Tree clone(){
        return new Tree(name);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(ArrayList<Challenge> challenges) {
        this.challenges = challenges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addUsers(User user){
        users.add(user);
    }
    public boolean removeUsers(User user){
        if(users.contains(user)) {
            users.remove(user);
            return true;
        }
        return false;
    }

    public void addChallenge(Challenge c){
        challenges.add(c);
    }

    public boolean removeChallenge(Challenge c){
        if(challenges.contains(c)) {
            challenges.remove(c);
            return true;
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
