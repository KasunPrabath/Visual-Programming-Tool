package com.company;
/**
 * Created by DILIP on 11/17/2016.
 */
public class Replace {
    private String arg;
    private String oldW;
    private String newW;
    private String []words;
    private String join;
    public Replace(String arg,String oldW,String newW ) {
        this.arg=arg;
        this.oldW=oldW;
        this.newW=newW;
    }

    @Override
    public String toString() {
        Split separate=new Split(arg," ");
        words=separate.getWords();
        join="";
        for(String i:words){
            if(i.equals(oldW)){
                i=newW;
            }
            join=join+i+" ";
        }
        return join;
    }
}
