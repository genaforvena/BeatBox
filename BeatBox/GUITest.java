package BeatBox;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

public class GUITest {
	JFrame frame;
	JLabel label;
	
	public static void main(String[] args) {
		GUITest gui = new GUITest();
		gui.go();
		
	}
	
	public void go() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.red);
		
		JTextArea text = new JTextArea(10,20);
		text.setLineWrap(true);
		panel.add(text);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JScrollPane scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scroll);
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JButton labelButton = new JButton("click me");
		labelButton.addActionListener(new LabelListener());
		
		JButton colorButton = new JButton("Change color");
		colorButton.addActionListener(new ColorListener());
		
		label = new JLabel("I'm a label");
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		panel.add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	class LabelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			label.setText("I've been changed");
		}
	}
	
	class ColorListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}
}
