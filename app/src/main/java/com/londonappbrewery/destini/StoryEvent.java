package com.londonappbrewery.destini;

/**
 * Created by Ahashan on 29-Oct-17.
 */

public class StoryEvent {
    private int storyEventId;
    private int firstAnswerId;
    private int secondQuestionId;

    public StoryEvent(int storyEventId, int firstAnswerId, int secondQuestionId) {
        this.storyEventId = storyEventId;
        this.firstAnswerId = firstAnswerId;
        this.secondQuestionId = secondQuestionId;
    }

    public int getStoryEventId() {
        return storyEventId;
    }

    public void setStoryEventId(int storyEventId) {
        this.storyEventId = storyEventId;
    }

    public void setFirstAnswerId(int firstAnswerId) {
        this.firstAnswerId = firstAnswerId;
    }

    public void setSecondQuestionId(int secondQuestionId) {
        this.secondQuestionId = secondQuestionId;
    }

    public int getFirstAnswerId() {
        return firstAnswerId;
    }

    public int getSecondQuestionId() {
        return secondQuestionId;
    }
}
