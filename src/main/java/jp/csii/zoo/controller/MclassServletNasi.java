package jp.csii.zoo.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.csii.zoo.dao.MclassDao;
import jp.csii.zoo.dto.MclassDto;

public class MclassServletNasi extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MclassDao dao = new MclassDao();
		ArrayList<MclassDto> al = dao.selectAll();
		req.setAttribute("cls", al);
		req.getRequestDispatcher("/mclasslistnasi.jsp").forward(req, resp);
	}
}
