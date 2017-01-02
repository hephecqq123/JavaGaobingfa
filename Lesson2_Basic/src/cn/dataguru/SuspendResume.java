package cn.dataguru;

public class SuspendResume {

	public static void main(String[] args) throws Exception {
		ChangeObjectThread t1 = new ChangeObjectThread("t1");
		ChangeObjectThread t2 = new ChangeObjectThread("t2");
		/*
		t1.start();
		Thread.sleep(1000);
		t2.start();
		t1.resume();
		t2.resume();
		t1.join();
		t2.join();
		*/
		t1.start();
		//Thread.sleep(4000);
		System.out.println(Thread.currentThread().getName()+" going to call t1.resume");
		t1.resume();
		System.out.println(Thread.currentThread().getName()+" t1.resume called");
		t1.join();
	}
	
}

class ChangeObjectThread extends Thread{
	public Object u = new Object();
	public ChangeObjectThread(String name){
		super.setName(name);
	}
	@Override
	public void run(){
		synchronized (u) {
			System.out.println("In thread "+getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			System.out.println(Thread.currentThread().getName()+" going to call suspend");
			Thread.currentThread().suspend();
			System.out.println(Thread.currentThread().getName()+" suspend called");
		}
		
	}
	
}