package com.company;

public class Arithmatic {
    private Double num1;
    private Double num2;
    private String op;
    private Double result;

    public Arithmatic(String num1,String num2,String op) {
        try {
            this.num1 = Double.parseDouble(num1);
            this.num2 = Double.parseDouble(num2);
            this.op = op;
        }catch(Exception e){
           // this.num1=
        }
    }
    public String getResult(){
        switch(op){
            case "+":result=num1+num2; break;
            case "-":result=num1-num2; break;
            case "*":result=num1*num2; break;
            case "/":result=num1/num2; break;
            case "%":result=num1%num2; break;
            //"":break;
        }

        return String.valueOf(result);
    }
}