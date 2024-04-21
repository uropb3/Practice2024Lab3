import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.RingBuffer;
import com.example.RingBufferImpl;

public class RingBufferImplTest {
    @Test
    void peek() {
        RingBuffer<Integer> buffer = new RingBufferImpl<>(3);
        buffer.add(1);
        assertEquals(1, buffer.peek());
    }

    @Test
    void peekEmpty() {
        RingBuffer<Integer> buffer = new RingBufferImpl<>(3);
        assertNull(buffer.peek());
    }

    @Test
    void addToFull() {
        RingBuffer<Integer> buffer = new RingBufferImpl<>(1);
        buffer.add(1);
        buffer.add(2);
        assertEquals(2, buffer.peek());
    }
}