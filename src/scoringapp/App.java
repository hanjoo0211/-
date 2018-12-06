// This app includes some Korean text encoded by "UTF-8".
// So, if you have some problem with text error, go Menu - Window - Preferences - General - Workspace.
// Then you can see "Text File Encoding". Please set it to "Other: UTF-8".

package scoringapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class App extends JFrame{
	private int scoreSum = 0;
	private int whichToCorrect = 0;
	private int setDifficulty = 0;
	
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
		Vector<JRadioButton> AnswerNumber = new Vector<>(5); // 5지선다 라디오버튼 벡터
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
			QuestionNumber.add(i, AnswerNumber);
			for(int j=0; j<5; j++) {
				QuestionNumber.get(i).add(j, new JRadioButton());
				AnswerGroup.get(i).add(QuestionNumber.get(i).get(j));
				
				if (i<10) {
					AnswerNumber.get(j).setBounds(150 + 20*j, 200 + 30*i, 20, 20);
				}
				else if (i<20) {
					AnswerNumber.get(j).setBounds(350 + 20*j, -100 + 30*i, 20, 20);
				}
				else if (i<30) {
					AnswerNumber.get(j).setBounds(550 + 20*j, -400 + 30*i, 20, 20);
				}
				else if (i<40) {
					AnswerNumber.get(j).setBounds(750 + 20*j, -700 + 30*i, 20, 20);
				}
				else if (setDifficulty != 2) {
					AnswerNumber.get(j).setBounds(950 + 20*j, -1000 + 30*i, 20, 20);
				}
				
				panel.add(AnswerNumber.get(j));
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
			
			
		}
	public static void main(String[] args) {
		new App();
	}
}

