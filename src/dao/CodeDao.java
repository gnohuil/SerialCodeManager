package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import model.Code;
import util.JdbcUtil;

public class CodeDao {
	
	public Code getCode(String sCode) {
		
		try {
			Connection con = JdbcUtil.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from code where code =" + sCode);
			Code c = new Code();
			while (rs.next()) {
				c.setBind_time(rs.getString(""));
				c.setCode(rs.getString(""));
				c.setDevice(rs.getString(""));
				c.setCreat_time(rs.getString(""));
			}
			JdbcUtil.release(rs, st, con);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Code> getList(){
		return null;
	}
	public int bindDevice(Code c){
		return 0;
	}
	public void addCode(Code c){
		try {
			Connection con = JdbcUtil.getConnection();
			Statement st = con.createStatement();
			st.executeQuery("insert into code (code,create_time) "
					+ "values("+c.getCode()+","+c.getCreat_time()+")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
