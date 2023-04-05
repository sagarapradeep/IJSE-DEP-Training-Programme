package method;

public class RecursionDemo1 {
    public static void main(String[] args) {
        printStar(0,6);
    }

//    public static void printStar(int iteration) {
//        if(iteration==36) return;
//        if(iteration!=0)
//        {
//            if(iteration%6==0) System.out.println();
//
//        }
//        System.out.print("* ");
//        printStar(++iteration);
//
//
//    }


    public static void printStar(int columnss,int raws) {
        if(raws==6)return;
        if (columnss == raws+1) {
            printStar(++raws,-1);
            return;
        }
        System.out.println("* ");
        printStar(raws,++columnss);

    }
}
