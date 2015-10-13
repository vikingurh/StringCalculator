package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }
    
    @Test
    public void testEmptyString(){
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void testOneNumber(){
        assertEquals(10, Calculator.add("10"));
    }
    
    @Test
    public void testOneNumber2(){
        assertEquals(3, Calculator.add("3"));
    }
    
    @Test
    public void testTwoNumbers(){
        assertEquals(11, Calculator.add("10,1"));
    }

    @Test
    public void testTwoNumbers2(){
        assertEquals(34, Calculator.add("29,5"));
    }
 
    @Test
    public void testManyNumbers(){
        assertEquals(100, Calculator.add("33,33,33,1"));
    }
 
    @Test
    public void testManyNumbers2(){
        assertEquals(3, Calculator.add("1,1,1"));
    }
 
    @Test
    public void testNewLineBetweenNumbers(){
        assertEquals(67, Calculator.add("7\n30,20\n10"));
    }

    @Test
    public void testNewLineBetweenNumbers2(){
        assertEquals(10, Calculator.add("1\n2\n3\n4"));
    }

    @Test
    public void testAnotherDelimeter(){
        assertEquals(5, Calculator.add("//:\n2:3"));
    }
}
