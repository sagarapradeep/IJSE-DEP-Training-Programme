public class ForLoopDemo1
{
    public static void main(String[] args) throws InterruptedException {
        String something = "Hello DEP-10, How are you!";


//        boolean erase =false;
//        for (int i = 0; true; i++) {
//            if(i==something.length())erase=true;
//            if (!erase)System.out.print(something.charAt(i));
//            if(erase) System.out.print("\b");
//            if(!erase)Thread.sleep(200);
//            if(erase)Thread.sleep(100);
//        }

        for (int i=0; true;i++ ) {
            if(i<something.length())
            {
                System.out.print(something.charAt(i));
                Thread.sleep(200);

            }
            else
            {
                System.out.print("\b");
                Thread.sleep(200);
                if(i==(2*(something.length()-1))) i=0;

            }


        }


    }
}
