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
           for(int i = 0; i < delArray.length; i++){
               if(delArray[i].startsWith("-")){
                   ArrayList<String> negatives = new ArrayList<String>();
                   for(int j = 0; j < delArray.length; j++){
                       if(delArray[i].startsWith("-")){
                           negatives.add(delArray[i]);
                       }
                   }
                   String temp = negatives.toString();
                   String neg = temp.substring(1, temp.length()-1).replaceAll("\\s","");
                   throw new IllegalArgumentException("Negatives not allowed: " + neg);
               }
           } 
           return findSum(delArray);
        }
        if(numbers.contains(",") || numbers.contains("\n")){
           String[] array = numbers.split("(,)|(\n)");
           for(int i = 0; i < array.length; i++){
               if(array[i].startsWith("-")){
                   ArrayList<String> negatives = new ArrayList<String>();
                   for(int j = 0; j < array.length; j++){
                       if(array[i].startsWith("-")){
                           negatives.add(array[i]);
                       }
                   }
                   String temp = negatives.toString();
                   String neg = temp.substring(1, temp.length()-1).replaceAll("\\s","");
                   throw new IllegalArgumentException("Negatives not allowed: " + neg);
               }
           }
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
}
