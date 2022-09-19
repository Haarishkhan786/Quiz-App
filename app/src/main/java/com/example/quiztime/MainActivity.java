package com.example.quiztime;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView questionBox , optionA , optionB , optionC , optionD , score, questionNo ;
    int score1 = 0;
    answer questiondata;

    public static ArrayList<answer> qPacket = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionBox = findViewById(R.id.questionBox);
        optionA = findViewById(R.id.option1);
        optionB = findViewById(R.id.option2);
        optionC = findViewById(R.id.option3);
        optionD = findViewById(R.id.option4);
        questionNo = findViewById(R.id.questionNo);
        score = findViewById(R.id.score);




        questiondata = new answer(1,"What is the name of PM ?", "haarish" , "modi ji" , "sallu bhai" , "haarish ki gf " , "modi ji");
        qPacket.add(questiondata);
        questiondata = new answer(2,"What is Haarish's favorite colour ?", "black" , "blue" , "red" , "White" , "black");
        qPacket.add(questiondata);
        questiondata = new answer(3,"What is haarish's favorite food ?", "biryani" , "dal roti" , "chicken fry" , "GF ki kiss" , "GF ki kiss");
        qPacket.add(questiondata);
        questiondata = new answer(4,"What is haarish's favorite day ?", "sunday" , "monday" , "tuesday" , "satarday" , "satarday");
        qPacket.add(questiondata);
        questiondata = new answer(5,"What is haarish's favorite sports ?", "football" , "pubg" , "cricket" , "chess" , "cricket");
        qPacket.add(questiondata);
        questiondata = new answer(6,"What is haarish's favorite device ?", "realme" , "iphone" , "samsung" , "oneplus" , "iphone");
        qPacket.add(questiondata);
        questiondata = new answer(7,"What is haarish's favorite work ?", "studying" , "playing" , "thinking about my GF" , "doing nothing" , "doing nothing");
        qPacket.add(questiondata);
        questiondata = new answer(8,"Who is haarish's favorite friend ?", "harsh" , "rishab" , "vishal" , "none of the above" , "none of the above");
        qPacket.add(questiondata);
        questiondata = new answer(9,"What is haarish's favorite drink ?", "coffee" , "water" , "aasu pee kr zinda hu" , "none" , "none");
        qPacket.add(questiondata);
        questiondata = new answer(10,"What is haarish's favorite car brand ?", "BMW" , "ferrari" , "porsche" , "jaguar" , "porsche");
        qPacket.add(questiondata);


        questionBox.setText(qPacket.get(0).getQuestion());
        optionA.setText(qPacket.get(0).getOptionA());
        optionB.setText(qPacket.get(0).getOptionB());
        optionC.setText(qPacket.get(0).getOptionC());
        optionD.setText(qPacket.get(0).getOptionD());
        questionNo.setText(qPacket.get(0).getQid().toString());



    }


    public void setDataA(View view){
        String question = (String) questionBox.getText();
        String selectedAns = (String) optionA.getText();
        checkAnswer(question , selectedAns);
    }

    public void setDataB(View view){
        String question = (String) questionBox.getText();
        String selectedAns = (String) optionB.getText();
        checkAnswer(question , selectedAns);
    }
    public void setDataC(View view){
        String question = (String) questionBox.getText();
        String selectedAns = (String) optionC.getText();
        checkAnswer(question , selectedAns);
    }
    public void setDataD(View view){
        String question = (String) questionBox.getText();
        String selectedAns = (String) optionD.getText();
        checkAnswer(question , selectedAns);
    }



    void checkAnswer(String question , String selectedAnswer){
        for (int i = 0; i < qPacket.size(); i++) {
            String question1 = qPacket.get(i).getQuestion();
            if(question1.equals(question)){
                if(qPacket.get(i).getAnswer().equals(selectedAnswer)){
                    score1 = score1 + 1;
                    String s = ""+score1;
                    score.setText(s);
                    if(i == qPacket.size() - 1){
                        Toast.makeText(MainActivity.this , "No More questions left" , Toast.LENGTH_LONG).show();
                    }else{
                        questionBox.setText(qPacket.get(i+1).getQuestion());
                        optionA.setText(qPacket.get(i+1).getOptionA());
                        optionB.setText(qPacket.get(i+1).getOptionB());
                        optionC.setText(qPacket.get(i+1).getOptionC());
                        optionD.setText(qPacket.get(i+1).getOptionD());
                        questionNo.setText(qPacket.get(i+1).getQid().toString());

//                        Toast.makeText(MainActivity.this , "score : "+score , Toast.LENGTH_SHORT).show();
//                        Toast.makeText(MainActivity.this , "size : "+qPacket.size() , Toast.LENGTH_SHORT).show();
//                        Toast.makeText(MainActivity.this , "i : "+i , Toast.LENGTH_SHORT).show();
                    }
                }else{
                    if(i == qPacket.size() - 1){
                        Toast.makeText(MainActivity.this , "No More questions left" , Toast.LENGTH_LONG).show();
                    }else {
                        score1 = score1 - 1;
                        String s = ""+score1;
                        score.setText(s);
                        questionBox.setText(qPacket.get(i + 1).getQuestion());
                        optionA.setText(qPacket.get(i + 1).getOptionA());
                        optionB.setText(qPacket.get(i + 1).getOptionB());
                        optionC.setText(qPacket.get(i + 1).getOptionC());
                        optionD.setText(qPacket.get(i + 1).getOptionD());
                        questionNo.setText(qPacket.get(i+1).getQid().toString());
                    }
                }
            }
        }

    }


    public void reset(View view){
        score1 = 0;
        score.setText("0");
        questionBox.setText(qPacket.get(0).getQuestion());
        optionA.setText(qPacket.get(0).getOptionA());
        optionB.setText(qPacket.get(0).getOptionB());
        optionC.setText(qPacket.get(0).getOptionC());
        optionD.setText(qPacket.get(0).getOptionD());
        questionNo.setText(qPacket.get(0).getQid().toString());
    }

}