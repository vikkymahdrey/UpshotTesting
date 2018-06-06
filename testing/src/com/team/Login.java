package com.team;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DatabaseConnectivity;
import com.notification.SendMail;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/In Login check servlet");
		String username =  request.getParameter("username");
		String password =  request.getParameter("password");
		
		System.out.println("Username"+username);
		System.out.println("password"+password);
		
	 
        try{ 
        	PrintWriter pw = response.getWriter();
        	
            Connection con=DatabaseConnectivity.getConnection();  
                    
            PreparedStatement ps=con.prepareStatement("select * from user where username=? and password=?"); 
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
            	System.out.println("Inside Success!");
                //pw.println("Login Success...!");
                //response.sendRedirect("/home.jsp");
                //request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
                request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
                
                SendMail mail = com.notification.SendMailFactory.getMailInstance();
				try{
					String message="Hi "+username+", You successfully login!";
				mail.send("vikky.softengi@gmail.com", "Login Success!", message);
				
				}catch(Exception ex){
					ex.printStackTrace();
				}
               
            }else{
            	System.out.println("Inside Faild!");
                //pw.println("Login Failed...!");
                request.getRequestDispatcher("/WEB-INF/views/failed.jsp").forward(request, response);
            }
            
            
            /*
            //Insert into Upshot db 
            PreparedStatement ps=con.prepareStatement("insert into upshot(name,password,email,country) values (?,?,?,?)");  
            ps.setString(1,name);
            ps.setString(2,password);  
            ps.setString(3,email);  
            ps.setString(4,country);                
            int status=ps.executeUpdate();  */
              
            con.close();  
        }catch(Exception ex){
        	ex.printStackTrace();
        }  
          
       
		
	}

}