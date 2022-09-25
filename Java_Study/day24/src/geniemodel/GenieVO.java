package geniemodel;

public class GenieVO {
	private int num; // pk값
	private String name; // 노래 제목
	private String artist; // 가수
	private String album; // 앨범이름
	


public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getArtist() {
	return artist;
}
public void setArtist(String artist) {
	this.artist = artist;
}
public String getAlbum() {
	return album;
}
public void setAlbum(String album) {
	this.album = album;
}
	@Override
	public String toString() {
		return "[번호: " + num + ", 노래:" + name + ", 가수: " + artist + ", 앨범: " + album + "]\n";
	}
}