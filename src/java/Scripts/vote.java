/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scripts;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author kimaiga
 */
public class vote extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet vote</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet vote at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        
    
//Database connection variables
    Connection conn= null;
    String url = "jdbc:mysql://localhost/";
    String dbName = "uchaguzi";
    String driver ="com.mysql.jdbc.Driver";
    String user = "root";
    String password = "";
    Statement st = null;
    ResultSet rs;

//attmept to connect to db
             try{
	       Class.forName(driver);

             conn = DriverManager.getConnection(url+dbName,user,password);

              st = conn.createStatement();

	            }
	            catch(Exception exp){
	              out.println("<h3>Cannot connect to the database,check network settings.</h3>");
	            }    
//voter verification
String idnumber = request.getParameter("id_number");
String voterid = request.getParameter("voter_id");
String voteserial = request.getParameter("voter_serial");
String president = request.getParameter("president");
String mp = request.getParameter("mp");
String governor = request.getParameter("governor");
String councillor = request.getParameter("councillor");



        if (idnumber.equals("")||voterid.equals("")){
  out.println("<h3>Cannot verify you, check your fields again.</h3>");
}
        else{
              String sql = "Select id_no,s_name,m_name,m_name,gender,voter_id,ward, constituency,county,poll_center from registration where id_no ='"+idnumber+"' and voter_id ='"+voterid+"'";

        try{
            int c=0;
            rs = st.executeQuery(sql);
            out.println("<h1>Registered!</h1>");            
            st = conn.prepareStatement(sql);
                  while(rs.next()){
                    c++;
                    }
            if (c==1) {


           rs = st.executeQuery(sql);
           st = conn.prepareStatement(sql);
            } 
            
            else {
                 out.println("<html><b><font color=red>NOT REGISTERED</font><br/>ID Number: <font color=red>"+idnumber+"</font></html>\n<html><b>Voter ID : <font color=red>"+voterid+"<br/> </html>");
            }
                           

        } catch(Exception exp){
            out.println("<h3>Cannot connect to the database,check network settings.</h3>");          
        }
        
        
        }         
//voting
        if (president.equals("")||mp.equals("")||councillor.equals("")||governor.equals("")){
  out.println("<h3>Kindly make selection in all fields!.</h3>");
}

        else{
            try{
        String sql = "INSERT into test VALUES("+"'"+president+"'," +"'"+mp+"',"+"'"+councillor+"',"+"'"+governor+"')" ;
        st.executeQuery(sql);
        out.println("You have voted!");
            }
        catch(Exception exp){
            
        }    
        }        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(vote.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(vote.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}