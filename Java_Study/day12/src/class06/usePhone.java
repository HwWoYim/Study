package class06;

public interface usePhone {
	// Phone클래스와 연동하려는 모든 클래스들은
	// 해당 인터페이스를 구현해야만 한다.
	// => "강제"
	// 인터페이스는 추상메소드와 상수(final)로만 구성되어있따
	
	// extends를 통한 다중상속xxxx
	// -> implements를 통해서 보완!
	
	public abstract void sounUp();	// public과 abstract이 숨어있다.
	void soundDown();
	void power();
	
	public static final int maxSound = 100;
	int minSound = 0;
}
