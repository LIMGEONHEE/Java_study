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
	private JTextField textiD;
	private JLabel lblName;
	private JLabel lblId;
	private JLabel lblPw;
	private JButton btnNewAccount;
	private JButton btnUnLogin;
	private JButton btnAccountSearch;
	private JTextField textPw;

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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("로그인");
		
		lblName = new JLabel("I'will 독서왕");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblName.setBounds(33, 88, 448, 83);
		frame.getContentPane().add(lblName);
		
		textiD = new JTextField();
		textiD.setFont(new Font("굴림", Font.BOLD, 20));
		textiD.setBounds(102, 216, 352, 47);
		frame.getContentPane().add(textiD);
		textiD.setColumns(10);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("굴림", Font.BOLD, 30));
		lblId.setBounds(33, 216, 57, 47);
		frame.getContentPane().add(lblId);
		
		lblPw = new JLabel("PW");
		lblPw.setFont(new Font("굴림", Font.BOLD, 30));
		lblPw.setBounds(33, 305, 57, 47);
		frame.getContentPane().add(lblPw);
		
		textPw = new JTextField();
		textPw.setFont(new Font("굴림", Font.BOLD, 20));
		textPw.setColumns(10);
		textPw.setBounds(102, 305, 352, 47);
		frame.getContentPane().add(textPw);
		
		btnNewAccount = new JButton("회원가입");
		btnNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewAccount.setFont(new Font("D2Coding", Font.BOLD, 28));
		btnNewAccount.setBounds(92, 429, 151, 42);
		frame.getContentPane().add(btnNewAccount);
		
		btnUnLogin = new JButton("비회원 로그인");
		btnUnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 홈 페이지 창 띄우기
				BookReviewHome.showBookReviewHome(frame);;
				frame.setVisible(false); // 버튼을 누르면 창 끄기
			}
		});
		btnUnLogin.setFont(new Font("D2Coding", Font.BOLD, 28));
		btnUnLogin.setBounds(92, 481, 317, 41);
		frame.getContentPane().add(btnUnLogin);
		
		btnAccountSearch = new JButton("찾기");
		btnAccountSearch.setFont(new Font("D2Coding", Font.BOLD, 28));
		btnAccountSearch.setBounds(255, 429, 151, 42);
		frame.getContentPane().add(btnAccountSearch);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("D2Coding", Font.BOLD, 28));
		btnLogin.setBounds(92, 378, 317, 41);
		frame.getContentPane().add(btnLogin);
	}
}
