package is.ru.stringcalculator;

import java.util.Arrays;
import java.util.ArrayList;

public class Calculator {

    public static int add(String numbers){
        if(numbers.isEmpty()){
           return 0;        
        }
        if(numbers.contains("//")){
           int cutoff = findCutoff(numbers);
           String delimeter = numbers.substring(2,cutoff);
           String delString = numbers.substring(cutoff+1); 
           String[] delArray = delString.split(delimeter);
           checkForNegatives(delArray); 
           return findSum(delArray);
        }
        if(numbers.contains(",") || numbers.contains("\n")){
           String[] array = numbers.split("(,)|(\n)");
           checkForNegatives(array);
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
  
    private static int findCutoff(String numbers){
       int i = 0;
       while(true){
          Character ch = numbers.charAt(i);
          if(ch == '\n'){
             break;
          }
          i++;
       }
       return i;
    }  
  
    private static void negativesNotAllowed(String[] array){
       ArrayList<String> negatives = new ArrayList<String>();
       for(int i = 0; i < array.length; i++){
           if(array[i].startsWith("-")){
               negatives.add(array[i]);
           }
       }
       String temp = negatives.toString();
       String neg = temp.substring(1, temp.length()-1).replaceAll("\\s","");
       throw new IllegalArgumentException("Negatives not allowed: " + neg);
    }

    private static void checkForNegatives(String[] array){
       for(int i = 0; i < array.length; i++){
           if(array[i].startsWith("-")){
               negativesNotAllowed(array);
           }
       }
    }
}
