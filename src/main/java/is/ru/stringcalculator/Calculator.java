package is.ru.stringcalculator;

public class Calculator {

    public static int add(String numbers){
        if(numbers.isEmpty()){
           return 0;        
        }
        else if(numbers.contains(",")){
           String[] array = numbers.split(",");
           int totalSum = 0;
           for(int i = 0; i < array.length; i++){
              totalSum = totalSum + Integer.parseInt(array[i]);
           }
           return totalSum;
        }
        else{
           return Integer.parseInt(numbers);
        }   
    }
}
