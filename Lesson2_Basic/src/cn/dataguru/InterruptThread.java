package cn.dataguru;

/**
 * public void Thread.interrupt() // �ж��߳� public boolean Thread.isInterrupted()
 * // �ж��Ƿ��ж� public static boolean Thread.interrupted() * // �ж��Ƿ��жϣ��������ǰ�ж�״̬
 * 
 * @author Gino
 *
 */
public class InterruptThread {

	public static void main(String[] args) {
		/*
		 * Thread t1 = new Thread(){
		 * 
		 * @Override public void run(){ while(true){
		 * if(Thread.currentThread().isInterrupted()){
		 * System.out.println("Thread interrupted"); break; } Thread.yield(); }
		 * } }; t1.start(); t1.interrupt();
		 */
		Thread t2 = new Thread() {
			public void run() {
				while (true) {
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Interruted!");
						break;
					}
					try {
						Thread.sleep(2000);
						throw new InterruptedException("Interrupt");
					} catch (InterruptedException e) {
						System.out.println("Interruted When Sleep");
						// �����ж�״̬���׳��쳣�������жϱ��λ
						Thread.currentThread().interrupt();
					}
					Thread.yield();
				}
			}
		};
		t2.start();
	}

}
