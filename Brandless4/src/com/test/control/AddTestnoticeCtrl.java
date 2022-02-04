package com.test.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.TestnoticeDAO;
import com.test.model.TestnoticeVO;

@WebServlet("/AddTestnoticeCtrl")
public class AddTestnoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String nname = request.getParameter("nname");
		String ntit = request.getParameter("ntit");
		String ncon = request.getParameter("ncon");
		
		TestnoticeVO vo = new TestnoticeVO();
		vo.setNname(nname);
		vo.setNtit(ntit);
		vo.setNcon(ncon);
		
		TestnoticeDAO dao = new TestnoticeDAO();
		int cnt = dao.addTestnotice(vo);
		
		if(cnt!=0) {
			response.sendRedirect("GetTestnoticeListCtrl");
		} else {
			response.sendRedirect("/notice/addTestnotice.jsp");
		} 
	}
}
