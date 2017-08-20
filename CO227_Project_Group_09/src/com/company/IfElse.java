package com.company;

import java.util.ArrayList;

/**
 * 12/2/2016.
 * this lass used to take boolean value of condition true or not
 * take condition s array or ArrayList
 */
public class IfElse {
    private String[] func;

    public IfElse(String[] func) {
        this.func = func;
    }
    public IfElse(ArrayList<String> aList) {
        func=new String[aList.size()];
        for(int i=0;i<aList.size();i++){
            this.func[i]=aList.get(i);
        }
    }
    public boolean getResult(){
        boolean pre=true;
        boolean curr=true;
        int count=-1;
        String bind="and";
        do{
            count+=1;
            curr=check2Con(func[count+0],func[count+1],func[count+2]);
            switch(bind){
                case "and":pre=pre&&curr;break;
                case "or":pre=pre||curr;break;
            }
            System.out.println(func[count+0]+" "+func[count+1]+" "+func[count+2]);
            count+=3;bind=func[count];
        }while((count+3)<func.length&&!(func[count].equals("end")));


        return pre;
    }
    private boolean check2Con(String arg1,String op,String arg2){
        /*this method used to check to argument and take true or false
        * give a boolean value*/
        switch (op){
            case "==":return arg1.equals(arg2);
            case "!=":return !(arg1.equals(arg2));
            case "<":return Integer.parseInt(arg1)<Integer.parseInt(arg2);
            case "<=":return Integer.parseInt(arg1)<=Integer.parseInt(arg2);
            case ">":return Integer.parseInt(arg1)>Integer.parseInt(arg2);
            case ">=":return Integer.parseInt(arg1)>=Integer.parseInt(arg2);
            default:return false;
        }
    }
}
