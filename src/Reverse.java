public class Reverse {
    static volatile int count = 0;
    private static final Object lock = new Object();
    public static void main(String[] args) {
         Thread t1 = new Thread(new Runnable() {
             @Override
             public void run() {
                 while (count <= 100) {
                     synchronized (lock) {
                         if(count % 3 == 1 || count % 3 == 2) {
                             try {
                                 lock.wait();
                             } catch (InterruptedException e) {
                                 throw new RuntimeException(e);
                             }
                         } else {
                             count += 1;
                             System.out.println(count);
                             lock.notifyAll();
                         }
                     }
                 }
             }
         });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    synchronized (lock) {
                        if (count % 3 == 0 || count % 3 == 2) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }else {
                            count += 1;
                            System.out.println(count);
                            lock.notifyAll();
                        }
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    synchronized (lock) {
                        if(count % 3 == 0 || count % 3 == 1) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }else {
                            count += 1;
                            System.out.println(count);
                            lock.notifyAll();
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
