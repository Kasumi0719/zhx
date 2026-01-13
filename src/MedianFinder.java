import java.util.PriorityQueue;

class MedianFinder {
    int size = 0;

    PriorityQueue<Integer> queueAsc;

    PriorityQueue<Integer> queueDesc;

    public MedianFinder() {
        queueAsc = new PriorityQueue<>((Integer o1, Integer o2) -> {return o1 - o2;});
        queueDesc = new PriorityQueue<>((Integer o1, Integer o2) -> {return o2 - o1;});
    }

    public void addNum(int num) {
        if(size % 2 == 0){
            if(queueDesc.isEmpty() || queueDesc.peek() > num) queueDesc.add(num);
            else {
                queueAsc.add(num);
                queueDesc.add(queueAsc.poll());
            }
        }else{
            if(queueDesc.peek() < num) queueAsc.add(num);
            else {
                queueDesc.add(num);
                queueAsc.add(queueDesc.poll());
            }
        }
        size++;
        return ;
    }

    public double findMedian() {
        if (size % 2 == 0) {
            return (queueDesc.peek() + queueAsc.peek()) / 2.0;
        }else{
            return (double)queueDesc.peek();
        }
    }
}