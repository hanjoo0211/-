package scoringapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame{
	public App() {
		setTitle("한국사능력검정시험 가채점 프로그램 2018320185 김한주");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = getContentPane();
		content.setLayout(new FlowLayout());
		setSize(1600,900);
		setVisible(true);
		content.setFocusable(true);
		content.requestFocus();
		
		JLabel la = new JLabel("한국사능력검정시험 가채점 프로그램");
		la.setFont(new Font("궁서", Font.PLAIN, 40));
		content.add(la);

	
	}
	public static void main(String[] args) {
		new App();
	}

}
