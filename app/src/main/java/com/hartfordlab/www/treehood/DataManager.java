package com.hartfordlab.www.treehood;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by will on 8/2/14.
 */
public class DataManager {
    ArrayList<Challenge> challenges;
    ArrayList<Tree> trees;
    ArrayList<User> users;

    public DataManager() {
        challenges = new ArrayList<Challenge>();
        trees = new ArrayList<Tree>();
        users = new ArrayList<User>();
    }

    public ArrayList<Challenge> getChallenges() {
        return challenges;
    }

    public ArrayList<Tree> getTrees() {
        return trees;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    //populates ArrayLists with new hardcoded data
    public void generateData(){

        users.add(new User("Knollwood", "Will", "password1", "312 Worthington Road",  0, new ArrayList<Challenge>()));
        users.add(new User("Knollwood", "Josh", "password2", "7405 Cliffbourne Court",  2, new ArrayList<Challenge>()));
        users.add(new User("Knollwood", "Jon", "password3", "315 Weatherbee Road",  3, new ArrayList<Challenge>()));
        users.add(new User("Stoneleigh", "Jeff", "password4", "316 Murdock Road",  0, new ArrayList<Challenge>()));
        users.add(new User("Stoneleigh", "Paul", "password5", "401 Stevenson Lane",  1, new ArrayList<Challenge>()));
        users.add(new User("StoneLeigh", "foo", "foo", "7405 cliffborne ct",  0, new ArrayList<Challenge>()));
        challenges.add(new Challenge("Recycle 100 cans", Challenge.NOT_STARTED, "Recycling helps keep waste out of landfills"));
        challenges.add(new Challenge("Plant one tree", Challenge.NOT_STARTED, "Photosynthetic organisms provide us with some of the oxygen we need to live"));
        challenges.add(new Challenge("Get a rebate on new green appliances", Challenge.NOT_STARTED, "Using less water reduces your carbon footprint."));
        challenges.add(new Challenge("Install solar panels", Challenge.NOT_STARTED, "Solar panels are an investment; they cost a lot at first, but save you money over time."));
        challenges.add(new Challenge("Clean up garbage in a nearby stream", Challenge.NOT_STARTED, "Humans can be careless sometimes, and occasionally they need others to pick up after them."));
        challenges.add(new Challenge("Spend time by the bay", Challenge.NOT_STARTED, "It never hurts to be reconnected with nature, no matter how brief."));

        users.get(0).returnChallenges().add(challenges.get(0).clone());
        users.get(0).returnChallenges().add(challenges.get(3).clone());
        users.get(1).returnChallenges().add(challenges.get(4).clone());
        users.get(1).returnChallenges().add(challenges.get(0).clone());
        users.get(2).returnChallenges().add(challenges.get(3).clone());
        users.get(2).returnChallenges().add(challenges.get(0).clone());
        users.get(3).returnChallenges().add(challenges.get(0).clone());
        users.get(3).returnChallenges().add(challenges.get(4).clone());
        users.get(4).returnChallenges().add(challenges.get(3).clone());
        users.get(4).returnChallenges().add(challenges.get(4).clone());

        Tree knollwood = new Tree("Knollwood");
        Tree stoneleigh = new Tree("Knollwood");
        for(int i = 0; i < 3; i ++){
            knollwood.addUsers(users.get(i).clone());
        }
        stoneleigh.addUsers(users.get(3).clone());
        stoneleigh.addUsers(users.get(4).clone());


        trees.add(stoneleigh);
        trees.add(knollwood);

    }

    public Challenge getChallenge(String name){
        for(int i = 0; i < challenges.size(); i++){
            if(challenges.get(i).getName().equals(name))
                return challenges.get(i);
        }
        return null;
    }

}
