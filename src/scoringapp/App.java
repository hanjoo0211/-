// This app includes some Korean text encoded by "UTF-8".
// So, if you have some problem with text error, go Menu - Window - Preferences - General - Workspace.
// Then you can see "Text File Encoding". Please set it to "Other: UTF-8".

package scoringapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame{
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
		
		// 채점회차 선택 리스너
		toCorrectCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//작성합시다
			}
		});
		
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
		
		// 난이도 선택 리스너
		difficulty0.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(difficulty0.isSelected()) {
					//작성합시다
				}
			}
		});
		
		difficulty1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(difficulty1.isSelected()) {
					//작성합시다
				}
			}
		});
		
		difficulty2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(difficulty2.isSelected()) {
					//작성합시다
				}
			}
		});
		
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
		
		// 채점방식 선택 리스너
		correctBy1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(correctBy1.isSelected()) {
					//작성합시다
				}
			}
		});
		
		correctBy5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(correctBy5.isSelected()) {
					//작성합시다
				}
			}
		});
		
		// 진행버튼
		JButton goButton = new JButton("채점하기");
		goButton.setFont(new Font("궁서", Font.PLAIN, 28));
		goButton.setBounds(550, 600, 180, 50);
		panel.add(goButton);
		
		// 진행버튼 리스너
		goButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//작성합시다
			}
		});
	}
	public static void main(String[] args) {
		new App();
	}
}

