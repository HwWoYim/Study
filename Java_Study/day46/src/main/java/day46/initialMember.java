package day46;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class initialMember
 *
 */
@WebListener
public class initialMember implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public initialMember() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	// 톰캣의 종료를 감지(모니터링)
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	// 톰캣(서버, 서블릿 컨테이너)의 시작을 감지
    	
    	ArrayList<Member> datas = new ArrayList<Member>();
    	for(int i = 0; i<=10; i++) {
    		Member data = new Member("홍길동" + i, "010-1234-5678" + i);
    		datas.add(data);
    	}
    	datas.add(new Member("임꺽정",null));
    	datas.add(new Member("아무무",null));
    	
    	
    	// context == application scope
    	ServletContext context = sce.getServletContext();
    	context.setAttribute("datas", datas); // 톰캣을 끄기 전까지 데이터가 유지될 예정
    	context.setAttribute("data", new Member());
    }
	
}
