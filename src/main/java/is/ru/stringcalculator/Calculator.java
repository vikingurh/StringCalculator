package is.ru.stringcalculator;

public class Calculator {

    public static int add(String numbers){
        if(numbers.isEmpty()){
           return 0;        
        }
        if(numbers.contains("//")){
           int i = 0;
           while(true){
              Character ch = numbers.charAt(i);
              if(ch == '\n'){
                 break;
              }
              i++;
           }
           String delimeter = numbers.substring(2,i);
           String delString = numbers.substring(i+1); 
           String[] delArray = delString.split(delimeter);
           return findSum(delArray);
        }
        if(numbers.contains(",") || numbers.contains("\n")){
           String[] array = numbers.split("(,)|(\n)");
           return findSum(array);
        } 
        return Integer.parseInt(numbers);   
    }

    private static int findSum(String[] array){
       int sum = 0;
       for(int i = 0; i < array.length; i++){
          sum = sum + Integer.parseInt(array[i]);
       }
       return sum;
    }
    
}
