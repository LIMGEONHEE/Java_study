package com.itwill.BookReview_view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JTable;

import com.itwill.BookReview_controller.BookReviewDao;
import com.itwill.BookReview_model.MyBook;
import com.itwill.BookReview_view.BookReviewCreate.CreateNotify;
import com.itwill.BookReview_view.BookReviewDetail.UpdateNotify;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class BookReviewMyBook extends JFrame implements CreateNotify, UpdateNotify {
	
	private static final String[] SEARCH_TYPES  = { 
            "제목", "저자", "제목+저자" 
    };
	
	private static final String[] COLUMN_NAMES = {
            "ISBN", "제목", "저자", "수정시간"
    };

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Component parent;
	
	private JLabel lblName;
	private JPanel searchPanel;
	private JTextField textSearchKeyword;
	private JComboBox comboBox;
	private JButton btnSearch;
	private JButton btnHome;
	private JButton btnReadAll;
	private JButton btnCreat;
	private JButton btnDetail;
	private JTable tableMyBook;
	private JButton btnDelete;
	private DefaultTableModel tableModel;
	
	 private JTable table;
	
	private BookReviewDao dao = BookReviewDao.getInstance();

	/**
	 * Launch the application.
	 */
	public static void showBookReviewMyBook(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookReviewMyBook frame = new BookReviewMyBook(parent);
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
	private BookReviewMyBook(Component parent) {
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

		lblName = new JLabel("내 서재");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setBackground(new Color(255, 255, 255));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setLabelFor(lblName);
		lblName.setFont(new Font("D2Coding", Font.BOLD, 33));
		lblName.setBounds(0, 0, 584, 52);
		contentPane.add(lblName);

		searchPanel = new JPanel();
		searchPanel.setBounds(0, 54, 584, 73);
		contentPane.add(searchPanel);

		comboBox = new JComboBox();
		comboBox.setBounds(3, 5, 155, 59);
		final DefaultComboBoxModel<String> comboBoxModel = 
				new DefaultComboBoxModel<>(SEARCH_TYPES);
		searchPanel.setLayout(null);
		comboBox.setModel(comboBoxModel);
		comboBox.setFont(new Font("D2Coding", Font.BOLD, 25));
		searchPanel.add(comboBox);

		textSearchKeyword = new JTextField();
		textSearchKeyword.setBounds(163, 5, 331, 59);
		textSearchKeyword.setFont(new Font("D2Coding", Font.BOLD, 25));
		searchPanel.add(textSearchKeyword);
		textSearchKeyword.setColumns(25);

		btnSearch = new JButton("");
		btnSearch.setBounds(499, 5, 83, 59);
		btnSearch.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\icon\\search.png"));
		btnSearch.addActionListener((e) -> search());
		btnSearch.setFont(new Font("D2Coding", Font.BOLD, 25));
		searchPanel.add(btnSearch);

		JPanel panel = new JPanel();
		panel.setBounds(0, 509, 584, 52);
		contentPane.add(panel);
		panel.setLayout(null);

		btnHome = new JButton("홈");
		btnHome.addActionListener((e)->dispose());
		btnHome.setBounds(0, 4, 113, 43);
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(btnHome);

		btnReadAll = new JButton("목록보기");
		btnReadAll.addActionListener((e) -> initializeTable());
		btnReadAll.setBounds(117, 4, 113, 43);
		btnReadAll.setBackground(new Color(255, 255, 255));
		btnReadAll.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(btnReadAll);

		btnCreat = new JButton("추가");
		btnCreat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 서평 작성하기 창 띄우기
				BookReviewCreate.showBookReviewCreate(parent, BookReviewMyBook.this);
				parent.setVisible(false); // 버튼을 누르면 창 끄기
				
			}
		});
		btnCreat.setBounds(231, 4, 113, 43);
		btnCreat.setBackground(new Color(255, 255, 255));
		btnCreat.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(btnCreat);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener((e) -> deletoMyBook());
		btnDelete.setBounds(459, 4, 113, 43);
		btnDelete.setFont(new Font("D2Coding", Font.BOLD, 18));
		btnDelete.setBackground(Color.WHITE);
		panel.add(btnDelete);

		btnDetail = new JButton("상세보기");
		btnDetail.addActionListener((e) -> showBookReviewDetail());
		panel.add(btnDetail);

		btnDetail.setBounds(346, 4, 113, 43);
		btnDetail.setBackground(new Color(255, 255, 255));
		btnDetail.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(btnDetail);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 128, 584, 371);
		contentPane.add(scrollPane);

		tableMyBook = new JTable();
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		tableMyBook.setModel(tableModel);
		scrollPane.setViewportView(tableMyBook);
	}
	
	
	

	private void showBookReviewDetail() {
		int index = tableMyBook.getSelectedRow(); // 테이블에서 선택된 행의 인덱스
		if (index == -1) { // JTable에서 선택된 행이 없을 때
			 JOptionPane.showMessageDialog(
					 contentPane ,
	                    "상세보기할 행을 먼저 선택하세요.", 
	                    "경고", 
	                    JOptionPane.WARNING_MESSAGE);
	            return;
		}
		Integer isbn = (Integer) tableModel.getValueAt(index, 0);
		
		BookReviewDetail.showBookReviewDetail(parent, isbn, BookReviewMyBook.this);
	}

	// DAO 메서드를 호출해서 검색 결과를 가져옴.


	private void search() {
		
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
	    List<MyBook> mybook = dao.search(type, keyword);
	    resetTable(mybook); // 테이블 리셋.
		 }
	
	
	private void initializeTable() {
		// DAO를 사용해서 DB 테이블에서 검색.
		List<MyBook> mybook = dao.read();
		resetTable(mybook); // 테이블 리셋
	}
	
	private void resetTable(List<MyBook> mybook) {
        // 검색한 내용을 JTable에 보여줌 - JTable의 테이블 모델을 재설정.
        tableModel = new DefaultTableModel(null, COLUMN_NAMES); // 테이블 모델 리셋.
        for (MyBook b: mybook) {
            // DB 테이블에서 검색한 레코드를 JTable에서 사용할 행 데이터로 변환.
            Object[] row = {
                    b.getIsbn(), b.getTitle(),
                    b.getWriter(), b.getModifiedTime(),
            };
            tableModel.addRow(row); // 테이블 모델에 행 데이터를 추가.
        }
        tableMyBook.setModel(tableModel); // JTable의 모델을 다시 세팅.
    }
	
	private void deletoMyBook() {
		int index = tableMyBook.getSelectedRow();
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
            Integer isbn = (Integer) tableModel.getValueAt(index, 0);
            // DAO의 delete 메서드 호출.
            int result = dao.delete(isbn);
            if (result == 1) {
                initializeTable(); // 테이블을 새로고침.
                JOptionPane.showMessageDialog(contentPane, "삭제 성공!");
            } else {
                JOptionPane.showMessageDialog(contentPane, "삭제 실패!");
            }
        }
		
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
