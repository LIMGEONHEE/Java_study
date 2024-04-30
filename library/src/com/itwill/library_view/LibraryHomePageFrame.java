package com.itwill.library_view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraryHomePageFrame extends JFrame {
	
	private JFrame frame;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel searchPanel;
	private JTextField textSearchKeyword;
	private JComboBox comboBox;
	private JButton btnSearch;
	private JButton btnHome;
	private JButton btnInfo;
	private JButton btnMyBooks;
	private JButton btnLogout;
	private JPanel panelBestBooks;
	private JLabel lblBestBooks;
	
	private Component parent;
	private JButton btnNew1;
	private JButton btnNew2;
	private JButton btnNew3;
	private JButton btnNew4;
	private JTextField textBest1;
	private JTextField textBest2;
	private JTextField textBest3;
	private JTextField textBest4;
	private JPanel panelNewBooks;
	private JLabel lblNewBooks;
	private JButton btnNew1_1;
	private JButton btnNew2_1;
	private JButton btnNew3_1;
	private JButton btnNew4_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


	/**
	 * Launch the application.
	 */
	public static void showLibraryHomePageFrame(Component parent) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryHomePageFrame frame = new LibraryHomePageFrame(parent);
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
	private LibraryHomePageFrame(Component parent) {
		this.parent = parent;
		
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 0;
		int y = 0;
		if (parent != null) {
            x = parent.getX(); // 부모 컴포넌트의 x 좌표
            y = parent.getY(); // 부모 컴포넌트의 y 좌표
        }
        setBounds(x, y, 600, 600);
        
        if (parent == null) {
            setLocationRelativeTo(null); // 화면 중앙에 JFrame을 띄움.
        }
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Iwill 도서관");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 33));
		lblNewLabel.setBounds(0, 0, 584, 44);
		contentPane.add(lblNewLabel);
		
		searchPanel = new JPanel();
		searchPanel.setBounds(0, 43, 584, 52);
		contentPane.add(searchPanel);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("D2Coding", Font.BOLD, 25));
		searchPanel.add(comboBox);
		
		textSearchKeyword = new JTextField();
		textSearchKeyword.setFont(new Font("D2Coding", Font.BOLD, 25));
		searchPanel.add(textSearchKeyword);
		textSearchKeyword.setColumns(25);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 검색한 결과 창 띄우기
				LibrarySearchFrame.showLibrarySearchFrame(parent);
				
			}
		});
		btnSearch.setFont(new Font("D2Coding", Font.BOLD, 25));
		searchPanel.add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 509, 584, 52);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnHome = new JButton("홈");
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setFont(new Font("D2Coding", Font.BOLD, 25));
		panel.add(btnHome);
		
		btnInfo = new JButton("정보");
		btnInfo.setBackground(new Color(255, 255, 255));
		btnInfo.setFont(new Font("D2Coding", Font.BOLD, 25));
		panel.add(btnInfo);
		
		btnMyBooks = new JButton("내 서재");
		btnMyBooks.setBackground(new Color(255, 255, 255));
		btnMyBooks.setFont(new Font("D2Coding", Font.BOLD, 25));
		panel.add(btnMyBooks);
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("D2Coding", Font.BOLD, 25));
		panel.add(btnLogout);
		
		panelBestBooks = new JPanel();
		panelBestBooks.setBounds(10, 105, 560, 195);
		contentPane.add(panelBestBooks);
		panelBestBooks.setLayout(null);
		
		lblBestBooks = new JLabel("인기도서");
		lblBestBooks.setBounds(220, 0, 80, 24);
		lblBestBooks.setFont(new Font("D2Coding", Font.BOLD, 20));
		panelBestBooks.add(lblBestBooks);
		
		btnNew1 = new JButton("");
		btnNew1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 도서 상세 창 띄우기
				LibraryDetailFrame.showLibraryDetailFrame(frame);
			}
		});
		btnNew1.setIcon(new ImageIcon("C:\\Users\\itwill\\Downloads\\22.jpg"));
		btnNew1.setBounds(29, 31, 90, 139);
		panelBestBooks.add(btnNew1);
		
		btnNew2 = new JButton("");
		btnNew2.setIcon(new ImageIcon("C:\\Users\\itwill\\Downloads\\3434.jpg"));
		btnNew2.setBounds(161, 31, 97, 139);
		panelBestBooks.add(btnNew2);
		
		btnNew3 = new JButton("");
		btnNew3.setIcon(new ImageIcon("C:\\Users\\itwill\\Downloads\\112e.jpg"));
		btnNew3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNew3.setBounds(305, 31, 90, 139);
		panelBestBooks.add(btnNew3);
		
		btnNew4 = new JButton("");
		btnNew4.setIcon(new ImageIcon("C:\\Users\\itwill\\Downloads\\rkrhq (1).jpg"));
		btnNew4.setBounds(439, 31, 90, 139);
		panelBestBooks.add(btnNew4);
		
		textBest1 = new JTextField();
		textBest1.setBackground(Color.WHITE);
		textBest1.setHorizontalAlignment(SwingConstants.CENTER);
		textBest1.setText("미움받을 용기");
		textBest1.setFont(new Font("D2Coding ligature", Font.PLAIN, 13));
		textBest1.setBounds(12, 174, 124, 21);
		panelBestBooks.add(textBest1);
		textBest1.setColumns(10);
		
		textBest2 = new JTextField();
		textBest2.setText("혼자 공부하는 자바");
		textBest2.setHorizontalAlignment(SwingConstants.CENTER);
		textBest2.setFont(new Font("D2Coding ligature", Font.PLAIN, 13));
		textBest2.setColumns(10);
		textBest2.setBounds(148, 174, 124, 21);
		panelBestBooks.add(textBest2);
		
		textBest3 = new JTextField();
		textBest3.setText("흐르는 강물처럼");
		textBest3.setHorizontalAlignment(SwingConstants.CENTER);
		textBest3.setFont(new Font("D2Coding ligature", Font.PLAIN, 13));
		textBest3.setColumns(10);
		textBest3.setBounds(288, 175, 124, 21);
		panelBestBooks.add(textBest3);
		
		textBest4 = new JTextField();
		textBest4.setText("각본 없음");
		textBest4.setHorizontalAlignment(SwingConstants.CENTER);
		textBest4.setFont(new Font("D2Coding ligature", Font.PLAIN, 13));
		textBest4.setColumns(10);
		textBest4.setBounds(424, 175, 124, 21);
		panelBestBooks.add(textBest4);
		
		panelNewBooks = new JPanel();
		panelNewBooks.setLayout(null);
		panelNewBooks.setBounds(10, 310, 560, 195);
		contentPane.add(panelNewBooks);
		
		lblNewBooks = new JLabel("신간도서");
		lblNewBooks.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblNewBooks.setBounds(220, 0, 80, 24);
		panelNewBooks.add(lblNewBooks);
		
		btnNew1_1 = new JButton("");
		btnNew1_1.setBounds(29, 31, 90, 139);
		panelNewBooks.add(btnNew1_1);
		
		btnNew2_1 = new JButton("");
		btnNew2_1.setBounds(161, 31, 97, 139);
		panelNewBooks.add(btnNew2_1);
		
		btnNew3_1 = new JButton("");
		btnNew3_1.setBounds(305, 31, 90, 139);
		panelNewBooks.add(btnNew3_1);
		
		btnNew4_1 = new JButton("");
		btnNew4_1.setBounds(439, 31, 90, 139);
		panelNewBooks.add(btnNew4_1);
		
		textField = new JTextField();
		textField.setText("---");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("D2Coding ligature", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(12, 174, 124, 21);
		panelNewBooks.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("--");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("D2Coding ligature", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(148, 174, 124, 21);
		panelNewBooks.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("---");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("D2Coding ligature", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(288, 175, 124, 21);
		panelNewBooks.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("//");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("D2Coding ligature", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(424, 175, 124, 21);
		panelNewBooks.add(textField_3);
	}
}
