package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    // TODO: Steps 4 & 8 - Declare member variables here:
    public StoryEvent[] storyEvents = new StoryEvent[]{
            new StoryEvent(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new StoryEvent(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new StoryEvent(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2)
    };

    public EndingEvent[] endingEvents = new EndingEvent[]{
            new EndingEvent(R.string.T4_End),
            new EndingEvent(R.string.T5_End),
            new EndingEvent(R.string.T6_End),
    };

    private Button firstChoiceBtn;
    private Button secondChoiceBtn;
    private TextView storyTextView;

    private int index;
    private int previousIndex;
    private int endIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            index=savedInstanceState.getInt("indexKey");
            if(index==2){
                index=0;
                previousIndex=0;
                endIndex=0;
            }
            else {
                previousIndex = savedInstanceState.getInt("previousIndexKey");
                endIndex = savedInstanceState.getInt("endIndexKey");
            }
        }
        else {
            index=0;
            previousIndex=0;
            endIndex=0;
        }
        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        firstChoiceBtn = (Button)findViewById(R.id.buttonTop);
        secondChoiceBtn = (Button)findViewById(R.id.buttonBottom);

        //Initializing Story TextView//
        storyTextView = (TextView)findViewById(R.id.storyTextView);
        //Setting the first Story Event in TextView//
        storyTextView.setText(storyEvents[index].getStoryEventId());

        //Setting the buttons text
        firstChoiceBtn.setText(storyEvents[index].getFirstAnswerId());
        secondChoiceBtn.setText(storyEvents[index].getSecondQuestionId());




        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        firstChoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateStory(false);
            }
        });
        secondChoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateStory(true);
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:


    }
    public void UpdateStory(boolean answer){
        switch (index){
            case 0:{
                if(answer){
                    previousIndex = index;
                    index = 1;
                }
                else {
                    previousIndex = index;
                    index = 2;
                }

                storyTextView.setText(storyEvents[index].getStoryEventId());

                firstChoiceBtn.setText(storyEvents[index].getFirstAnswerId());
                secondChoiceBtn.setText(storyEvents[index].getSecondQuestionId());
                break;
            }
            case 1:{
                if(answer){
                    endIndex = 0;

                    storyTextView.setText(endingEvents[endIndex].getEndingEventId());

                    firstChoiceBtn.setVisibility(View.INVISIBLE);
                    secondChoiceBtn.setVisibility(View.INVISIBLE);
                }
                else {
                    previousIndex = index;
                    index = 2;

                    storyTextView.setText(storyEvents[index].getStoryEventId());

                    firstChoiceBtn.setText(storyEvents[index].getFirstAnswerId());
                    secondChoiceBtn.setText(storyEvents[index].getSecondQuestionId());
                }
                break;
            }
            case 2:{
                if(previousIndex ==0){
                    if(answer){
                        endIndex = 1;
                    }
                    else {
                        endIndex=2;
                    }
                }
                else {
                    if(answer){
                        endIndex=1;
                    }
                    else {
                        endIndex=2;
                    }
                }
                storyTextView.setText(endingEvents[endIndex].getEndingEventId());
                firstChoiceBtn.setVisibility(View.INVISIBLE);
                secondChoiceBtn.setVisibility(View.INVISIBLE);
                break;
            }

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("indexKey",index);
        outState.putInt("endIndexKey",endIndex);
        outState.putInt("previousIndexKey",previousIndex);
    }
}
