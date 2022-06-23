package jp.csii.zoo.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.csii.zoo.dao.MclassDao;
import jp.csii.zoo.dto.MclassDto;

public class MclassServletNasiDel extends HttpServlet{

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	try {
	
	String strDelid = req.getParameter("delid");

	MclassDao dao = new MclassDao();
	
	dao.delete(strDelid);
	
	ArrayList<MclassDto> al = dao.selectAll();
	
	req.setAttribute("cls", al);
	req.setAttribute("msg", strDelid + "番のデータが削除されました。");
	req.getRequestDispatcher("/mclasslistnasi.jsp").forward(req, resp);
	
	} catch (Exception e) {
		req.setAttribute("msg", "データの削除は失敗しました。");
		req.getRequestDispatcher("/mclasslistnasi.jsp").forward(req, resp);
	}
	

	
	
	
}
	
}
