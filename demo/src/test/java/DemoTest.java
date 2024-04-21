import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Demo;
import java.time.Duration;

public class DemoTest {
    @Test
    void timeoutNotExceeded() {
        var demo = new Demo();
        assertTimeout(Duration.ofSeconds(1), () -> demo.run());
    }
}