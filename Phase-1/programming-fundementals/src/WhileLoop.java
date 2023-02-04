public class WhileLoop {
    public static void main(String[] args) {
//        int i=1;
//        int k=1;
//        while (i < 8) {
//            int j=0;
//            while (j < i) {
//                System.out.print("*");
//                j++;
//            }
//            System.out.println();
//            i++;
//        }
//
//        while (k < 8) {
//            int l=0;
//            {
//                while(l<(8-k))
//                {
//                    System.out.print("*");
//                    l++;
//                }
//
//            }
//            System.out.println();
//            k++;
//        }
        int i=0;
        while (i<12) {
            int j=0;
            while (j<(i<6?i:(12-i))) {
                System.out.print("x ");
                j++;
            }
            System.out.println();
            i++;
        }


    }




}
