package com.example.chattingboxy;

public class Palaindrome {
    int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getReverse(){
        int i = number,reverse = 0,remainder;
        while(i!=0){
            remainder = i % 10;
            reverse = reverse *10 + remainder;
            i /=10;
        }
        return reverse;
    }

    public String checkPalaindrome(int rev){

        if(number == rev){
            return "true";
        }
        return "false";
    }


}
