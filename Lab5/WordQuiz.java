package Lab5;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WordQuiz {
	
	private Dictionary dict;
	private boolean activeGame;
	private int numGuesses;
	private Scanner scanner = new Scanner(System.in);
	public WordQuiz(Dictionary dict) {
		
		this.dict = dict;
		boolean searchingFile = true;
		String filnamn = null;
		
		Scanner reader = new Scanner(System.in);
		
		while (searchingFile) {
			
			try {
				
				System.out.print("Vänligen skriv in vilken fil ni ska hämta glosor från: ");
				filnamn = reader.next();
				
				File file = new File("/home/ollha403/lucsp113-ollha403/" + filnamn + "/");
				InputStream is = new FileInputStream(file);
				
				
				dict.load(is);
				
				
				searchingFile = false;
			}catch (Exception e) {
				System.out.println("Error! Du stavade fel på filen, mannen kod:"+ e.getMessage());
			}
		}
		
			
	}
	
	public void runQuiz() throws IOException {
		Set<Word> cont = new HashSet<Word>();		//lägger till i cont när man har rätt på ett ord
		int tries = 1;
		File file = new File("/home/ollha403/lucsp113-ollha403/spara.txt/");
		OutputStream os = new FileOutputStream(file);
		
		activeGame = true;
		
		System.out.println("Översätt förljande ord:");
		
		while(activeGame) {
		String word; 
		
		for(Word i : dict.terms()) {
			
			if(cont.equals(dict.terms())) {
				activeGame = false;
				break;
			}
			else if(cont.contains(i)) {
				continue;
			}
			System.out.println("Ordet är: " + i);
			System.out.print("Er gissning: ");
			word = scanner.nextLine();
			
			Word w = new Word(word);
			
			if(dict.lookUp(i).contains(w)){
				cont.add(i);
				System.out.println("Rätt");
				
			}
			else {
				System.out.println("Fel!");
				numGuesses ++;
			}
			
		}
		if(cont.equals(dict.terms())) {
			activeGame = false;
			break;
		}else {
		System.out.println("Du missade " + numGuesses + " ord, du suger" );
		numGuesses = 0;
		System.out.println("TESTA IGEN");
		tries++;
		}

	} 
		System.out.println("Du gjorde det på " + tries + " försök");
		dict.save(os);
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		Dictionary sweng = new Dictionary();
	
		WordQuiz wq = new WordQuiz(sweng); 
		wq.runQuiz();
		
	}
	


}
