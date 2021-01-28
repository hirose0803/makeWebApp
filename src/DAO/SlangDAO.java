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
import model.Slang;
public class SlangDAO {
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
	public void insertOne(Slang slang) {
		try {
			this.connect();
			ps = db.prepareStatement("INSERT INTO slangs(title,body,type) VALUES(?,?,?)");
			ps.setString(1, slang.getTitle());
			ps.setString(2, slang.getBody());
			ps.setInt(3, slang.getType());
			ps.execute();
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
	}

	public List<Slang> getListBySearchType(String SerchType){
		List<Slang> list=new ArrayList<>();
		try {
			this.connect();
			if(SerchType.equals("0")) {
				ps=db.prepareStatement("SELECT * FROM slangs ORDER BY title ASC");
				rs=ps.executeQuery();
			}else {
				ps=db.prepareStatement("SELECT * FROM slangs WHERE type= ? ORDER BY title ASC");
				ps.setInt(1, Integer.parseInt(SerchType));
				rs=ps.executeQuery();
			}
			while(rs.next()) {
				int id=rs.getInt("id");
				String title=rs.getString("title");
				String body=rs.getString("body");
				int type=rs.getInt("type");
				Slang s=new Slang(id,title,body,type);
				list.add(s);
			}

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				this.disconnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public Slang findOne(int id) {
		Slang slang = null;
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM slangs WHERE id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				String title=rs.getString("title");
				String body=rs.getString("body");
				int type=rs.getInt("type");
				slang=new Slang(id,title,body,type);
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
		return slang;
	}
	public void updateOne(Slang slang) {
		try {
			this.connect();
			ps=db.prepareStatement("UPDATE slangs SET title=?,body=?,type=? WHERE id =?");
			ps.setString(1,slang.getTitle());
			ps.setString(2, slang.getBody());
			ps.setInt(3, slang.getType());
			ps.setInt(4, slang.getId());
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
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
	public void deleteOne(int id) {
		try {
			this.connect();
			ps=db.prepareStatement("DELETE FROM slangs WHERE id=?");
			ps.setInt(1, id);
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
