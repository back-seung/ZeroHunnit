package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class User_GUI extends JFrame implements ActionListener {
	// 중앙
	private JPanel User_C_P = new JPanel();
	private JPanel Register_P = new JPanel();
	private JPanel User_C_N_P = new JPanel();

	// 하단
	private JLabel lb_N = new JLabel("Zero Hunnit");
	private JButton register_Btn = new JButton("회원가입");
	private JButton login_Btn = new JButton("로그인");
	// private JButton submit_Btn = new JButton("SUBMIT");

	public User_GUI() {
		init();
		setCP();
	}

	// 기본 GUI 설정
	private void init() {
		this.add("North", User_C_N_P);
		this.add("South", lb_N);
		this.add("Center", User_C_P);
		this.setBounds(100, 100, 300, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	// User_C_P 설정
	private void setCP() {
		User_C_P.setLayout(new BorderLayout());
		// 센터 상단 메뉴
		User_C_P.add("North", User_C_N_P);
		User_C_N_P.setLayout(new GridLayout(1, 2));
		User_C_N_P.add(register_Btn);
		User_C_N_P.add(login_Btn);

	}

	// 센터 중앙 입력 창
	private void setCCP() {

	}

	// 상단 버튼 별 이벤트 리스너
	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
