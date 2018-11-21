package com.mcpk.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		File input2 = new File("C:\\Users\\user\\eclipse-workspace\\input2.txt");
		Scanner scanner = new Scanner(input2);
		String inputString = scanner.useDelimiter("\\A").next();
		WordCounter wordCounter = new WordCounter();
		System.out.println(wordCounter.obtainWordsList(inputString));
		scanner.close();
	}
}