package project;

public class VO {
	private int gid; // pk값
	private String title; // 노래 제목
	private String singer; // 가수
	private String album; // 앨범이름
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	@Override
	public String toString() {
		return "VO [gid=" + gid + ", title=" + title + ", singer=" + singer + ", album=" + album + "]";
	}
	
}
