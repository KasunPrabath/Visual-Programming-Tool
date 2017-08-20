import java.util.ArrayList;

/**
 * 12/1/2016.
 * This class is used to join words using some word
 * this class has constructor
 * when creating this class object,should gives two argument
 * first one is String word and second one is String arrayList of words
 */
public class Join {
    private String operation;
    private String [] args;
    private String result;
    private String[] output=new String[1];
    public Join(String operation, String[] args) {
        this.operation = operation;
        this.args = args;
    }
    public Join(String operation, ArrayList<String> aList) {
        this.operation = operation;
        this.args = args;
        this.args=new String[aList.size()];
        for(int i=0;i<aList.size();i++){
            this.args[i]=aList.get(i);
        }
    }

    public String[] finalResult(){
        //this class join all words in array list using first word and gives result as a first vlaue of an array
        result="";
        for(int i=0;i<args.length-1;i++){
            result+=args[i]+operation;
        }
        result+=args[args.length-1];
        output[0]=result;
        return output;
    }
}
