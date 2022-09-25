package test;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

// 핸들러 클래스를 만들고 싶다.
// "핸들러" 클래스가 어딘가에 존재한다.
// 그러면 상속 받아야한다. 상속받기 위해서는 SimpleTagSupport키워드를 사용하여 핸들러 클래스로 전환 할 수 있다.
public class MsgTagHandler extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
//		// TODO Auto-generated method stub
//		super.doTag();
		JspWriter out=getJspContext().getOut();
		out.println("핸들러 클래스 기반으로 출력하는 메세지! :D");
	}
	// 시작태그를 만나면 자동으로 호출되어 수행되는 메소드이다.
	
}
