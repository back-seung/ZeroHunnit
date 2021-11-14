package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DAO.Admin_DAO;
import DTO.User_DTO;

public class Admin_GUI extends JFrame implements ActionListener, ItemListener {
	Admin_DAO A_DAO = new Admin_DAO();
	ArrayList<User_DTO> uList = null;

	// 생성자
	public Admin_GUI() {
		// getInstance
		init();
		addListener();
		menu_Panel();
		mod_Panel();
		del_Panel();
		view_Panel();
		setFont();
		loadData();
	}

	// 폰트 생성
	Font TitleFont = new Font("맑은 고딕", Font.BOLD, 30);
	Font EngFont = new Font("Consolas", Font.BOLD, 20);
	Font KorFont = new Font("맑은 고딕", Font.BOLD, 20);

	// 폰트 적용
	private void setFont() {
		// 상단 버튼
		mod_Btn.setFont(KorFont);
		del_Btn.setFont(KorFont);
		view_Btn.setFont(KorFont);
		// 중앙 컴포넌트
		// 수정
		M_Main_lb.setFont(TitleFont);
		M_Name_lb.setFont(KorFont);
		M_Wt_lb.setFont(KorFont);
		M_Mod_Btn.setFont(TitleFont);
		// 삭제
		D_Main_lb.setFont(TitleFont);
		D_Name_lb.setFont(KorFont);
		D_Del_Btn.setFont(TitleFont);
		// 전체보기
		V_Main_lb.setFont(TitleFont);
		// 하단 회사명
		lb_S.setFont(TitleFont);
	}

	// 기본 GUI 설정
	private void init() {
		this.setLayout(new BorderLayout());
		this.add("North", menu_P);
		this.add("Center", mod_P);
		this.add("South", lb_S);
		this.setBounds(100, 100, 400, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		M_Mod_Btn.addActionListener(this);
		D_Del_Btn.addActionListener(this);
		V_UserList.addItemListener(this);
	}

	// 메뉴 디자인
	private void menu_Panel() {
		menu_P.setLayout(new GridLayout(1, 3));
		menu_P.add(mod_Btn);
		mod_Btn.setBackground(Color.decode("#4e71ba"));
		menu_P.add(del_Btn);
		del_Btn.setBackground(Color.decode("#4e71ba"));
		menu_P.add(view_Btn);
		view_Btn.setBackground(Color.decode("#4e71ba"));
	}

	// 수정 디자인
	private JLabel M_Main_lb = new JLabel("수 정 하 기");
	private JLabel M_Name_lb = new JLabel("User Name 입력");
	private JTextField M_Name_tf = new JTextField(8);
	private JLabel M_Wt_lb = new JLabel("수정할 몸무게(kg) 입력");
	private JTextField M_Wt_tf = new JTextField(8);
	private JButton M_Mod_Btn = new JButton("수정");

	// 수정 컨셉 : customer의 유저 name을 검색해서 몸무게 변경
	private void mod_Panel() {
		mod_P.setBackground(Color.decode("#4e71ba"));
		mod_P.setLayout(new GridLayout(6, 1));
		mod_P.add(M_Main_lb);
		mod_P.add(M_Name_lb);
		mod_P.add(M_Name_tf);
		mod_P.add(M_Wt_lb);
		mod_P.add(M_Wt_tf);
		mod_P.add(M_Mod_Btn);
		M_Mod_Btn.setBackground(Color.decode("#4e71ba"));
	}

	// 삭제 디자인
	private JLabel D_Main_lb = new JLabel("삭 제 하 기");
	private JLabel D_Name_lb = new JLabel("삭제할 User Name 입력");
	private JTextField D_Name_tf = new JTextField(8);
	private JButton D_Del_Btn = new JButton("삭제");

	// 삭제 컨셉 : 유저의 name을 받고 일치하면 user 삭제
	private void del_Panel() {
		del_P.setBackground(Color.decode("#4e71ba"));
		del_P.setLayout(new GridLayout(4, 1));
		del_P.add(D_Main_lb);
		del_P.add(D_Name_lb);
		del_P.add(D_Name_tf);
		del_P.add(D_Del_Btn);
		D_Del_Btn.setBackground(Color.decode("#4e71ba"));
	}

	// 전체보기 디자인
	private JLabel V_Main_lb = new JLabel("전 체 보 기");
	private List V_UserList = new List(15);
	private TextArea V_Detail = new TextArea(4, 20);

	// 전체보기 설정
	private void view_Panel() {
		view_P.setBackground(Color.decode("#4e71ba"));
		view_P.setLayout(new GridLayout(3, 1));
		view_P.add(V_Main_lb);
		view_P.add(V_UserList);
		view_P.add(V_Detail);
	}

	// uList 받아오기
	private void loadData() {
		V_UserList.removeAll();
		uList = A_DAO.usrAll();
		for (int i = 0; i < uList.size(); i++) {
			V_UserList.add(uList.get(i).getName());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mod_Btn)) {
			this.remove(view_P);
			this.remove(del_P);
			this.add(mod_P);
			this.setVisible(true);
		} else if (e.getSource().equals(del_Btn)) {
			this.remove(mod_P);
			this.remove(view_P);
			this.add(del_P);
			this.setVisible(true);
		} else if (e.getSource().equals(view_Btn)) {
			this.remove(mod_P);
			this.remove(del_P);
			this.add(view_P);
			this.setVisible(true);
		} else if (e.getSource().equals(M_Mod_Btn)) {
			User_DTO modU = new User_DTO();
			modU.setName(M_Name_tf.getText());
			modU.setWeight(Integer.parseInt(M_Wt_tf.getText()));
			A_DAO.usrEdit(modU);
		} else if (e.getSource().equals(D_Del_Btn)) {
			User_DTO delU = new User_DTO();
			delU.setName(D_Name_tf.getText());
			A_DAO.usrDel(delU);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource().equals(V_UserList)) {
			int selIDX = V_UserList.getSelectedIndex();
			User_DTO u = uList.get(selIDX);
			detailView(u);
		}
	}

	private void detailView(User_DTO u) {
		V_Detail.setText("");
		V_Detail.append("ID : " + u.getId() + "\n");
		V_Detail.append("NAME : " + u.getName() + "님\n");
		V_Detail.append("HEIGHT : " + Integer.toString(u.getHeight()) + "cm\n");
		V_Detail.append("WEIGHT : " + Integer.toString(u.getWeight()) + "kg\n");
	}
}
