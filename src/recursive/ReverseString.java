package recursive;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseString {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		String result = reverseWord(word);
		System.out.println(result);
	}

	public static String reverseWord(String word) {
		if (word.length() == 1) {
			return word;
		} else {
			return reverseWord(word.substring(1, word.length())) + word.charAt(0);
		}
	}
}
