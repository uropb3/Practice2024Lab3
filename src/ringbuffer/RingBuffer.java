package ringbuffer;

public interface RingBuffer<E> extends Iterable<E> {    
    E poll();
    E peek();
    void add(E data);    
    int getSize();
}