package com.exercise;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.exercise.utils.StreamAnalyzer;

public class MainClass {
	
	private static String fileName = "menu.txt";
	private static Scanner in;

	public static void main(String[] args) {
		
		List<String> menuList = StreamAnalyzer.analyzeFile(fileName,w->w.limit(5).collect(Collectors.toList()));
		boolean exit = false;
		IOService ioService = new IOService();
		do{
			menuList.forEach(System.out::println);
			System.out.print("Please choose your input: ");
			in = new Scanner(System.in);
			int i = in.nextInt();
			if(i==1){
				System.out.println("##########################");
				ioService.findAllVocabulary().forEach(System.out::println);
				System.out.println("##########################");
			}
			else if(i==2){
				System.out.println("##########################");
				System.out.print("Please enter your keyword: ");
				in = new Scanner(System.in);
				String input = in.next();
				ioService.findVocabularyByWord(input).forEach(System.out::println);
				System.out.println("##########################");
			}
			else if(i==3){
				System.out.println("##########################");
				System.out.print("Please enter your limit: ");
				in = new Scanner(System.in);
				int input = in.nextInt();
				ioService.findVocabularyByLimit(input).forEach(System.out::println);
				System.out.println("##########################");
			}
			else if(i==4){
				System.out.println("##########################");
				System.out.print("Please enter your vocabulary in Bahasa: ");
				in = new Scanner(System.in);
				String inputId = in.next();
				
				System.out.print("Please enter your vocabulary in English: ");
				in = new Scanner(System.in);
				String inputEng = in.next();
				
				System.out.println(ioService.addVocabulary(inputId, inputEng));
				System.out.println("##########################");
			}
			else if(i==5){
				exit = true;
			}
		}while(!exit);
		

	}

}
