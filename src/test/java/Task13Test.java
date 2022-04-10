import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Task13Test {
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
    public void printHashMapAbonents() {
        Task13.execute(new String[]{"task13", "print"});
        Assert.assertEquals("""
                [TASK13] HashMap Abonents:\r
                [TASK13] {555} Abonent{name='Igor', surname='Cayman', lastName='Pavlovich', address='Spartanburg 2'}\r
                [TASK13] {444} Abonent{name='Stepan', surname='Baia', lastName='Vitaliyovich', address='Fairhope 55'}\r
                [TASK13] {333} Abonent{name='Pavlo', surname='Akirov', lastName='Igorevich', address='Nampa 19'}\r
                [TASK13] {222} Abonent{name='Vitaliy', surname='Dou', lastName='Nikolayovich', address='New Kensington 15'}\r
                [TASK13] {111} Abonent{name='Nikolay', surname='Zahi', lastName='Stepanovich', address='Union Avenue 33'}\r
                """, outContent.toString());
    }

    @Test
    public void sortBySurname() {
        Task13.execute(new String[]{"task13", "print", "sort"});
        Assert.assertEquals("""
                [TASK13] HashMap Abonents:\r
                [TASK13] {555} Abonent{name='Igor', surname='Cayman', lastName='Pavlovich', address='Spartanburg 2'}\r
                [TASK13] {444} Abonent{name='Stepan', surname='Baia', lastName='Vitaliyovich', address='Fairhope 55'}\r
                [TASK13] {333} Abonent{name='Pavlo', surname='Akirov', lastName='Igorevich', address='Nampa 19'}\r
                [TASK13] {222} Abonent{name='Vitaliy', surname='Dou', lastName='Nikolayovich', address='New Kensington 15'}\r
                [TASK13] {111} Abonent{name='Nikolay', surname='Zahi', lastName='Stepanovich', address='Union Avenue 33'}\r
                [TASK13] Abonents after sort:\r
                [TASK13] ArrayList Abonents:\r
                [TASK13] Abonent{name='Pavlo', surname='Akirov', lastName='Igorevich', address='Nampa 19'}\r
                [TASK13] Abonent{name='Stepan', surname='Baia', lastName='Vitaliyovich', address='Fairhope 55'}\r
                [TASK13] Abonent{name='Igor', surname='Cayman', lastName='Pavlovich', address='Spartanburg 2'}\r
                [TASK13] Abonent{name='Vitaliy', surname='Dou', lastName='Nikolayovich', address='New Kensington 15'}\r
                [TASK13] Abonent{name='Nikolay', surname='Zahi', lastName='Stepanovich', address='Union Avenue 33'}\r
                """, outContent.toString());
    }

    @Test
    public void findByAnyField() {
        Task13.execute(new String[]{"task13", "print", "find", "Vitaliy"});
        Assert.assertEquals("""
                [TASK13] HashMap Abonents:\r
                [TASK13] {555} Abonent{name='Igor', surname='Cayman', lastName='Pavlovich', address='Spartanburg 2'}\r
                [TASK13] {444} Abonent{name='Stepan', surname='Baia', lastName='Vitaliyovich', address='Fairhope 55'}\r
                [TASK13] {333} Abonent{name='Pavlo', surname='Akirov', lastName='Igorevich', address='Nampa 19'}\r
                [TASK13] {222} Abonent{name='Vitaliy', surname='Dou', lastName='Nikolayovich', address='New Kensington 15'}\r
                [TASK13] {111} Abonent{name='Nikolay', surname='Zahi', lastName='Stepanovich', address='Union Avenue 33'}\r
                [TASK13] Founded abonent: Abonent{name='Vitaliy', surname='Dou', lastName='Nikolayovich', address='New Kensington 15'}\r                                                                                                                      
                """, outContent.toString());
    }

    @Test
    public void findAndChange() {
        Task13.execute(new String[]{
                "task13",
                "print",
                "find", "Vitaliy",
                "change", "Vitaliy", "Prachov", "Serhiyovich", "Academic", "Yanhelya", "5",
                "stop",
                "print"});
        Assert.assertEquals("""
                [TASK13] HashMap Abonents:\r
                [TASK13] {555} Abonent{name='Igor', surname='Cayman', lastName='Pavlovich', address='Spartanburg 2'}\r
                [TASK13] {444} Abonent{name='Stepan', surname='Baia', lastName='Vitaliyovich', address='Fairhope 55'}\r
                [TASK13] {333} Abonent{name='Pavlo', surname='Akirov', lastName='Igorevich', address='Nampa 19'}\r
                [TASK13] {222} Abonent{name='Vitaliy', surname='Dou', lastName='Nikolayovich', address='New Kensington 15'}\r
                [TASK13] {111} Abonent{name='Nikolay', surname='Zahi', lastName='Stepanovich', address='Union Avenue 33'}\r
                [TASK13] Founded abonent: Abonent{name='Vitaliy', surname='Dou', lastName='Nikolayovich', address='New Kensington 15'}\r
                [TASK13] Abonent changed!\r
                [TASK13] HashMap Abonents:\r
                [TASK13] {555} Abonent{name='Igor', surname='Cayman', lastName='Pavlovich', address='Spartanburg 2'}\r
                [TASK13] {444} Abonent{name='Stepan', surname='Baia', lastName='Vitaliyovich', address='Fairhope 55'}\r
                [TASK13] {333} Abonent{name='Pavlo', surname='Akirov', lastName='Igorevich', address='Nampa 19'}\r
                [TASK13] {222} Abonent{name='Vitaliy', surname='Prachov', lastName='Serhiyovich', address='Academic Yanhelya 5'}\r
                [TASK13] {111} Abonent{name='Nikolay', surname='Zahi', lastName='Stepanovich', address='Union Avenue 33'}\r
                """, outContent.toString());
    }


}