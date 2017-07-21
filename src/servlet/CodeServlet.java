package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CodeDao;
import model.Code;
import util.StringEncrypt;


public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String type = request.getParameter("type"); 
		String deviceid = request.getParameter("deviceid"); 
		String code = request.getParameter("code"); 
		
		String ret = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long now = System.currentTimeMillis();
		CodeDao dao = new CodeDao();
		Code c = new Code();
		if(type==null) {
			type = "";
		}
		if(type.equals("1")) {
			for(int i=0 ; i <= 5; i++) {
				Random r =new Random(i);
				c.setCreat_time(df.format(new Date(now)));
				System.out.println(StringEncrypt.Encrypt(System.currentTimeMillis()+"+"+i+r.nextLong()));
				c.setCode(StringEncrypt.Encrypt(System.currentTimeMillis()+"+"+i+r.nextLong()));
				dao.addCode(c);
			}
			
		}else if(type.equals("2")) {
			c = dao.getCode(code);
			if(c != null) {
				c.setDevice(deviceid);
				c.setBind_time(df.format(new Date(now)));
			}
			dao.bindDevice(c);
		}else {
			
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(ret);
		out.flush();
		out.close();
	}

}
