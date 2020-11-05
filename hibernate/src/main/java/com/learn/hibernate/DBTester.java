package com.learn.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBTester {
	
	 
	public static void main(String[] args) throws SQLException
	{
		String dbUrl="jdbc:postgresql://localhost:5432/kuber"; 
		 String username="kuber"; String password="P@$$w0rd";
		System.out.println("connecting to database usrl:"+dbUrl); 
		 Connection myConn=DriverManager.getConnection(dbUrl, username, password);
		 System.out.println("connection successful!!!!");
		PreparedStatement st=myConn.prepareStatement("select first_name from student");
		ResultSet res=st.executeQuery();
		ArrayList<String> arList=new ArrayList<String>();
		while(res.next())
		{
			arList.add(res.getString("first_name"));
			System.out.println(res.getString("first_name"));
		}
		System.out.println(arList.size());
		
		StringBuilder strBuilder=new StringBuilder();
		strBuilder.append("[");
		for(String s:arList)
		{
			strBuilder.append("\""+s+"\",");
		}
		strBuilder.deleteCharAt(strBuilder.length()-1);
		strBuilder.append("]");
		System.out.println(strBuilder.toString());
	}
		 	
}
