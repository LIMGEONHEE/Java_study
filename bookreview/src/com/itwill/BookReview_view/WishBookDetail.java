package com.itwill.BookReview_view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.BookReview_controller.BookReviewDao;
import com.itwill.BookReview_model.MyBook;
import com.itwill.BookReview_model.WishBook;
import com.itwill.BookReview_view.BookReviewDetail.UpdateNotify;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class WishBookDetail extends JFrame implements UpdateNotify  {
	
	private static final String[] SEARCH_TYPES  = { 
            "(분류)", "소설", "자기계발", "시", "만화", 
            "요리" , "여행", "예술"
    };

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Component parent;
	private JTextField textFieldTitle;
	private JTextField textFieldWriter;
	private JTextField textFieldPublisher;
	private JTextField textFieldCategory;
	private JTextField textFieldMemo;
	private BookReviewDao dao = BookReviewDao.getInstance();
	private UpdateNotify app;
	

	private String wishBookTitle;
	private JComboBox comboBoxCategory;
	private JLabel lblTitle;
	private JLabel lblWriter;
	private JLabel lblPublisher;
	private JLabel lblMebo;
	private JButton btnUpdate;
	private JButton btnClose;
	

	/**
	 * Launch the application.
	 */
	public static void showWishBookDetail(Component parent, String wishBookTitle, UpdateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WishBookDetail frame = new WishBookDetail(parent, wishBookTitle, app);
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
	private WishBookDetail(Component parent, String wishBookTitle, UpdateNotify app) {
		setTitle("관심 상세");
		this.parent = parent;
		this.wishBookTitle = wishBookTitle;
		this.app = app;
		
		initialize();
		initializeWishBook();
	}
	
	private void initializeWishBook() {
		WishBook wishbook = dao.read1(wishBookTitle);
		if(wishbook == null) return;
		textFieldTitle.setText(wishbook.getTitle1());
		textFieldWriter.setText(wishbook.getWriter1());
		textFieldCategory.setText(wishbook.getCategory1());
		textFieldPublisher.setText(wishbook.getPublisher1());
		textFieldMemo.setText(wishbook.getMemo());
		
	}

	public void initialize(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(215, 209, 187));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("제목");
		lblTitle.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblTitle.setBounds(12, 10, 84, 44);
		contentPane.add(lblTitle);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textFieldTitle.setColumns(10);
		textFieldTitle.setBounds(100, 10, 472, 44);
		contentPane.add(textFieldTitle);
		
		lblWriter = new JLabel("저자");
		lblWriter.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblWriter.setBounds(12, 79, 66, 44);
		contentPane.add(lblWriter);
		
		textFieldWriter = new JTextField();
		textFieldWriter.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textFieldWriter.setColumns(10);
		textFieldWriter.setBounds(100, 81, 472, 44);
		contentPane.add(textFieldWriter);
		
		lblPublisher = new JLabel("출판사");
		lblPublisher.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblPublisher.setBounds(12, 149, 82, 44);
		contentPane.add(lblPublisher);
		
		textFieldPublisher = new JTextField();
		textFieldPublisher.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textFieldPublisher.setColumns(10);
		textFieldPublisher.setBounds(100, 149, 180, 44);
		contentPane.add(textFieldPublisher);
		
		comboBoxCategory = new JComboBox();
		comboBoxCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedText = (String) comboBoxCategory.getSelectedItem();
				textFieldCategory.setText(selectedText);
			}
		});
		final DefaultComboBoxModel<String> comboBoxModel = 
				new DefaultComboBoxModel<>(SEARCH_TYPES);
		comboBoxCategory.setModel(comboBoxModel);
		comboBoxCategory.setFont(new Font("D2Coding", Font.BOLD, 23));
		comboBoxCategory.setBounds(292, 151, 132, 44);
		contentPane.add(comboBoxCategory);
		
		textFieldCategory = new JTextField();
		textFieldCategory.setEditable(false);
		textFieldCategory.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textFieldCategory.setColumns(10);
		textFieldCategory.setBounds(440, 150, 132, 43);
		contentPane.add(textFieldCategory);
		
		lblMebo = new JLabel("메모");
		lblMebo.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblMebo.setBounds(12, 217, 82, 44);
		contentPane.add(lblMebo);
		
		textFieldMemo = new JTextField();
		textFieldMemo.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textFieldMemo.setColumns(10);
		textFieldMemo.setBounds(13, 267, 558, 214);
		contentPane.add(textFieldMemo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(215, 209, 187));
		panel_1.setLayout(null);
		panel_1.setBounds(12, 499, 560, 62);
		contentPane.add(panel_1);
		
		btnUpdate = new JButton("업데이트");
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\icon\\icons8-update-done-material-filled\\icons8-update-done-25.png"));
		btnUpdate.addActionListener((e) -> UpdateWishBook());
		btnUpdate.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(50, 0, 215, 53);
		panel_1.add(btnUpdate);
		
		btnClose = new JButton("취소");
		btnClose.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\icon\\icons8-close-ios-17-glyph\\icons8-close-25.png"));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnClose.setBackground(Color.WHITE);
		btnClose.setBounds(315, 0, 215, 53);
		panel_1.add(btnClose);
	}
	
	private void initalizeWishBook() {
		WishBook wishbook = dao.read1(wishBookTitle);
		if (wishbook == null) return;
		textFieldTitle.setText(wishbook.getTitle1());
		textFieldWriter.setText(wishbook.getWriter1());
		textFieldCategory.setText(wishbook.getCategory1());
		textFieldPublisher.setText(wishbook.getPublisher1());
		textFieldMemo.setText(wishbook.getMemo());
	}
	
	private void UpdateWishBook() {
		String title1 = textFieldTitle.getText();
		String writer1 = textFieldWriter.getText();
		String category1 = textFieldCategory.getText();
		String publisher1 = textFieldPublisher.getText();
		String memo = textFieldMemo.getText();
		
		
		boolean isEmpty = 
				title1.equals("") || 
				writer1.equals("") || 
				category1.equals("") ||
				publisher1.equals("") || 
				memo.equals("");
		
		if (isEmpty) {
            JOptionPane.showMessageDialog(this, 
                    "모든 내용을 반드시 입력해야 합니다.", 
                    "경고", JOptionPane.WARNING_MESSAGE);
            return;
		
	}
		WishBook wishbook = new WishBook(title1, writer1, category1,  publisher1,  memo, null, null);
		int result = dao.update1(wishbook);
		if (result == 1) {
            app.notifyUpdateSuccess();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "업데이트 실패");
        }
		
	}

	@Override
	public void notifyUpdateSuccess() {
		initializeWishBook();
        JOptionPane.showMessageDialog(contentPane, "업데이트 성공!");
		
	}


}
