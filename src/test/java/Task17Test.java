import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Task17Test {

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
        Task17.execute(new String[]{"task5", "print"});
        Assert.assertEquals("""
                [TASK17] HashMap Books:\r
                [TASK17] {131} Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK17] {967} Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                [TASK17] {152} Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK17] {552} Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK17] {523} Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                """, outContent.toString());
    }


    @Test
    public void sortByName() {
        Task17.execute(new String[]{"task5", "print", "sort", "name"});
        Assert.assertEquals("""
                [TASK17] HashMap Books:\r
                [TASK17] {131} Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK17] {967} Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                [TASK17] {152} Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK17] {552} Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK17] {523} Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                [TASK17] Books after sort:\r
                [TASK17] ArrayList Books:\r
                [TASK17] Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                [TASK17] Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK17] Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK17] Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK17] Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                """, outContent.toString());
    }

    @Test
    public void sortByPublicationYear() {
        Task17.execute(new String[]{"task5", "print", "sort", "publicationYear"});
        Assert.assertEquals("""
                [TASK17] HashMap Books:\r
                [TASK17] {131} Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK17] {967} Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                [TASK17] {152} Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK17] {552} Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK17] {523} Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                [TASK17] Books after sort:\r
                [TASK17] ArrayList Books:\r
                [TASK17] Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                [TASK17] Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK17] Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                [TASK17] Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK17] Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                """, outContent.toString());
    }

    @Test
    public void sortByPrice() {
        Task17.execute(new String[]{"task5", "print", "sort", "price"});
        Assert.assertEquals("""
                [TASK17] HashMap Books:\r
                [TASK17] {131} Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK17] {967} Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                [TASK17] {152} Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK17] {552} Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK17] {523} Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                [TASK17] Books after sort:\r
                [TASK17] ArrayList Books:\r
                [TASK17] Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK17] Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK17] Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                [TASK17] Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK17] Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                """, outContent.toString());
    }

    @Test
    public void checkIfBookWithNameBook3Exist() {
        Task17.execute(new String[]{"task5", "print", "unique", "Book", "3", "stop"});
        Assert.assertEquals("""
                [TASK17] HashMap Books:\r
                [TASK17] {131} Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK17] {967} Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                [TASK17] {152} Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK17] {552} Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK17] {523} Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                [TASK17] Book with name 'Book 3' already exists!\r
                """, outContent.toString());
    }

    @Test
    public void checkIfBookWithNameBook6NotExist() {
        Task17.execute(new String[]{"task5", "print", "unique", "Book", "6", "stop"});
        Assert.assertEquals("""
                [TASK17] HashMap Books:\r
                [TASK17] {131} Book{name='Book 3', authorFullName='Dou Mariana', publication='Prachov', publicationYear=2003, price=50.0}\r
                [TASK17] {967} Book{name='Book 5', authorFullName='Gaia Aeronwy', publication='Prachov', publicationYear=2005, price=200.0}\r
                [TASK17] {152} Book{name='Book 2', authorFullName='Kirov Hakan', publication='Prachov', publicationYear=2005, price=130.0}\r
                [TASK17] {552} Book{name='Book 4', authorFullName='Layman Harry', publication='Prachov', publicationYear=2009, price=22.0}\r
                [TASK17] {523} Book{name='Book 1', authorFullName='Joel Zahi', publication='Prachov', publicationYear=2001, price=100.0}\r
                [TASK17] Book with name 'Book 6' not exists!\r
                """, outContent.toString());
    }
}