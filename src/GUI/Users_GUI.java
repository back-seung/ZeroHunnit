package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DTO.User_DTO;

public class Users_GUI extends JFrame implements ActionListener {
	// 생성자
	private User_DTO myU = new User_DTO();

	public Users_GUI(User_DTO u) {
		this.myU = u;
		init();
		menu_Panel();
		addListener();
		record_Panel();
		insert_Panel();
		rank_Panel();
		setFont();
	}

	// 폰트 생성
	Font TitleFont = new Font("맑은 고딕", Font.BOLD, 30);
	Font EngFont = new Font("Consolas", Font.BOLD, 20);
	Font KorFont = new Font("맑은 고딕", Font.BOLD, 20);

	// 폰트 적용
	private void setFont() {
		// 상단 버튼
		record_Btn.setFont(KorFont);
		insert_Btn.setFont(KorFont);
		rank_Btn.setFont(KorFont);
		// 중앙 컴포넌트
		// 기록 조회
		R_Main_lb.setFont(KorFont);
		// 기록 추가
		I_Main_lb.setFont(TitleFont);
		I_Name_lb.setFont(KorFont);
		I_Wt_lb.setFont(KorFont);
		I_Submit_Btn.setFont(KorFont);
		// 랭킹 보기
		Rnk_Main_lb.setFont(KorFont);
		// 하단 회사명
		lb_S.setFont(TitleFont);
	}

	// 기본 GUI 설정
	private void init() {
		this.setLayout(new BorderLayout());
		this.add("Notrh", menu_P);
		this.add("Center", record_P);
		this.add("South", lb_S);
		this.setBounds(100, 100, 400, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	// 상단 메뉴
	private JPanel menu_P = new JPanel();
	private JButton record_Btn = new JButton("누적기록");
	private JButton insert_Btn = new JButton("기록추가");
	private JButton rank_Btn = new JButton("랭킹보기");

	// 중앙
	private JPanel record_P = new JPanel();
	private JPanel insert_P = new JPanel();
	private JPanel rank_P = new JPanel();

	// 하단
	private JLabel lb_S = new JLabel("Zero Hunnit");

	// 메뉴 버튼 설정
	private void menu_Panel() {
		menu_P.setLayout(new GridLayout(1, 3));
		menu_P.add(record_Btn);
		record_Btn.setBackground(Color.decode("#4e71ba"));
		menu_P.add(insert_Btn);
		insert_Btn.setBackground(Color.decode("#4e71ba"));
		menu_P.add(rank_Btn);
		rank_Btn.setBackground(Color.decode("#4e71ba"));
	}

	// 이벤트 리스너
	private void addListener() {
		record_Btn.addActionListener(this);
		insert_Btn.addActionListener(this);
		rank_Btn.addActionListener(this);
	}

	// 개인 기록 조회
	JLabel R_Main_lb = new JLabel("개 인 기 록 조 회");
	List myRecord = new List(15);

	// 게인 기록 조회 디자인
	private void record_Panel() {
		record_P.setBackground(Color.decode("#4e71ba"));
		record_P.setLayout(new BorderLayout());
		record_P.add("North", R_Main_lb);
		record_P.add("Center", myRecord);
	}

	// 기록 화면
	private JLabel I_Main_lb = new JLabel("기 록 추 가");
	private JLabel I_Name_lb = new JLabel("종 목 입 력");
	private JTextField I_Name_tf = new JTextField(8);
	private JLabel I_Wt_lb = new JLabel("무 게 입 력");
	private JTextField I_Wt_tf = new JTextField(8);
	private JButton I_Submit_Btn = new JButton("추가");

	// 기록 화면 디자인
	private void insert_Panel() {
		insert_P.setBackground(Color.decode("#4e71ba"));
		I_Submit_Btn.setBackground(Color.decode("#4e71ba"));
		insert_P.setLayout(new GridLayout(6, 1));
		insert_P.add(I_Main_lb);
		insert_P.add(I_Name_lb);
		insert_P.add(I_Name_tf);
		insert_P.add(I_Wt_lb);
		insert_P.add(I_Wt_tf);
		insert_P.add(I_Submit_Btn);
	}

	// 랭킹보기
	private JLabel Rnk_Main_lb = new JLabel("랭 킹 보 기");
	private List Rnk_List = new List();

	// 랭킹보기 디자인
	private void rank_Panel() {
		rank_P.setBackground(Color.decode("#4e71ba"));
		rank_P.add(Rnk_Main_lb);
		rank_P.add(Rnk_List);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(record_Btn)) {
			this.remove(insert_P);
			this.remove(rank_P);
			this.add("Center", record_P);
			this.setVisible(true);
		} else if (e.getSource().equals(insert_Btn)) {
			this.remove(record_P);
			this.remove(rank_P);
			this.add("Center", insert_P);
			this.setVisible(true);
		} else if (e.getSource().equals(rank_Btn)) {
			this.remove(insert_P);
			this.remove(record_P);
			this.add("Center", rank_P);
			this.setVisible(true);
		}
	}
}
