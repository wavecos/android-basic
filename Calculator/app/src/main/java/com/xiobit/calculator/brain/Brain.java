package com.xiobit.calculator.brain;

/**
 * Created by onix on 6/20/15.
 */
public class Brain {

    float op1, op2;


    public float add() {
        return op1 + op2;
    }

    public float minus() {
        return op1 - op2;
    }

    public float divide() {
        return  op1 / op2;
    }

    public  float times() {
        return  op1 * op2;
    }

    public static void main(String[] args) {
        System.out.println("Hello Brain ! :)");
    }



}
