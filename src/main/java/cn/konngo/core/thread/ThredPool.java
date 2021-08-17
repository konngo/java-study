package cn.konngo.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * java �̳߳�
 *
 */
public class ThredPool {

	public static void main(String[] args) {
		ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
		for (int i = 1; i <= 10; i++) {
            final int ii = i;
            try {
                Thread.sleep(ii * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cacheThreadPool.execute(()->System.out.println("�߳����ƣ�" + Thread.currentThread().getName() + "��ִ��" + ii));
        }
	}
}
