import ringbuffer.RingBuffer;
import ringbuffer.RingBufferImpl;

public class App {
    /* Реализовать кольцевой буфер (или циклический буфер). Это структура данных, использующая 
    единственный буфер фиксированного размера, как будто бы после последнего элемента сразу же снова идет первый. 
    Реализация должна использовать односвязный список. */

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