package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain05 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblName.setBounds(22, 37, 110, 30);
		frame.getContentPane().add(lblName);
		
		JLabel lblNumber = new JLabel("전화번호");
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblNumber.setBounds(22, 87, 110, 39);
		frame.getContentPane().add(lblNumber);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblEmail.setBounds(22, 136, 110, 39);
		frame.getContentPane().add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(144, 37, 225, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(144, 87, 225, 30);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(144, 136, 225, 30);
		frame.getContentPane().add(textField_2);
		
		JButton btnButton = new JButton("입력");
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String number = textField_1.getText();
				String email = textField_2.getText();
				
				String msg = String.format("%s : %s : %s", name, number, email);
				textResult.setText(msg);
			}
		});
		btnButton.setBounds(375, 131, 97, 39);
		frame.getContentPane().add(btnButton);
		
		textResult = new JTextArea();
		textResult.setBounds(22, 198, 450, 180);
		frame.getContentPane().add(textResult);

		
	}
}
