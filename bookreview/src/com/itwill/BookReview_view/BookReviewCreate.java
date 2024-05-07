package com.itwill.BookReview_view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.BookReview_model.*;
import com.itwill.BookReview_controller.*;
import com.itwill.BookReview_controller.BookReviewDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class BookReviewCreate extends JFrame {
	
	private static final String[] SEARCH_TYPES  = { 
            "(분류)", "소설", "자기계발", "시", "만화", 
            "요리" , "여행", "예술"
    };
	
	public interface CreateNotify {
        void notifyCreateSuccess();
    }

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private BookReviewDao dao = BookReviewDao.getInstance();
	 private CreateNotify app;
	 private JTextField textIsbn;
	 private JTextField textCategory;
	 private JTextField textTitle;
	 
	 private Component parent;
	 private JTextField textWriter;
	 private JTextField textPublisher;
	 private JTextArea textBookReview;
	 private JComboBox comboBoxCategory;
	 private JLabel lblIsbn;
	 private JLabel lbltitle;
	 private JLabel lblBookReview;
	 private JPanel panelReview;
	 private JButton btnSave;
	 private JButton btnClose;
	 private JLabel lbltitWriter;
	 private JLabel lblPublisher;
	

	/**
	 * Launch the application.
	 */
	public static void showBookReviewCreate(Component parent, CreateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookReviewCreate frame = new BookReviewCreate(parent, app);
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
	private BookReviewCreate(Component parent, CreateNotify app) {
		this.app = app;
		this.parent = parent;

		initialize();
	}

	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		textIsbn.setFont(new Font("D2Coding", Font.BOLD, 20));
		textIsbn.setEditable(false);
		textIsbn.setBounds(87, 13, 195, 37);
		contentPane.add(textIsbn);
		textIsbn.setColumns(10);
		
		textCategory = new JTextField();
		textCategory.setEditable(false);
		textCategory.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textCategory.setColumns(10);
		textCategory.setBounds(441, 13, 123, 37);
		contentPane.add(textCategory);
		
		lbltitle = new JLabel("제목");
		lbltitle.setFont(new Font("D2Coding", Font.BOLD, 23));
		lbltitle.setBounds(12, 60, 63, 40);
		contentPane.add(lbltitle);
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textTitle.setColumns(10);
		textTitle.setBounds(87, 63, 477, 37);
		contentPane.add(textTitle);
		
		lblBookReview = new JLabel("서평");
		lblBookReview.setFont(new Font("D2Coding", Font.BOLD, 23));
		lblBookReview.setBounds(12, 161, 63, 40);
		contentPane.add(lblBookReview);
		
		JScrollPane scrollPaneReview = new JScrollPane();
		scrollPaneReview.setBounds(12, 211, 560, 289);
		contentPane.add(scrollPaneReview);
		
		panelReview = new JPanel();
		scrollPaneReview.setViewportView(panelReview);
		panelReview.setLayout(null);
		
		textBookReview = new JTextArea();
		textBookReview.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textBookReview.setBounds(0, 0, 558, 287);
		panelReview.add(textBookReview);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 509, 584, 52);
		contentPane.add(panel_1);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener((e) -> createNewMyBook());
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
		
		lbltitWriter = new JLabel("저자");
		lbltitWriter.setFont(new Font("D2Coding", Font.BOLD, 23));
		lbltitWriter.setBounds(12, 110, 63, 40);
		contentPane.add(lbltitWriter);
		
		textWriter = new JTextField();
		textWriter.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textWriter.setColumns(10);
		textWriter.setBounds(87, 113, 195, 37);
		contentPane.add(textWriter);
		
		lblPublisher = new JLabel("출판사");
		lblPublisher.setFont(new Font("D2Coding", Font.BOLD, 23));
		lblPublisher.setBounds(294, 110, 69, 40);
		contentPane.add(lblPublisher);
		
		textPublisher = new JTextField();
		textPublisher.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textPublisher.setColumns(10);
		textPublisher.setBounds(369, 113, 195, 37);
		contentPane.add(textPublisher);
		
		comboBoxCategory = new JComboBox();
		comboBoxCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedText = (String) comboBoxCategory.getSelectedItem();
				textCategory.setText(selectedText);
			}
		});
		final DefaultComboBoxModel<String> comboBoxModel = 
				new DefaultComboBoxModel<>(SEARCH_TYPES);
		comboBoxCategory.setModel(new DefaultComboBoxModel(new String[] {"(분류)", "소설", "자기계발", "시", "만화", "요리", "여행", "예술"}));
		comboBoxCategory.setFont(new Font("D2Coding", Font.BOLD, 20));
		comboBoxCategory.setBounds(306, 12, 123, 40);
		contentPane.add(comboBoxCategory);
		

		
	}

	private void createNewMyBook() {
        // 제목, 내용, 작성자에 입력된 내용을 MyBook 객체로 만들어서
        // DAO 메서드를 사용해서 DB 테이블에 insert.
        String title = textTitle.getText();
        String writer= textWriter.getText();
        String publisher = textPublisher.getText();
        String category = textCategory.getText();
        String bookreview = textBookReview.getText();
        		if (title.equals("") || writer.equals("") || 
        				category.equals("")	|| publisher.equals("")	||bookreview.equals("") ) {
            JOptionPane.showMessageDialog(
                    BookReviewCreate.this, 
                    "ISBN, 제목, 저자, 서평은 반드시 입력해야 합니다!", 
                    "경고", 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        MyBook mybook = new MyBook(0, title, writer, category, publisher ,bookreview, null, null);
        int result = dao.create(mybook);
        if (result == 1) {
            // BlogMain 프레임에게 테이블 삽입 성공을 알려줌.
            app.notifyCreateSuccess();
            dispose(); // 현재 창 닫기.
        } else {
            JOptionPane.showMessageDialog(BookReviewCreate.this, "INSERT 실패");
        }
        
        
    }
}
