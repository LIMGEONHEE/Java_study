package com.itwill.library_view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class LibraryInfoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblOperatingHours;
	private JLabel lblAdressTitle;
	private JLabel lblMetro_1;
	private JLabel lblMetro_2;
	private JLabel lblMetro_3;
	private JLabel lblMetro_4;
	private JLabel lblBlank1;
	
	private Component parent;
	private JLabel lblAddress;
	private JLabel lblLine;
	private JLabel lblMetro;
	private JLabel lblMetro1;
	private JLabel lblMetro2;
	private JLabel lblBlank3;
	private JLabel lblBus;
	private JLabel lblMetro2_1;
	private JLabel lblMetro2_1_1;
	private JLabel lblMetro2_1_2;
	private JLabel lblMetro2_1_1_1;

	/**
	 * Launch the application.
	 */
	public static void showLibraryInfoFrame (Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryInfoFrame frame = new LibraryInfoFrame(parent);
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
	private LibraryInfoFrame(Component parent) {
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
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		lblOperatingHours = new JLabel("운영시간/휴관일");
		lblOperatingHours.setFont(new Font("D2Coding", Font.BOLD, 25));
		panel.add(lblOperatingHours);
		
		lblMetro_1 = new JLabel(" - 화~일  09:00 ~ 21:00");
		lblMetro_1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		panel.add(lblMetro_1);
		
		lblMetro_2 = new JLabel(" - 매주 월요일 휴관");
		lblMetro_2.setFont(new Font("D2Coding", Font.PLAIN, 18));
		panel.add(lblMetro_2);
		
		lblMetro_3 = new JLabel(" - 일요일을 제외한 법정공휴일 및 국가가 정한 임시 휴일");
		lblMetro_3.setFont(new Font("D2Coding", Font.PLAIN, 18));
		panel.add(lblMetro_3);
		
		lblMetro_4 = new JLabel(" - 기타 관장이 필요하다고 인정하는 날 미리 공지 후 휴관");
		lblMetro_4.setFont(new Font("D2Coding", Font.PLAIN, 18));
		panel.add(lblMetro_4);
		
		lblBlank1 = new JLabel(" ");
		lblBlank1.setFont(new Font("D2Coding", Font.BOLD, 25));
		panel.add(lblBlank1);
		
		lblAdressTitle = new JLabel("오시는 길");
		lblAdressTitle.setFont(new Font("D2Coding", Font.BOLD, 25));
		panel.add(lblAdressTitle);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\itwill\\Downloads\\도서관 위치.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		lblAddress = new JLabel(" 주소: 서울특별시 강남구 테헤란로 124( 역삼동,삼원타워 )");
		lblAddress.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(lblAddress);
		
		lblLine = new JLabel(" --------------------------------------------------------");
		lblLine.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(lblLine);
		
		lblMetro = new JLabel(" 지하철");
		lblMetro.setFont(new Font("D2Coding", Font.BOLD, 20));
		panel.add(lblMetro);
		
		lblMetro1 = new JLabel("  - 강남역 1번 출구 도보 150m");
		lblMetro1.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(lblMetro1);
		
		lblMetro2 = new JLabel("  - 역삼역 3번 출구 도보 200m");
		lblMetro2.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(lblMetro2);
		
		lblBlank3 = new JLabel(" ");
		lblBlank3.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(lblBlank3);
		
		lblBus = new JLabel(" 버스");
		lblBus.setFont(new Font("D2Coding", Font.BOLD, 20));
		panel.add(lblBus);
		
		lblMetro2_1 = new JLabel("  - 강남역,역감세무서 : ");
		lblMetro2_1.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(lblMetro2_1);
		
		lblMetro2_1_1 = new JLabel("    146, 341, 360, 740");
		lblMetro2_1_1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		panel.add(lblMetro2_1_1);
		
		lblMetro2_1_2 = new JLabel("  - 강남역, 12번 출구");
		lblMetro2_1_2.setFont(new Font("D2Coding", Font.BOLD, 18));
		panel.add(lblMetro2_1_2);
		
		lblMetro2_1_1_1 = new JLabel("    146, 341, 360, 740");
		lblMetro2_1_1_1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		panel.add(lblMetro2_1_1_1);
	}

}
