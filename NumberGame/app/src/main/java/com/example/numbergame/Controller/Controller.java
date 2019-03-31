package com.example.numbergame.Controller;


import android.view.View;
import android.widget.Button;

import com.example.numbergame.Logic.ProcessNumber;
import com.example.numbergame.MainActivity;

public class Controller {

    // initialization
    private MainActivity mainActivity;
    private int first, second;
    private ProcessNumber process;
    private Button btnFirst;
    private Button btnSecond;

    // constructor
    public Controller(MainActivity mainActivity,Button btnFirst, Button btnSecond) {

        process = new ProcessNumber();
        this.mainActivity = mainActivity;
        mainActivity.setTV(process.getScore());

        setNumberForButton();
        checkNumbers();
        setForMistakes();
        this.mainActivity.setTvTurn(process.getTurnsleft());
        this.mainActivity.setValue(getNumber(),getNumber());
        this.btnFirst = btnFirst;
        this.btnSecond = btnSecond;
        Listen();
        CheckScore();
    }


    // Checks score
    public void CheckScore(){
        if(process.getScore() >= 10){
            mainActivity.Intender(true,process.getMistakes());
        }
        if (process.getScore() <= -10){
            mainActivity.Intender(false,process.getMistakes());
        }
    }

    public void setForMistakes(){
        mainActivity.setTvMistakes(process.NoOfItemsInArrayList());
    }

    // Check turns
    public Boolean CheckTurns(){
        if(process.getTurnsleft() ==0){
            mainActivity.Intender(false,process.getMistakes());
            return false;
        }
        return true;
    }


    // gets value for first and second button
    public void setNumberForButton(){
        first = getNumber();
        second = getNumber();
    }

    //checks value for equality
    public void checkNumbers(){
        if(first == second){
            setNumberForButton();
        }
    }

    // get random number
    public int getNumber(){
        return process.getRandom();
    }

    public  void Listen(){
        btnFirst.setOnClickListener(new FirstButtonListener());

        btnSecond.setOnClickListener(new SecondButtonListener());
    }

    class FirstButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            process.setTurnsleft(process.getTurnsleft() - 1);
            int firstValue = mainActivity.getFirst();
            int secondValue = mainActivity.getSecond();
            process.checkIfFirst(firstValue,secondValue);
            mainActivity.setTV(process.getScore());
            setNumberForButton();
            checkNumbers();
            CheckScore();
            setForMistakes();
            if(CheckTurns()){
                mainActivity.setTvTurn(process.getTurnsleft());
                mainActivity.setValue(first,second);
            }

        }
    }

    class SecondButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            process.setTurnsleft(process.getTurnsleft() - 1);
            int firstValue = mainActivity.getFirst();
            int secondValue = mainActivity.getSecond();
            process.checkifSeconds(firstValue,secondValue);
            mainActivity.setTV(process.getScore());
            setNumberForButton();
            checkNumbers();
            CheckScore();
            setForMistakes();
            if(CheckTurns()){
                mainActivity.setTvTurn(process.getTurnsleft());
                mainActivity.setValue(first,second);
            }
        }
    }



}
