package cn.dataguru;
/**
 * �½��߳�
 * @author Gino
 *
 */
public class CreateThread {
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			@Override
			public void run(){
				System.out.println("Hello, I am t1");
			}
		};
		t1.start();
	}
}
