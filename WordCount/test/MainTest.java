import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Admin on 09.06.2017.
 */
class MainTest {

    @Test
    void wordCount() {
     assertEquals(Main.wordCount(new String[]{"test/ku.txt","5"}).size(),5);

    }

}