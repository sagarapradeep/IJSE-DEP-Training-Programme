package method;

public class RecursionDemo2 {
    public static void main(String[] args) {
        int width=5;
        int length=10;
        printStarRectangle(0,0,length,width);

    }

//    public static void printStar(int iteration) {
//
//        if(iteration==36) return;
//        if (iteration != 0) {
//            if(iteration%6==0) System.out.println();
//        }
//        System.out.print("* ");
//        printStar(++iteration);
//    }

//    public static void printStar(int raws, int columns) {               //star square
//        if(raws==6)return;
//        if (columns == 6) {
//            System.out.println();
//            ++raws;
//            columns=0;
//        }
//        if (raws!=6) {
//            System.out.print("* ");
//        }
//
//        printStar(raws, ++columns);
//    }

//    public static void printStar(int raws, int columns,int length) {               //star half triangle
//        if(raws==length) return;
//        if (columns == (length - raws)) {
//            System.out.println();
//            ++raws;
//            columns=0;
//
//        }
//        if (raws!=length) {
//            System.out.print("* ");
//        }
//
//        printStar(raws,++columns,length);
//    }
//    public static void printStar(int raws, int columns,int length) {               //star half triangle from higher
//        if (raws == length) return;
//        if (columns ==length- raws) {
//            System.out.println();
//            ++raws;
//            columns=0;
//        }
//        if (raws != length) {
//            System.out.print("* ");
//        }
//        printStar(raws, ++columns,length);
//    }

//    public static void printStar(int raws, int columns,int length) {               //star half triangle from lower
//        if (raws == length) return;
//        if (columns ==raws+1) {
//            System.out.println();
//            ++raws;
//            columns=0;
//        }
//        if (raws != length) {
//            System.out.print("* ");
//        }
//        printStar(raws, ++columns,length);
//    }

    public static void printStarRectangle(int raws, int columns,int length,int width) {               //star half triangle from lower
        if (raws == width) return;
        if (columns ==length) {
            System.out.println();
            ++raws;
            columns=0;
        }
        if (raws != width) {
            System.out.print("* ");
        }
        printStarRectangle(raws, ++columns,length,width);
    }
}

