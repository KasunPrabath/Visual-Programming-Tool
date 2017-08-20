package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String input = "10 20";
        run(input);

    }

    public static void run(String input) {

        String[] list;
        String[] string = new String[20];
        double[] number = new double[20];

        list = Split(input, " ");

        number[0] = Arithmetic("+", list[0], list[1]);

            string[1] = Replace("A car A bus A jet A boy A girl", "A", "The");
            System.out.println(string[1]);


    }

    public static String[] Split(String string, String op) {

        String[] list;
        list = string.split(op);
        return list;
    }

    public static double Arithmetic(String op, String num1, String num2) {

        double result = 0;
        switch (op) {
            case "+":
                result = Double.parseDouble(num1) + Double.parseDouble(num2);
                break;
            case "-":
                result = Double.parseDouble(num1) - Double.parseDouble(num2);
                break;
            case "*":
                result = Double.parseDouble(num1) * Double.parseDouble(num2);
                break;
            case "/":
                result = Double.parseDouble(num1) / Double.parseDouble(num2);
                break;
            case "%":
                result = Double.parseDouble(num1) % Double.parseDouble(num2);
                break;
        }
        return result;
    }

    public static String Replace(String arg, String oldW, String newW) {
        String join = null;
        String[] words;

        words = arg.split(" ");
        for (String i : words) {
            if (i.equals(oldW)) {
                i = newW;
            }
            join = join + i + " ";
        }
        return join;
    }

}





