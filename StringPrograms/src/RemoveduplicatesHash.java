import java.util.LinkedHashSet;
import java.util.Set;


public class RemoveduplicatesHash {

	public static void main(String[] args) {
		
		 String string = "geeksforgeeks";

		    char[] chars = string.toCharArray();
		    Set<Character> charSet = new LinkedHashSet<Character>();
		    for (char c : chars) {
		        charSet.add(c);
		    }

		    StringBuilder sb = new StringBuilder();
		    for (Character character : charSet) {
		        sb.append(character);
		    }
		    		
		    System.out.println(String.valueOf(sb));
	}

}
