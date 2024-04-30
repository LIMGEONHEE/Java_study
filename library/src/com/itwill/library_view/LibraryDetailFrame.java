package com.itwill.library_view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraryDetailFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblBookImg;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextField textTitle;
	private JTextField textWriter;
	private JTextField textPublisher;
	private JTextField textCategory;
	private JTextField textLocation;
	private JTextField textId;
	
	private Component parent;

	/**
	 * Launch the application.
	 */
	public static void showLibraryDetailFrame(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryDetailFrame frame = new LibraryDetailFrame(parent);
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
	
	private LibraryDetailFrame(Component parent) {
		this.parent = parent;
		
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 50, 20));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 584, 561);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		lblBookImg = new JLabel("img...");
		lblBookImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookImg.setBounds(159, 10, 252, 200);
		panel.add(lblBookImg);
		
		JLabel lblTitle = new JLabel("제목");
		lblTitle.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblTitle.setBounds(12, 239, 126, 36);
		panel.add(lblTitle);
		
		JLabel lblWriter = new JLabel("저자");
		lblWriter.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblWriter.setBounds(12, 285, 126, 36);
		panel.add(lblWriter);
		
		JLabel lblPublisher = new JLabel("출판사");
		lblPublisher.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblPublisher.setBounds(12, 331, 126, 36);
		panel.add(lblPublisher);
		
		JLabel lblLocation = new JLabel("도서위치");
		lblLocation.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblLocation.setBounds(12, 423, 126, 36);
		panel.add(lblLocation);
		
		JLabel lblId = new JLabel("등록번호");
		lblId.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblId.setBounds(12, 469, 126, 36);
		panel.add(lblId);
		
		JLabel lblCategory = new JLabel("분류");
		lblCategory.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblCategory.setBounds(12, 377, 126, 36);
		panel.add(lblCategory);
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("D2Coding", Font.BOLD, 20));
		textTitle.setBounds(159, 239, 411, 36);
		panel.add(textTitle);
		textTitle.setColumns(10);
		
		textWriter = new JTextField();
		textWriter.setFont(new Font("D2Coding", Font.BOLD, 20));
		textWriter.setColumns(10);
		textWriter.setBounds(159, 285, 411, 36);
		panel.add(textWriter);
		
		textPublisher = new JTextField();
		textPublisher.setFont(new Font("D2Coding", Font.BOLD, 20));
		textPublisher.setColumns(10);
		textPublisher.setBounds(159, 331, 411, 36);
		panel.add(textPublisher);
		
		textCategory = new JTextField();
		textCategory.setFont(new Font("D2Coding", Font.BOLD, 20));
		textCategory.setColumns(10);
		textCategory.setBounds(159, 377, 411, 36);
		panel.add(textCategory);
		
		textLocation = new JTextField();
		textLocation.setFont(new Font("D2Coding", Font.BOLD, 20));
		textLocation.setColumns(10);
		textLocation.setBounds(159, 423, 411, 36);
		panel.add(textLocation);
		
		textId = new JTextField();
		textId.setFont(new Font("D2Coding", Font.BOLD, 20));
		textId.setColumns(10);
		textId.setBounds(159, 469, 411, 36);
		panel.add(textId);
		
		JButton btnClose = new JButton("닫기");
		btnClose.addActionListener((e) -> dispose());
		btnClose.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnClose.setBounds(208, 515, 119, 34);
		panel.add(btnClose);
	}
}
