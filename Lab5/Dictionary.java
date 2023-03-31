package Lab5;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Dictionary {
	
	private Map<Word, Set<Word>> dict = new HashMap<Word, Set<Word>>();
	
	
	public void add (Word k, Word v) { // Här tar vi emot nycklar & värden som object & lägger till dem i vår hashmap
		
		if(dict.containsKey(k)==true) { //Kollar om nyckeln k finns i dict
			dict.get(k).add(v); // Om nycklen k redan finns så läggs värdet V till i denns set
		}else{
			dict.put(k, new HashSet<Word>()); // Om nyckeln inte finns i dict så skapar vi den nyckeln
			dict.get(k).add(v); // Och lägger där efter till värdet i nyckelns set.
		}
		
	}
	
	public void add (String k, String v) { // Om vi får in en ny nyckel & värde som string så skickar vi dem hit.
		add(new Word(k), new Word(v)); // Här skickar vi båda string genom metoden Word så att dem blir till object, därefter skickas dem till andra ADD funktionen
		
	}
	
	public Set<Word> terms () {	// Denna klassen returnerar samtliga nycklar i vår hashamap
		return dict.keySet();
	}
	
	// tar in en nyckel & tar fram samtliga värden till den nyckeln
	public Set<Word> lookUp (Word k) {
		if(dict.containsKey(k)) { // Kollar om nyckeln K finns med i dict.
			return dict.get(k); // om nyckeln k finns med så returneras samtliga värden
		}else
		return null; // Om inte så returneras null.
	}
	
	public Dictionary inverse() {
		
		Dictionary d = new Dictionary();
		
		for(Word i : dict.keySet()) {
			for(Set<Word> j : dict.values()) {
			
				d.add(j.toString(), i.toString());
				
			}
		}
		return d;
	}
	
	// Läser in orden från givna strömmen & lägger dessa i ordlistan
	public void load (InputStream is)  {
		Scanner sc = new Scanner(is);
		
		//Nu kör vi
		while(sc.hasNextLine()) {
			
			String line = sc.nextLine();
			String[] kv = line.split("=");
			
			String key = kv[0];
			String value = kv[1];
			
			add(key.trim(), value.trim());
		}
		
	}
	// Lagrar ordlistan på dem givna strömmen
	public void save (OutputStream os) throws IOException {
		
		String key;
		String value;
			
			for (Word i : dict.keySet()) {
					key = i.toString();
					
				for (Word j : dict.get(i)) {
					value = j.toString();
					
					os.write((key + " = " + value + "\n").getBytes());
				}
					
			}
			
		
	}

}
