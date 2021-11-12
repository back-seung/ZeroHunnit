package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Info_DTO;
import DTO.Training_DTO;
import DTO.User_DTO;

public class User_DAO {
	private Connection conn = null;

	public static User_DTO user_dao = null;

	public static User_DTO getInstance() {
		if (user_dao == null) {
			user_dao = new User_DTO();
		}
		return user_dao;
	}

	public User_DAO() {
		init();
	}

	private void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("클래스 로드 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패");
		}
	}

	private void getConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "1111");
			System.out.println("DB 접속 성공");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
	}

	public void usrAdd(User_DTO usr) { // 회원등록
		String sql = "insert into customer values (?,?,?,?)";
		try {
			getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, usr.getName());
			psmt.setString(2, usr.getId());
			psmt.setInt(3, usr.getHeight());
			psmt.setInt(4, usr.getWeight());
			int k = psmt.executeUpdate();
			System.out.println(k + "건 등록완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public User_DTO usrOne(User_DTO usr) { // 회원검색
		String sql = "select * from customer where name=?";
		ResultSet rs = null;
		User_DTO returnDTO = new User_DTO();
		try {
			getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, usr.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				returnDTO.setId(rs.getString("id"));
				returnDTO.setName(rs.getString("name"));
				returnDTO.setHeight(rs.getInt("height"));
				returnDTO.setWeight(rs.getInt("weight"));
			}
			return returnDTO;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<User_DTO> usrAll() { // 회원전체보기
		String sql = "select * from customer";
		ResultSet rs = null;
		User_DTO returnDTO = null;
		ArrayList<User_DTO> ulist = new ArrayList<>();
		try {
			getConnection();
			Statement p = conn.createStatement();
			rs = p.executeQuery(sql);
			while (rs.next()) {
				returnDTO = new User_DTO();
				returnDTO.setId(rs.getString("id"));
				returnDTO.setName(rs.getString("name"));
				returnDTO.setHeight(rs.getInt("height"));
				returnDTO.setWeight(rs.getInt("weight"));
				ulist.add(returnDTO);
			}
			return ulist;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void trnAdd(Training_DTO trn) { // 운동등록
		String sql = "insert into taining values (?)";
		try {
			getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, trn.getT_name());
			int k = psmt.executeUpdate();
			System.out.println(k + "건 등록완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Training_DTO> trnAll() { // 운동전체보기
		String sql = "select * from taining";
		ResultSet rs = null;
		Training_DTO returnDTO = null;
		ArrayList<Training_DTO> tlist = new ArrayList<>();
		try {
			getConnection();
			Statement p = conn.createStatement();
			rs = p.executeQuery(sql);
			while (rs.next()) {
				returnDTO = new Training_DTO();
				returnDTO.setT_name(rs.getString("id"));
				tlist.add(returnDTO);
			}
			return tlist;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ArrayList<Info_DTO> usrRank() { // 랭킹
		String sql = "select * from info order by liftweight desc";
		ResultSet rs = null;
		Info_DTO returnDTO = null;
		ArrayList<Info_DTO> tlist = new ArrayList<>();
		try {
			getConnection();
			Statement p = conn.createStatement();
			rs = p.executeQuery(sql);
			while (rs.next()) {
				returnDTO = new Info_DTO();
				returnDTO.setC_name(rs.getString("c_name"));
				returnDTO.setT_name(rs.getString("t_name"));
				returnDTO.setLiftWeight(rs.getInt("liftweight"));
				tlist.add(returnDTO);
			}
			return tlist;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
}
