// This app includes some Korean text encoded by "UTF-8".
// So, if you have some problem with text error, go Menu - Window - Preferences - General - Workspace.
// Then you can see "Text File Encoding". Please set it to "Other: UTF-8".

package scoringapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class App extends JFrame{
	private int scoreSum = 0; // 점수 합계
	private int whichToCorrect = 0; // 채점회차
	private int setDifficulty = 0; // 난이도

	private int[] CorrectAnswer = new int[50]; // 정답
	private int[] ScorePerQuestion = new int[50]; // 배점
	private int[] writtenAnswer = new int[50]; // 입력된 답안
	private boolean[] isAnswerCorrect = new boolean[50]; // 정오답 체크


	// 프로그램
	public App() {
		setTitle("한국사능력검정시험 가채점 프로그램 2018320185 김한주");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		Container content = getContentPane();

		JPanel panel = new JPanel();
		placeSelectPanel(panel);
		content.add(panel);

		setVisible(true);
		content.setFocusable(true);
		content.requestFocus();
	}

	// 첫 화면 구성
	public void placeSelectPanel(JPanel panel) {
		panel.setLayout(null);

		// 제목
		JLabel title = new JLabel("한국사능력검정시험 가채점 프로그램");
		title.setFont(new Font("궁서", Font.PLAIN, 40));
		title.setBounds(300, 50, 1200, 50);
		panel.add(title);

		// 채점회차
		JLabel toCorrect = new JLabel("채점회차");
		toCorrect.setFont(new Font("궁서", Font.PLAIN, 28));
		toCorrect.setBounds(300, 250, 1200, 50);
		panel.add(toCorrect);

		// 채점회차 선택
		JComboBox<String> toCorrectCombo = new JComboBox<>(Database.toCorrects);
		toCorrectCombo.setFont(new Font("궁서", Font.PLAIN, 28));
		toCorrectCombo.setBounds(500, 250, 200, 50);
		panel.add(toCorrectCombo);

		// 난이도
		JLabel difficulty = new JLabel("난이도");
		difficulty.setFont(new Font("궁서", Font.PLAIN, 28));
		difficulty.setBounds(300, 350, 1200, 50);
		panel.add(difficulty);

		// 난이도 선택
		ButtonGroup difficultyGroup = new ButtonGroup();

		JRadioButton difficulty0 = new JRadioButton("고급", true);
		JRadioButton difficulty1 = new JRadioButton("중급");
		JRadioButton difficulty2 = new JRadioButton("초급");

		difficulty0.setFont(new Font("궁서", Font.PLAIN, 28));
		difficulty1.setFont(new Font("궁서", Font.PLAIN, 28));
		difficulty2.setFont(new Font("궁서", Font.PLAIN, 28));

		difficulty0.setBounds(500, 350, 100, 50);
		difficulty1.setBounds(600, 350, 100, 50);
		difficulty2.setBounds(700, 350, 100, 50);

		difficultyGroup.add(difficulty0);
		difficultyGroup.add(difficulty1);
		difficultyGroup.add(difficulty2);

		panel.add(difficulty0);
		panel.add(difficulty1);
		panel.add(difficulty2);

		// 채점방식
		JLabel correctingMethod = new JLabel("채점방식");
		correctingMethod.setFont(new Font("궁서", Font.PLAIN, 28));
		correctingMethod.setBounds(300, 450, 1200, 50);
		panel.add(correctingMethod);

		// 채점방식 선택
		ButtonGroup correctingMethodGroup = new ButtonGroup();

		JRadioButton correctBy1 = new JRadioButton("1문제씩(선택식)", true);
		JRadioButton correctBy5 = new JRadioButton("5문제씩(입력식)");


		correctBy1.setFont(new Font("궁서", Font.PLAIN, 28));
		correctBy5.setFont(new Font("궁서", Font.PLAIN, 28));


		correctBy1.setBounds(500, 450, 300, 50);
		correctBy5.setBounds(800, 450, 300, 50);


		correctingMethodGroup.add(correctBy1);
		correctingMethodGroup.add(correctBy5);


		panel.add(correctBy1);
		panel.add(correctBy5);

		// 진행버튼
		JButton goButton = new JButton("채점하기");
		goButton.setFont(new Font("궁서", Font.PLAIN, 28));
		goButton.setBounds(550, 600, 180, 50);
		panel.add(goButton);

		// 진행버튼 리스너
		goButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 채점회차 적용
				whichToCorrect = toCorrectCombo.getSelectedIndex();

				// 난이도 적용
				if(difficulty2.isSelected())
					setDifficulty = 2;
				else if (difficulty1.isSelected())
					setDifficulty = 1;
				else
					setDifficulty = 0;

				// 데이터베이스에서 정답 추출
				AnswerProcess(Database.answer[whichToCorrect][setDifficulty]);

				// 화면 전환
				panel.removeAll();
				panel.repaint();

				// 채점 방식 적용
				if(correctBy1.isSelected())
					placeCorrecting1Panel(panel);
				else
					placeCorrecting5Panel(panel);


			}
		});
	}

	// 채점 화면 구성 (1문제씩)
	public void placeCorrecting1Panel(JPanel panel) {
		panel.setLayout(null);

		// 제목
		JLabel title = new JLabel("한국사능력검정시험 가채점 프로그램");
		title.setFont(new Font("궁서", Font.PLAIN, 40));
		title.setBounds(300, 50, 1200, 50);
		panel.add(title);

		// 입력
		Vector<ButtonGroup> AnswerGroup = new Vector<>(50); // 라디오버튼 그룹 벡터
		Vector<Vector<JRadioButton>> QuestionNumber = new Vector<>(50); // 5지선다 벡터 포함하는 문제 번호 벡터

		for(int i=0; i<50; i++) {
			JLabel QuestionNumbers = new JLabel(Integer.toString(i+1));
			QuestionNumbers.setFont(new Font("궁서", Font.PLAIN, 20));
			if (i<10) {
				QuestionNumbers.setBounds(125, 200 + 30*i, 40, 20);
			}
			else if (i<20) {
				QuestionNumbers.setBounds(325, -100 + 30*i, 40, 20);
			}
			else if (i<30) {
				QuestionNumbers.setBounds(525, -400 + 30*i, 40, 20);
			}
			else if (i<40) {
				QuestionNumbers.setBounds(725, -700 + 30*i, 40, 20);
			}
			else if (setDifficulty != 2){ // 초급은 문제가 40문제
				QuestionNumbers.setBounds(925, -1000 + 30*i, 40, 20);
			}

			panel.add(QuestionNumbers);

			AnswerGroup.add(i, new ButtonGroup());
			QuestionNumber.add(i, new Vector<JRadioButton>(5)); // 5지선다 라디오버튼

			for(int j=0; j<5; j++) {
				QuestionNumber.get(i).add(j, new JRadioButton());
				AnswerGroup.get(i).add(QuestionNumber.get(i).get(j));

				if (i<10) {
					QuestionNumber.get(i).get(j).setBounds(150 + 20*j, 200 + 30*i, 20, 20);
				}
				else if (i<20) {
					QuestionNumber.get(i).get(j).setBounds(350 + 20*j, -100 + 30*i, 20, 20);
				}
				else if (i<30) {
					QuestionNumber.get(i).get(j).setBounds(550 + 20*j, -400 + 30*i, 20, 20);
				}
				else if (i<40) {
					QuestionNumber.get(i).get(j).setBounds(750 + 20*j, -700 + 30*i, 20, 20);
				}
				else if (setDifficulty != 2) {
					QuestionNumber.get(i).get(j).setBounds(950 + 20*j, -1000 + 30*i, 20, 20);
				}

				panel.add(QuestionNumber.get(i).get(j));
			}
		}

		// 진행버튼
		JButton goButton = new JButton("결과보기");
		goButton.setFont(new Font("궁서", Font.PLAIN, 28));
		goButton.setBounds(550, 600, 180, 50);
		panel.add(goButton);

		// 진행버튼 리스너
		goButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// 입력 데이터 저장
				for(int i=0; i<50; i++) {
					for(int j=0; j<5; j++) {
						if(QuestionNumber.get(i).get(j).isSelected())
							writtenAnswer[i] = j+1;						
					}

				}

				// 채점
				CorrectingProcess(setDifficulty, CorrectAnswer, ScorePerQuestion, writtenAnswer);

				// 결과화면 전환
				panel.removeAll();
				panel.repaint();
				placeScorePanel(panel);


			}
		});
	}

	// 채점화면 구성 (5문제씩)
	public void placeCorrecting5Panel(JPanel panel) {
		panel.setLayout(null);

		// 제목
		JLabel title = new JLabel("한국사능력검정시험 가채점 프로그램");
		title.setFont(new Font("궁서", Font.PLAIN, 40));
		title.setBounds(300, 50, 1200, 50);
		panel.add(title);
		
		// 안내문
		JLabel notice = new JLabel("답안을 5개 단위로 끊어서 입력하십시오. 모든 답안이 입력되지 않을 시 진행되지 않을 수 있습니다.");
		notice.setFont(new Font("궁서", Font.PLAIN, 24));
		notice.setBounds(100, 120, 1200, 50);
		panel.add(notice);

		// 입력
		Vector<JTextField> AnswerText = new Vector<>(10);

		for(int i=0; i<10; i++) {
			JLabel QuestionNumbers = new JLabel((5*i+1) + " ~ " + (5*i+5));
			QuestionNumbers.setFont(new Font("궁서", Font.PLAIN, 20));
			AnswerText.add(i, new JTextField(5));
			AnswerText.get(i).setFont(new Font("굴림", Font.PLAIN, 16));

			if (i<8) {
				QuestionNumbers.setBounds(565, 200 + 35*i, 100, 20);
				AnswerText.get(i).setBounds(665, 200 + 35*i, 50, 20);
			}
			else if (setDifficulty != 2){
				QuestionNumbers.setBounds(565, 200 + 35*i, 100, 20);
				AnswerText.get(i).setBounds(665, 200 + 35*i, 50, 20);
			}
			panel.add(QuestionNumbers);
			panel.add(AnswerText.get(i));
		}

		// 진행버튼
		JButton goButton = new JButton("결과보기");
		goButton.setFont(new Font("궁서", Font.PLAIN, 28));
		goButton.setBounds(550, 600, 180, 50);
		panel.add(goButton);

		// 진행버튼 리스너
		goButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 입력 데이터 저장
				int QuestionNumber = 10;
				if(setDifficulty == 2)
					QuestionNumber = 8;
				for(int i=0; i<QuestionNumber; i++) {
					char charAnswer[] = AnswerText.get(i).getText().toCharArray();
					for(int j=0; j<5; j++)
						writtenAnswer[5*i+j] = (int)(charAnswer[j]-48); // 숫자키의 아스키코드를 숫자로 변환
				}

				// 채점
				CorrectingProcess(setDifficulty, CorrectAnswer, ScorePerQuestion, writtenAnswer);

				// 결과화면 전환
				panel.removeAll();
				panel.repaint();
				placeScorePanel(panel);


			}
		});
	}

	// 결과화면 구성
	public void placeScorePanel(JPanel panel) {
		panel.setLayout(null);

		// 제목
		JLabel title = new JLabel("한국사능력검정시험 가채점 프로그램");
		title.setFont(new Font("궁서", Font.PLAIN, 40));
		title.setBounds(300, 50, 1200, 50);
		panel.add(title);

		// 점수 안내
		JLabel score = new JLabel("당신의 점수는 " + scoreSum + "점 입니다.");
		score.setFont(new Font("궁서", Font.PLAIN, 28));
		score.setBounds(450, 300, 600, 50);
		panel.add(score);

		// 등급 안내
		JLabel rate = new JLabel();

		switch(setDifficulty) {
		case 0:
			if(scoreSum >= 70)
				rate = new JLabel("축하합니다. 제 " + (41 - whichToCorrect) + "회 한국사능력검정시험에 1급으로 합격하셨습니다.");
			else if(scoreSum >= 60)
				rate = new JLabel("축하합니다. 제 " + (41 - whichToCorrect) + "회 한국사능력검정시험에 2급으로 합격하셨습니다.");
			else
				rate = new JLabel("제 " + (41 - whichToCorrect) + "회 한국사능력검정시험에 합격하지 못했습니다.");
			break;
		case 1:
			if(scoreSum >= 70)
				rate = new JLabel("축하합니다. 제 " + (41 - whichToCorrect) + "회 한국사능력검정시험에 3급으로 합격하셨습니다.");
			else if(scoreSum >= 60)
				rate = new JLabel("축하합니다. 제 " + (41 - whichToCorrect) + "회 한국사능력검정시험에 4급으로 합격하셨습니다.");
			else
				rate = new JLabel("제 " + (41 - whichToCorrect) + "회 한국사능력검정시험에 합격하지 못했습니다.");
			break;
		case 2:
			if(scoreSum >= 70)
				rate = new JLabel("축하합니다. 제 " + (41 - whichToCorrect) + "회 한국사능력검정시험에 5급으로 합격하셨습니다.");
			else if(scoreSum >= 60)
				rate = new JLabel("축하합니다. 제 " + (41 - whichToCorrect) + "회 한국사능력검정시험에 6급으로 합격하셨습니다.");
			else
				rate = new JLabel("제 " + (41 - whichToCorrect) + "회 한국사능력검정시험에 합격하지 못했습니다.");
			break;
		}

		rate.setFont(new Font("궁서", Font.PLAIN, 28));
		if(scoreSum >= 60)
			rate.setBounds(185, 400, 1000, 50);
		else
			rate.setBounds(300, 400, 1000, 50);
		panel.add(rate);

		// 다시하기 버튼
		JButton goButton = new JButton("다시하기");
		goButton.setFont(new Font("궁서", Font.PLAIN, 28));
		goButton.setBounds(550, 600, 180, 50);
		panel.add(goButton);

		// 다시하기 버튼 리스너
		goButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 초기화면 전환
				panel.removeAll();
				panel.repaint();
				placeSelectPanel(panel);
			}
		});
	}

	// 데이터베이스에서 정답을 추출하는 메소드
	public void AnswerProcess(String answerData) { // answerData에는 Database.answer[n-9][0/1/2]가 들어갑니다.
		int QuestionNumber = 0; // 문제 번호

		StringTokenizer st = new StringTokenizer(answerData, " \t\n\r");
		while(st.hasMoreTokens()) {
			QuestionNumber = Integer.parseInt(st.nextToken());
			CorrectAnswer[QuestionNumber-1] = Integer.parseInt(st.nextToken());
			ScorePerQuestion[QuestionNumber-1] = Integer.parseInt(st.nextToken());
		}
	}

	// 채점 메소드
	public void CorrectingProcess(int difficulty, int[] CorrectAnswer, int[] ScorePerQuestion, int[] writtenAnswer) {
		scoreSum = 0; // 점수 초기화
		int QuestionNumbers = 50; // 문제 개수

		if(difficulty == 2)
			QuestionNumbers = 40; // 초급 문제 개수 40

		for(int i=0; i<QuestionNumbers; i++) {
			if(writtenAnswer[i] == CorrectAnswer[i]) {
				scoreSum += ScorePerQuestion[i];
				isAnswerCorrect[i] = true;
			}
			else
				isAnswerCorrect[i] = false;
		}

	}
	public static void main(String[] args) {
		new App();
	}
}

