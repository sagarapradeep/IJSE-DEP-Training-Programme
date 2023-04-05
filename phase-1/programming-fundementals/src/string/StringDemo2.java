package string;

public class StringDemo2 {
    public static void main(String[] args) {
        /*Java 11*/
        String star="*";
        System.out.println(star.repeat(5));             //repeat

        /*Java 11*/
        String something = "          This is something      ";
        System.out.println(something.stripLeading());           //remove leading whites spaces
        System.out.println(something.stripTrailing());           //remove tailing whites spaces
        System.out.println(something.strip());           //same as trim. But advance than trim


        var name = "Kasun";
        var contact="077455545";
        var age =24;
        String something1 = String.format("My name is %s, my contact is %s,my age is %s",name,contact,age);      //%s make parameter

        something = String.format("%1$s's details, %1$s's contact:%2$s,%1$s's age %3$s",name,contact,age);
        System.out.println(something);









    }
}
