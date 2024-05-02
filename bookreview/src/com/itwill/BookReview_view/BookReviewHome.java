package com.itwill.BookReview_view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class BookReviewHome extends JFrame {
	
	private static final String[] SEARCH_TYPES  = { 
            "제목", "저자", "제목+저자" 
    };

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblName;
	private JPanel searchPanel;
	private JTextField textSearchKeyword;
	private JComboBox comboBox;
	private JButton btnSearch;
	private JButton btnHome;
	private JButton btnInfo;
	private JButton btnMyBooks;
	private JButton btnLogout;
	
	private Component parent;
	private JPanel panelRecom;
	private JLabel lblRecom;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel_1_2_1;
	private JLabel lblNewLabel_1_1_1;

	/**
	 * Launch the application.
	 */
	public static void showBookReviewHome(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookReviewHome frame = new BookReviewHome(parent);
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
	private BookReviewHome(Component parent) {
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
		
		lblName = new JLabel("I'will 독서왕");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setBackground(new Color(255, 255, 255));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setLabelFor(lblName);
		lblName.setFont(new Font("D2Coding", Font.BOLD, 33));
		lblName.setBounds(0, 0, 584, 44);
		contentPane.add(lblName);
		
		searchPanel = new JPanel();
		searchPanel.setBounds(0, 43, 584, 52);
		contentPane.add(searchPanel);
		
		comboBox = new JComboBox();
		final DefaultComboBoxModel<String> comboBoxModel = 
                new DefaultComboBoxModel<>(SEARCH_TYPES);
        comboBox.setModel(comboBoxModel);
		comboBox.setFont(new Font("D2Coding", Font.BOLD, 25));
		searchPanel.add(comboBox);
		
		textSearchKeyword = new JTextField();
		textSearchKeyword.setFont(new Font("D2Coding", Font.BOLD, 25));
		searchPanel.add(textSearchKeyword);
		textSearchKeyword.setColumns(25);
		
		btnSearch = new JButton("검색");
		btnSearch.setFont(new Font("D2Coding", Font.BOLD, 25));
		searchPanel.add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 509, 584, 52);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnHome = new JButton("홈");
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setFont(new Font("D2Coding", Font.BOLD, 20));
		panel.add(btnHome);
		
		btnInfo = new JButton("내 서재");
		btnInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 내 독서기록 페이지 창 띄우기
				BookReviewMyBook.showBookReviewMyBook(parent);
				parent.setVisible(false); // 버튼을 누르면 창 끄기
			}
		});
		btnInfo.setBackground(new Color(255, 255, 255));
		btnInfo.setFont(new Font("D2Coding", Font.BOLD, 20));
		panel.add(btnInfo);
		
		btnMyBooks = new JButton("관심 도서");
		btnMyBooks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 읽지 않은 책 페이지 창 띄우기
				BookReviewWantTo.showBookReviewUnRead(parent);
				parent.setVisible(false);
				
			}
		});
		btnMyBooks.setBackground(new Color(255, 255, 255));
		btnMyBooks.setFont(new Font("D2Coding", Font.BOLD, 20));
		panel.add(btnMyBooks);
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("D2Coding", Font.BOLD, 20));
		panel.add(btnLogout);
		
		panelRecom = new JPanel();
		panelRecom.setBounds(12, 105, 560, 394);
		contentPane.add(panelRecom);
		panelRecom.setLayout(null);
		
		lblRecom = new JLabel("<추천 도서>");
		lblRecom.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblRecom.setBounds(12, 10, 269, 43);
		panelRecom.add(lblRecom);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(12, 63, 135, 143);
		panelRecom.add(lblNewLabel_1);
		
		lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(413, 63, 135, 143);
		panelRecom.add(lblNewLabel_1_1);
		
		lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setBounds(212, 63, 135, 143);
		panelRecom.add(lblNewLabel_1_2);
		
		lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setBounds(12, 241, 135, 143);
		panelRecom.add(lblNewLabel_1_3);
		
		lblNewLabel_1_2_1 = new JLabel("New label");
		lblNewLabel_1_2_1.setBounds(212, 241, 135, 143);
		panelRecom.add(lblNewLabel_1_2_1);
		
		lblNewLabel_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1.setBounds(413, 241, 135, 143);
		panelRecom.add(lblNewLabel_1_1_1);
		
		JButton btnMore = new JButton("더 보기...");
		btnMore.setFont(new Font("D2Coding", Font.PLAIN, 15));
		btnMore.setBounds(439, 21, 109, 32);
		panelRecom.add(btnMore);
	}
}
