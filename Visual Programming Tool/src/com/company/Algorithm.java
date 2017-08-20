package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Algorithm {

    Structure struct;

    public Algorithm(Structure struct) {
        this.struct = struct;
    }

    public void run(Structure struct) throws IOException {
        String typenext = struct.getType();
        String typenext2 = struct.getType();
        String list[];
        HashMap<String, String> graph = new HashMap<>();
        HashMap<String, String> graphS = new HashMap<>();
        ArrayList<Structure> arrayList = new ArrayList<>();
        ArrayList<Structure> temp = new ArrayList<Structure>();
        HashMap<String,Structure> nodeStorage = new HashMap<>();

        Stack<Structure> s = new Stack<Structure>();
        s.add(struct);      //add root node to stack
        while (!s.isEmpty()) {   //if the stack not empty
            Structure x = s.pop();  //pop nodes from the stack

            if(x.getTruepath().getType()!=null) s.add(x.getTruepath());  //add true or false pathes to stack
            if(x.getFalsepath().getType()!=null) s.add(x.getFalsepath());

            nodeStorage.put(x.getName(),x);   //add each node to Hashmap
            System.out.println(x.getName()); //node name is the key

        }
        //if we can add code as a strings in a Array list we can write it to file using writer class
        ArrayList<String> array = new ArrayList<>();
        array.add("kasun");
        array.add("prabath");
        array.add("amarasinghe");
        GenerateCode code =new GenerateCode();
        code.run(array);



        // System.out.println(nodeStorage.get("split_2"));









//        while (typenext2 != null) {
//
//            int count = NodeCount(struct.getTruepath());
//            //System.out.println("node Count :" + count);
//            temp = struct.getTruepath();
//
//                if (typenext.equals("split")) {
//
//                    Split split1 = new Split(struct.getFunc().get(1), struct.getFunc().get(0));
//                    list = split1.getWords();
//                    for (String i : list) {
//                        System.out.println(i);
//                    }
//                } else if (typenext.equals("Arithmatic")) {
//                    Arithmatic artm = new Arithmatic(struct.getFunc().get(1), struct.getFunc().get(2), struct.getFunc().get(0));
//                    System.out.println(artm.getResult());
//                    graph.put(struct.getName(), artm.getResult());
//
//                } else if (typenext.equals("Replace")) {
//
//                    Replace rep = new Replace(struct.getFunc().get(0), struct.getFunc().get(1), struct.getFunc().get(2));
//                    //System.out.println(rep.toString());
//                    graph.put(struct.getName(), rep.toString());
//
//                } else if (typenext.equals("if")) {
//
//                    IfElse if_1 = new IfElse(struct.getFunc().get(0), struct.getFunc().get(1), struct.getFunc().get(2));
//                    if (!if_1.checkCondion()) {
////                        JsonNode rootNode = objectMapper.readTree(jsonData);
////                        ((ObjectNode) rootNode).remove("connected_to");
////                        ((ObjectNode) rootNode).remove("type");
//                    }
//
//                } else if (typenext.equals("else")) {
//
//                    IfElse else_1 = new IfElse(struct.getFunc().get(0), struct.getFunc().get(1), struct.getFunc().get(2));
//
//                    if (!else_1.checkCondion()) {
//                        break;
//                    }
//
//                } else if (typenext.equals("join")) {
//
//                    String join = " ";
//                    for (int i = 1; i < struct.getFunc().size() - 1; i++) {
//                        join += struct.getFunc().get(i) + struct.getFunc().get(0);
//                    }
//                    join += struct.getFunc().get(struct.getFunc().size() - 1);
//                    System.out.println(join);
//                    graph.put(struct.getName(), join);
//
//                } else if (typenext.equals("while")) {
//
//                } else {
//                    return;
//                }
//                //}
//            /*for(Structure node:struct.getTruepath()){
//                struct = node.getTruepath().get(0);
//            }*/
//                struct = struct.getTruepath().get(0);
//                typenext = struct.getType();
//            }
       }

//    public void Writer() {
//        try {
//            FileWriter writer = new FileWriter("MyFile.java", true);
//            BufferedWriter bufferedWriter = new BufferedWriter(writer);
//
//            bufferedWriter.write("Hello World");
//            bufferedWriter.newLine();
//            bufferedWriter.write("See You Again!");
//
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public int NodeCount(ArrayList<Structure> arrayList) {
        return arrayList.size();
    }


}



