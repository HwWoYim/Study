package geniecontroller;

import java.util.ArrayList;

import geniemodel.GenieDAO;
import geniemodel.GenieVO;
import genieview.GenieView;

public class GenieController {
	GenieDAO gDAO;
	GenieView gView;
	public GenieController() {
		gDAO = new GenieDAO();
		gView = new GenieView();
	}

	public void startApp() {
		while(true) {
			gView.startView();
			if(gView.num == 1) {	// 1~50위 차트 목록 보기
				GenieVO gVO = new GenieVO();
				gView.song2(gDAO.selectAll(gVO));


			} else if(gView.num == 2) {	// 노래추가
				GenieVO vo = new GenieVO();
				String name = gView.inputString();
				vo.setName(name);
				String artist = gView.inputString();
				vo.setArtist(artist);
				String album = gView.inputString();
				vo.setAlbum(album);
				gDAO.insert(vo);
				


			} else if(gView.num==3) { // 노래검색
				GenieVO vo = new GenieVO();
				int num = gView.song(gDAO.selectAll(vo)); // 노래 목록, 입력 받기
//				vo.setNum(num);
				vo.setNum(gDAO.selectAll(vo).get(num-1).getNum());
				vo = gDAO.selectOne(vo);
				if(vo==null) {
					continue;
				}
				String res = gView.musicList(vo);
				if(res.equals("Y")) {
					gDAO.selectOne(vo);
					System.out.println("둠칫둠칫~부킁부킁");
					continue;
				}
				System.out.println("음악감상실패");
				continue;
			} else if(gView.num==4) { // 노래변경
//				  gView.change();
	               
//	                boolean flag = gView.update(vo);
//	                if (flag) {
//	                    gView.success();
//	                }else {
//	                	gView.fail();
//	                }
				boolean flag = gDAO.update(gView.changeInfo());
				if(flag) {
					System.out.println();
				}
			} else if(gView.num==5) {
				GenieVO vo = new GenieVO();
				gView.song2(gDAO.selectAll(vo));//메뉴출력
				int num = gView.inputInt();
//				vo.setNum(gDAO.selectAll(new GenieVO()).get(num - 1).getNum());
				vo.setNum(num);
				gDAO.delete(vo);
			} else if(gView.num == 6) {
				System.out.println("삭제완료");
				System.out.println("종료합니다.");
				break;
			}

		}
	}
}
