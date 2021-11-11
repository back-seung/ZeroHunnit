package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Admin_GUI extends JFrame implements ActionListener {
	// 생성자
	public Admin_GUI() {
		init();
		addListener();
		menu_Panel();
		mod_Panel();
		del_Panel();
		view_Panel();
	}

	// 기본 GUI 설정
	private void init() {
		this.setLayout(new BorderLayout());
		this.add("North", menu_P);
		this.add("Center", mod_P);
		this.add("South", lb_S);
		this.setBounds(100, 100, 400, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	// 상단
	private JPanel menu_P = new JPanel();
	private JButton mod_Btn = new JButton("수정");
	private JButton del_Btn = new JButton("삭제");
	private JButton view_Btn = new JButton("전체보기");
	// 중앙
	private JPanel mod_P = new JPanel();
	private JPanel del_P = new JPanel();
	private JPanel view_P = new JPanel();

	// 하단
	private JLabel lb_S = new JLabel("Zero Hunnit");

	// 이벤트 리스너
	private void addListener() {
		mod_Btn.addActionListener(this);
		del_Btn.addActionListener(this);
		view_Btn.addActionListener(this);
	}

	// 메뉴 디자인
	private void menu_Panel() {
		menu_P.setLayout(new GridLayout(1, 3));
		menu_P.add(mod_Btn);
		menu_P.add(del_Btn);
		menu_P.add(view_Btn);
	}

	// 수정 디자인
	private JLabel M_Main_lb = new JLabel("수 정 하 기");
	private JLabel M_Name_lb = new JLabel("User Name 입력");
	private JTextField M_Name_tf = new JTextField(8);
	private JLabel M_Wt_lb = new JLabel("수정할 무게(kg) 입력");
	private JTextField M_Wt_tf = new JTextField(8);
	private JButton M_Mod_Btn = new JButton("수정");

	// 수정 컨셉 : info의 유저 name을 검색해서 무게 변경
	private void mod_Panel() {
		mod_P.setLayout(new GridLayout(6, 1));
		mod_P.add(M_Main_lb);
		mod_P.add(M_Name_lb);
		mod_P.add(M_Name_tf);
		mod_P.add(M_Wt_lb);
		mod_P.add(M_Wt_tf);
		mod_P.add(M_Mod_Btn);
	}

	// 삭제 디자인
	private JLabel D_Main_lb = new JLabel("삭 제 하 기");
	private JLabel D_Name_lb = new JLabel("삭제할 User Name 입력");
	private JTextField D_Name_tf = new JTextField(8);
	private JButton D_Del_Btn = new JButton("삭제");

	// 삭제 컨셉 : 유저의 name을 받고 일치하면 user 삭제
	private void del_Panel() {
		del_P.setLayout(new GridLayout(4, 1));
		del_P.add(D_Main_lb);
		del_P.add(D_Name_lb);
		del_P.add(D_Name_tf);
		del_P.add(D_Del_Btn);
	}

	// 전체보기 디자인
	private JLabel V_Main_lb = new JLabel("전 체 보 기");
	private List V_UserList = new List(15);
	private TextArea V_Detail = new TextArea(4, 20);

	// 전체보기 설정
	private void view_Panel() {
		view_P.setLayout(new GridLayout(3, 1));
		view_P.add(V_Main_lb);
		view_P.add(V_UserList);
		view_P.add(V_Detail);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mod_Btn)) {
			this.remove(del_P);
			this.remove(view_P);
			this.add(mod_P);
			this.setVisible(true);
		} else if (e.getSource().equals(del_Btn)) {
			this.remove(mod_P);
			this.remove(view_P);
			this.add(del_P);
			this.setVisible(true);
		} else if (e.getSource().equals(view_Btn)) {
			this.remove(del_P);
			this.remove(mod_P);
			this.add(view_P);
			this.setVisible(true);
		}
	}
}
