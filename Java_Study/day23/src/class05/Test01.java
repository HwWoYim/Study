package class05;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test01 {

	public static void main(String[] args) {
		
		// Jsoup
		// 타겟 URL와 연결 -> conn
		final String url="https://comic.naver.com/index";
		Document doc=null;
		try {
			doc=Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/////System.out.println(doc);
		// Jsoup으로 HTML 전체문서를 받아옴
		
		Elements eles=doc.select("ul > li > div > h6 > a > span");
		/////System.out.println(eles);

		DAO dao=new DAO();
		
		Iterator<Element> itr=eles.iterator();
		while(itr.hasNext()) {
			/////System.out.println(itr.next());
			String str=itr.next().text();
			System.out.println(str);
			VO vo=new VO();
			vo.setTitle(str);
			dao.insert(vo);
		}
		System.out.println("로그: DB에 저장완료!");
		
		for(VO v:dao.selectAll(null)) {
			System.out.println(v);
		}
		
	}

}
