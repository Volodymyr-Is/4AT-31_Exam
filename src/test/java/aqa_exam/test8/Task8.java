package aqa_exam.test8;

import aqa_course.task2.Task2Classes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task8 {

    Task2Classes testMethods = new Task2Classes();

    @Test
    public void testAdd(){
        Assert.assertEquals(testMethods.add(6,3), 9);
    }

    @Test
    public void testSubtract(){
        Assert.assertEquals(testMethods.sub(6,3), 3);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(testMethods.mult(6, 3), 18);
    }

    @DataProvider(name = "addData")
    public Object[][] addData() {
        return new Object[][] {
                {2, 3, 5},
                {10, 5, 15},
                {-1, 1, 0}
        };
    }

    @Test(dataProvider = "addData")
    public void testAddWithData(int a, int b, int expected) {
        Assert.assertEquals(testMethods.add(a, b), expected);
    }

    @DataProvider(name = "subtractData")
    public Object[][] subtractData() {
        return new Object[][] {
                {5, 3, 2},
                {10, 10, 0},
                {-5, -5, 0}
        };
    }

    @Test(dataProvider = "subtractData")
    public void testSubtractWithData(int a, int b, int expected) {
        Assert.assertEquals(testMethods.sub(a, b), expected);
    }

    @DataProvider(name = "multData")
    public Object[][] multData() {
        return new Object[][] {
                {2, 3, 6},
                {0, 10, 0},
                {-2, 3, -6}
        };
    }

    @Test(dataProvider = "multData")
    public void testMultWithData(int a, int b, int expected) {
        Assert.assertEquals(testMethods.mult(a, b), expected);
    }

    @DataProvider(name = "divData")
    public Object[][] divData() {
        return new Object[][] {
                {4, 2, 2},
                {10, 10, 1},
                {-2, 1, -2}
        };
    }

//    @Parameters({"a", "b"})
    @Test(dataProvider = "divData")
    public void testDivWithParams(int a, int b, int expected) {
        Assert.assertEquals(testMethods.div(a, b), expected);
    }
}
