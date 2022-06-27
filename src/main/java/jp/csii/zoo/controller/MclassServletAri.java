package jp.csii.zoo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.csii.zoo.dao.MclassDao;
import jp.csii.zoo.dto.MclassDto;
import jp.csii.zoo.dto.MclassDtoPaging;



public class MclassServletAri extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MclassDao dao = new MclassDao();
		
		ArrayList<MclassDto> al = dao.selectAll();

		/**
		 * ページング処理開始******************************************************************************
		 *
		 */
		// 当ページの初期値
		int page = 0;

		// 画面から当ページを取得
		String str_page = req.getParameter("page");

		MclassDtoPaging paging = new MclassDtoPaging();

		// DBから取得のデータをlistに格納
		paging.setList(al);

		// データ総件数の設定
		paging.setCount();

		// ページ毎の表示件数設定
		paging.setPagesize(5);

		// 総ページ数
		paging.setPagenumber();

		// 最後のページ
		paging.setEndpage();

		// 第一ページ
		paging.setIndexpage(1);

		if (str_page != null) {

			// 将页转换整型判断其大小
			int pag = Integer.parseInt(str_page);

			// 当大于零，将传过来的pag值赋给当前页page
			if (pag >= 0) {
				page = pag;
				// 如果小于最大值时则，将其传过来的值减1在赋值给当前页，让其一直在最后一页
				if (pag > (paging.getPagenumber() - 1)) {
					page = pag - 1;
				}
			}
		}
		paging.setPage(page);// 最终确认当前页
		List<Object> list_page = new ArrayList<>();

		// 将当前页的值传给新的list_page集合中，list集合是全部数据综合，用i调用其中的几条数据给list_page
		for (int i = paging.getPage() * paging.getPagesize(); i < (paging.getPage() + 1) * paging.getPagesize()
				&& i < al.size(); i++) {
			list_page.add(al.get(i));
		}

		// 将paging对象其设置在作用域中，以便后面页面调用
		req.setAttribute("paging", paging);
		req.setAttribute("mclassDtoListKey", list_page);

		/**
		 * ページング処理終了******************************************************************************
		 *
		 */
		req.getRequestDispatcher("/mclasslistari.jsp").forward(req, resp);
	}
}
