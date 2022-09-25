package test;

public class IPhone implements Phone{
	private AppleWatch watch;
	private int number;
	public IPhone() {
		System.out.println("������ ��ü�����Ϸ�");
	}
	public IPhone(AppleWatch watch) {
		System.out.println("������ ��ü�����Ϸ�22");
		this.watch=watch;
	}
	public IPhone(AppleWatch watch,int number) {
		System.out.println("������ ��ü�����Ϸ�333");
		this.watch=watch;
		this.number=number;
	}
	@Override
	public void powerOn() {
		System.out.println("������ ���� ON : "+this.number);
	}
	@Override
	public void powerOff() {
		System.out.println("������ ���� OFF");
	}
	@Override
	public void volumeUp() {
		watch.volumeUp();
	}
	@Override
	public void volumeDown() {
		watch.volumeDown();
	}
	
}
