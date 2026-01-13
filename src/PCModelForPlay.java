import com.sun.source.tree.SynchronizedTree;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class PCModelForPlay {
    public static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
    public static int count = 0;
    public static Object lock = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                while (count <= 100) {
                    Random random = new Random();
                    int sleepTime = 20;
                    sleepTime += random.nextInt(80);
                    try {
                        Thread.sleep(sleepTime);
                        queue.put(count++);
                        System.out.println("线程A生产数字: " + count);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if(queue.peek() != null && queue.peek() % 2 == 0 && queue.peek() % 3 != 0) {
                            System.out.println("线程B消费数字: " + queue.poll());
                        }
                    }
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (lock){
                        if(queue.peek() != null && queue.peek() % 3 == 0) {
                            System.out.println("线程C消费数字: " + queue.poll());
                        }
                    }
                }
            }
        });
        Thread threadD = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (lock){
                        if(queue.peek() != null && queue.peek() % 2 != 0 && queue.peek() % 3 != 0) {
                            System.out.println("线程D消费数字: " + queue.poll());
                        }
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
