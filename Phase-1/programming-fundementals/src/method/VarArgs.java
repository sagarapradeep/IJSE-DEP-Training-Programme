package method;

public class VarArgs
{
    public static void main(String[] args) {

        myMethod("name","comment","ds");            //can pass any number of arguments

    }

    public static void myMethod(String...args) {                //can take any number of parameters
        for (String arg : args) {
            System.out.println(arg);

        }

    }
}
