/**
 *11/17/2016.
 * This class use to replace a word in a sentence
 * when create this object, should give three constructor sentence, old word and new word
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
    public String[] finalResult(){
        String[] list=new String[1];
        list[0]=toString();
        return list;//return new sentence as a first value of a array
    }
    @Override
    public String toString() {
        /*splitting sentence and replace new word */
        Split separate=new Split(arg," ");//create split object and split by space
        words=separate.getWords();//get words after splitting
        join="";
        for(String i:words){
            if(i.equals(oldW)){//if old word equal this word it should be replace
                i=newW;
            }
            join=join+i+" ";
        }
        return join;
    }
}
