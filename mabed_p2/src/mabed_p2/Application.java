package mabed_p2;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DuplicateCounter duplicateCounter = new DuplicateCounter();
		try {
		duplicateCounter.count("problem2.txt");
		duplicateCounter.write("unique_word_counts.txt");
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
