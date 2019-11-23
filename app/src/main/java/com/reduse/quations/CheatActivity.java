package com.reduse.quations;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends LoggingActivity {

    private static final String KEY_CORRECT_ANSWER ="key_correct_answer";
    private static final String KEY_CORRECT_ANSWER_WAS_SHOW ="key_correct_answer_was_show";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        Button showCorrectAnswerButton = findViewById(R.id.show_answer_button);
        showCorrectAnswerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showCorrectAnswer();
            }
        });


    }

    private void showCorrectAnswer() {
        Intent intent =  getIntent();
        boolean correctAnswer = intent.getBooleanExtra(KEY_CORRECT_ANSWER,false);
        TextView correctAnswerView = findViewById(R.id.correct_answer);
        correctAnswerView.setText(String.valueOf(correctAnswer));
        setResult(RESULT_OK,makeAnswerShowIntent());
    }
    private static Intent makeAnswerShowIntent(){
        Intent intent =new Intent();
        intent.putExtra(KEY_CORRECT_ANSWER_WAS_SHOW,true);
        return intent;
    }
    public  static Intent makeIntent (Context context, boolean correctAnswer){
        Intent intent = new Intent(context, CheatActivity.class);
        intent.putExtra(KEY_CORRECT_ANSWER, correctAnswer);
        return intent;

    }
    public static boolean correctAnswerWasShow(Intent intent){
        return intent !=null && intent.getBooleanExtra(KEY_CORRECT_ANSWER_WAS_SHOW,false);

    }

}
