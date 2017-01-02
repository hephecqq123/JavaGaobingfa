package cn.dataguru;

public class SimpleWN2 {
	final static Object object = new Object();

	public static class T1 extends Thread {
		@Override
		public void run() {
			synchronized (object) {
				System.out.println(System.currentTimeMillis() + ": T1 start");
				try {
					System.out.println(System.currentTimeMillis() + ": T1 wait for object");
					object.wait();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis() + ": T1 end");
			}
		}
	}

	public static class T2 extends Thread {
		@Override
		public void run() {
			synchronized (object) {
				System.out.println(System.currentTimeMillis() + ":T2 start! notify all thread");
				object.notifyAll();
				System.out.println(System.currentTimeMillis() + ":T2 end!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new T1();
		Thread t1_1 = new T1();
		Thread t1_2 = new T1();
		Thread t2 = new T2();
		t1.start();
		t1_1.start();
		t1_2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();

	}

}
