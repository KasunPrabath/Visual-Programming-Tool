#!/bin/bash
javac Main.java
jar cfm Programe.jar manifest.txt Main.class Arithmetic.class IfElse.class Join.class Programme.class Replace.class Split.class
java -jar Programe.jar "$ LKR 150" "1 144"
