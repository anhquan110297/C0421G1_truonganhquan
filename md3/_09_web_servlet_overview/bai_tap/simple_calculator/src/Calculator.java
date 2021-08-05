public class Calculator {
    public double simpleCalculator (double firstOperand,double secondOperand,String operator){
        double result = 0;
        switch (operator){
            case "addition":
               result =  firstOperand + secondOperand;
                break;
            case "subtraction":
                result = firstOperand - secondOperand;
                break;
            case "multiple":
                result = firstOperand * secondOperand;
                break;
            case "division":
                try {
                    result = firstOperand / secondOperand;
                } catch (Exception e){
                    System.err.println("Error Second Operand an not is zero");
                }
                break;
        }
        return result;
    }
}
