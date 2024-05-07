package com.itwill.BookReview_view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.BookReview_controller.BookReviewDao;
import com.itwill.BookReview_model.MyBook;
import com.itwill.BookReview_model.WishBook;
import com.itwill.BookReview_view.BookReviewCreate.CreateNotify;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;

public class WishBookCreate extends JFrame {
	
	private static final String[] SEARCH_TYPES  = { 
            "(분류)", "소설", "자기계발", "시", "만화", 
            "요리" , "여행", "예술"
    };
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private BookReviewDao dao = BookReviewDao.getInstance();
	
	private Component parent;
	private JTextField textFieldTitle;
	private JTextField textFieldWriter;
	private JTextField textFieldPublisher;
	private JLabel lblTitle;
	private JLabel lblWriter;
	private JComboBox comboBoxCategory;
	private JTextField textFieldCategory;
	private JLabel lblMebo;
	private JPanel panel_1;
	private JButton btnSave;
	private JButton btnClose;
	private JScrollPane scrollPaneMemo;
	private JPanel panel;
	private JTextField textFieldMemo;
	 private CreateNotify app;
	 private JLabel lblPublisher;
	
	/**
	 * Launch the application.
	 */
	public static void showWishBookCreate(Component parent, CreateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WishBookCreate frame = new WishBookCreate(parent, app);
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
	private WishBookCreate(Component parent, CreateNotify app) {
		this.parent = parent;
		this.app = app;
		
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
		
		lblTitle = new JLabel("제목");
		lblTitle.setBounds(12, 11, 84, 44);
		lblTitle.setFont(new Font("D2Coding", Font.BOLD, 25));
		contentPane.add(lblTitle);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textFieldTitle.setBounds(100, 11, 472, 44);
		contentPane.add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		lblWriter = new JLabel("저자");
		lblWriter.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblWriter.setBounds(12, 80, 66, 44);
		contentPane.add(lblWriter);
		
		textFieldWriter = new JTextField();
		textFieldWriter.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textFieldWriter.setColumns(10);
		textFieldWriter.setBounds(100, 82, 472, 44);
		contentPane.add(textFieldWriter);
		
		lblPublisher = new JLabel("출판사");
		lblPublisher.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblPublisher.setBounds(12, 150, 82, 44);
		contentPane.add(lblPublisher);
		
		textFieldPublisher = new JTextField();
		textFieldPublisher.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textFieldPublisher.setColumns(10);
		textFieldPublisher.setBounds(100, 150, 180, 44);
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
		comboBoxCategory.setModel(new DefaultComboBoxModel(new String[] {"(분류)", "소설", "자기계발", "시", "만화", "요리", "여행", "예술"}));
		comboBoxCategory.setFont(new Font("D2Coding", Font.BOLD, 23));
		comboBoxCategory.setBounds(292, 152, 132, 44);
		contentPane.add(comboBoxCategory);
		
		textFieldCategory = new JTextField();
		textFieldCategory.setFont(new Font("D2Coding", Font.PLAIN, 23));
		textFieldCategory.setColumns(10);
		textFieldCategory.setBounds(440, 151, 132, 43);
		contentPane.add(textFieldCategory);
		
		lblMebo = new JLabel("메모");
		lblMebo.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblMebo.setBounds(12, 218, 82, 44);
		contentPane.add(lblMebo);
		
		scrollPaneMemo = new JScrollPane();
		scrollPaneMemo.setBounds(12, 267, 560, 216);
		contentPane.add(scrollPaneMemo);
		
		panel = new JPanel();
		scrollPaneMemo.setViewportView(panel);
		panel.setLayout(null);
		
		textFieldMemo = new JTextField();
		textFieldMemo.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textFieldMemo.setBounds(0, 0, 558, 214);
		panel.add(textFieldMemo);
		textFieldMemo.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 509, 584, 52);
		contentPane.add(panel_1);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener((e) -> createNewWishBook());
		btnSave.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(50, 0, 215, 53);
		panel_1.add(btnSave);
		
		btnClose = new JButton("취소");
		btnClose.addActionListener((e) -> dispose());
		btnClose.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnClose.setBackground(Color.WHITE);
		btnClose.setBounds(315, 0, 215, 53);
		panel_1.add(btnClose);
	}
	private void createNewWishBook() {
        // 제목, 내용, 작성자에 입력된 내용을 WishBook 객체로 만들어서
        // DAO 메서드를 사용해서 DB 테이블에 insert.
        String title1 = textFieldTitle.getText();
        String writer1= textFieldWriter.getText();
        String category1 = textFieldCategory.getText();
        String publisher1 = textFieldPublisher.getText();
        String memo = textFieldMemo.getText();
        		if (title1.equals("") || writer1.equals("") || 
        				category1.equals("")	|| publisher1.equals("")	|| memo.equals("") ) {
        			JOptionPane.showMessageDialog(
                    WishBookCreate.this, 
                    "제목, 저자, 분류, 출판사, 메모는 반드시 입력해야 합니다!", 
                    "경고", 
                    JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        WishBook wishbook = new WishBook(title1, writer1, publisher1, category1,  memo,  null, null);
        int result = dao.create1(wishbook);
        if (result == 1) {
            // BlogMain 프레임에게 테이블 삽입 성공을 알려줌.
            app.notifyCreateSuccess();
            dispose(); // 현재 창 닫기.
        } else {
            JOptionPane.showMessageDialog(WishBookCreate.this, "INSERT 실패");
        }
        
        
    }
}
