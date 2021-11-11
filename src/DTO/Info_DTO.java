package DTO;

public class Info_DTO {
	private String c_name = null;
	private String t_name = null;
	private String t_date = null;
	private int liftWeight = 0;
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_date() {
		return t_date;
	}
	public void setT_date(String t_date) {
		this.t_date = t_date;
	}
	public int getLiftWeight() {
		return liftWeight;
	}
	public void setLiftWeight(int liftWeight) {
		this.liftWeight = liftWeight;
	}
	/**
		CREATE TABLE info(
		c_name varchar2(10),
		t_name varchar2(10),
		liftweight number,
		tdate date default sysdate,
		FOREIGN KEY(c_id) REFERENCES customer(name)
		ON DELETE CASCADE,
		FOREIGN KEY(t_id) REFERENCES training(t_name)
		ON DELETE SET NULL);
	 */
}
