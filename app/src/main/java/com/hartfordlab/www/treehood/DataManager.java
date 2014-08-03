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
        users.add(new User("StoneLeigh", "Jeff", "password4", "316 Murdock Road",  0, new ArrayList<Challenge>()));
        users.add(new User("StoneLeigh", "Paul", "password5", "401 Stevenson Lane",  1, new ArrayList<Challenge>()));
        users.add(new User("StoneLeigh", "foo", "foo", "7405 cliffborne ct",  0, new ArrayList<Challenge>()));
        challenges.add(new Challenge("FLY WITH AN E-TICKET", Challenge.NOT_STARTED, "The cost of processing a paper ticket is approximately $10, while processing " +
                "an e-ticket costs only $1. In the near future, e-tickets will be the only option, saving the airline industry $3 billion a year. In addition to financial " +
                "savings, the sheer amount of paper eliminated by this process is commendable."));
        challenges.add(new Challenge("GREENER LAWN CARE", Challenge.NOT_STARTED, "If you must water your lawn, do it early in the morning before any moisture is lost to evaporation. " +
                "Have a few weeds? Spot treat them with vinegar. Not sure if you should rake? Normal " +
                "clippings act as a natural fertilizer, let them be. If you've waited too long, rake by hand — it's excellent exercise."));
        challenges.add(new Challenge("TELECOMMUTE", Challenge.NOT_STARTED, "See if you can work out an arrangement with your employer that you work from home for some portion of the week." +
                " Not only will you save money and gasoline, and you get to work in your pajamas!"));
        challenges.add(new Challenge("GIVE IT AWAY", Challenge.NOT_STARTED, "Before you throw something away, think about if someone else might need it. Either donate to a charitable organization or " +
                "post it on a web site designed to connect people and things, such as Freecycle.org."));
        challenges.add(new Challenge("GO TO A CAR WASH", Challenge.NOT_STARTED, "Professional car washes are often more efficient with water consumption. If everyone in the U.S. who washes their" +
                " car themselves took just one visit to the car wash we could save nearly 8.7 billion gallons of water."));
        challenges.add(new Challenge("USE RECHARGABLE BATTERIES", Challenge.NOT_STARTED, "Each year 15 billion batteries produced and sold and most of them are disposable alkaline batteries. " +
                "Only a fraction of those are recycled. Buy a charger and a few sets of rechargeable batteries. Although it requires an upfront investment, it is one that should pay off in no time. " +
                "And on Christmas morning when all the stores are closed? You'll be fully stocked."));
        challenges.add(new Challenge("CHANGE YOUR LIGHT", Challenge.NOT_STARTED, "If every household in the United State replaced one regular lightbulb with one of those new compact fluorescent" +
                " bulbs, the pollution reduction would be equivalent to removing one million cars from the road.\n" +
                "\n" +
                "Don't like the color of light? Use these bulbs for closets, laundry rooms and other places where it won't irk you as much."));

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
        users.get(5).returnChallenges().add(challenges.get(3).clone());
        users.get(5).returnChallenges().add(challenges.get(4).clone());

        Tree knollwood = new Tree("Knollwood");
        Tree stoneleigh = new Tree("StoneLeigh");
        for(int i = 0; i < 3; i ++){
            knollwood.addUsers(users.get(i).clone());
        }
        stoneleigh.addUsers(users.get(3).clone());
        stoneleigh.addUsers(users.get(4).clone());


        trees.add(stoneleigh);
        trees.add(knollwood);

    }

    public Tree getTree(String name){
        for(Tree t: trees){
            if(t.getName().equals(name))
                return t;
        }
        return null;
    }


    public Challenge getChallenge(String name){
        for(int i = 0; i < challenges.size(); i++){
            if(challenges.get(i).getName().equals(name))
                return challenges.get(i);
        }
        return null;
    }

}
