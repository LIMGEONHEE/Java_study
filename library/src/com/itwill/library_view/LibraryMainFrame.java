package com.itwill.library_view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LibraryMainFrame {

	private JFrame frame;
	private JTextField textiD;
	private JLabel lblLibraryName;
	private JLabel lblId;
	private JLabel lblPw;
	private JButton btnNewAccount;
	private JButton btnLogin;
	private JButton btnAccountSearch;
	private JTextField textPw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryMainFrame window = new LibraryMainFrame();
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
	public LibraryMainFrame() {
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
		
		lblLibraryName = new JLabel("Iwill 도서관");
		lblLibraryName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibraryName.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblLibraryName.setBounds(33, 88, 448, 83);
		frame.getContentPane().add(lblLibraryName);
		
		textiD = new JTextField();
		textiD.setFont(new Font("굴림", Font.BOLD, 20));
		textiD.setBounds(102, 231, 352, 47);
		frame.getContentPane().add(textiD);
		textiD.setColumns(10);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("굴림", Font.BOLD, 30));
		lblId.setBounds(33, 231, 57, 47);
		frame.getContentPane().add(lblId);
		
		lblPw = new JLabel("PW");
		lblPw.setFont(new Font("굴림", Font.BOLD, 30));
		lblPw.setBounds(33, 308, 57, 47);
		frame.getContentPane().add(lblPw);
		
		textPw = new JTextField();
		textPw.setFont(new Font("굴림", Font.BOLD, 20));
		textPw.setColumns(10);
		textPw.setBounds(102, 308, 352, 47);
		frame.getContentPane().add(textPw);
		
		btnNewAccount = new JButton("회원가입");
		btnNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewAccount.setFont(new Font("D2Coding", Font.BOLD, 28));
		btnNewAccount.setBounds(92, 447, 151, 54);
		frame.getContentPane().add(btnNewAccount);
		
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 홈 페이지 창 띄우기
				LibraryHomePageFrame.showLibraryHomePageFrame(frame);
				frame.setVisible(false); // 버튼을 누르면 창 끄기
				
			}
		});
		btnLogin.setFont(new Font("D2Coding", Font.BOLD, 28));
		btnLogin.setBounds(92, 390, 317, 47);
		frame.getContentPane().add(btnLogin);
		
		btnAccountSearch = new JButton("찾기");
		btnAccountSearch.setFont(new Font("D2Coding", Font.BOLD, 28));
		btnAccountSearch.setBounds(255, 447, 151, 54);
		frame.getContentPane().add(btnAccountSearch);
	}
}
