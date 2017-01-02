package cn.dataguru;

public class AccountingSyncBad implements Runnable {
	static AccountingSyncBad instance = new AccountingSyncBad();
	static int i = 0;
	
	@Override
	public void run(){
		for(int j=0;j<10000000;j++){
			increase();
		}
	}
	
	private static synchronized void increase() {
		i++;
		
	}

	public static void main(String[] args) throws Exception {
		Thread t1 = new Thread(new AccountingSyncBad());
		Thread t2 = new Thread(new AccountingSyncBad());
		t1.start();t2.start();
		t1.join(); t2.join();
		System.out.println(i);
	}
}
