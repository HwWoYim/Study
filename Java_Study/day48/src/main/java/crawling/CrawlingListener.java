package crawling;

import java.io.IOException;
import java.util.Iterator;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;

/**
 * Application Lifecycle Listener implementation class CrawlingListener
 *
 */
@WebListener
public class CrawlingListener implements ServletContextListener {

	/**
	 * Default constructor. 
	 */
	public CrawlingListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce)  { 
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce)  { 


	}

}
