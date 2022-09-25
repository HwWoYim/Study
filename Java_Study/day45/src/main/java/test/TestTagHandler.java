package test;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestTagHandler extends SimpleTagSupport {

	// 태그 속성을 저장할 멤버변수
	private String border;
	private String bgcolor;

	public String getBorder() {
		return border;
	}

	public void setBorder(String border) {
		this.border = border;
	}

	public String getBgcolor() {
		return bgcolor;
	}

	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out=getJspContext().getOut();

		// 태그 바디의 내용을 받아오는 코드
		//    <jsp:doBody />
		JspFragment body=getJspBody();
		if(body!=null) {
			out.println("<h1>");
			body.invoke(null);
			out.println("</h1>");
		}

		out.println("<table border="+border+" bgcolor="+bgcolor+">");
		for(String v:new Test().getDatas()) {
			out.println("<tr><td>"+v+"</td></tr>");
		}
		out.println("</table>");














	}

}
