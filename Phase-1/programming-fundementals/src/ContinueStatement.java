public class ContinueStatement {
    public static void main(String[] args) {

//        for (int i = 0; i < 4; i++) {
//            if(i==2) continue;
//            System.out.println("______________");
//            System.out.println(i + " IJSE");
//            System.out.println(i + " ABC");
//
//        }

        label1:
        System.out.println("Nested Loops");

        forloop:
        for (int i = 0; i < 5; i++) {
            label2:
            System.out.printf("For loop: iteration (%s) start\n",i);
            int j=0;
            whileloop:
            while (j < 3) {
                if (true) {
                    continue forloop;
                }
                System.out.printf("While loop iteration (%s) starts\n",j);

                System.out.printf("While loop iteration (%s) ends\n",j);
                j++;
            }

            System.out.printf("For loop:iteration (%s) end\n", i);
            System.out.println("\n");
            i++;

        }



    }
}
