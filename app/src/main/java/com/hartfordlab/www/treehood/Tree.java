package com.hartfordlab.www.treehood;

// A 'Tree' is a group == neighborhood

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Tree implements Serializable{
    private static final long serialVersionUID = 4935962796334302233L;
    private ArrayList<User> users;
    private ArrayList<Challenge> challenges;

    public Tree(){
        users = new ArrayList<User>();
        challenges = new ArrayList<Challenge>();
    }


}
