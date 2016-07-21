package com.concussionconnect.concussionproject;

/**
 * Created by annamcabee on 4/7/15.
 */
public class Symptom {
    private String name;
    private int score;
    public Symptom(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        return name;
    }
}
