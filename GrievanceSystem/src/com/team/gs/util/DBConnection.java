package com.team.gs.util;

import java.sql.*;
public class DBConnection {
public static Connection getConnection() throws Exception{
	Class.forName("com.mysql.jdbc.Driver");
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/grievances","root","root");
	return c;
}
public static void main(String a[])
{
	try{
System.out.println(getConnection());
	}
	catch(Exception e)
	{e.printStackTrace();}
}
}

