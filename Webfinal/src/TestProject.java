import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProject
 */
/**
 * The input.txt absolute path in GoogleQuery Class varies from different computers. 
 */
@WebServlet("/TestProject")
public class TestProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		
		if(request.getParameter("keyword")== null) { // cat
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}

		GoogleQuery google = new GoogleQuery(request.getParameter("keyword")+"¥x¥_©@°ØÆU");
		HashMap<String, String> query = google.query();
		
		String[][] s = new String[query.size()][2];
		
		request.setAttribute("query", s);
		int num = 0;
		for(Entry<String, String> entry : query.entrySet()) { 
		    String key = entry.getKey();
		    String value = entry.getValue();
		    s[num][0] = key;//title
		    s[num][1] = value;//url
		    num++;
		}
		// convert the KeywordList to double arrayList
		KeywordList a = GoogleQuery.finalSort;
		for(int i=0;i<a.lst.size();i++) {
			 s[i][0] = a.lst.get(i).name;//title
			 s[i][1] = a.lst.get(i).url;//url
		}
		request.getRequestDispatcher("googleitem.jsp")
		 .forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}