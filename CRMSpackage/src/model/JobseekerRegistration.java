package model;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;

import javax.sql.*;
public class JobseekerRegistration extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	String emailaddress=req.getParameter("emailaddress");
	String firstname=req.getParameter("firstname");
	String lastname=req.getParameter("lastname");
	String username=req.getParameter("username");
	String password=req.getParameter("password");
	String rpassword=req.getParameter("rpassword");
	String totalexperience=req.getParameter("totalexperience");
	String jobcategory=req.getParameter("jobcategory");
	String keyskills=req.getParameter("keyskills");
	String phonenumber=req.getParameter("phonenumber");
	String mobilenumber=req.getParameter("mobilenumber");
	String currentlocation=req.getParameter("currentlocation");
	String prefferedjoblocation=req.getParameter("prefferedjoblocation");
	String highestqualificationheld=req.getParameter("highestqualificationheld");
	String major=req.getParameter("major");
	String institute=req.getParameter("institute");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/crms","newuser1","password");
		 PreparedStatement ps=con.prepareStatement("insert into jobseekerinformation values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 PreparedStatement pst=con.prepareStatement("create table "+username+"appliedjobs(referenceid varchar(45))");
		 pst.executeUpdate();
		 ps.setString(1,emailaddress);
		 ps.setString(2,firstname);
		 ps.setString(3,lastname);
		 ps.setString(4,username);
		 ps.setString(5,password);
		 ps.setString(6,rpassword);
		 ps.setString(7,totalexperience);
		 ps.setString(8,jobcategory);
		 ps.setString(9,keyskills);
		 ps.setString(10,phonenumber);
		 ps.setString(11,mobilenumber);
		 ps.setString(12,currentlocation);
		 ps.setString(13,prefferedjoblocation);
		 ps.setString(14,highestqualificationheld);
		 ps.setString(15,major);
		 ps.setString(16,institute);
		 int count=ps.executeUpdate();
		 if(count==1)
		 {
			 String type="jobseeker";
			 HttpSession hs=req.getSession();
			 hs.setAttribute("username",username);
			 hs.setAttribute("password",password);
			 hs.setAttribute("type",type);
			 RequestDispatcher rd=req.getRequestDispatcher("/redirectuser");
			 rd.forward(req,res);
		 }
		 else
			 out.println("There might be some error.Please try again after sometime");	 
	}
	catch(Exception e)
	{
		out.println("Exception caught at JobseekerRegistration servlet class New W");
		out.println(e);
	}

}
}
