package com.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class IOServiceTest {
	
	@Test
	public void addVocabulary() throws Exception {	
		IOService ioService = new IOService();
		assertEquals(ioService.addVocabulary("makan", "eat"), "Success add new vocabulary!");
	}
	
	@Test
	public void findAllVocabulary() throws Exception {	
		IOService ioService = new IOService();
		assertTrue(ioService.findAllVocabulary().size()>0);
	}
	
	@Test
	public void findVocabularyByWord() throws Exception {	
		IOService ioService = new IOService();
		assertTrue(ioService.findVocabularyByWord("a").get(0).contains("a"));
	}
	
	@Test
	public void findVocabularyByLimit() throws Exception {	
		IOService ioService = new IOService();
		assertTrue(ioService.findVocabularyByLimit(2).size()==2);
	}

}
