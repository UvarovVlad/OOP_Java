package com.tasks6.rle;

public class Application
{
    public static void main( String[] args )
    {
        String input = args[0];
        String output = "";
        if(input != "") {
            for (int i = 0; i < input.length() - 1; i++) {
                int k = 1;
                output += input.charAt(i);
                while (input.charAt(i) == input.charAt(i + 1)) {
                    k++;
                    if (i == input.length() - 2)
                        break;
                    i++;
                    if (k == 9) {
                        break;
                    }
                }
                if (k != 1) {
                    output += k;
                }
            }
            if (input.charAt(input.length() - 2) != input.charAt(input.length() - 1)) {
                output += input.charAt(input.length() - 1);
            }
        }
        System.out.println(output);
    }
}