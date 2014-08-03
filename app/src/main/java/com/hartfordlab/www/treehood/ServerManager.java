package com.hartfordlab.www.treehood;

import java.util.ArrayList;

public class ServerManager {
    //TODO: define private csv file here

    public ServerManager(){

        //TODO: open the csv file here
    }

    public User login(String username,String password,DataManager dataManager){

        ArrayList<User> users = dataManager.getUsers();
        System.out.println("j_: input: " + username + ", " + password);
        for(User u: users){
            System.out.println("j_: comparing " + u.getName());
            if(u.getName().equals(username) && u.comparePassword(password)){
                return u;
            }
        }

        return null;
    }


}
