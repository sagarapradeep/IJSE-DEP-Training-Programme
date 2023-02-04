public class Loop {
    public static void main(String[] args) throws InterruptedException {

        String statement = "Hi! we are DEP-10, How are you?";
        boolean erase = false;
        boolean condition = true;

//        for (int i = 0; true; i++) {
//            if (i == statement.length()) {
//                erase = !erase;
//                i = 0;
//            }
//
//            if(!erase)
//            {
//                System.out.print(statement.charAt(i));
//                Thread.sleep(400);
//            }
//            else {
//                System.out.print("\b");
//                Thread.sleep(700);
//
//
//
//            }
//
//        }

        for (int j = 0; true; j++) {
            if (condition) {
                System.out.print(statement.charAt(j));
                Thread.sleep(200);
            }
            if (!condition) {
                System.out.print("\b");
                Thread.sleep(600);
            }
            if (j == 2*(statement.length()-1)) {
                condition = !condition;
                j=0;
            }
            if (j == statement.length()-1) {
                condition = !condition;
            }


        }

    }
}
