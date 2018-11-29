package scoringapp;
import java.util.*;
public class DatabaseProcess {
	
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(Database.answer[0][0], " \t\n\r");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}

}
