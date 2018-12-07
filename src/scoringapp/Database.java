// This app includes some Korean text encoded by "UTF-8".
// So, if you have some problem with text error, go Menu - Window - Preferences - General - Workspace.
// Then you can see "Text File Encoding". Please set it to "Other: UTF-8".

package scoringapp;

public class Database {
	
	static String toCorrects[] = {"41회차(최근)", "40회차", "39회차", "38회차", "37회차", "36회차", "35회차", "34회차", "33회차", "32회차", "31회차", "30회차", 
			"29회차", "28회차", "27회차", "26회차", "25회차", "24회차", "23회차", "22회차", "21회차", "20회차", 
			"19회차", "18회차", "17회차", "16회차", "15회차", "14회차", "13회차", "12회차", "11회차", "10회차", "9회차"};
	
	static String answer[][] // n회차 고/중/초급 각각 answer[41-n][0/1/2] *9회차부터 정답 존재
			= {
					// 41회차
					{"1	4	1	26	5	2\r\n" + 
							"2	2	3	27	5	2\r\n" + 
							"3	1	1	28	2	3\r\n" + 
							"4	1	2	29	5	1\r\n" + 
							"5	4	3	30	5	2\r\n" + 
							"6	3	2	31	1	2\r\n" + 
							"7	4	1	32	3	3\r\n" + 
							"8	1	2	33	5	2\r\n" + 
							"9	5	2	34	5	1\r\n" + 
							"10	4	2	35	1	2\r\n" + 
							"11	3	3	36	2	3\r\n" + 
							"12	4	1	37	4	1\r\n" + 
							"13	4	2	38	2	2\r\n" + 
							"14	1	2	39	2	2\r\n" + 
							"15	1	2	40	3	2\r\n" + 
							"16	4	2	41	3	3\r\n" + 
							"17	3	2	42	4	2\r\n" + 
							"18	2	2	43	2	1\r\n" + 
							"19	2	2	44	2	2\r\n" + 
							"20	2	3	45	3	2\r\n" + 
							"21	1	1	46	2	2\r\n" + 
							"22	3	2	47	1	2\r\n" + 
							"23	1	2	48	3	3\r\n" + 
							"24	4	3	49	5	2\r\n" + 
							"25	3	2	50	3	1", // 41회차 고급
							
							"1	2	1	26	3	2\r\n" + 
							"2	5	2	27	3	2\r\n" + 
							"3	1	2	28	5	3\r\n" + 
							"4	2	2	29	4	2\r\n" + 
							"5	1	3	30	4	1\r\n" + 
							"6	1	1	31	4	2\r\n" + 
							"7	2	2	32	5	1\r\n" + 
							"8	1	2	33	2	2\r\n" + 
							"9	1	2	34	5	2\r\n" + 
							"10	4	3	35	1	2\r\n" + 
							"11	5	1	36	4	2\r\n" + 
							"12	2	3	37	3	2\r\n" + 
							"13	4	2	38	3	3\r\n" + 
							"14	2	3	39	4	3\r\n" + 
							"15	5	1	40	5	1\r\n" + 
							"16	3	2	41	5	2\r\n" + 
							"17	4	2	42	5	2\r\n" + 
							"18	5	2	43	2	2\r\n" + 
							"19	4	2	44	2	1\r\n" + 
							"20	5	2	45	3	3\r\n" + 
							"21	4	2	46	3	2\r\n" + 
							"22	2	1	47	1	3\r\n" + 
							"23	3	2	48	5	2\r\n" + 
							"24	1	2	49	4	1\r\n" + 
							"25	4	3	50	2	2", // 41회차 중급
							
							"1	3	2	21	1	3\r\n" + 
							"2	4	3	22	4	2\r\n" + 
							"3	4	2	23	2	3\r\n" + 
							"4	1	3	24	2	2\r\n" + 
							"5	2	2	25	1	2\r\n" + 
							"6	3	3	26	3	2\r\n" + 
							"7	1	2	27	2	3\r\n" + 
							"8	2	3	28	1	2\r\n" + 
							"9	2	2	29	3	3\r\n" + 
							"10	3	2	30	3	3\r\n" + 
							"11	4	3	31	1	3\r\n" + 
							"12	4	3	32	4	2\r\n" + 
							"13	3	2	33	3	3\r\n" + 
							"14	1	2	34	1	2\r\n" + 
							"15	3	2	35	2	2\r\n" + 
							"16	2	3	36	2	3\r\n" + 
							"17	4	3	37	1	2\r\n" + 
							"18	2	3	38	4	2\r\n" + 
							"19	3	2	39	2	3\r\n" + 
							"20	4	3	40	3	3"} // 41회차 초급
			};
	public static void main(String[] args) {
		//System.out.println(answer[0][2]);

	}

}