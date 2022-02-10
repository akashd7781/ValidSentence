package com.demo;

import java.util.Objects;

public class CheckSentence implements ValidatesSentences {

	private static final int MINIMUM_ALLOWED_NUMBER = 13;

	public CheckSentence() {
		//default (auto-generated without explicit declaration anyway)
	}


	public final boolean isSentenceConsideredValid(String sentence) {
		String temporary = nullCheck(sentence);
		return temporary.length() > 1 && areConditionsValid(temporary);
	}

	private boolean areConditionsValid(String sentence) {
		return firstCharacterUpperCase(sentence)
				&& evenQuotationMarks(sentence)
				&& periodMark(sentence)
				&& numberSpelledoutBelow13(sentence);
		//	              && isSentenceEndsWithQuestionMark(sentence);

	}

	private String nullCheck(String sentence) {
		Objects.requireNonNull(sentence, "null is not an acceptable value");
		return sentence.trim();
	}

	private boolean firstCharacterUpperCase(String sentence) {
		return Character.isLetter(sentence.charAt(0))
				&& sentence.charAt(0) == sentence.toUpperCase().charAt(0);
	}

	private boolean evenQuotationMarks(String sentence) {
		return (retrieveCountOfAGivenCharacter(sentence,'"') % 2) == 0;
	}

	private boolean periodMark(String sentence) {
		// return sentence.charAt(sentence.length() - 1) == '.' && retrieveCountOfAGivenCharacter(sentence,'.') == 1;
		if(sentence.length()-1!='.'  && retrieveCountOfAGivenCharacter(sentence,'.') == 1) {
			return true;
		}
		else if(sentence.length()-1!='!'  && retrieveCountOfAGivenCharacter(sentence,'!') == 1) {
			return true;
		}
		else if(sentence.length()-1!='?'  && retrieveCountOfAGivenCharacter(sentence,'?') == 1) {
			return true;
		}
		return false;
	}



	private int retrieveCountOfAGivenCharacter(String sentence, Character charToCount) {
		int counter = 0;
		for (char c : sentence.toCharArray()) {
			if (c == charToCount) {
				counter++;
			}
		}
		return counter;
	}


	private boolean numberSpelledoutBelow13(String sentence) {
		String temp = sentence.replaceAll("[^-0-9]+", " "); 
		temp = temp.trim();

		if (temp.isEmpty()) {
			return true;
		}

		int lowestNumber = MINIMUM_ALLOWED_NUMBER;
		for (String number : temp.split(" ")) {
			lowestNumber = Math.min(lowestNumber, Integer.parseInt(number));
		}

		return lowestNumber >= MINIMUM_ALLOWED_NUMBER;
	}


}
