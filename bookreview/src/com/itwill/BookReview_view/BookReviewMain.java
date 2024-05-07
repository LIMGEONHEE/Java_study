package com.itwill.BookReview_view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class BookReviewMain {

	private JFrame frame;
	private JLabel lblName;
	private JButton btnUnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookReviewMain window = new BookReviewMain();
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
	public BookReviewMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 533, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("로그인");
		
		lblName = new JLabel("I'will 독서노트");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("D2Coding", Font.BOLD, 50));
		lblName.setBounds(33, 88, 448, 83);
		frame.getContentPane().add(lblName);
		
		btnUnLogin = new JButton("들어가기");
		btnUnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 홈 페이지 창 띄우기
				BookReviewHome.showBookReviewHome(frame);;
				frame.setVisible(false); // 버튼을 누르면 창 끄기
			}
		});
		btnUnLogin.setFont(new Font("D2Coding", Font.BOLD, 28));
		btnUnLogin.setBounds(158, 293, 201, 41);
		frame.getContentPane().add(btnUnLogin);
	}
}
