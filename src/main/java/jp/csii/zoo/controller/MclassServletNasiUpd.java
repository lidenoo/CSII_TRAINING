package jp.csii.zoo.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.csii.zoo.dao.MclassDao;
import jp.csii.zoo.dto.MclassDto;

public class MclassServletNasiUpd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MclassDao dao = new MclassDao();

		String strUpdid = req.getParameter("updid");

		MclassDto dto = dao.selectById(strUpdid);

		req.setAttribute("updDto", dto);

		req.getRequestDispatcher("/mclassupd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String strId = req.getParameter("id");
			String strGradeid = req.getParameter("gradeid");
			String strName = req.getParameter("name");

			MclassDto dto = new MclassDto();

			// 文字列⇒intに切り替え
			dto.setId(Integer.parseInt(strId));
			dto.setGradeId(Integer.parseInt(strGradeid));
			dto.setName(strName);

			MclassDao dao = new MclassDao();
			dao.updateById(dto);
			ArrayList<MclassDto> al = dao.selectAll();
			req.setAttribute("cls", al);
			req.setAttribute("msg", "データの変更しました。");
			req.getRequestDispatcher("/mclasslistnasi.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("msg", "データの削除は失敗しました。");
			req.getRequestDispatcher("/mclasslistnasi.jsp").forward(req, resp);
		}
	}

}
