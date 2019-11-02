package mabed_p1;

import java.io.IOException;


public class Application {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DuplicateRemover duplicateRemover = new DuplicateRemover();
		
		try {
			duplicateRemover.remove("problem1.txt");
			duplicateRemover.write("unique_words.txt");
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	
	}
}
