package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DTO.Admin_DTO;

public class User_GUI extends JFrame implements ActionListener {
	// Admin DTO & GUI 불러오기
	Admin_DTO A_DTO = new Admin_DTO();
	Admin_GUI A_GUI = null;

	// 생성자
	public User_GUI() {
		init();
		menu();
		addListener();
		Register_Panel();
		Login_Panel();
		Admin_Panel();
		setFont();
	}

	// 폰트 생성
	Font TitleFont = new Font("맑은 고딕", Font.BOLD, 30);
	Font EngFont = new Font("Consolas", Font.BOLD, 20);
	Font KorFont = new Font("맑은 고딕", Font.BOLD, 20);

	// 폰트 적용
	private void setFont() {
		// 상단 버튼
		register_Btn.setFont(KorFont);
		login_Btn.setFont(KorFont);
		admin_Btn.setFont(KorFont);
// 각 중앙 컴포넌트
		// 회원가입
		R_Main_lb.setFont(TitleFont);
		R_id_lb.setFont(EngFont);
		R_name_lb.setFont(EngFont);
		R_ht_lb.setFont(EngFont);
		R_wt_lb.setFont(EngFont);
		submit_Btn.setFont(TitleFont);
		// 로그인
		L_Main_lb.setFont(TitleFont);
		L_id_lb.setFont(EngFont);
		L_pw_lb.setFont(EngFont);
		logging_Btn.setFont(TitleFont);
		// 관리자
		A_Main_lb.setFont(TitleFont);
		A_id_lb.setFont(EngFont);
		A_pw_lb.setFont(EngFont);
		logging_Btn2.setFont(TitleFont);
		// 하단 회사명
		lb_S.setFont(TitleFont);
	}

	// 기본 GUI 설정
	private void init() {
		this.setLayout(new BorderLayout());
		this.add("North", menu_P);
		this.add("Center", register_P);
		this.add("South", lb_S);
		this.setBounds(100, 100, 400, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	// 상단 메뉴
	private JPanel menu_P = new JPanel();
	private JButton register_Btn = new JButton("회원가입");
	private JButton login_Btn = new JButton("로그인");
	private JButton admin_Btn = new JButton("관리자");
	// 중앙
	private JPanel register_P = new JPanel();
	private JPanel login_P = new JPanel();
	private JPanel admin_P = new JPanel();

	// 하단
	private JLabel lb_S = new JLabel("Zero Hunnit");

	// 회원가입
	private JLabel R_Main_lb = new JLabel("회 원 가 입");
	private JLabel R_id_lb = new JLabel("ID");
	private JTextField R_id_tf = new JTextField(8);
	private JLabel R_name_lb = new JLabel("Name");
	private JTextField R_name_tf = new JTextField(8);
	private JLabel R_ht_lb = new JLabel("Height");
	private JTextField R_ht_tf = new JTextField(8);
	private JLabel R_wt_lb = new JLabel("Weight");
	private JTextField R_wt_tf = new JTextField(8);
	private JButton submit_Btn = new JButton("SUBMIT");

	// 회원가입 화면 디자인
	private void Register_Panel() {
		register_P.setBackground(Color.decode("#4e71ba"));
		submit_Btn.setBackground(Color.decode("#4e71ba"));
		register_P.setLayout(new GridLayout(10, 1));
		register_P.add(R_Main_lb);
		register_P.add(R_id_lb);
		register_P.add(R_id_tf);
		register_P.add(R_name_lb);
		register_P.add(R_name_tf);
		register_P.add(R_ht_lb);
		register_P.add(R_ht_tf);
		register_P.add(R_wt_lb);
		register_P.add(R_wt_tf);
		register_P.add(submit_Btn);
	}

	// 로그인 화면
	private JLabel L_Main_lb = new JLabel("유 저 로 그 인");
	private JLabel L_id_lb = new JLabel("ID");
	private JTextField L_id_tf = new JTextField(8);
	private JLabel L_pw_lb = new JLabel("Weight = your pw");
	private JTextField L_pw_tf = new JTextField(8);
	private JButton logging_Btn = new JButton("LOGIN");

	// 로그인 화면 디자인
	private void Login_Panel() {
		login_P.setBackground(Color.decode("#4e71ba"));
		logging_Btn.setBackground(Color.decode("#4e71ba"));
		login_P.setLayout(new GridLayout(6, 1));
		login_P.add(L_Main_lb);
		login_P.add(L_id_lb);
		login_P.add(L_id_tf);
		login_P.add(L_pw_lb);
		login_P.add(L_pw_tf);
		login_P.add(logging_Btn);
	}

	// 관리자 화면
	private JLabel A_Main_lb = new JLabel("관 리 자 로 그 인");
	private JLabel A_id_lb = new JLabel("ID");
	private JTextField A_id_tf = new JTextField(8);
	private JLabel A_pw_lb = new JLabel("PW");
	private JTextField A_pw_tf = new JTextField(8);
	private JButton logging_Btn2 = new JButton("LOGIN");

	// 관리자 화면 디자인
	private void Admin_Panel() {
		admin_P.setBackground(Color.decode("#4e71ba"));
		logging_Btn2.setBackground(Color.decode("#4e71ba"));
		admin_P.setLayout(new GridLayout(6, 1));
		admin_P.add(A_Main_lb);
		admin_P.add(A_id_lb);
		admin_P.add(A_id_tf);
		admin_P.add(A_pw_lb);
		admin_P.add(A_pw_tf);
		admin_P.add(logging_Btn2);
	}

	// 메뉴 버튼 설정
	private void menu() {
		menu_P.setLayout(new GridLayout());
		menu_P.add(register_Btn);
		register_Btn.setBackground(Color.decode("#4e71ba"));
		menu_P.add(login_Btn);
		login_Btn.setBackground(Color.decode("#4e71ba"));
		menu_P.add(admin_Btn);
		admin_Btn.setBackground(Color.decode("#4e71ba"));

	}

	private void addListener() {
		register_Btn.addActionListener(this);
		login_Btn.addActionListener(this);
		admin_Btn.addActionListener(this);
		logging_Btn2.addActionListener(this);
	}

	// 상단 버튼 별 이벤트 리스너
	@Override
	public void actionPerformed(ActionEvent e) {
		// 회원가입 버튼
		if (e.getSource().equals(register_Btn)) {
			this.remove(login_P);
			this.remove(admin_P);
			this.add("Center", register_P);
			this.setVisible(true);
			// 로그인 버튼
		} else if (e.getSource().equals(login_Btn)) {
			this.remove(register_P);
			this.remove(admin_P);
			this.add("Center", login_P);
			this.setVisible(true);
			// 관리자 버튼
		} else if (e.getSource().equals(admin_Btn)) {
			this.remove(login_P);
			this.remove(register_P);
			this.add(admin_P);
			this.setVisible(true);
			// 관리자 로그인 버튼
		} else if (e.getSource().equals(logging_Btn2)) {
			if (A_id_tf.getText().equals(A_DTO.getAdm_id()) && A_pw_tf.getText().equals(A_DTO.getAdm_pw())) {
				System.out.println("관리자 메뉴로 진입합니다.");
				A_GUI = new Admin_GUI();
			}
		}
	}
}
