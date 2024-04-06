import ringbuffer.RingBuffer;
import ringbuffer.RingBufferImpl;

public class App {
    public static void main(String[] args) throws Exception {
        RingBuffer<Integer> buffer = new RingBufferImpl<Integer>(2);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);

        for (var n : buffer) {
            System.out.println(n);
        }
    }
}