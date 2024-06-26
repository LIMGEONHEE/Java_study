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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;



public class BookReviewHome extends JFrame {
	
	private static final String[] SEARCH_TYPES  = { 
            "제목", "저자", "제목+저자" 
    };

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblName;
	private JButton btnHome;
	private JButton btnInfo;
	private JButton btnMyBooks;
	private JButton btnLogout;
	
	private Component parent;
	private JPanel panelRecom;
	private JLabel lblRecom;
	private JLabel lblNewLabel;

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
		setTitle("홈");
		this.parent = parent;
		
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		contentPane.setBackground(new Color(215, 209, 187));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
contentPane.setLayout(null);
		
		lblName = new JLabel("어서오세요:)");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setBackground(new Color(255, 255, 255));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setLabelFor(lblName);
		lblName.setFont(new Font("D2Coding", Font.BOLD, 33));
		lblName.setBounds(12, 10, 287, 44);
		contentPane.add(lblName);
		final DefaultComboBoxModel<String> comboBoxModel = 
                new DefaultComboBoxModel<>(SEARCH_TYPES);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(12, 509, 560, 42);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnHome = new JButton("홈");
		btnHome.setIcon(new ImageIcon("C:\\Users\\itwill\\AppData\\Local\\Microsoft\\Windows\\INetCache\\IE\\G3ATH1KU\\icons8-home-25[1].png"));
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setFont(new Font("D2Coding", Font.BOLD, 19));
		panel.add(btnHome);
		
		btnInfo = new JButton("내 서재");
		btnInfo.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\icon\\icons8-library-ios-17-filled\\icons8-library-25.png"));
		btnInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 내 독서기록 페이지 창 띄우기
				BookReviewMyBook.showBookReviewMyBook(parent);
				parent.setVisible(false); // 버튼을 누르면 창 끄기
			}
		});
		btnInfo.setBackground(new Color(255, 255, 255));
		btnInfo.setFont(new Font("D2Coding", Font.BOLD, 19));
		panel.add(btnInfo);
		
		btnMyBooks = new JButton("관심도서");
		btnMyBooks.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\icon\\icons8-star-ios-17-glyph\\icons8-star-25.png"));
		btnMyBooks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 읽지 않은 책 페이지 창 띄우기
				BookReviewWishBook.showBookReviewWishBook(parent);
				parent.setVisible(false);
				
			}
		});
		btnMyBooks.setBackground(new Color(255, 255, 255));
		btnMyBooks.setFont(new Font("D2Coding", Font.BOLD, 19));
		panel.add(btnMyBooks);
		
		btnLogout = new JButton("나가기");
		btnLogout.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\icon\\icons8-exit-ios-17-glyph\\icons8-exit-25.png"));
		btnLogout.addActionListener(new ActionListener() {
			// 로그인 창 띄우기
			public void actionPerformed(ActionEvent e) {
			BookReviewMain.main(null); // 새로운 로그인 창 띄우기
			
			// 현재 창(현재 프레임) 닫기
	        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnLogout);
	        frame.dispose(); // 현재 창 닫기
			}
		});
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("D2Coding", Font.BOLD, 19));
		panel.add(btnLogout);
		
		panelRecom = new JPanel();
		panelRecom.setBounds(12, 88, 560, 416);
		contentPane.add(panelRecom);
		panelRecom.setLayout(null);
		
		lblRecom = new JLabel("<추천 도서>");
		lblRecom.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblRecom.setBounds(12, 2, 269, 43);
		panelRecom.add(lblRecom);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\books\\인간실격.jpg"));
		lblNewLabel.setBounds(12, 51, 135, 165);
		panelRecom.add(lblNewLabel);
		
		JLabel lblSasdasd = new JLabel("");
		lblSasdasd.setHorizontalAlignment(SwingConstants.CENTER);
		lblSasdasd.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\books\\혼자 공부하는 자바 (1).jpg"));
		lblSasdasd.setBounds(413, 51, 135, 165);
		panelRecom.add(lblSasdasd);
		
		JLabel lblSasdasd_1 = new JLabel("");
		lblSasdasd_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSasdasd_1.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\books\\각본 없음 .jpg"));
		lblSasdasd_1.setBounds(205, 51, 135, 165);
		panelRecom.add(lblSasdasd_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\books\\세이노 (1).jpg"));
		lblNewLabel_1.setBounds(12, 241, 135, 165);
		panelRecom.add(lblNewLabel_1);
		
		JLabel lblSasdasd_2 = new JLabel("");
		lblSasdasd_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSasdasd_2.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\books\\초보자를 위한 sql (1).jpg"));
		lblSasdasd_2.setBounds(413, 241, 135, 165);
		panelRecom.add(lblSasdasd_2);
		
		JLabel lblSasdasd_1_1 = new JLabel("");
		lblSasdasd_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSasdasd_1_1.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\books\\자바스크립트 (1).jpg"));
		lblSasdasd_1_1.setBounds(205, 241, 135, 165);
		panelRecom.add(lblSasdasd_1_1);
		
		JLabel lblSubtitle = new JLabel("오늘은 어떤 책을 읽으셨나요?");
		lblSubtitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblSubtitle.setForeground(Color.BLACK);
		lblSubtitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblSubtitle.setBackground(Color.WHITE);
		lblSubtitle.setBounds(12, 55, 287, 27);
		contentPane.add(lblSubtitle);
	}
}
