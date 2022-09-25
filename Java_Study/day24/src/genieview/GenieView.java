package genieview;

import java.util.ArrayList;
import java.util.Scanner;

import geniemodel.GenieVO;

public class GenieView {
	Scanner sc = new Scanner(System.in);
	public int num;
	public String str;

	public void startView() {
		while (true) {
			System.out.println("============================ Genie Music ============================");
			System.out.println("[1]1~50위차트 [2]노래추가 [3]노래검색 [4]노래변경 [5]노래삭제 [6]종료");
			System.out.print("입력 : ");
			try {
				num = sc.nextInt();
				if (1 <= num && num <= 5) {
					break;
				}
				System.out.println("다시 입력해주세요!");
				System.out.println();
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("메뉴 항목 중에 선택하세요!");
				System.out.println();
			}
		}
	}

	public int inputInt() { // 정수입력
		while (true) {
			System.out.print("입력 : ");
			try {
				num = sc.nextInt();
				return num;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("다시 입력해주세요");
			}
		}
	}

	public String inputString() { // 문자입력
		while (true) {
			System.out.println("입력 : ");
			try {
				str = sc.next();
				return str;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("다시 입력해주세요");
			}
		}
	}

	public GenieVO changeInfo() {
		GenieVO vo = new GenieVO();
		String name = inputString();
		String artist = inputString();
		String album = inputString();
		System.out.println("변경할 노래 입력 : ");
		int num = inputInt();

		vo.setName(name);
		vo.setArtist(artist);
		vo.setAlbum(album);
		vo.setNum(num);
		return vo;
	}

	public String change(GenieVO vo) {
		System.out.println("노래 : " + vo.getName());
		System.out.println("가수 : " + vo.getArtist());
		System.out.println("앨범 : " + vo.getAlbum());
		System.out.println("변경하시겠습니까?\nY/N");
		String ans = sc.next();
		return ans;
	}

	public int song(ArrayList<GenieVO> datas) {
		System.out.println("음악목록");
		for (GenieVO g : datas) {
			System.out.println(g);
		}
		System.out.println("음악번호 입력 : ");
		int num = sc.nextInt();
		return num;
	}

	public void song2(ArrayList<GenieVO> datas) {
		System.out.println("음악목록");
		for (GenieVO g : datas) {
			System.out.println(g);
		}
	}

	public int search() {
		System.out.println("음악번호 입력 : ");
		int gid = sc.nextInt();
		return gid;
	}

	public String musicList(GenieVO vo) {
		System.out.println("노래 : " + vo.getName());
		System.out.println("가수 : " + vo.getArtist());
		System.out.println("앨범 : " + vo.getAlbum());
		System.out.println("노래를 들으시겠습니까?\nY/N : ");
		String ans = sc.next();
		return ans;
	}

}
