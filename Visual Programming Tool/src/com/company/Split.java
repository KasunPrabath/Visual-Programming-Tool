package com.company;

/**
 * Created by DILIP on 11/17/2016.
 */
public class Split {
    /*this class use for split function
    * */
    private String list[];
    private String arg, op;
    private double[] number_list;

    public Split(String arg, String op) {
        this.arg = arg;
        this.op = op;
    }

    public String[] getWords() {
        list = arg.split(op);
        return list;
    }

    public double return_number(String num) {
        double x = Double.parseDouble(num);
        return x;
    }


}
