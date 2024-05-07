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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.BookReview_controller.BookReviewDao;
import com.itwill.BookReview_model.MyBook;
import com.itwill.BookReview_model.WishBook;
import com.itwill.BookReview_view.BookReviewCreate.CreateNotify;
import com.itwill.BookReview_view.BookReviewDetail.UpdateNotify;

public class BookReviewWishBook extends JFrame implements CreateNotify, UpdateNotify {
	
	private static final String[] SEARCH_TYPES  = { 
            "제목", "저자", "제목+저자" 
    };
	
	private static final String[] COLUMN_NAMES = {
            "제목", "저자", "분류", "작성시간", "수정시간"
    };

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableWishBook;
	
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
	 private JTable table;

	/**
	 * Launch the application.
	 */
	public static void showBookReviewWishBook(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookReviewWishBook frame = new BookReviewWishBook(parent);
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
	private BookReviewWishBook(Component parent) {
		this.parent = parent;

		initialize();
		initializeTable();
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
		btnDetail.addActionListener((e) -> showWishBookDetail());
		btnDetail.setBounds(350, 4, 107, 43);
		btnDetail.setBackground(new Color(255, 255, 255));
		btnDetail.setForeground(new Color(0, 0, 0));
		btnDetail.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(btnDetail);

		btnReadAll = new JButton("목록보기");
		btnReadAll.addActionListener((e) -> initializeTable());
		btnReadAll.setBounds(131, 4, 107, 43);
		btnReadAll.setBackground(new Color(255, 255, 255));
		btnReadAll.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(btnReadAll);

		btnCreat = new JButton("추가");
		btnCreat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 관심도서 작성하기 창 띄우기
				WishBookCreate.showWishBookCreate(parent, BookReviewWishBook.this);
				parent.setVisible(false);
			}
		});
		btnCreat.setBounds(240, 4, 107, 43);
		btnCreat.setBackground(new Color(255, 255, 255));
		btnCreat.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(btnCreat);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener((e) -> deletWishBook());
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
	

	private void deletWishBook() {
		int index = tableWantTo.getSelectedRow();
		if (index == -1) { // JTable에서 선택된 행이 없을 때
			 JOptionPane.showMessageDialog(
					 contentPane,
					 "삭제할 행을 먼저 선택하세요.", 
	                    "경고", 
	                    JOptionPane.WARNING_MESSAGE);
	            return;
	}
		int confirm = JOptionPane.showConfirmDialog(
                contentPane, 
                "정말 삭제할까요?", 
                "삭제 확인", 
                JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
            // 선택된 행에서 블로그 번호(id)를 읽음.
            String title1 = (String) tableModel.getValueAt(index, 0);
            // DAO의 delete 메서드 호출.
            int result = dao.delete1(title1);
            if (result == 1) {
                initializeTable(); // 테이블을 새로고침.
                JOptionPane.showMessageDialog(contentPane, "삭제 성공!");
            } else {
                JOptionPane.showMessageDialog(contentPane, "삭제 실패!");
            }
        }
		
	}
		

	private void showWishBookDetail() {
		int index = tableWantTo.getSelectedRow(); // 테이블에서 선택된 행의 인덱스
		if (index == -1) { // JTable에서 선택된 행이 없을 때
			 JOptionPane.showMessageDialog(
					 contentPane ,
	                    "상세보기할 행을 먼저 선택하세요.", 
	                    "경고", 
	                    JOptionPane.WARNING_MESSAGE);
	            return;
	} 
		String wishBookTitle = (String) tableModel.getValueAt(index, 0);	
	
	WishBookDetail.showWishBookDetail(parent, wishBookTitle, BookReviewWishBook.this);
}
		
private void search1() {
		
		int type = comboBox.getSelectedIndex(); // 콤보박스에서 선택된 아이템의 인덱스
		String keyword = textSearchKeyword.getText(); // 검색어
		 if (keyword.equals("")) {
	            JOptionPane.showMessageDialog(contentPane, 
	                    "검색어를 입력하세요.", 
	                    "경고", JOptionPane.WARNING_MESSAGE);
	            textSearchKeyword.requestFocus();
		return;
		
		 }
		// DAO 메서드를 호출해서 검색 결과를 가져옴.
	    List<WishBook> wishbook = dao.search1(type, keyword);
	    resetTable(wishbook); // 테이블 리셋.
		 }
	

	private void initializeTable() {
		// DAO를 사용해서 DB테이블에서 검색.
		List<WishBook> wishbook = dao.read1();
		resetTable(wishbook); // 테이블 리셋
	}

	private void resetTable(List<WishBook> wishbook) {
		// 검색한 내용을 JTable에 보여줌 - JTable의 테이블 모델을 재설정.
		 tableModel = new DefaultTableModel(null, COLUMN_NAMES); // 테이블 모델 리셋.
		 for (WishBook w: wishbook) {
			 // DB 테이블에서 검색한 레코드를 JTable에서 사용할 행 데이터로 변환.
	            Object[] row = {
	                    w.getTitle1(), w.getWriter1(),
	                    w.getCategory1(), w.getCreatedTime1(), w.getModifiedTime1(),
	            };
	            tableModel.addRow(row); // 테이블 모델에 행 데이터를 추가.
	        }
		 tableWantTo.setModel(tableModel);
		 }

	@Override
	public void notifyCreateSuccess() {
		initializeTable();
		JOptionPane.showMessageDialog(contentPane, "저장 성공했습니다!");
		
	}

	@Override
	public void notifyUpdateSuccess() {
		initializeTable();
        JOptionPane.showMessageDialog(contentPane, "업데이트 성공!");
		
	}
		



}
