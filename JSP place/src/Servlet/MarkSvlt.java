package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.determine;

/**
 * Servlet implementation class MarkSvlt
 */
@WebServlet("/MarkSvlt")
public class MarkSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarkSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		String tea_id =req.getParameter("id"); 
	    String class_id=null;
	    String score=null;
	    String stu_id=null;
	    String action = req.getParameter("action");
	    determine deter = null;
	        
	  if ("choosestu".equalsIgnoreCase(action)) {    		
	     	deter = doChoose(tea_id);
	     	sendBean(req,res,deter,"/choosestu.jsp");
	     	   } 
	     
	  if ("score".equalsIgnoreCase(action)) {    		
	     	deter = doAccept2(tea_id);
	     	sendBean(req,res,deter,"/score.jsp");
	     	   } 
	     	   
	  if ("marking".equalsIgnoreCase(action)) {  
	        class_id=req.getParameter("class_id");
	        score=req.getParameter("score") ;
	        stu_id=req.getParameter("id") ;    		
	     	doMarking(req,res,stu_id,class_id,score);
	        res.sendRedirect("score.jsp");      
	     	   } 
	     	    
	     	   
	  if ("public".equalsIgnoreCase(action)) {  
	        tea_id=req.getParameter("id");
	     	deter = doChoose(tea_id);
	     	sendBean(req,res,deter,"/public.jsp");
	     	   }  	   
	     	   
	  if ("accept".equalsIgnoreCase(action)) {  
	        class_id=req.getParameter("class_id");
	     	deter=doAccept(class_id);
	     	sendBean(req,res,deter,"/displaystu.jsp");
	     	   }
	     	   
	  if ("enrol".equalsIgnoreCase(action)) {  
	        stu_id=req.getParameter("stu_id");
	        class_id=req.getParameter("class_id");
	     	deter=doEnrol(req,res,stu_id,class_id);
	     	sendBean(req,res,deter,"/displaystu.jsp");
	     	   }	   
	     	     	      	  
	    }
	    
	    
	   public void doMarking(HttpServletRequest req, HttpServletResponse res,
	   String stu_id,String class_id,String score)throws ServletException, IOException{
	   	int num=0;
	   	int temp=0;
	   	determine deter =new determine();
	   	num=deter.marking(stu_id,class_id,score);
	   	if(num==0) doError(req,res,"更新失败！");
	   	try{
	   	   temp=Integer.parseInt(score);	
	   		} 
	   	catch(NumberFormatException e){System.out.print(e.toString());
	   	doError(req,res,"格式不对，请重输！！");
	   	    }
	   		if(temp>=60)
	   	num=deter.addMark(stu_id,class_id);
	   	if(num==0) doError(req,res,"更新失败！");	
	   	}
	    
	    
	   public determine doEnrol(HttpServletRequest req, HttpServletResponse res,
	   String stu_id,String class_id)throws ServletException, IOException{
	     	int num=0;
	   		determine deter =new determine();
	   	    num= deter.enrol(stu_id,class_id);
	   	    if(num==0) doError(req,res,"更新失败！");
	   	    return deter;
	   	}
				   
	  
	  public determine doChoose(String tea_id){
	  	determine deter =new determine();
	  	deter.getClass(tea_id);
	  	return deter; 	
	  	}
	  	
	  public determine doAccept2(String class_id){
	  		determine deter = new determine();
	  		deter.getStudents2(class_id);
	  		return deter;  		
	  		}
	  		
	  public determine doAccept(String class_id){
	  		determine deter = new determine();
	  		deter.getStudents(class_id);
	  		return deter;  		
	  		}		  
	    
	      public void sendBean(HttpServletRequest req, HttpServletResponse res,
	                       determine deter, String target)
	                       throws ServletException, IOException {
	    req.setAttribute("deter", deter);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
