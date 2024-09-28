import java.util.Scanner;

/**
 * Provides functionality for users to encode messages
 *
 * @author Tyler Ferron
 */
public class EncryptionMachine {

	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	/**
	 * Encodes a single letter based on a given increment
	 *
	 * @param letter The character that will be encoded
	 * @param increment How many spots down the alphabet we will encode the letter to
	 * @return Returns the encoded letter
	 */
	private static String alterLetter(char letter, int increment) {
		int newIndex = ALPHABET.indexOf(letter) + increment;
		if (newIndex >= 26) {
			newIndex -= 26;
		}
		String newLetterString = ALPHABET.substring(newIndex, newIndex+1);
		return newLetterString;
	}

	/**
	 * Encodes a single word based on a given increment
	 *
	 * @param word The word that will be encoded
	 * @param increment How many spots down the alphabet we will encode the letter to
	 * @return Returns the encoded word
	 */
	private static String alterWord(String word, int increment) {
		String newWord = "";
		for (int i = 0; i < word.length(); i++) {
			String newLetter = alterLetter(word.charAt(i), increment);
			newWord += newLetter;
		}
		return newWord;
	}

	public static void main(String[] args)
	{
		Scanner myObj = new Scanner(System.in);
		System.out.println("Welcome to the CSCI717 Encryption Machine Construction\r\n"
				+ "The program lets you encrypt a message\r\n"
				+ "with an integer key for your recipient to decrypt!\r\n"
				+ "Enter key:\r\n");
		int key = Integer.parseInt(myObj.nextLine());
		System.out.println("What sentence do you want to encrypt?");
		String sentence = myObj.nextLine().toLowerCase();
		String[] words = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		String returnSentence = "";
		for (int i = 0; i < words.length; i++) {
			returnSentence += alterWord(words[i], key) + " ";
		}
		System.out.println("Your encrypted sentence is: \"" + returnSentence + "\"");
	}
}