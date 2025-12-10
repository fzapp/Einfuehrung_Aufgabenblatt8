package p2;
import java.lang.String;

public class P2_main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String shortenToLowerCase(String input, int shortenBy) {
		if(input.length() < shortenBy) {
			return "";
		}
		String output = input.substring(0,input.length()-shortenBy);
		return output.toLowerCase();
	}

}
