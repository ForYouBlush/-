package Servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.sqlBean;

/**
 * Servlet implementation class login_confirm
 */
@WebServlet("/login_confirm")
public class login_confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_confirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		String action = req.getParameter("action");
	      if ("logout".equalsIgnoreCase(action)) {
	      HttpSession session=req.getSession(true);
	        session.invalidate();
	        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
	        rd.forward(req, res);
	    } 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   String message=null; 
		   String id=null;
		   id=req.getParameter("id");
		   HttpSession session=req.getSession(true);
		   session.setAttribute("id",String.valueOf(id));
		   String password=null;
		   password= req.getParameter("password");
		 
		   String kind =null;
		   kind=req.getParameter("kind");
		   String temp =getPassword(req,res,id,kind);
		   if( password.equals(temp))
		   goo(req,res,kind);
		   else {
		   message="用户名或密码有误！";
		   doError(req,res,message)	;
		 	}
		 	} 
		  
		public void goo(HttpServletRequest req, HttpServletResponse res,String kind)
		throws ServletException,IOException
		{

			if(kind.equals("student")) {	
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/student.jsp");
		    rd.forward(req, res);}
		    if(kind.equals("teacher")){
		    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacher.jsp");
		    rd.forward(req, res);}
		    if(kind.equals("admin")){
		    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin.jsp");
		    rd.forward(req, res);}
			}
			

		  
		     
		  public String getPassword(HttpServletRequest req, HttpServletResponse res,
		                        String id,String kind)
		                        throws ServletException, IOException {
		   sqlBean db= new sqlBean();                  	
		   String pw="";                     	                     	
		   String sql="select password from "+kind+" where id='"+id+"'";
		   try{
		   ResultSet rs=db.executeQuery(sql); 	
		   if(rs.next() ){
		     pw= rs.getString("password");
		   	}
		   	} 
		   	catch(Exception e)
		{ System.out.print(e.toString());}   	    
		    return pw; 
		                            }
		     
		     	
		      
		     public void doError(HttpServletRequest req,
		                      HttpServletResponse res,
		                      String str)
		                      throws ServletException, IOException {

		    req.setAttribute("problem", str);
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorpage.jsp");
		    rd.forward(req, res);
	}

}
