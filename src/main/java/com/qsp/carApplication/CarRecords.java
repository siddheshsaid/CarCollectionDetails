package com.qsp.carApplication;
import java.io.IOException;



import java.io.PrintWriter;
import java.sql.*;

import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CarRecords extends HttpServlet{
	
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{  
	
	String Cno=req.getParameter("no");
	int n= Integer.parseInt(Cno);
	String Cname=req.getParameter("cn");
	String Cmodel=req.getParameter("cm");
	String Cprice=req.getParameter("cp");
	int c=Integer.parseInt(Cprice);
	
//	PrintWriter output=resp.getWriter();
//	output.print("<html><body bgcolor='orange'><h1> Details are:"+n+" "+Cname+" "+Cmodel+" "+c+ " "+"</h1></body></html>");
	
	
	String qry="insert into carrecord.customerdetails values(?,?,?,?)";
//	"update carrecord.customerdetails set Cname= 'raju' where Cno=6"
	
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Siddhesh@123");
		PreparedStatement pstmt=con.prepareStatement(qry);
		pstmt.setInt(1, n);
		pstmt.setString(2,Cname);
		pstmt.setString(3,Cmodel);
		pstmt.setInt(4, c);
		pstmt.executeUpdate();
		
		
		//pstmt.executeUpdate();
		
		System.out.println("Data Entered");
	} 
	catch(Exception e) {
    e.printStackTrace();
	}
	
		
		
		
	}
	
	

}
