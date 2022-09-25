package class05;

public class VO {
	private int wid;
	private String title;
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "VO [wid=" + wid + ", title=" + title + "]";
	}
}
