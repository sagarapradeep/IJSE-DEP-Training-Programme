public class LoopDemo {
    public static void main(String[] args) throws InterruptedException {
        String something = "Hello DEP-20, How are you?";
//        System.out.println(something.substring(0,2)+"\b");


        for (int i = 0; i < 5; i++) {
            System.out.println("IJSE");
            Thread.sleep(1000);
        }

            for (int i = 0; i < something.length(); i++) {
                System.out.print(something.charAt(i));
                Thread.sleep(500);
            }


            for (int j = 0; j < something.length(); j++) {
                Thread.sleep(500);
                System.out.print("\b");

            }

        //exercise 2
//        for (int i = 0; i < something.length(); i++) {
//
//            int j=30+i;
//            System.out.print("\u001b["+Integer.toString(j)+"m"+something.charAt(i));
//            if (j>=40) j=30;
//
//
//            System.out.print("\u001b["+Integer.toString(j)+"m"+something.charAt(i));





        }
//






}
