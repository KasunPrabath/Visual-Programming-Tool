package com.company;

/**
 * Created by DILIP on 11/21/2016.
 */
public class IfElse {
    private String input1;
    private String op;
    private String input2;
    private boolean ret;
    public IfElse(String input1, String op, String input2) {
        this.input1 = input1;
        this.op = op;
        this.input2 = input2;
    }
    boolean checkCondion(){
        switch(op){
            case "==":ret=input1.equals(input2);break;
            case "<":ret=Double.parseDouble(input1)<Double.parseDouble(input2);break;
            case ">":ret=Double.parseDouble(input1)>Double.parseDouble(input2);break;
            case ">=":ret=Double.parseDouble(input1)>=Double.parseDouble(input2);break;
            case "<=":ret=Double.parseDouble(input1)<=Double.parseDouble(input2);break;
            case "!=":ret=Double.parseDouble(input1)!=Double.parseDouble(input2);break;
        }
        return ret;
    }
}
