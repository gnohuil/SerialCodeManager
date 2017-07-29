package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Code;
import util.JdbcUtil;

public class CodeDao {
	
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
	public Code getCode(String sCode) {
		
		try {
			 con = JdbcUtil.getConnection();
			 st = con.createStatement();
			 rs = st.executeQuery("select * from code where code =" + sCode);
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
	public List<Code> getList(int isuse,int start,int count){
		List<Code> lists = new ArrayList<Code>();
		try {
			 con = JdbcUtil.getConnection();
			 st = con.createStatement();
			 if(isuse==0)
				 rs = st.executeQuery("select * from code where device is null order by createtime desc limit "+start+","+count);
			 else
				 rs = st.executeQuery("select * from code where device is not null order by createtime desc limit "+start+","+count);
			
			while (rs.next()) {
				Code c = new Code();
				c.setBind_time(rs.getString("bindtime"));
				c.setCode(rs.getString("code"));
				c.setDevice(rs.getString("device"));
				c.setCreat_time(rs.getString("createtime"));
				lists.add(c);
			}
			JdbcUtil.release(rs, st, con);
			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getTotalRecords(int isuse){

		try {
			 con = JdbcUtil.getConnection();
			 st = con.createStatement();
			 if(isuse==0)
				 rs = st.executeQuery("select count(*) from code where device is null");
			 else
				 rs = st.executeQuery("select count(*) from code where device is not null");
			
			if (rs.next()) {
				return rs.getInt(1);
			}
			JdbcUtil.release(rs, st, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void bindDevice(Code c) {
		try {
			 con = JdbcUtil.getConnection();
			 st = con.createStatement();
			 st.executeUpdate("update code set device = '"+c.getDevice()+"',bindtime='"
			 +c.getBind_time()+"' where code = '"+c.getCode()+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addCode(Code c){
		try {
			 con = JdbcUtil.getConnection();
			 st = con.createStatement();
			 st.executeUpdate("insert into code (code,createtime) "
					+ "values('"+c.getCode()+"','"+c.getCreat_time()+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
