package geniecrawling;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import geniemodel.GenieDAO;
import geniemodel.GenieVO;


public class GenieCrawling {

	public static void main(String[] args) {

		final String url = "https://www.genie.co.kr/chart/top200"; // 크롤링할 페이지의 url주소
		Document doc = null;
		try {
			doc=Jsoup.connect(url).get(); // 파싱 : jsoup는 java로 사용할 수 있는 HTML Parser기능을 가진 java 라이브러리. Jsoup에 url을 연결시켜준다.
			// get으로 document를 불러오자
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title="a.title"; // 가져올 데이터의 영역
		String singer = "a.artist";
		String album = "a.albumtitle";
		Elements all = doc.select("div.music-list-wrap");
		Elements titlE = all.select(title); // select를 이용하여 원하는 태그를 선택하고 원하는 값을 가져온다
		Elements singeR = all.select(singer);
		Elements albuM = all.select(album);

//		Iterator<Element> title = element.select("a.title.ellipsis").iterator();
//		Iterator<Element> singer = element.select("a.artist.ellipsis").iterator();
//		Iterator<Element> album = element.select("a.albumtitle.ellipsis").iterator();
//		int rank = 0;
//
//		while(rank < 50) {
//
//			rank++;
//
//			System.out.println(rank + "위 " + singer.next().text() + " - " + title.next().text() + " : " + album.next().text());
//
//		}
		GenieDAO dao = new GenieDAO();
		Iterator<Element> titLE = titlE.iterator(); // Iterator : 리스트의 데이터를 받아 순차적으로 데이터를 출력한다.
		Iterator<Element> singER = singeR.iterator(); // Element타입의 데이터를 받아 순차적으로 출력할 것을 변수에 저장한다.
		Iterator<Element> albUM = albuM.iterator();
		while(albUM.hasNext())
		{ // 가장 적은 양의 데이터를 가진 Iterator로 hasNext() 반복문
			String str=titLE.next().text();
//			System.out.println(str);
			String str2=singER.next().text();
//			System.out.println(str2);
			String str3 = albUM.next().text();
			System.out.println("제목 : " + str + "\t가수 : " + str2 + "\t앨범 : " + str3);
			GenieVO vo = new GenieVO();
			vo.setName(str); // 저장하면 DAO에서 insert함수로 DB에 저장
			vo.setArtist(str2);
			vo.setAlbum(str3);
			dao.insert(vo);
		}
		System.out.println("로그 : DB에 저장완료!");
		dao.selectAll(null);

	}

}
