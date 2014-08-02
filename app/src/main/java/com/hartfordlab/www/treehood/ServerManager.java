package com.hartfordlab.www.treehood;


import java.util.ArrayList;

public class ServerManager {

    public ServerManager(){

    }

    public User login(String username, String password){
        //TODO: Actually hitup firebase and get real user credentials
        Tree t = new Tree();
        String address = "7405 Cliffbourne Ct.";
        int score = 1;
        ArrayList<Challenge> challenges = new ArrayList<Challenge>();
        return new User(t,username,address,score,challenges);
    }


}
