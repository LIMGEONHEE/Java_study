package com.itwill.library_view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.itwill.library_view.LibraryDetailFrame.UpdateNotify;

public class LibraryHomePageFrame extends JFrame {
	
	private static final String[] SEARCH_TYPES  = { 
            "제목", "저자", "제목+저자" 
    };
	
	private JFrame frame;
	private DefaultTableModel tableModel;


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
		
		lblName = new JLabel("Iwill 독서왕");
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
		btnHome.setFont(new Font("D2Coding", Font.BOLD, 20));
		panel.add(btnHome);
		
		btnInfo = new JButton("내 독서기록");
		btnInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LibraryInfoFrame.showLibraryInfoFrame(parent);
			}
		});
		btnInfo.setBackground(new Color(255, 255, 255));
		btnInfo.setFont(new Font("D2Coding", Font.BOLD, 20));
		panel.add(btnInfo);
		
		btnMyBooks = new JButton("읽고 싶은 책");
		btnMyBooks.setBackground(new Color(255, 255, 255));
		btnMyBooks.setFont(new Font("D2Coding", Font.BOLD, 20));
		panel.add(btnMyBooks);
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("D2Coding", Font.BOLD, 20));
		panel.add(btnLogout);
	}
}
