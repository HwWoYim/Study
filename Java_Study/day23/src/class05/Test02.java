package class05;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test02 {
	public static void main(String[] args) {
		
		final String url="https://comic.naver.com/index";
		Document doc=null;
		try {
			doc=Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/////System.out.println(doc);
		
		String idStr="ul#genreRecommand";
		String classStr="div.genreRecomInfo2";
		Elements eles=doc.select(classStr);
		/////System.out.println(eles);
		
		Iterator<Element> itr=eles.iterator();
		while(itr.hasNext()) {
			String str=itr.next().text();
			System.out.println(str);
			System.out.println();
		}
		
	}
}
