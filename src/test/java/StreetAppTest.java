import org.junit.Test;

import java.util.Arrays;


public class StreetAppTest {

    @Test
    public void testStreetAppHasProcess() throws Exception {
        new StreetApp(Arrays.asList(1, 2)).process();
    }

}
