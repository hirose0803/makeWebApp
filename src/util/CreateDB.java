package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDB {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("assets/slang-word.txt");
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mmoslang?useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String pass = "";
			Connection db = DriverManager.getConnection(url, user, pass);

			db.setAutoCommit(false);
			PreparedStatement ps = db.prepareStatement("INSERT INTO slangs(title,body,type) VALUES(?,?,?)");
			String line;
			while ((line = br.readLine()) != null) {
				String[] vals = line.split(",");
				ps.setString(1, vals[0]);
				ps.setString(2, vals[1]);
				ps.setString(3, vals[2]);
				ps.executeUpdate();
			}
			db.commit();
			db.close();
			br.close();
			System.out.println("done!");
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}