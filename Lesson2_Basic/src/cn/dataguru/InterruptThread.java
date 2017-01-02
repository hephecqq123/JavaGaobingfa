package cn.dataguru;

/**
 * public void Thread.interrupt() // 中断线程 public boolean Thread.isInterrupted()
 * // 判断是否被中断 public static boolean Thread.interrupted() * // 判断是否被中断，并清除当前中断状态
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
						// 设置中断状态，抛出异常后会清除中断标记位
						Thread.currentThread().interrupt();
					}
					Thread.yield();
				}
			}
		};
		t2.start();
	}

}
