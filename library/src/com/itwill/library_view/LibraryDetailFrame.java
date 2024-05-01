package com.itwill.library_view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.library_controller.LibraryDao;
import com.itwill.library_model.Library;

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
	
	public interface UpdateNotify {
		public void notifyUpdateSuccess();
	}

	private static final long serialVersionUID = 1L;
	
	private LibraryDao dao = LibraryDao.getInstance();
	private int libraryId;
	private Component parent;
	private UpdateNotify app;
	
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
	private JLabel lblTitle;
	private JLabel lblWriter;
	private JLabel lblPublisher;
	private JLabel lblLocation;
	private JLabel lblId;
	private JLabel lblCategory;
	private JButton btnClose;
	private JTextField textLoan_availability;
	private JLabel lblLoan_availability;

	

	/**
	 * Launch the application.
	 */
	public static void showLibraryDetailFrame(Component parent, int libraryId, UpdateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryDetailFrame frame = new LibraryDetailFrame(parent, libraryId, app);
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
	
	private LibraryDetailFrame(Component parent, int libraryId, UpdateNotify app) {
		this.parent = parent;
		this.libraryId = libraryId;
		this.app = app;
		
		initialize();
		initializeLibrary();
	}
	
	private void initializeLibrary() {
		Library library = dao.read(libraryId);
		if (library == null) return;
		
		textTitle.setText(library.getTitle());
		textWriter.setText(library.getWriter());
		textPublisher.setText(library.getPublisher());
		textId.setText(libraryId + "");
		textCategory.setText(library.getCategorie());
		textLocation.setText(library.getLocation());
		textLoan_availability.setText(library.getLoan_availability());
		
		
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
		lblBookImg.setBounds(179, 10, 198, 174);
		panel.add(lblBookImg);
		
		lblTitle = new JLabel("제목");
		lblTitle.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblTitle.setBounds(12, 201, 126, 36);
		panel.add(lblTitle);
		
		lblWriter = new JLabel("저자");
		lblWriter.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblWriter.setBounds(12, 247, 126, 36);
		panel.add(lblWriter);
		
		lblPublisher = new JLabel("출판사");
		lblPublisher.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblPublisher.setBounds(12, 293, 126, 36);
		panel.add(lblPublisher);
		
		lblLocation = new JLabel("도서위치");
		lblLocation.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblLocation.setBounds(12, 385, 126, 36);
		panel.add(lblLocation);
		
		lblId = new JLabel("등록번호");
		lblId.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblId.setBounds(12, 431, 126, 36);
		panel.add(lblId);
		
		lblCategory = new JLabel("분류");
		lblCategory.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblCategory.setBounds(12, 339, 126, 36);
		panel.add(lblCategory);
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("D2Coding", Font.BOLD, 20));
		textTitle.setBounds(159, 201, 411, 36);
		panel.add(textTitle);
		textTitle.setColumns(10);
		
		textWriter = new JTextField();
		textWriter.setFont(new Font("D2Coding", Font.BOLD, 20));
		textWriter.setColumns(10);
		textWriter.setBounds(159, 247, 411, 36);
		panel.add(textWriter);
		
		textPublisher = new JTextField();
		textPublisher.setFont(new Font("D2Coding", Font.BOLD, 20));
		textPublisher.setColumns(10);
		textPublisher.setBounds(159, 293, 411, 36);
		panel.add(textPublisher);
		
		textCategory = new JTextField();
		textCategory.setFont(new Font("D2Coding", Font.BOLD, 20));
		textCategory.setColumns(10);
		textCategory.setBounds(159, 339, 411, 36);
		panel.add(textCategory);
		
		textLocation = new JTextField();
		textLocation.setFont(new Font("D2Coding", Font.BOLD, 20));
		textLocation.setColumns(10);
		textLocation.setBounds(159, 385, 411, 36);
		panel.add(textLocation);
		
		textId = new JTextField();
		textId.setFont(new Font("D2Coding", Font.BOLD, 20));
		textId.setColumns(10);
		textId.setBounds(159, 431, 411, 36);
		panel.add(textId);
		
		btnClose = new JButton("닫기");
		btnClose.addActionListener((e) -> dispose());
		btnClose.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnClose.setBounds(205, 523, 119, 34);
		panel.add(btnClose);
		
		lblLoan_availability = new JLabel("도서예약");
		lblLoan_availability.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblLoan_availability.setBounds(12, 477, 126, 36);
		panel.add(lblLoan_availability);
		
		textLoan_availability = new JTextField();
		textLoan_availability.setFont(new Font("D2Coding", Font.BOLD, 20));
		textLoan_availability.setColumns(10);
		textLoan_availability.setBounds(159, 477, 411, 36);
		panel.add(textLoan_availability);
	}
}
