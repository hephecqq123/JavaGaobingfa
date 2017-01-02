package cn.dataguru;

public class AccountingSyncClass implements Runnable {
	static AccountingSyncClass instance = new AccountingSyncClass();
	static int i = 0;
	
	@Override
	public void run(){
		for(int j=0;j<10000000;j++){
			increase();
		}
	}
	
	private synchronized void increase() {
		i++;
		
	}

	public static void main(String[] args) throws Exception {
		Thread t1 = new Thread(new AccountingSyncClass());
		Thread t2 = new Thread(new AccountingSyncClass());
		t1.start();t2.start();
		t1.join(); t2.join();
		System.out.println(i);
	}
}
