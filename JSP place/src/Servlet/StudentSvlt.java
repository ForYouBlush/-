package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.student;

/**
 * Servlet implementation class StudentSvlt
 */
@WebServlet("/StudentSvlt")
public class StudentSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		String stu_id =req.getParameter("id");
	    int success = 0;
	    String action = req.getParameter("action");
	    student stu = null;
	    String message="";
	   
	    if ("new".equalsIgnoreCase(action)) {
	      stu = doNew(req,res);
	      
	      sendBean(req, res, stu, "/getStudent.jsp");
	    }  
	    
	    if ("update".equalsIgnoreCase(action)) {
	    	try{		
	     	stu = doUpdate(req,res, stu_id);
	     	sendBean(req,res,stu,"/getStudent.jsp");
	     	   }
	     	  catch(SQLException e){} 
	    }
				   
	    if ("delete".equalsIgnoreCase(action)) {
	    	try{			
	      	success = doDelete(stu_id);	
	      	    }
	      	    catch(SQLException e){}				
	    	if (success != 1) {
	    		doError(req, res, "StudentSvlt: Delete unsuccessful. Rows affected: " + success);
	    	} else {
	    		res.sendRedirect("http://localhost:8080/WEBmanage/getStudent.jsp");
	    	}
	   
	    }
	    }
	    

	 public student doNew(HttpServletRequest req,HttpServletResponse res )
	                           throws ServletException,IOException{
	      student stu= new student();                     	
	      String stu_id=req.getParameter("id");
	      String name=new String(req.getParameter("name"));
	      String password= req.getParameter("password");
	      String dep=new String (req.getParameter("dep"));
	      String sex = new String(req.getParameter("sex"));
	      String jiguan = new String(req.getParameter("jiguan"));
	      if(isTrue(req,res,stu_id,name,password) && hasLogin(req,res,stu_id)){
	      
	      stu.setId(stu_id);
	      stu.setName(name);
	      stu.setPassword(password);
	      stu.setDep(dep);
	      stu.setSex(sex);
	      stu.setJiguan(jiguan);
	      stu.addStudent(); }  
	      return stu;                	
	                           	
	                           	}

	 public student doUpdate(HttpServletRequest req,HttpServletResponse res , String id)
	                           throws ServletException,IOException,SQLException {                      	
	    student stu = new student();   
	    String name=new String(req.getParameter("name"));  
	                 
	    String password = req.getParameter("password");
	    String dep = new String(req.getParameter("dep"));
	    String sex = new String(req.getParameter("sex"));
	    String jiguan = new String(req.getParameter("jiguan"));
	    if(isTrue(req,res,id,name,password)){
	    stu.setId(id);
	    stu.setName(name);
	    stu.setPassword(password);
	    stu.setDep(dep);
	    stu.setSex(sex);
	    stu.setJiguan(jiguan);
	    stu.updateStudent();}
			return stu;
	  }

	  public int doDelete(String id) throws SQLException {
	  	int num=0;
	    student stu=new student();
	    num=stu.deleteStudent(id);
	    return num;
	  }
		
	public void sendBean(HttpServletRequest req, HttpServletResponse res,
	                       student stu, String target)
	                       throws ServletException, IOException {
	    req.setAttribute("stu", stu);
	    RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
	    rd.forward(req, res);
	  }
	  
	  
	  public void doError(HttpServletRequest req,
	                      HttpServletResponse res,
	                      String str)
	                      throws ServletException, IOException {


	    req.setAttribute("problem", str);
	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorpage.jsp");
	    rd.forward(req, res);
	  }
	  
	  public boolean hasLogin(HttpServletRequest req, HttpServletResponse res,String id)
	  throws ServletException, IOException{
	  	boolean f=true;
	  	String message="对不起，该学生号已经被注册过了!";
	  	student stu= new student();
	  	f= stu.hasLogin(id);
	  	if(f==false){
	  	doError(req,res,message);	
	  		}
	  		return f;
	  	}
	  
	  public boolean isTrue(HttpServletRequest req, HttpServletResponse res,
	                        String id,String name,String password)
	                        throws ServletException, IOException {
	   boolean f=true;                     	
	   String message ="";
	   if(id==null || id.equals(""))  {
	   	f=false;
	   	message="错误，学生号不能为空！";
	   	doError(req,res,message);	}
	   
	   if(name==null || name.equals(""))  {
	   	f=false;
	   	message="学生姓名不能为空，请重新填写！";
	   	doError(req,res,message);	}
	  	
	       
	   if(password==null || password.equals(""))  {
	   	f=false;
	   	message="密码不能为空，请重新填写！";
	   	doError(req,res,message);	}  

	     return f;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
