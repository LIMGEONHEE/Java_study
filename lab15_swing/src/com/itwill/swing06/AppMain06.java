package com.itwill.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AppMain06 {

	private JFrame frame;
	private JRadioButton rdPrivate;
	private JRadioButton rdProtected;
	private JRadioButton rdPackage;
	private JRadioButton rdPublic;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox cbAbstract;
	private JCheckBox cbFinal;
	private JCheckBox cbStatic;
	private JComboBox<String> comboBox;
	private JButton btnInfo;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	private JRadioButton selectedRadioButton;
	
	private ArrayList<JCheckBox> selectedCheckBoxex = new ArrayList<>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain06 window = new AppMain06();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 578, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		rdPrivate = new JRadioButton("Private");
		rdPrivate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		rdPrivate.setSelected(true);
		buttonGroup.add(rdPrivate);
		rdPrivate.setFont(new Font("D2Coding", Font.BOLD, 20));
		rdPrivate.setBounds(8, 6, 135, 50);
		frame.getContentPane().add(rdPrivate);

		rdPackage = new JRadioButton("Package");
		rdPackage.addActionListener((e) -> handleRadioButtonClick(e));
		buttonGroup.add(rdPackage);
		rdPackage.setFont(new Font("D2Coding", Font.BOLD, 20));
		rdPackage.setBounds(141, 6, 135, 50);
		frame.getContentPane().add(rdPackage);

		rdProtected = new JRadioButton("Protected");
		rdProtected.addActionListener((e) -> handleRadioButtonClick(e));
		buttonGroup.add(rdProtected);
		rdProtected.setFont(new Font("D2Coding", Font.BOLD, 20));
		rdProtected.setBounds(280, 6, 135, 50);
		frame.getContentPane().add(rdProtected);

		rdPublic = new JRadioButton("Public");
		rdPublic.addActionListener(this::handleRadioButtonClick);
		buttonGroup.add(rdPublic);
		rdPublic.setFont(new Font("D2Coding", Font.BOLD, 20));
		rdPublic.setBounds(419, 6, 135, 50);
		frame.getContentPane().add(rdPublic);

		cbAbstract = new JCheckBox("abstract");
		cbAbstract.addActionListener((e) -> handleCheckBoxClick(e));
		cbAbstract.setFont(new Font("D2Coding", Font.BOLD, 20));
		cbAbstract.setBounds(8, 77, 135, 41);
		frame.getContentPane().add(cbAbstract);

		cbFinal = new JCheckBox("final");
		cbFinal.addActionListener((e) -> handleCheckBoxClick(e));
		cbFinal.setFont(new Font("D2Coding", Font.BOLD, 20));
		cbFinal.setBounds(141, 77, 135, 41);
		frame.getContentPane().add(cbFinal);

		cbStatic = new JCheckBox("static");
		cbStatic.addActionListener(this::handleCheckBoxClick);
		cbStatic.setFont(new Font("D2Coding", Font.BOLD, 20));
		cbStatic.setBounds(280, 77, 135, 41);
		frame.getContentPane().add(cbStatic);

		comboBox = new JComboBox<>(); // new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleComboBoxChange(e);
			}
		});
		final String[] emails = { "naver.com", "gamil.com", "kakao.com", "yahoo.com" };
		final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(emails);
		comboBox.setModel(model);
		comboBox.setFont(new Font("D2Coding", Font.BOLD, 20));
		comboBox.setBounds(8, 130, 268, 50);
		frame.getContentPane().add(comboBox);

		btnInfo = new JButton("확인");
		btnInfo.addActionListener((e) -> handleButtonClick());
		btnInfo.setFont(new Font("D2Coding", Font.BOLD, 20));
		btnInfo.setBounds(290, 124, 135, 56);
		frame.getContentPane().add(btnInfo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 190, 542, 173);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding", Font.BOLD, 20));
		scrollPane.setViewportView(textArea);
	}

	private void handleButtonClick() {
		// JTextArea에 출력할 문자열들을 붙일(append) 문자열 버퍼
		StringBuffer buffer = new StringBuffer();
		
		// 어떤 라디오버튼이 선택됐는 지
		if (rdPrivate.isSelected()) {
			buffer.append(rdPrivate.getText());
		} else if (rdPackage.isSelected()) {
			buffer.append(rdPackage.getText());
		} else if (rdProtected.isSelected()) {
			buffer.append(rdProtected.getText());
		} else {
			buffer.append(rdPublic.getText());
		}
		buffer.append("라디오버튼 선택됨.\n");
		
		// 어떤 체크박스(들)이 선택됐는 지
		if (cbAbstract.isSelected()) {
			buffer.append(cbAbstract.getText());
		} 
		if (cbFinal.isSelected()) {
			buffer.append(cbFinal.getText());
		}
		if (cbStatic.isSelected()) {
			buffer.append(cbStatic.getText()).append(" ");
		}
		buffer.append("체크박스 선택됨.\n");
		
		// 콤보박스에서 선택된 아이템
		Object selectedItem = comboBox.getSelectedItem();
		buffer.append(selectedItem.toString())
				.append(" 콤보박스 아이템 선택됨.\n");
		
		// 문자열 버퍼의 내용을 JTextArea에 씀.
		textArea.setText(buffer.toString());

	}

	private void handleComboBoxChange(ActionEvent e) {
		// 이벤트가 발생한 컴포넌트(JComboBox) 찾기
		JComboBox<String> combo = (JComboBox<String>) e.getSource();

		// 콤보박스에서 선택된 아이템 찾기
		int index = combo.getSelectedIndex(); // 콤보박스에서 선택된 아이템의 인덱스
		String item = (String) combo.getSelectedItem(); // 콤보박스에서 선택된 아이템

		// JTextArea에 정보 출력
		textArea.setText(index + ": " + item);

	}

	private void handleCheckBoxClick(ActionEvent e) {
		// 3개의 체크박스들 중에서 누가 클릭됐는 지
		JCheckBox cb = (JCheckBox) e.getSource();
		String text = cb.getText();
		boolean selected = cb.isSelected();
		textArea.setText(text + ": " + selected);
	}

	private void handleRadioButtonClick(ActionEvent e) {
		// 4개 라디오버튼들 중에서 누가 클릭됐는 지 찾기:
		JRadioButton rb = (JRadioButton) e.getSource();
		String text = rb.getText(); // 이벤트가 발생한 라디오 버튼의 텍스트
		boolean selected = rb.isSelected(); // 이벤트가 발생한 라디오버튼의 선택 여부
		textArea.setText(text + ": " + selected);
	}
}
