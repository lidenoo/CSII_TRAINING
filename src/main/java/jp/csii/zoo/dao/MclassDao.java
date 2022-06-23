package jp.csii.zoo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jp.csii.zoo.dto.MclassDto;

public class MclassDao {

	// JDBCドライバ内部のDriverクラスパス
	private static final String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";

	// 接続するMySQLデータベースパス
	private static final String URL = "jdbc:mysql://localhost/csii_db?useUnicode=true&characterEncoding=utf8";

	// データベースのユーザー名
	private static final String USER = "root";

	// データベースのパスワード
	private static final String PASSWD = "sqlau4a83";

	// DBコネクション保持用
	private Connection con = null;

	// ステートメント保持用
	private Statement smt = null;

	/**
	 * フィールド変数の情報を基に、DB接続をおこなう関数
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public void connect() {

		try {

			Class.forName(RDB_DRIVE);
			this.con = DriverManager.getConnection(URL, USER, PASSWD);
			this.smt = this.con.createStatement();

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}

	}

	/**
	 * DB接続解除をおこなう関数
	 */
	public void disconnect() {

		if (this.smt != null) {
			try {
				this.smt.close();
			} catch (SQLException ignore) {
			}
		}

		if (this.con != null) {
			try {
				this.con.close();
			} catch (SQLException ignore) {
			}
		}

	}

	/**
	 * クエリ発行をおこなう関数
	 *
	 * @return クエリ結果セット
	 *
	 * @param sql 発行するSQL
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public ResultSet executeQuery(String sql) {

		try {
			return this.smt.executeQuery(sql);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * SQL実行をおこなう関数
	 *
	 * @return 更新行数
	 *
	 * @param sql 実行するSQL
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public int executeUpdate(String sql) {

		try {
			return this.smt.executeUpdate(sql);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public ArrayList<MclassDto> selectAll() {

		try {
			// DB接続
			connect();

			// データを全件取得するSQL文を用意
			String sql = "SELECT * FROM csii_db.m_class";
			// SQL文を発行し、結果セットを取得
			ResultSet rs = executeQuery(sql);

			// データ格納用のリストオブジェクトを生成
			ArrayList<MclassDto> mclassList = new ArrayList<MclassDto>();

			// 結果セットから1行ずつデータを取得
			while (rs.next()) {
				MclassDto dto = new MclassDto();
				dto.setId(rs.getInt("id"));
				dto.setGradeId(rs.getInt("grade_id"));
				dto.setName(rs.getString("name"));
				mclassList.add(dto);
			}

			// 呼び出し元へ学生データを返す
			return mclassList;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}
	}

	public MclassDto selectById(String id) {

		try {
			// DB接続
			connect();
			// データを一件取得するSQL文を用意
			String sql = "SELECT * FROM csii_db.m_class WHERE id = '" + id + "'";
			// SQL文を発行し、結果セットを取得
			ResultSet rs = executeQuery(sql);

			MclassDto dto = new MclassDto();

			if (rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setGradeId(rs.getInt("grade_id"));
				dto.setName(rs.getString("name"));
			}
			// 呼び出し元へ学生データを返す
			return dto;
		} catch (Exception e) {
			return null;
		}
	}

	public void delete(String delid) {

		try {
			// DB接続
			connect();

			// 指定されたISBN番号の書籍データを削除するSQL文を用意
			String sql = "DELETE FROM csii_db.m_class WHERE id ='" + delid + "'";

			// SQL文を発行
			executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}

	public void updateById(MclassDto dto) {
		try {
			// DB接続
			connect();
			String sql = "UPDATE csii_db.m_class SET grade_id ='" + dto.getGradeId() + "',name='" + dto.getName()
					+ "' WHERE id ='" + dto.getId() + "'";
			// SQL文を発行
			executeUpdate(sql);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}
	}


	public void insert(MclassDto dto){

		try{
			connect();
		String sql = "INSERT INTO csii_db.m_class (grade_id, name) VALUES ('" + dto.getGradeId() + "','" + dto.getName() + "')";

		executeUpdate(sql);


		}catch(Exception e){
			throw new IllegalStateException(e);	
		}finally{

			disconnect();
		}
		



		//INSERT INTO `csii_db`.`m_class` (`grade_id`, `name`) VALUES ('6', 'JESS');



	}

}
