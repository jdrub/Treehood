package com.hartfordlab.www.treehood;

import java.util.ArrayList;
import static android.support.v4.app.ActivityCompat.startActivity;

public class ServerManager {
    //TODO: define private csv file here

    public ServerManager(){

        //TODO: open the csv file here
    }

    public User login(String username,String password){
        //TODO: pull user from a locally-stored queue, or return null if user doesn't exist
        String treeName = "Mill Creek";
        String address = "7405 Cliffbourne Ct.";
        int score = 2;
        ArrayList<Challenge> challenges = new ArrayList<Challenge>();
        challenges.add(new Challenge("Recycling Challenge",Challenge.IN_PROGRESS,
                "Collect 100 used/empty bottles!"));
        return new User(treeName,username,password,address,score,challenges);
    }


}
