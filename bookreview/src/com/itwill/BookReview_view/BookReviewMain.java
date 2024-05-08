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
import javax.swing.ImageIcon;
import java.awt.Color;


public class BookReviewMain {

	private JFrame frame;
	private JLabel lblName;
	private JButton btnUnLogin;
	private JLabel lblNewLabel;

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
		frame.getContentPane().setBackground(new Color(215, 209, 187));
		frame.setBounds(100, 100, 533, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("입장");
		
		lblName = new JLabel("이름 추천 받아요~");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("D2Coding", Font.BOLD, 45));
		lblName.setBounds(67, 60, 391, 62);
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
		btnUnLogin.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnUnLogin.setBounds(183, 408, 141, 41);
		frame.getContentPane().add(btnUnLogin);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\icon\\book.jpg"));
		lblNewLabel.setBounds(32, 132, 450, 261);
		frame.getContentPane().add(lblNewLabel);
	}
}
