package scoringapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame{
	public App() {
		setTitle("�ѱ���ɷ°������� ��ä�� ���α׷� 2018320185 ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = getContentPane();
		content.setLayout(new FlowLayout());
		setSize(1600,900);
		setVisible(true);
		content.setFocusable(true);
		content.requestFocus();
		
		JLabel la = new JLabel("�ѱ���ɷ°������� ��ä�� ���α׷�");
		la.setFont(new Font("�ü�", Font.PLAIN, 40));
		content.add(la);

	
	}
	public static void main(String[] args) {
		new App();
	}

}
