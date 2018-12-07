// Dummy-data
// 코드 테스트용

package scoringapp;
import java.util.*;
public class DatabaseProcess {
	
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(Database.answer[0][1], " \t\n\r");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token + "\n");
		}
	}

}
