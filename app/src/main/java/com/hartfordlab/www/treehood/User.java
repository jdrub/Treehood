package com.hartfordlab.www.treehood;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private static final long serialVersionUID = -1320487862009050313L;
    private Tree tree; // the group/neighborhood that they live in
    private String name;
    private String address;
    private int score;
    private ArrayList<Challenge> challenges;

    public User(Tree treeIn, String nameIn, String addressIn, int scoreIn,
                ArrayList<Challenge> challengesIn){
        //TODO: actually create user
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
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



}
