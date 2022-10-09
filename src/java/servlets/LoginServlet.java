
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author Aster
 */
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String logout = request.getParameter("request");
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        if (username.equals("") || username == null) { //If no username session variable exists
            if (logout.equals("logout")){
            session.invalidate();
            request.setAttribute("message", "Successfully logged out.");
            }
               getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
        else {
               response.sendRedirect("home");  
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NullPointerException {
        String username = (String) request.getAttribute("username");
        String password = (String) request.getAttribute("password");
        //If the username or password are blank, an error is displayed and we return to the login page
        try {
            if (!username.equals("") || password.equals("")) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message", "Invalid login. Make sure to fill both fields.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
            }
        }
        //If the username and password are filled
        catch (NullPointerException e) {
            AccountService newlogin = new AccountService();
            if (newlogin.login(username, password) != null){ //If user/password matches one of the stored pairs
                HttpSession session = request.getSession();
                session.setAttribute("username", username); //Set username as a session thing
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                    .forward(request, response);
            }
            else { //If the user/pass pair doesn't match, return to the login page with an error message and the current info
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message", "Invalid login. Make sure to fill both fields.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        }
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
