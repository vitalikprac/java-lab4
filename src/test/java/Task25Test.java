import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Task25Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }


    @Test
    public void printHashMapBooks() {
        Task25.execute(new String[]{"task25", "print"});
        Assert.assertEquals("""
                [TASK25] HashMap Articles:\r
                [TASK25] {131} Article{name='Processor Pentium', price=50.0}\r
                [TASK25] {967} Article{name='Intel', price=200.0}\r
                [TASK25] {152} Article{name='Video Card', price=130.0}\r
                [TASK25] {552} Article{name='NVIDIA', price=500.0}\r
                [TASK25] {523} Article{name='PC1', price=100.0}\r
                """, outContent.toString());
    }

    @Test
    public void delete152and131Book() {
        Task25.execute(new String[]{"task25", "print", "delete", "152", "delete", "131", "print"});
        Assert.assertEquals("""
                [TASK25] HashMap Articles:\r
                [TASK25] {131} Article{name='Processor Pentium', price=50.0}\r
                [TASK25] {967} Article{name='Intel', price=200.0}\r
                [TASK25] {152} Article{name='Video Card', price=130.0}\r
                [TASK25] {552} Article{name='NVIDIA', price=500.0}\r
                [TASK25] {523} Article{name='PC1', price=100.0}\r
                [TASK25] HashMap Articles:\r
                [TASK25] {967} Article{name='Intel', price=200.0}\r
                [TASK25] {552} Article{name='NVIDIA', price=500.0}\r
                [TASK25] {523} Article{name='PC1', price=100.0}\r
                """, outContent.toString());
    }


}