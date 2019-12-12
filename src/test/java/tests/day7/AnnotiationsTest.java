package tests.day7;

import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotiationsTest<QAfterClass> {
    // runs automatically before every test
    @BeforeMethod
    public void setup() {
        //some code that will be running before every test, like: test1, test2, test3...
        //we can use method with @BeforeMethod annotation
        System.out.println("Before method!");
    }


    @Test
    public void test1() {
        System.out.println("Test 1!");
        Assert.assertTrue(5 == 5);
    }
    @Test
    public void test2() {
        System.out.println("Test 2!");
    }
    @Test
    public void test3() {
        System.out.println("Test 3!");
    }
    // runs automatically after every test
    @AfterMethod
    public void teardown(){
        System.out.println("After Method!");
    }

}
