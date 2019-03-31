package com.example.numbergame.Logic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class ProcessNumber {
    private  int numberOne;
    private  int numberTwo;
    private  int score;
    private int turnsleft;
    private ArrayList<Integer> mistakes;
    public ProcessNumber(){
        score = 0;
        turnsleft = 20;
        mistakes = new ArrayList<>();
    }


    public ArrayList<Integer> getMistakes() {
        return mistakes;
    }

    public int NoOfItemsInArrayList(){
        return mistakes.size();
    }

    public void ClearArrayList(){
        mistakes.clear();
    }

    public void setMistakes(ArrayList<Integer> mistakes) {
        this.mistakes = mistakes;
    }

    public int getTurnsleft() {
        return turnsleft;
    }

    public void setTurnsleft(int turnsleft) {
        this.turnsleft = turnsleft;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(int numberOne) {
        this.numberOne = numberOne;
    }

    public int getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(int numberTwo) {
        this.numberTwo = numberTwo;
    }

    public int getRandom(){
        return new Random().nextInt(100-1)+1;
    }

    public void checkIfFirst(int first, int second){
        if(first > second){
            score ++;
            return;
        }
        mistakes.add(20-getTurnsleft()+1);
        score --;
    }

    public void checkifSeconds(int first, int second){
        if(first < second){
            score ++;
            return;
        }
        mistakes.add(20-getTurnsleft()+1);
        score --;
    }
}
