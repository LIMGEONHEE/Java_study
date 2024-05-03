package com.itwill.BookReview_view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.BookReview_controller.BookReviewDao;
import com.itwill.BookReview_model.MyBook;

public class BookReviewWantTo extends JFrame {
	
	private static final String[] SEARCH_TYPES  = { 
            "제목", "저자", "제목+저자" 
    };

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Component parent;
	
	private JLabel lblName;
	private JPanel searchPanel;
	private JTextField textSearchKeyword;
	private JComboBox comboBox;
	private JButton btnSearch;
	private JButton btnDetail;
	private JButton btnReadAll;
	private JButton btnCreat;
	private JButton btnHome;
	private JButton btnDelete;
	private JTable tableWantTo;
	private DefaultTableModel tableModel;
	
	
	private BookReviewDao dao = BookReviewDao.getInstance();

	/**
	 * Launch the application.
	 */
	public static void showBookReviewUnRead(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookReviewWantTo frame = new BookReviewWantTo(parent);
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
	private BookReviewWantTo(Component parent) {
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

		lblName = new JLabel("관심 도서");
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
		final DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(SEARCH_TYPES);
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
		panel.setLayout(null);

		btnDetail = new JButton("상세보기");
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDetail.setBounds(350, 4, 107, 43);
		btnDetail.setBackground(new Color(255, 255, 255));
		btnDetail.setForeground(new Color(0, 0, 0));
		btnDetail.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(btnDetail);

		btnReadAll = new JButton("목록보기");
		// TODO
//		btnReadAll.addActionListener((e) -> initializeTable());
		btnReadAll.setBounds(131, 4, 107, 43);
		btnReadAll.setBackground(new Color(255, 255, 255));
		btnReadAll.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(btnReadAll);

		btnCreat = new JButton("추가");
		btnCreat.setBounds(240, 4, 107, 43);
		btnCreat.setBackground(new Color(255, 255, 255));
		btnCreat.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(btnCreat);
		
		btnDelete = new JButton("삭제");
		btnDelete.setBounds(464, 4, 107, 43);
		btnDelete.setFont(new Font("D2Coding", Font.BOLD, 18));
		btnDelete.setBackground(Color.WHITE);
		panel.add(btnDelete);

		btnHome = new JButton("홈");
		btnHome.addActionListener((e) -> dispose());
		btnHome.setBounds(12, 4, 107, 43);
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setFont(new Font("D2Coding", Font.BOLD, 20));
		panel.add(btnHome);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 105, 584, 404);
		contentPane.add(scrollPane);

		tableWantTo = new JTable();
		scrollPane.setViewportView(tableWantTo);
	}
	
	// TODO 테이블 바꾸기
//	private void initializeTable() {
//		// DAO를 사용해서 DB테이블에서 검색.
//		List<MyBook> mybook = dao.read();
//		resetTable(mybook); // 테이블 리셋
//	}
//
	// TODO 테이블 바꾸기
//	private void resetTable(List<MyBook> mybook) {
//		// 검색한 내용을 JTable에 보여줌 - JTable의 테이블 모델을 재설정.
//		 tableModel = new DefaultTableModel(null, COLUMN_NAMES); // 테이블 모델 리셋.
		
//	}

}
