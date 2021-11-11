package DTO;

public class User_DTO {
	private String id = null; // 회원 아이디
	private String name = null; // 회원 이름
	private int height = 0;
	private int weight = 0;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
		CREATE TABLE customer(
		id varchar2(10) PRIMARY KEY,
		name varchar2(10),
		height number,
		weight number);
	 */
}
