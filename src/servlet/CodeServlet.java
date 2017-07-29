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
import util.Page;
import util.StringEncrypt;


public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String type = request.getParameter("type"); 
		
		String deviceid = request.getParameter("deviceid"); //type==2
		String code = request.getParameter("code"); 
		
		String currentPage = request.getParameter("currentPage"); //type=3
		String counts =  request.getParameter("counts"); 
		String isuse = request.getParameter("isuse");
		String total = request.getParameter("total");

		String ret = "ok";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long now = System.currentTimeMillis();
		CodeDao dao = new CodeDao();
		Code c = new Code();
		if(type==null) {
			type = "";
		}
		if(type.equals("1")) {
			for(int i=0 ; i <= 10; i++) {
				Random r =new Random(i);
				c.setCreat_time(df.format(new Date(now)));
				System.out.println(StringEncrypt.Encrypt(System.currentTimeMillis()+"+"+i+r.nextLong()));
				c.setCode(StringEncrypt.Encrypt(System.currentTimeMillis()+"+"+i+r.nextLong()));
				dao.addCode(c);
			}
			response.sendRedirect("code?type=3");
		}else if(type.equals("2")) {//绑定设备号
			c = dao.getCode(code);
			if(c != null) {
				c.setDevice(deviceid);
				c.setBind_time(df.format(new Date(now)));
				dao.bindDevice(c);
			}else{
				ret="code is error";
			}
		}else {//查看序列码
			Page p =new Page();
			int curPage = 0;
			int cts = 10;
			int iuse = 0;
			if(currentPage != null && !currentPage.equals(""))
				curPage = Integer.parseInt(currentPage);
			if(counts != null && !counts.equals(""))
			    cts = Integer.parseInt(counts);
			if(isuse != null && !isuse.equals(""))
			    iuse = Integer.parseInt(isuse);
			p.setMaxResults(cts);
			if(total!=null && !total.equals(""))
				p.setTotalRecords(Integer.parseInt(total));
			else
				p.setTotalRecords(dao.getTotalRecords(iuse));
			 
			p.setResults(dao.getList(iuse, curPage*cts, cts));
			request.setAttribute("p", p);
			request.setAttribute("isuse", iuse);
			request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(ret);
		out.flush();
		out.close();
	}

}
