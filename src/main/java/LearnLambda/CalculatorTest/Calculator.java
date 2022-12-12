package LearnLambda.CalculatorTest;

public class Calculator {
    public static void main(String[] args) {
        MathOperation add = (x,y)-> x+y;
        MathOperation subtract = (x,y)->x-y;
        MathOperation mulltiply = (x,y)->x*y;
        MathOperation divide =(x,y)->x/y;

        System.out.println(add.operate(2,3));
        System.out.println(subtract.operate(5,1));
        System.out.println(mulltiply.operate(2,5));
        System.out.println(divide.operate(6,2));

/*
        System.out.println(calculate(add));
        System.out.println(calculate(subtract));
        System.out.println(calculate(mulltiply));
        System.out.println(calculate(divide));*/

        int result= calculate(5,add,2);
        result=calculate(result,subtract,3);
        result=calculate(result,mulltiply,7);
        result=calculate(result,add,2);
        result=calculate(result,divide,3);
        System.out.println(result);
    }

    private static int calculateTest(MathOperation mathOperation){
        int x=100;
        int y=5;
        return mathOperation.operate(x,y);
    }

    private static int calculate(int onScreenNumber,MathOperation mathOperation,int enteredNumber){
        return mathOperation.operate(onScreenNumber,enteredNumber );
    }
}
