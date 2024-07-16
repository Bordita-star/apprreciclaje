package com.example.reciclajeapp;

public class Reward {
    private String rewardDescription;
    private int requiredPoints;

    public Reward(String rewardDescription, int requiredPoints) {
        this.rewardDescription = rewardDescription;
        this.requiredPoints = requiredPoints;
    }

    public String getRewardDescription() {
        return rewardDescription;
    }

    public void setRewardDescription(String rewardDescription) {
        this.rewardDescription = rewardDescription;
    }

    public int getRequiredPoints() {
        return requiredPoints;
    }

    public void setRequiredPoints(int requiredPoints) {
        this.requiredPoints = requiredPoints;
    }
}
