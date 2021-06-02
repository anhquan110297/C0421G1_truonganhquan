package _01_java.bai_tap;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number");
        int number = scanner.nextInt();
        String display = "";
        if ( number <= 10 && number > 0 ){
            switch (number){
                case 1:
                    display = "One";
                    break;
                case 2:
                    display = "Two";
                    break;
                case 3:
                    display = "Three";
                    break;
                case 4:
                    display = "Four";
                    break;
                case 5:
                    display = "Five";
                    break;
                case 6:
                    display = "Six";
                    break;
                case 7:
                    display = "Seven";
                    break;
                case 8:
                    display = "Eight";
                    break;
                case 9:
                    display = "Nine";
                    break;
                case 10:
                    display = "Ten";
                    break;
            }

        }else if (number < 20){
            switch (number){
                case 11:
                    display = "Eleven";
                    break;
                case 12:
                    display = "Twelve";
                    break;
                case 13:
                    display = "Thirteen";
                    break;
                case 14:
                    display = "Fourteen";
                    break;
                case 15:
                    display = "Fifteen";
                    break;
                case 16:
                    display = "Sixteen";
                    break;
                case 17:
                    display = "Seventeen";
                    break;
                case 18:
                    display = "Eighteen";
                    break;
                case 19:
                    display = "Nineteen";
                    break;
            }

        }else if (number < 100){
            int tens = number/10;
            int ones = number - (tens*10);
            switch (tens){
                case 2:
                    display = "Twenty";
                    break;
                case 3:
                    display = "Thirty";
                    break;
                case 4:
                    display = "Fourty";
                    break;
                case 5:
                    display = "Fifty";
                    break;
                case 6:
                    display = "Sixty";
                    break;
                case 7:
                    display = "Seventy";
                    break;
                case 8:
                    display = "Eighty";
                    break;
                case 9:
                    display = "Ninety";
                    break;

            }
            switch (ones){
                case 1:
                    display += " One";
                    break;
                case 2:
                    display += " Two";
                    break;
                case 3:
                    display += " Three";
                    break;
                case 4:
                    display += " Four";
                    break;
                case 5:
                    display += " Five";
                    break;
                case 6:
                    display += " Six";
                    break;
                case 7:
                    display += " Seven";
                    break;
                case 8:
                    display += " Eight";
                    break;
                case 9:
                    display += " Nine";
                    break;

            }

        }else if (number < 1000){
            int hundreds = number/100;
            int spec = number%100;
            int tens = (number - (hundreds*100))/10;
            int ones = (number - (hundreds*100)-(tens*10));

            switch (hundreds){
                case 1:
                    display = "One hundred";
                    break;
                case 2:
                    display = "Two hundred";
                    break;
                case 3:
                    display = "Three hundred";
                    break;
                case 4:
                    display = "Four hundred";
                    break;
                case 5:
                    display = "Fine hundred";
                    break;
                case 6:
                    display = "Six hundred";
                    break;
                case 7:
                    display = "Seven hundred";
                    break;
                case 8:
                    display = "Eight hundred";
                    break;
                case 9:
                    display = "Nine hundred";
                    break;

            }
            switch (tens){
                case 1:
                    switch (spec){
                        case 11:
                            display += " and eleven";
                            break;
                        case 12:
                            display += " and twelve";
                            break;
                        case 13:
                            display += " and thirteen";
                            break;
                        case 14:
                            display += " and fourteen";
                            break;
                        case 15:
                            display += " and fifteen";
                            break;
                        case 16:
                            display += " and sixteen";
                            break;
                        case 17:
                            display += " and seventeen";
                            break;
                        case 18:
                            display += " and eighteen";
                            break;
                        case 19:
                            display += " and  nineteen";
                            break;
                    }
                case 2:
                    display += " and twenty";
                    break;
                case 3:
                    display += " and thirty";
                    break;
                case 4:
                    display += " and fourty";
                    break;
                case 5:
                    display += " and fifty";
                    break;
                case 6:
                    display += " and sixty";
                    break;
                case 7:
                    display += " and seventy";
                    break;
                case 8:
                    display += " and eighty";
                    break;
                case 9:
                    display += " and ninety";
                    break;
            }
            switch (ones){
                case 1:
                    display += " one";
                    break;
                case 2:
                    display += " two";
                    break;
                case 3:
                    display += " three";
                    break;
                case 4:
                    display += " four";
                    break;
                case 5:
                    display += " five";
                    break;
                case 6:
                    display += " six";
                    break;
                case 7:
                    display += " seven";
                    break;
                case 8:
                    display += " eight";
                    break;
                case 9:
                    display += " nine";
                    break;
            }
        }
        System.out.println(display);
    }
}
