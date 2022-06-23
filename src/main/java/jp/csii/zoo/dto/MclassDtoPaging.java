package jp.csii.zoo.dto;

import java.util.List;

public class MclassDtoPaging {

	private int page;// 当ページ

	private int pagesize;// ページ毎表示される件数

	private int indexpage = 1;// 最初のページ

	private int endpage;// 最後のページ

	private int count;// 総件数

	private int pagenumber;// 総ページ数

	private List<MclassDto> list;// DBから取得するデータをlistに格納

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getIndexpage() {
		return indexpage;
	}

	public void setIndexpage(int indexpage) {
		this.indexpage = indexpage;
	}

	public int getEndpage() {

		return endpage;
	}

	public void setEndpage() {
		this.endpage = pagenumber;
	}

	public int getCount() {
		this.count = list.size();
		return count;
	}

	public void setCount() {
		this.count = list.size();
	}

	public int getPagenumber() {
		return pagenumber;
	}

	public void setPagenumber() {
		this.pagenumber = (count % pagesize == 0) ? count / pagesize : count / pagesize + 1;
	}

	public List<MclassDto> getList() {
		return list;
	}

	public void setList(List<MclassDto> mclassDtoList) {
		this.list = mclassDtoList;
	}
}
