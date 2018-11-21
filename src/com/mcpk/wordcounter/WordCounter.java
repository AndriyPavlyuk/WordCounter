package com.mcpk.wordcounter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map;

public class WordCounter {

	public String obtainWordsList(String inputString) {
		int count;
		String[] wordsArray = inputString.toLowerCase().split("\\s+");
		Map<String, Integer> wordsMap = new TreeMap<>();
		
		for (String word : wordsArray) {
			String separatedWord = separateSymbols(word);
			if (wordsMap.containsKey(separatedWord)) {
				count = wordsMap.get(separatedWord);
				wordsMap.put(separatedWord, count + 1);
			} else {
				wordsMap.put(separatedWord, 1);
			}
		}
		Map<String, Integer> sortByCountValueMap = sortByCountValue(wordsMap);
		return displayWordsList(sortByCountValueMap);
	}

	private String displayWordsList(Map<String, Integer> charactersMap) {
		StringBuilder charactersList = new StringBuilder();
		for (String key : charactersMap.keySet()) {
			charactersList.append("\"" + key + "\" - " + charactersMap.get(key));
			charactersList.append("\n");
		}
		return charactersList.toString();
	}

	private static String separateSymbols(String word) {
		int numberOfLetters = 0;
		int wordLength = word.length();
		char[] fullWord = word.toCharArray();
		for (int i = 0; i < wordLength; i++) {
			if (Character.isLetter(fullWord[i]) || (fullWord[i] == '-')) {
				numberOfLetters++;
			}
		}
		char[] letters = new char[numberOfLetters];
		numberOfLetters = 0;
		for (int i = 0; i < wordLength; i++) {
			if (Character.isLetter(fullWord[i]) || (fullWord[i] == '-')) {
				letters[numberOfLetters] = fullWord[i];
				numberOfLetters++;
			}
		}
		return String.valueOf(letters);
	}

	public static Map<String, Integer> sortByCountValue(Map<String, Integer> mapOfRepeatedWord) {

		Set<Map.Entry<String, Integer>> setOfWordEntries = mapOfRepeatedWord.entrySet();

		List<Map.Entry<String, Integer>> listOfwordEntry = new ArrayList<Map.Entry<String, Integer>>(setOfWordEntries);

		Collections.sort(listOfwordEntry, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> es1, Entry<String, Integer> es2) {
				return es2.getValue().compareTo(es1.getValue());
			}
		});

		Map<String, Integer> wordLHMap = new LinkedHashMap<String, Integer>();

		for (Map.Entry<String, Integer> map : listOfwordEntry) {
			wordLHMap.put(map.getKey(), map.getValue());
		}

		return wordLHMap;
	}
}