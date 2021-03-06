package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class C9QuestionActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView qcount, question, timer;
    private ExtendedFloatingActionButton option1, option2, option3;
    private List<Question> questionList;
    private CountDownTimer countDown;

    private int questNum;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c9_question);


        qcount = findViewById(R.id.qcount);
        question = findViewById(R.id.question);
        timer = findViewById(R.id.timer);


        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        getQuestionsList();

        score = 0;
    }

    private void getQuestionsList() {
        questionList = new ArrayList<>();


        questionList.add(new Question("When a panic occur, the program starts:", "Winding with errors", "Winding", "UnWinding", 2));
        questionList.add(new Question("Which of te given field has the most use of Rust language : ", "Artifical Intelligence", "IOT/Embedded devices", "Web Designing", 2));
        questionList.add(new Question("To handle an error we can use:", "Array List", "Vectors", "enum of option T and E", 3));
        setQuestion();


    }


    private void setQuestion() {

        timer.setText(String.valueOf(10));


        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOptionA());
        option2.setText(questionList.get(0).getOptionB());
        option3.setText(questionList.get(0).getOptionC());


        qcount.setText(String.valueOf(1) + "/" + String.valueOf(questionList.size()));


        startTimer();


        questNum = 0;
    }

    private void startTimer() {
        countDown = new CountDownTimer(12000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished < 10000)

                    timer.setText(String.valueOf(millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {

                changeQuestion();
            }


        };
        countDown.start();
    }

    @Override
    public void onClick(View v) {

        int selectedOption = 0;
        switch (v.getId()) {
            case R.id.option1:
                selectedOption = 1;
                break;
            case R.id.option2:
                selectedOption = 2;
                break;
            case R.id.option3:
                selectedOption = 3;
                break;
            default:
        }

        countDown.cancel();

        checkAnswer(selectedOption, v);


    }

    private void checkAnswer(int selectedOption, View view) {
        if (selectedOption == questionList.get(questNum).getCorrectAns()) {
            //Right answer
            ((ExtendedFloatingActionButton) view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            score++;

        } else {
            ((ExtendedFloatingActionButton) view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));


//            switch (questionList.get(questNum).getCorrectAns()) {
//                case 1:
//                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
//                    break;
//
//
//                case 2:
//                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
//                    break;
//
//
//                case 3:
//                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
//                    break;
//            }
        }


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeQuestion();

            }
        }, 2000);
    }


    private void changeQuestion() {


        if (questNum < questionList.size() - 1) {
            questNum++;

            playAnime(question, 0, 0);
            playAnime(option1, 0, 1);
            playAnime(option2, 0, 2);
            playAnime(option3, 0, 3);

            qcount.setText(String.valueOf(questNum + 1) + "/" + String.valueOf(questionList.size()));
            timer.setText(String.valueOf(10));
            startTimer();


        } else {

            //Score Activity
            Intent intent = new Intent(getApplicationContext(), Score.class);
            intent.putExtra("SCORE", String.valueOf(score) + "/" + String.valueOf(questionList.size()));
            startActivity(intent);
            C9QuestionActivity.this.finish();

        }
    }

    private void playAnime(View view, final int value, int viewNum) {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (value == 0) {
                    switch (viewNum) {
                        case 0:
                            ((TextView) view).setText(questionList.get(questNum).getQuestion());
                            break;
                        case 1:
                            ((com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton) view).setText(questionList.get(questNum).getOptionA());
                            break;

                        case 2:
                            ((com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton) view).setText(questionList.get(questNum).getOptionB());
                            break;

                        case 3:
                            ((com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton) view).setText(questionList.get(questNum).getOptionC());
                            break;
                    }

                    if (viewNum != 0)
                        ((ExtendedFloatingActionButton) view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF018786")));
                    playAnime(view, 1, viewNum);
                }

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

}