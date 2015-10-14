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
 
    @Test
    public void testAnotherDelimeter2(){
        assertEquals(10, Calculator.add("//;\n5;5"));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testNegativeValue(){
        assertEquals(-9, Calculator.add("-12,3"));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNegativeValue2(){
        assertEquals(-1, Calculator.add("//;\n5;-6"));
    }

    @Test
    public void testNumberBiggerThanThousand(){
        assertEquals(5, Calculator.add("1200,2,3"));
    }

    @Test
    public void testNumberBiggerThanThousand2(){
        assertEquals(0, Calculator.add("1001"));
    }

    @Test
    public void testNumberBiggerThanThousand3(){ 
        assertEquals(1000, Calculator.add("1000"));
    }

    @Test
    public void testDelimeterOfAnyLength(){
        assertEquals(50, Calculator.add("//[;:ab]\n40;:ab5;:ab5"));
    }

    @Test
    public void testDelimeterOfAnyLength2(){
        assertEquals(10, Calculator.add("//[:::]\n5:::5"));
    }

    @Test
    public void testMultipleDelimeters(){
        assertEquals(13, Calculator.add("//[;][:]\n4;4:5"));
    }

}
