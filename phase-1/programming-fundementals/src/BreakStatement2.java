public class BreakStatement2 {
    public static void main(String[] args) {
        start:
        System.out.println("IJSE");

        first:{
            System.out.println("First started");
            second:{
                System.out.println("Second started");
                third:{
                    System.out.println("Third started");
                    if(true) break third;
                    forth:{
                        System.out.println("Forth started");
                        System.out.println("Forth ended");

                    }
                }System.out.println("Thrid ended");
            }System.out.println("Second ended");
        }System.out.println("First ended");

        end:
        System.out.println("App ended");
    }
}
