package test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("*.jsp")
public class EncFilter extends HttpFilter implements Filter {
	
	private String encoding; // 맴버변수로 만들어버림
       
    public EncFilter() {
        super();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.encoding);//하드코딩 -> web.xml(환경설정파일)에 저장되어있던 초기화 매개변수로 교체
		System.out.println("doFilter() 동작완료.");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("필터 클래스 최초 초기화 완료");
		
		this.encoding=fConfig.getServletContext().getInitParameter("encoding");
	}

}
