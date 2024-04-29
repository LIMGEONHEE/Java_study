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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblLibraryName = new JLabel("iwill 도서관");
		lblLibraryName.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblLibraryName.setBounds(67, 88, 372, 83);
		frame.getContentPane().add(lblLibraryName);
		
		textiD = new JTextField();
		textiD.setFont(new Font("굴림", Font.BOLD, 20));
		textiD.setBounds(102, 231, 352, 47);
		frame.getContentPane().add(textiD);
		textiD.setColumns(10);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("굴림", Font.BOLD, 30));
		lblId.setBounds(33, 228, 57, 47);
		frame.getContentPane().add(lblId);
		
		lblPw = new JLabel("PW");
		lblPw.setFont(new Font("굴림", Font.BOLD, 30));
		lblPw.setBounds(33, 305, 57, 47);
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
		btnNewAccount.setBounds(180, 410, 151, 67);
		frame.getContentPane().add(btnNewAccount);
		
		btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("D2Coding", Font.BOLD, 28));
		btnLogin.setBounds(12, 410, 151, 67);
		frame.getContentPane().add(btnLogin);
		
		btnAccountSearch = new JButton("찾기");
		btnAccountSearch.setFont(new Font("D2Coding", Font.BOLD, 28));
		btnAccountSearch.setBounds(354, 410, 151, 67);
		frame.getContentPane().add(btnAccountSearch);
	}
}
