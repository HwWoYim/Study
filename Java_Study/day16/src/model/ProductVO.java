package model;

public class ProductVO {
	private int num; // PK
	private String name;
	private int cnt; // 재고 데이터
	private int price;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductVO [num=" + num + ", name=" + name + ", cnt=" + cnt + ", price=" + price + "]";
	}
}
