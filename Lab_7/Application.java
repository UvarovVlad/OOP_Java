package com.tasks7.rpn; 
 
import java.util.Deque;
import java.util.LinkedList; 
 
public class Application { 
 
 	public static double parse(String rpnString) { 
        String input = rpnString; 
 	 	String[] str = input.split(" "); 
 	    LinkedList<String> arr = new LinkedList<String>(); 
        for (String str1: str) {
            arr.add(str1); 
        } 
        while(arr.size() != 1) 
        {             
            int j = 0;
            while(j < arr.size()) 
            { 
                if(arr.get(j).equals("+"))
                     break;
                if(arr.get(j).equals("-"))  
                    break;
                if(arr.get(j).equals("*"))
                    break;
                if(arr.get(j).equals("/"))
                    break;
                j++; 
            } 
            if(j == arr.size() || j < 2) 
                throw new RPNParserException(); 
 
            Double res =  new Double(-100000);
            if(arr.get(j).equals("+"))
                res = Double.parseDouble(arr.get(j - 2)) + Double.parseDouble(arr.get(j - 1));
            if(arr.get(j).equals("-"))
                res = Double.parseDouble(arr.get(j - 2)) - Double.parseDouble(arr.get(j - 1));
            if(arr.get(j).equals("*"))
                res = Double.parseDouble(arr.get(j - 2)) * Double.parseDouble(arr.get(j - 1));
            if(arr.get(j).equals("/")) {
                if (Double.parseDouble(arr.get(j - 1)) == 0)
                    throw new ArithmeticException();
                res = Double.parseDouble(arr.get(j - 2)) / Double.parseDouble(arr.get(j - 1)); 
            } 
            arr.remove(j - 2);
            arr.remove(j - 2);
            arr.remove(j - 2);
            if (res == -100000) 
            { 
                throw new RPNParserException(); 
            } 
            arr.add(j - 2, res.toString()); 
        } 
        return Double.parseDouble(arr.get(0)); 
 	} 
 
 	public static void main(String[] args) { 
 
 	} 
 
} 
