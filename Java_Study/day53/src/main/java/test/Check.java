package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Check
 */
@WebServlet("/check.do")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 요청으로 오니까 여기에 로직을 만들어도 됨.
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그:Servlet doPost :[" + request.getParameter("mid") + "]");
		
		TestDAO dao = new TestDAO();
		TestVO vo = new TestVO();
		vo.setMid(request.getParameter("mid"));
		int result = dao.check(vo);
		
		// 요청했던 곳으로 result 값을 보낸다.
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().write(result+"");
		// Spring은 String으로 데이터를 변환작업해주는데 지긍은 없다.
		// -> 직접 String으로 데이터를 변환해야한다.
	}

}
