package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ContactUpdateFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPanel;
	private JPanel buttonPanel;
	private JButton btnCancel;
	private JButton btnSave;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JLabel lblName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContactUpdateFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPanel = new JPanel();
		contentPane.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblName.setBounds(0, 10, 67, 33);
		contentPanel.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.BOLD, 20));
		textName.setBounds(91, 10, 321, 33);
		contentPanel.add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblPhone.setBounds(0, 57, 80, 33);
		contentPanel.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.BOLD, 20));
		textPhone.setColumns(10);
		textPhone.setBounds(91, 57, 321, 33);
		contentPanel.add(textPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblEmail.setBounds(0, 108, 67, 33);
		contentPanel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("D2Coding", Font.BOLD, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(91, 108, 321, 33);
		contentPanel.add(textEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnSave = new JButton("저장");
		btnSave.setFont(new Font("D2Coding", Font.BOLD, 20));
		buttonPanel.add(btnSave);
		
		btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("D2Coding", Font.BOLD, 20));
		buttonPanel.add(btnCancel);
	}
}
