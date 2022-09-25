package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do") // *.do 요청을 수행하면 해당 어노테이션에 의해 FC 로 오게됨!!
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() { 
    	// ★ FrontController fc = new FrontController(); -> XXXX
    	// 객체화를 하지 않았는데 메서드를 사용할 수 있었다.
    	// 서블릿 컨테이너(== 객체관리하는 것) == 웹 서버 == 톰캣이 서블릿을 객체화해주고 있었다.
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get이든 post든 actiondo를 수행
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get이든 post든 actiondo를 수행
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); 			// /day49/index.do 로 표현
		String cp = request.getContextPath();  			// /day49 로 표현
		String command = uri.substring(cp.length());  	// /index.do 로 표현
		System.out.println(command);
		
		ActionForward forward = null;
		if(command.equals("/main.do")) { // main
			try {
				forward = new MainAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/insertB.do")) { // insertB - 게시글 추가
			try {
				forward = new InsertBAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/insertR.do")) { // insertR - 댓글 추가
			try {
				forward = new InsertRAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/deleteB.do")) { // deleteB - 게시글 삭제
			try {
				forward = new DeleteBAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		else if(command.equals("/search.do")) {
//		try {
//			forward = new SearchAction().execute(request, response);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
		else if(command.equals("/deleteR.do")) { // deleteR - 댓글 삭제
			try {
				forward = new DeleteRAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/fav.do")) { // fav - 좋아요
			try {
				forward = new FavAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/insertM.do")) { // insert - 회원 가입
			try {
				forward = new InsertAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/login.do")) { // login - 로그인
				try {
					forward = new LoginAction().execute(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		else if(command.equals("/logout.do")) { // logout - 로그 아웃
			try {
				forward = new LogoutAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/deleteM.do")) {
			try {
				forward = new DeleteMAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*
		if(forward==null) {
			forward=new ActionForward();
			forward.setPath("error/error.jsp");
			forward.setRedirect(false);
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
		try {
			dispatcher.forward(request, response);
			// : 타겟페이지(인자)로 request,response 객체를 전달하는 메서드
			// : 제어권을 넘겨줌 -> 클라이언트가 응답을 확인할수있음
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		if(forward != null) { // 이동할 정보(경로와 방식)가 있는 경우
			if(forward.isRedirect()) { // true면 sendRedirect이동방식, false면 forward이동방식
				response.sendRedirect(forward.getPath());
			} else {
				// 클라이언트로부터 최초에 들어온 요청을 JSP/servlet 내에서 원하는 자원으로 요청을 보내거나
				// 특정 자원의 처리를 요청하고 처리결과를 얻어오는 기능
				System.out.println("forward.getPath() : " + forward.getPath());
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				// 타겟페이지(인자로) request, response 객체를 전달
				// 제어권을 넘겨줌 -> 클라이언트가 응답 확인 가능
			}
		}
		response.setContentType("text/html; charset=UTF-8"); // 인코딩
		PrintWriter out = response.getWriter();
		out.println("<script>alert('요청처리실패!');location.href='error.jsp';</script>");
//		out.println("<script>alert('요청처리실패!');history.go(-1);</script>");
//		forward.setPath("error.jsp");
//		forward.setRedirect(true);
	}
}
