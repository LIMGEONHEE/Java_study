package com.itwill.BookReview_view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.BookReview_controller.BookReviewDao;
import com.itwill.BookReview_model.MyBook;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookReviewDetail extends JFrame {
	
	public interface UpdateNotify {
        public void notifyUpdateSuccess();
    }

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private BookReviewDao dao = BookReviewDao.getInstance();
	private UpdateNotify app;
	 
	private Component parent;
	private JTextField textCategory;
	private JTextField textTitle;
	private JTextField textWriter;
	private JTextField textPublisher;
	private JLabel lblIsbn;
	private JTextField textIsbn;
	private JLabel lblCategory;
	private JLabel lbltitle;
	private JLabel lbltitWriter;
	private JLabel lblPublisher;
	private JLabel lblBookReview;
	private JPanel panel_1;
	private JButton btnSave;
	private JButton btnClose;
	private JTextArea textReview;
	private JPanel panelReview;
	private JScrollPane scrollPane;
	private int MyBookIsbn;
	private int mybookIsbn;

	/**
	 * Launch the application.
	 */
	public static void showBookReviewDetail(Component parent, int MyBookIsbn ,UpdateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookReviewDetail frame = new BookReviewDetail(parent, MyBookIsbn, app);
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
	private BookReviewDetail(Component parent, int MyBookIsbn, UpdateNotify app) {
		this.parent = parent;
		this.app = app;
		this.MyBookIsbn = MyBookIsbn;
		
		initialize();
		initializeMyBook();
	}
	
	

	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("D2Coding", Font.BOLD, 23));
		lblIsbn.setBounds(12, 10, 63, 40);
		contentPane.add(lblIsbn);
		
		textIsbn = new JTextField();
		textIsbn.setEditable(false);
		textIsbn.setColumns(10);
		textIsbn.setBounds(87, 13, 195, 37);
		contentPane.add(textIsbn);
		textIsbn.setColumns(10);
		
		lblCategory = new JLabel("분류");
		lblCategory.setFont(new Font("D2Coding", Font.BOLD, 23));
		lblCategory.setBounds(294, 10, 63, 40);
		contentPane.add(lblCategory);
		
		textCategory = new JTextField();
		textCategory.setColumns(10);
		textCategory.setBounds(369, 13, 195, 37);
		contentPane.add(textCategory);
		
		lbltitle = new JLabel("제목");
		lbltitle.setFont(new Font("D2Coding", Font.BOLD, 23));
		lbltitle.setBounds(12, 60, 63, 40);
		contentPane.add(lbltitle);
		
		textTitle = new JTextField();
		textTitle.setColumns(10);
		textTitle.setBounds(87, 63, 477, 37);
		contentPane.add(textTitle);
		
		lbltitWriter = new JLabel("저자");
		lbltitWriter.setFont(new Font("D2Coding", Font.BOLD, 23));
		lbltitWriter.setBounds(12, 110, 63, 40);
		contentPane.add(lbltitWriter);
		
		textWriter = new JTextField();
		textWriter.setColumns(10);
		textWriter.setBounds(87, 113, 195, 37);
		contentPane.add(textWriter);
		
		lblPublisher = new JLabel("출판사");
		lblPublisher.setFont(new Font("D2Coding", Font.BOLD, 23));
		lblPublisher.setBounds(294, 110, 69, 40);
		contentPane.add(lblPublisher);
		
		textPublisher = new JTextField();
		textPublisher.setColumns(10);
		textPublisher.setBounds(369, 113, 195, 37);
		contentPane.add(textPublisher);
		
		lblBookReview = new JLabel("서평");
		lblBookReview.setFont(new Font("D2Coding", Font.BOLD, 23));
		lblBookReview.setBounds(12, 161, 63, 40);
		contentPane.add(lblBookReview);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 205, 552, 293);
		contentPane.add(scrollPane);
		
		panelReview = new JPanel();
		scrollPane.setViewportView(panelReview);
		panelReview.setLayout(null);
		
		textReview = new JTextArea();
		textReview.setBounds(0, 0, 550, 291);
		panelReview.add(textReview);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 508, 584, 52);
		contentPane.add(panel_1);
		
		btnSave = new JButton("업데이트");
		btnSave.addActionListener((e) -> UpdateMyBook());
		btnSave.setFont(new Font("D2Coding", Font.BOLD, 20));
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(50, 0, 215, 53);
		panel_1.add(btnSave);
		
		btnClose = new JButton("취소");
		btnClose.addActionListener((e) -> dispose());
		btnClose.setFont(new Font("D2Coding", Font.BOLD, 20));
		btnClose.setBackground(Color.WHITE);
		btnClose.setBounds(315, 0, 215, 53);
		panel_1.add(btnClose);
	}
	private void initializeMyBook() {
		MyBook mybook = dao.read(MyBookIsbn);
		if (mybook == null) return;
		
		textIsbn.setText(mybookIsbn + "");
		textTitle.setText(mybook.getTitle());
		textCategory.setText(mybook.getCategory());
		textWriter.setText(mybook.getWriter());
		textPublisher.setText(mybook.getPublisher());
		textReview.setText(mybook.getBookreview());
		
	}
	
	private void UpdateMyBook() {
		String title = textTitle.getText();
		String category = textCategory.getText();
		String writer = textWriter.getText();
		String publisher = textPublisher.getText();
		String bookreview = textReview.getText();
		
		boolean isEmpty = 
				title.equals("") || 
				category.equals("") ||
				writer.equals("") || 
				publisher.equals("") || 
				bookreview.equals("");
		
		if (isEmpty) {
            JOptionPane.showMessageDialog(this, 
                    "모든 내용을 반드시 입력해야 합니다.", 
                    "경고", JOptionPane.WARNING_MESSAGE);
            return;
		
	}
		MyBook mybook = new MyBook(mybookIsbn, title, writer, publisher ,bookreview, category, null, null);
		int result = dao.update(mybook);
		if (result == 1) {
            app.notifyUpdateSuccess();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "업데이트 실패");
        }
		
	} 
	
}
