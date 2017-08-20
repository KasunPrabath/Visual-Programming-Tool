package com.company;

/**This class used for the backup the algorithm
 * This do not have code generating part
 * Main.java has the algorithm and code generating part combined
 **/

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Algorithm {
    static HashMap  <String ,Node> hashMap;
    static HashMap<String,String[]> collection;
    static BufferedWriter printer;
    private static int ifcount=0,elsecount=0,closer=0,closeok=0;
    public static void main(String[] args) throws Exception {


        byte []jsondata = Files.readAllBytes(Paths.get("D:\\generatecodes\\data\\currency.txt"));

        ObjectMapper getObject= new ObjectMapper();
        Graph graph = getObject.readValue(jsondata,Graph.class);
        hashMap = graph.convertToHashmap();
        printer=new BufferedWriter(new FileWriter("Programme2.java"));
        printer.write("public class Programme2{\n");
        printer.write("\tpublic String run(String arg){\n");
        printer.write("Split objS;\nArithmetic objA;\nJoin objJ;\nReplace objR;\n");
        collection=new HashMap<>();
        trace(graph.firstNode());
        printer.write("\t}\n}");
        printer.close();
    }
    public static void trace(String nodeName)throws Exception{
        if(hashMap.get(nodeName).getType()!=null){
            String nodeType=hashMap.get(nodeName).getType();

            if(nodeType.equals("split")){
                System.out.println(nodeName);
                printer.write("//"+nodeName);printer.newLine();
            }else if(nodeType.equals("if_else")){
                System.out.println(nodeName);
                ifcount+=1;
                printer.write("if(){");printer.newLine();

            }else if(nodeType.equals("Join")){
                System.out.println(nodeName);
                printer.write("//"+nodeName);printer.newLine();

            }else if(nodeType.equals("replace")){
                System.out.println(nodeName);
                printer.write("//"+nodeName);printer.newLine();

            }else if(nodeType.equals("arithmetic")){
                System.out.println(nodeName);
                printer.write("//"+nodeName);printer.newLine();

            }else if(nodeType.equals("while")){
                System.out.println(nodeName);
                printer.write("//"+nodeName);printer.newLine();

            }else if(nodeType.equals("massage")){
                System.out.println(nodeName);
                printer.write("//"+nodeName);printer.newLine();
            }
            else if(nodeType.equals("output")){
                System.out.println(nodeName);
                printer.write("//"+nodeName);printer.newLine();
            }
            for(String nextNode:hashMap.get(nodeName).getCon_true()){
                trace(nextNode);
            }
            for(String nextNode:hashMap.get(nodeName).getCon_false()){
                trace(nextNode);
            }
        }
    }
}
