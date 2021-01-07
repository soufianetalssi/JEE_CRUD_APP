package Tp5;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Service;

/**
 * Servlet implementation class ajouter
 */
@WebServlet("/client")
public class client extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public client() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Contact c = new Contact();
		Service S = new Service();
		
		
		try {
			
		
			SimpleDateFormat date = new SimpleDateFormat("dd/MM/YYYY");
			Date D = date.parse(request.getParameter("dn"));
			c.setCode(Integer.parseInt(request.getParameter("code")));
			c.setDn(D);
			c.setVille(request.getParameter("ville"));
			c.setNom(request.getParameter("nom"));
			c.setPrenom(request.getParameter("prenom"));
			S.ajouter(c);
			
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
