package test;

public class Galaxy implements Phone {

	public void initMethod() {
		System.out.println("��ü�� �ʱ�ȭ�ϴ� �۾��� ó���ϴ� �޼���...");
	}
	public void destroyMethod() {
		System.out.println("��ü �޸𸮸� �����Ҷ� ȣ���ϴ� �޼���...");
	}
	
	@Override
	public void powerOn() {
		System.out.println("������ ���� ON");
	}
	@Override
	public void powerOff() {
		System.out.println("������ ���� OFF");
	}
	@Override
	public void volumeUp() {
		System.out.println("������ �Ҹ� ++");
	}
	@Override
	public void volumeDown() {
		System.out.println("������ �Ҹ� --");
	}
	
}
