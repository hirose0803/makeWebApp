package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.Request;
public class RequestDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	private void connect() throws NamingException, SQLException {
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/mmoslang");
			this.db=ds.getConnection();
	}
	private void disconnect() throws SQLException {
		if(rs !=null) {
			rs.close();
		}
		if(ps !=null) {
			ps.close();
		}
		if(db != null) {
			db.close();
		}
	}
	public List<Request> findAll(){
		List<Request> list=new ArrayList<>();
		try {
			this.connect();
			ps = db.prepareStatement("SELECT * FROM request");
			rs = ps.executeQuery();
			while (rs.next()) {
				String title = rs.getString("title");
				list.add(new Request(title));
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.disconnect();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return list;
	}
	public void insertOne(Request req) {
		try {
			this.connect();
			ps = db.prepareStatement("INSERT INTO request(title) VALUES (?);");
			ps.setString(1,req.getReq());
			ps.execute();
			System.out.println(req.getReq());
		}catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.disconnect();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
	public void deleteOne(Request req) {
		try {
			this.connect();
			ps=db.prepareStatement("DELETE FROM request WHERE title=?");
			ps.setString(1, req.getReq());
			ps.execute();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			try {
				this.disconnect();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
}
