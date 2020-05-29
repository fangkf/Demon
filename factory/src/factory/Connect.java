package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection Connetli() {
		String Url="jdbc:mysql://localhost:3306/factory?useSSL=true&characterEncoding=utf-8";
		String UserName="root";
		String Password="";
		String jdbcName="com.mysql.jdbc.Driver";
		Connection con=null;
		try {
			Class.forName(jdbcName);
		}
		catch(Exception e) {}
		try {
			con=DriverManager.getConnection(Url,UserName,Password);
		}
		catch(SQLException e) {}
		if(con!=null) 
			System.out.println("数据库连接成功");
		return con;
		
	}
		


}