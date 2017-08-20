package com.company;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Kasun Prabath on 11/27/2016.
 */
public class GenerateCode {

    public void run(ArrayList<String> array) throws IOException {

        int size = array.size();
        Writer writer = new Writer();

        writer.Append("public class MyFile {");
        writer.Append("     public void run() {");

        for (int i = 0; i < size; i++) {
            writer.Append(array.get(i));
        }

        writer.Append("     }");
        writer.Append("}");
        writer.CloseAppend();
    }
}
