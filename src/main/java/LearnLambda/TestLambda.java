package LearnLambda;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestLambda {
    public static void main(String[] args) {
        /*GreetingService g = (name) ->System.out.println("Hello " +name);
        g.greet("Fiyaz");*/

       /* test((n)->n.toUpperCase());
        test((n)->n.toUpperCase());*/

        //test((n)->n.toLowerCase(),"Fiyaz");


        GreetingService g = new GreetingService() {
            @Override
            public void greet(String name, String last) {

            }
        };

        Supplier<Double>  supplier = () -> Math.random();
        System.out.println(supplier.get());

        Consumer<String> consumer = (name) -> System.out.println(name);
        consumer.accept("SDET III");


        GreetingService g1 = (fname,lName) -> {
            System.out.println(fname+lName);
        };

        g1.greet("SDET","BATCH4");


    }
    /*public static void test(GreetingService g){
        String returnedString = g.greet("Hello 123");
        System.out.println(returnedString);
    }


    public static void test(GreetingService g,String name){
        String returnedString = g.greet(name);
        System.out.println(returnedString);
    }*/
}
