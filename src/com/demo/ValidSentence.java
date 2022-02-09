package com.demo;

import java.util.Scanner;

public class ValidSentence {

	public static void main(String[] args) {
		String[] str = { "The quick brown fox said \"hello Mr lazy dog\".",
				"The quick brown fox said hello Mr lazy dog.",
				"One lazy dog is too few, 13 is too many.", 
				"One lazy dog is too few, thirteen is too many.",
				"How many \"lazy dogs\" are there?",
				"How \"many \"lazy dogs\" are there?",
				"the quick brown fox said “hello Mr lazy dog\".",
				"\"The quick brown fox said “hello Mr lazy dog.\"",
				"One lazy dog is too few, 12 is too many.",
		"Are there 11, 12, or 13 lazy dogs?" };
		CheckSentence checkSentence=new CheckSentence();	
		for(int i=0;i<str.length;i++) {
			if(checkSentence.isSentenceConsideredValid(str[i])==true)

				System.out.println(str[i]+ " is correct");
			else
				System.out.println(str[i] + " is incorrect");

		}
	}

}