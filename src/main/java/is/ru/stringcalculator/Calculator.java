package is.ru.stringcalculator;

public class Calculator {

    public static int add(String numbers){
        if(numbers.isEmpty()){
           return 0;        
        }
        else if(numbers.contains("//")){
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
           int sum = 0;
           for(int j = 0; j < delArray.length; j++){
              sum = sum + Integer.parseInt(delArray[j]);
           }
           return sum;
        }
        else if(numbers.contains(",") || numbers.contains("\n")){
           String[] array = numbers.split("(,)|(\n)");
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
