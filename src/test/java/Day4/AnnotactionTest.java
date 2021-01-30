package Day4;

import org.testng.annotations.*;

public class AnnotactionTest { //suite testów

    @BeforeClass
    public void beforeAll() {
        System.out.println("To sie wykonuje przed wszystkimi testami");
    }

    @AfterClass
    public void afterAll() {
        System.out.println("To sie wykonuje po wszystkich testach");
    }

    @BeforeMethod
    public void setup() {
        System.out.println("to sie wykonuje przed kazdym testem");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("To sie wykonuje po kazdym tescie");
    }

    @Test
    public void test1() {
        System.out.println("To jest pierwszy test");
    }

    @Test
    public void test2() {
        System.out.println("To jest pierwszy test");
    }

    @Test
    public void test3() {
        System.out.println("To jest pierwszy test");
    }
}
