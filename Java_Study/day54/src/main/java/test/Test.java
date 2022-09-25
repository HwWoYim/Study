package test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/test.do")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	// NewFile.jsp에서 post방식으로 요청하기 때문
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String path="C:\\0607_YIM\\workspace\\day54\\src\\main\\webapp\\images";// 사용자가 업로드 시도한 파일을 어디에 저장할지
		int maxSize=100000; // 바이트 단위
		MultipartRequest mr=new MultipartRequest(request,path,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		
		
		// 속성 선언에서 multipartRequest가 request를 대신하게 되어 request로는 데이터를 볼 수가 없다.
//		String mid=request.getParameter("mid");
//		String fileName=request.getParameter("fileName");
//		System.out.println("로그1 ["+mid+"]");
//		System.out.println("로그2 ["+fileName+"]");

		// 주체가 request에서 mr로 바뀌었다.
		String mid = mr.getParameter("mid");
		System.out.println("로그1 ["+mid+"]");
		
		
		Enumeration<?> file = mr.getFileNames(); //Enumeration -> 컬렉션의 일종
		// 다중업로드를 하지 않을거기 때문에 반복문을 사용하지 않는다.
		if(file.hasMoreElements()) { // 파일이 업로드가 되었다면?
			String paramName = (String)file.nextElement();
			System.out.println("파라미터명 ["+paramName+"]");
			
			String serverFileName = mr.getFilesystemName(paramName);
			System.out.println("서버에 업로드된 파일명 ["+serverFileName+"]");
			request.getSession().setAttribute("img", serverFileName);
			
			String clientFileName = mr.getOriginalFileName(paramName);
			System.out.println("사용자 업로드된 파일명 ["+clientFileName+"]");
			
			String fileType = mr.getContentType(paramName);
			System.out.println("파일의 타입 ["+fileType+"]");
			
			long length = mr.getFile(paramName).length();
			System.out.println("파일의 크기 ["+length+"]");
		}
		
		response.sendRedirect("NewFile.jsp"); // 수행작업을 마치고 NewFile로 간다.
	}

}
