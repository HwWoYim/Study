package class01;

class A{
	int x;
	int y;
	void show() {
		System.out.println(this.x+" / "+this.y);
	}
	A(){
		this(1,2);
		System.out.println("111");
	}
	A(int x){
		this(x,3);
		System.out.println("222");
	}
	A(int x,int y){
		this.x=x;
		this.y=y;
		System.out.println("333");
	}
}

public class Test02 {

	public static void main(String[] args) {

		A a1=new A(13);
		A a2=new A();

		a1.show();
		a2.show();


	}

}
