package com.company;

/**
 * Created by Kasun Prabath on 11/27/2016.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    FileWriter writer = new FileWriter("MyFile.java", true);
    BufferedWriter bufferedWriter = new BufferedWriter(writer);

    public Writer() throws IOException {
    }

    public void Append(String string) {
        try {
            this.bufferedWriter.write(string);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CloseAppend() {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}