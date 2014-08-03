package com.hartfordlab.www.treehood;

import java.util.ArrayList;
import static android.support.v4.app.ActivityCompat.startActivity;

public class ServerManager {
    //TODO: define private csv file here

    public ServerManager(){

        //TODO: open the csv file here
    }

    public User login(String username,String password,DataManager dataManager){
        return dataManager.getUsers().get(0);
    /*    ArrayList<User> users = dataManager.getUsers();
        for(User u: users){
            if(u.getName().equals(username) && u.comparePassword(password)){
                return u;
            }
        }

        return null;*/
    }


}
