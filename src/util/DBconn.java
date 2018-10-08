package util;

import java.sql.*;

public class DBconn {
	static String url = "jdbc:mysql://localhost:3306/management?useunicuee=true& characterEncoding=utf8"; 	
	static String username = "root"; 	
	static String password = "root";
	static Connection conn = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	
	public static void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("init [SQL���������ʼ��ʧ��]");
			e.printStackTrace();
		}
	}
	
	public static int addUpdDel(String sql) {
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("sql���ݿ���ɾ���쳣");
			e.printStackTrace();
		}
		return i;
	}
	
	public static ResultSet selectsql(String sql) {
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("sql���ݿ��ѯ�쳣");
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void closeconn() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("sql���ݿ�ر��쳣");
			e.printStackTrace();
		}
	}
}
