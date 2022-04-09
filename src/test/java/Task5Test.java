import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Task5Test {
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
        Task5.execute(new String[]{"task5", "print"});
        Assert.assertEquals("""
                [TASK5] HashMap Books:\r
                [TASK5] {131} Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK5] {967} Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                [TASK5] {152} Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK5] {552} Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK5] {523} Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                """, outContent.toString());
    }

    @Test
    public void delete967and152Book() {
        Task5.execute(new String[]{"task5", "print", "delete", "967", "delete", "152", "print"});
        Assert.assertEquals("""
                [TASK5] HashMap Books:\r
                [TASK5] {131} Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK5] {967} Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                [TASK5] {152} Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK5] {552} Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK5] {523} Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                [TASK5] HashMap Books:\r
                [TASK5] {131} Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK5] {552} Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK5] {523} Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                """, outContent.toString());
    }

    @Test
    public void sortByName() {
        Task5.execute(new String[]{"task5", "print", "sort", "name"});
        Assert.assertEquals("""
                [TASK5] HashMap Books:\r
                [TASK5] {131} Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK5] {967} Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                [TASK5] {152} Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK5] {552} Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK5] {523} Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                [TASK5] Books after sort:\r
                [TASK5] ArrayList Books:\r
                [TASK5] Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                [TASK5] Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK5] Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK5] Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK5] Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                """, outContent.toString());
    }

    @Test
    public void sortByPublicationYear() {
        Task5.execute(new String[]{"task5", "print", "sort", "publicationYear"});
        Assert.assertEquals("""
                [TASK5] HashMap Books:\r
                [TASK5] {131} Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK5] {967} Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                [TASK5] {152} Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK5] {552} Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK5] {523} Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                [TASK5] Books after sort:\r
                [TASK5] ArrayList Books:\r
                [TASK5] Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                [TASK5] Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK5] Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                [TASK5] Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK5] Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                """, outContent.toString());
    }

    @Test
    public void sortByPrice() {
        Task5.execute(new String[]{"task5", "print", "sort", "price"});
        Assert.assertEquals("""
                [TASK5] HashMap Books:\r
                [TASK5] {131} Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK5] {967} Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                [TASK5] {152} Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK5] {552} Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK5] {523} Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                [TASK5] Books after sort:\r
                [TASK5] ArrayList Books:\r
                [TASK5] Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK5] Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK5] Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                [TASK5] Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK5] Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                """, outContent.toString());
    }
}