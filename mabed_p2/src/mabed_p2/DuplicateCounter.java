package mabed_p2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DuplicateCounter {
	private Map< String,Integer> wordCounter = new HashMap< String,Integer>(); 
	private String[] uniqueWords;
	private Set<String> wordSet = new HashSet<String>();
	
	DuplicateCounter(){
	}
	
	public void getUniqueWords(String dataFile) throws IOException{
		FileInputStream fileSearch = new FileInputStream(dataFile);
		Scanner scnr = new Scanner(fileSearch);	
		while(scnr.hasNext()) {
			wordSet.add(scnr.next().trim());
		}
		fileSearch.close();
		
		this.uniqueWords = new String[wordSet.size()];
		Iterator words = wordSet.iterator();
		
		for(int i=0;i<wordSet.size();i++) {
			uniqueWords[i] = ((String) words.next()).trim();
		}
	}
	
	public void count(String dataFile) throws IOException{
		getUniqueWords(dataFile);
		
		for(int i=0;i<this.wordSet.size();i++) {
		FileInputStream fileSearch = new FileInputStream(dataFile);
		Scanner scnr = new Scanner(fileSearch);	
		String temp = "";
		int count = 0;
		while(scnr.hasNext()) {
			temp = scnr.next().trim();
			if(this.uniqueWords[i].equals(temp)) {
				count++;
			}
		}
		
		this.wordCounter.put(uniqueWords[i],count);
		fileSearch.close();
		}
		
	}
	
	public void write(String outputFile) throws FileNotFoundException {
		FileOutputStream fileWrite = new FileOutputStream(outputFile);
		PrintWriter fileOutput = new PrintWriter(fileWrite);
	       
		Set< Map.Entry< String,Integer> > temp = this.wordCounter.entrySet();    
	      
		fileOutput.println("[Unique Word : Frequency]\n");
	       for (Map.Entry< String,Integer> vals : temp) 
	       { 
	           fileOutput.print("[" + vals.getKey()+" : "); 
	           fileOutput.println(vals.getValue() + "]"); 
	       } 
	       fileOutput.close();
	    
	} 
}
