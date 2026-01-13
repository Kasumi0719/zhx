import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedQueueForPlay {
    private final int size;

    private final Queue<Integer> queueForPlay;

    private final ReentrantLock lock;

    private final Condition notEmpty;

    private final Condition notFull;

    public BlockedQueueForPlay(int size) {
        this.size = size;
        queueForPlay = new LinkedList<>();
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    };

    public void add(int x) throws InterruptedException {
        lock.lock();
        try {
            while (queueForPlay.size() == size) notFull.await();
            queueForPlay.add(x);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int get() throws InterruptedException {
        lock.lock();
        try{
            while (queueForPlay.isEmpty()) notEmpty.await();
            int output = queueForPlay.poll();
            notFull.signal();
            return output;
        } finally {
            lock.unlock();
        }
    }
}
