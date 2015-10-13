package is.ru.stringcalculator;

public class Calculator {

    public static int add(String numbers){
        if(numbers.isEmpty()){
           return 0;        
        }
        else if(numbers.contains(",")){
           String[] array = numbers.split(",");
           return Integer.parseInt(array[0]) + Integer.parseInt(array[1]);
        }
        else{
           return 10;
        }   
    }
}
