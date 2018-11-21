package com.mcpk.wordcounter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WordCounterTest {

	private  WordCounter wordList;
	@Before
	public void setUp() {
		wordList = new  WordCounter();
	}

	@Test
	public void countWords() {
        String expectedResult = "\"dorothy\" - 2\n"+
							"\"a\" - 1\n" +
							"\"creature\" - 1\n" +
							"\"her\" - 1\n" +
							"\"quasi-bird\" - 1\n" +
							"\"saw\" - 1\n" +
							"\"terrified\" - 1\n" + 
							"\"which\" - 1\n";
        assertEquals(expectedResult, wordList. obtainWordsList("Dorothy, dorothy saw a quasi-bird creature which terrified her."));
	}
}