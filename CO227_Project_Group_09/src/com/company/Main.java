package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * printer.write lines are the code generating part
 **/

public class Main {
    static HashMap  <String ,Node> hashMap;//this HashMap use to save every node in the graph
    static HashMap<String,String[]> collection;//this HashMap use to save data in functions to traverse algorithm
    static BufferedWriter printer;//tool for generate java file(printer)
    //variables used to tracing
    private static int ifcount=0,elsecount=0,closer=0,whileO=0,whileC=0;

    public static void main(String[] args) throws Exception {

        byte []jsondata = Files.readAllBytes(Paths.get("/home/oracle/Documents/CO227_Project_Group_09/data/currency.txt"));//load json file as a text file

        ObjectMapper getObject= new ObjectMapper();
        Graph graph = getObject.readValue(jsondata,Graph.class);
        hashMap = graph.convertToHashmap();
        printer=new BufferedWriter(new FileWriter("output/Programme.java"));//generate java file name
        //generate basic structure of the generate code
        printer.write("import java.util.*;\n");
        printer.write("public class Programme{\n");
        printer.write("\tprivate String [] arg;\n");
        printer.write("\tpublic void run(){\n");
        printer.write("Split objS;Arithmetic objA;Join objJ;Replace objR;IfElse objI;\n");
        printer.write("ArrayList<String> nodeA;String [] node;\n");
        collection=new HashMap<>();//create collection HashMap
        trace(graph.firstNode());//call trace method
        printer.write("\t}");//run method close
        printSet();//set argument
        printer.write("\n}");//class close
        printer.close();//close Buffered reader
    }

    //this is tracing method
    public static void trace(String nodeName)throws Exception{
        if(hashMap.get(nodeName).getType()!=null){
            String nodeType=hashMap.get(nodeName).getType();
            if(nodeType.equals("split")){
                /*if node Name is Split this section is used for that */
                System.out.println(nodeName);
                String[] func=hashMap.get(nodeName).getFunc();
                Split obj;
                if(hashMap.get(nodeName).isSystem()){
                    /*if user give function data in system,output of another node*/
                    String[] node=(func[1]).split("\\.");
                    String arg=(collection.get(node[0]))[Integer.parseInt(node[1])];
                    obj=new Split(arg,func[0]);//call split class
                    printer.write("objS="+"new Split("+node[0]+"["+node[1]+"],\""+func[0]+"\");");printer.newLine();
                }else{
                    /*if user gives function( condition ) as value*/
                    obj=new Split(func[1],func[0]);
                    printer.write("objS="+"new Split(\""+func[1]+"\",\""+func[0]+"\");");printer.newLine();
                }
                collection.put(nodeName,obj.getWords());
                printer.write("String[] "+nodeName+"=objS.getWords();");printer.newLine();

            }else if(nodeType.equals("if_else")){
                /*if node name is If else*/
                System.out.println(nodeName);
                ifcount+=1;//this count for how many if condition counted
                String[] func=hashMap.get(nodeName).getFunc();//get condition what user gives
                String[] newFunc=new String[func.length];

                if(hashMap.get(nodeName).isSystem()){
                    /*if user gives values in system this section for identify them*/
                    String[] node;printer.write("nodeA=new ArrayList<>();\n");
                    for(int i=0;i<func.length;i++){
                        /*this if else used to separate argument and condition*/
                        if(i%2==0){//condition patten arg1 ,cond ,arg2,cond,arg3,cond.....end
                            node=func[i].split("\\.");
                            newFunc[i]=(collection.get(node[0]))[Integer.parseInt(node[1])];
                            printer.write("nodeA.add("+node[0]+"["+node[1]+"]);");
                        }else{
                            newFunc[i]=func[i];
                            printer.write("nodeA.add(\""+func[i]+"\");");
                        }
                    }
                    printer.write("\nobjI=new IfElse(nodeA);\n");
                }else{

                    newFunc=func;
                    printer.write("node={"+loopStr(func)+"};\n");
                    printer.write("objI=new IfElse(node);\n");
                }
                IfElse obj=new IfElse(newFunc);//create If_else object to take condition weather true or false
                printer.write("if(objI.getResult()){");printer.newLine();

            }else if(nodeType.equals("Join")){
                /*this section used for join list of words*/
                System.out.println(nodeName);
                String[] func=hashMap.get(nodeName).getFunc();
                Join obj;
                String op=func[0];
                String list[]=new String[func.length-1];int count=0;
                printer.write("nodeA=new ArrayList<>();\n");
                if(hashMap.get(nodeName).isSystem()){
                    /*if user gives value from system that be*/
                    String[] node;
                    for(int i=1;i<func.length;i++){
                        node=(func[i]).split("\\.");
                        list[count]=(collection.get(node[0]))[Integer.parseInt(node[1])];
                        printer.write("nodeA.add("+node[0]+"["+node[1]+"]);");
                        count++;
                    }
                }else{
                    for(int i=1;i<func.length;i++){
                        list[count]=func[i];count++;
                        printer.write("nodeA.add("+func[i]+");");
                    }
                }
                obj=new Join(op,list);
                collection.put(nodeName,obj.finalResult());
                printer.write("\nobjJ=new Join(\""+op+"\",nodeA);\n");
                printer.write("String[] "+nodeName+"=objJ.finalResult();\n");

            }else if(nodeType.equals("Replace")){
                System.out.println(nodeName);
                String[] func=hashMap.get(nodeName).getFunc();
                Replace obj;
                if(hashMap.get(nodeName).isSystem()){
                    String[] node=(func[0]).split("\\.");
                    String arg1=(collection.get(node[0]))[Integer.parseInt(node[1])];//Word
                    printer.write("objR=new Replace("+node[0]+"["+node[1]+"],");
                    node=(func[1]).split("\\.");
                    String arg2=(collection.get(node[0]))[Integer.parseInt(node[1])];//oldW
                    printer.write(node[0]+"["+node[1]+"],");
                    node=(func[2]).split("\\.");
                    String arg3=(collection.get(node[0]))[Integer.parseInt(node[1])];//newW
                    printer.write(node[0]+"["+node[1]+"]);\n");
                    obj=new Replace(arg1,arg2,arg3);
                }else{
                    String[] node=(func[0]).split("\\.");
                    String arg1=(collection.get(node[0]))[Integer.parseInt(node[1])];
                    obj=new Replace(arg1,func[1],func[2]);
                    printer.write("objR=new Replace(" + node[0]+"["+node[1]+"],\""+func[1]+"\",\""+func[2]+"\");\n");
                }
                printer.write("String[] "+nodeName+"=objR.finalResult();\n");
                collection.put(nodeName,obj.finalResult());

            }else if(nodeType.equals("arithmetic")){
                System.out.println(nodeName);
                String[] func=hashMap.get(nodeName).getFunc();
                Arithmetic obj;
                String op=func[0];
                if(hashMap.get(nodeName).isSystem()){
                    String[] node1=(func[1]).split("\\.");
                    String arg1=(collection.get(node1[0]))[Integer.parseInt(node1[1])];//first argument
                    String[] node2=(func[2]).split("\\.");
                    String arg2=(collection.get(node2[0]))[Integer.parseInt(node2[1])];//second argument
                    obj=new Arithmetic(op,arg1,arg2);//create Arithmetic object
                    printer.write("objA=new Arithmetic(\""+op+"\","+node1[0]+"["+node1[1]+"],"+node2[0]+"["+node2[1]+"]);\n");
                }else{
                    obj=new Arithmetic(op,func[1],func[2]);
                    printer.write("objA=new Arithmetic(\""+op+"\",\""+func[1]+"\""+func[2]+"\");\n");
                }
                collection.put(nodeName,obj.getResult());
                printer.write("String[] "+nodeName+"=objA.getResult();\n");

            }else if(nodeType.equals("while")){

                System.out.println(nodeName);
                whileO+=1;
                String[] func=hashMap.get(nodeName).getFunc();

                if(hashMap.get(nodeName).isSystem()){
                    String[] node;
                    node=func[0].split("\\.");
                    printer.write("for(int i=0;i<"+(collection.get(node[0]))[Integer.parseInt(node[1])]+";i++){");printer.newLine();
                }else{
                    printer.write("for(int i="+func[0]+"){");printer.newLine();
                }


            }else if(nodeType.equals("message")){//this section is first node
                System.out.println(nodeName);
                collection.put(nodeName,hashMap.get(nodeName).getFunc());
            }
            else if(nodeType.equals("output")){
                System.out.println(nodeName);
                printer.write("System.out.println("+hashMap.get(nodeName).getFunc()[0].split("\\.")[0]+"[0]);");

            }
            for(String nextNode:hashMap.get(nodeName).getCon_true()){//recursion
                trace(nextNode);//after one node go to next node in true path
            }
            if(ifcount!=elsecount) {//close if and start else
                printer.write("}else{");printer.newLine();
                elsecount+=1;
            }
            if(whileO!=whileC) {//close while
                printer.write("}");printer.newLine();
                whileC+=1;
            }
            for(String nextNode:hashMap.get(nodeName).getCon_false()){
                trace(nextNode);//after one node go to next node in false path
            }

            if(elsecount!=closer){//close else section
                printer.write("}");printer.newLine();
                closer+=1;
            }
        }
    }
    public static String loopStr(String[] list){
        /*this method used in If_else section */
        String ret="";
        for(int i=0;i<list.length-1;i++){
            ret+="\""+list[i]+"\",";
        }
        ret+="\""+list[list.length-1]+"\"";
        return  ret;
    }
    private static void printSet()throws Exception{
        //this is used to write setArg function of generate code(Programme.java)
        printer.write("public void setArg(String[] arg){\n" +
                "        this.arg=arg;\n" +
                "    }");
    }

}
