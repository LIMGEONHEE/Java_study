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
import javax.swing.JScrollPane;

public class AppMain05 {

	private JFrame frame;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JButton btnButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;

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

		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblName.setBounds(22, 37, 110, 30);
		frame.getContentPane().add(lblName);

		lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblPhone.setBounds(22, 87, 110, 39);
		frame.getContentPane().add(lblPhone);

		lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblEmail.setBounds(22, 136, 110, 39);
		frame.getContentPane().add(lblEmail);

		textName = new JTextField();
		textName.setBounds(144, 37, 225, 30);
		frame.getContentPane().add(textName);
		textName.setColumns(10);

		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(144, 87, 225, 30);
		frame.getContentPane().add(textPhone);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(144, 136, 225, 30);
		frame.getContentPane().add(textEmail);

		btnButton = new JButton("입력");
		btnButton.addActionListener(new ActionListener() { // 익명 내부 클래스
			@Override
			public void actionPerformed(ActionEvent e) {
				handleInputButtonClick();
			}
		});
		btnButton.setBounds(375, 131, 97, 39);
		frame.getContentPane().add(btnButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 199, 440, 202);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding", Font.BOLD, 20));
		scrollPane.setViewportView(textArea);

	}

	private void handleInputButtonClick() {
		// JTextField(이름, 전화번호, 이메일)에 입력된 문자열을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		String msg = String.format("이름: %s, 전화번호: %s, 이메일: %s\n", name, phone, email);
		
		// 이름, 전화번호, 이메일을 JTextArea에 씀.
//		textArea.setText(msg);
		textArea.append(msg); // 기존에 작성된 내용 끝에 추가.
		
		// 모든 JTextField의 입력된 내용을 지움.
		textName.setText("");
		textPhone.setText("");
		textEmail.setText("");
	}
}
