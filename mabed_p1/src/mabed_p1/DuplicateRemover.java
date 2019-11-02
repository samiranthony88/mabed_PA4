package mabed_p1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
	private Set<String> wordSet = new HashSet<String>();
	public String[] uniqueWords;
	
	DuplicateRemover(){
	}
	
	public void remove(String dataFile) throws IOException{
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
	
	public void write(String outputFile) throws FileNotFoundException {
		FileOutputStream fileWrite = new FileOutputStream(outputFile);
		PrintWriter fileOutput = new PrintWriter(fileWrite);
		for(int i=0;i<this.wordSet.size();i++) {
		fileOutput.println(this.uniqueWords[i]);
		}
		fileOutput.flush();
		fileOutput.close();
	}
}
