package com.company;
/**
 *11/17/2016.
 * This class used for arithmatic operation like add div mul sub and rem...
 * this class has construct
 * when creating this class object,should gives three argument
 * operation num1 and num2 as String
 * and this class gives a double value as result
 */
public class Arithmetic {
    private Double num1;
    private Double num2;
    private String op;
    private Double result;

    public Arithmetic(String op, String num1, String num2) {
        this.num1=Double.parseDouble(num1);
        this.num2=Double.parseDouble(num2);
        this.op=op;
    }
    private Double getR(){
        switch(op){
            case "+":result=num1+num2; break;
            case "-":result=num1-num2; break;
            case "*":result=num1*num2; break;
            case "/":result=num1/num2; break;
            case "%":result=num1%num2; break;
            case "^":result=Math.pow(num1,num2); break;
        }
        return result;
    }
    public String[] getResult(){
        //this method give result of two number operation as a first value of a array
        double val=getR();
        String[] resultA=new String[1];
        resultA[0]=""+val;
        return resultA;
    }

}