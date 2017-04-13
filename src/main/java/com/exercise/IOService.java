package com.exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import com.exercise.utils.StreamAnalyzer;

public class IOService {
	
	private static String vocabularyDB = "vocabDB.txt";
	
	public String addVocabulary(String id,String eng){
		
		try(FileWriter fw = new FileWriter(vocabularyDB, true);
				BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw)){
			
			out.printf("\n%s : %s",id,eng);
			} catch (IOException e) {
				return "IOException: " + e;
			}
		return "Success add new vocabulary!";
	}
	
	public List<String> findAllVocabulary(){
		
		List<String> listVocabulary = StreamAnalyzer.analyzeFile(vocabularyDB, v->v.collect(Collectors.toList()));
		return listVocabulary;
	}
	
	public List<String> findVocabularyByWord(String keyword){
		List<String> listVocabulary = StreamAnalyzer.analyzeFile(vocabularyDB, v->v.filter(w->w.contains(keyword)).collect(Collectors.toList()));
		return listVocabulary;
	}
	
	public List<String> findVocabularyByLimit(Integer limitNumber){
		List<String> listVocabulary = StreamAnalyzer.analyzeFile(vocabularyDB, v->v.limit(limitNumber).collect(Collectors.toList()));
		return listVocabulary;
	}

}
