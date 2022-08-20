package com.juggernauts.todoapp.utils;

import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 * git branch: Twitter_API
 *
 * Twitter4J/ wrapper for Twitter API V2
 * Tweet object POSTs tweet to share ToDoApp
 * for Team Juggernaut, by way of Habit.ual
 */

public class Tweet {

    public Tweet(){}

    public String tw = "I stay on task with the ToDoApp from Habit.ual. Download the app today!";


    public String shareApp(String tw){

        System.out.println();
        System.out.println("*************** TWEET in Progress *********************");

        String API_KEY = "foo";
        String API_KEY_SECRET ="foo";
        String ACCESS_TOKEN = "foo-bar";
        String ACCESS_TOKEN_SECRET = "foo";

        try {
            twitter4j.Twitter twitter = new TwitterFactory().getInstance();

            // twitter.setOAuthConsumer(API_KEY, API_KEY_SECRET);

            AccessToken accessToken = new AccessToken(ACCESS_TOKEN, ACCESS_TOKEN_SECRET);

            twitter.setOAuthAccessToken(accessToken);

            twitter.updateStatus(tw);
            System.out.println();
            System.out.println("Successfully updated the status in Twitter.");
        } catch (TwitterException te) {
            te.printStackTrace();
        }
        return "Successfully updated the status in Twitter.";
    }
}