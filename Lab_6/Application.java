package com.tasks6.rle_decoder;

public class Application
{
    public static void main( String[] args )
    {
        String input = args[0];
        String output = "";
        if((input != "") && ((input.charAt(0) < '0') || ((int) input.charAt(0) > '9'))) {
            for (int i = 0; i < input.length(); i++) {

                char k = input.charAt(i);

                if (i < input.length() - 1) {
                    if (input.charAt(i + 1) == input.charAt(i)) {
                        output = "";
                        break;
                    }
                }

                if (((input.charAt(i) >= '1') && (input.charAt(i) <= '9'))) {

                    if (i < input.length() - 1) {
                        if ((input.charAt(i + 1) >= '0') && ( input.charAt(i + 1) <= '9')) {
                            output = "";
                            break;
                        }
                    }

                    for (int j = 0; j < Character.getNumericValue(input.charAt(i)) - 1; j++) {
                        output += input.charAt(i - 1);
                    }

                }
                if ((input.charAt(i) < '0') || ((int) input.charAt(i) > '9'))
                    output += input.charAt(i);
            }
        }
        System.out.println(output);
    }
}