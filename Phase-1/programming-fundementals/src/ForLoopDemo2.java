import java.util.Scanner;

public class ForLoopDemo2 {
    public static void main(String[] args) throws InterruptedException {
        boolean mainCondition=true;                     //define boolean conditions for input loop.For two inputs use one for loop
        boolean condition =true;
        Scanner scanner = new Scanner(System.in);           //scanner object creation
        int number =0;                  //main variables initialized to 0
        int speedSelection=0;
        int threadSpeed=0;

        for (; mainCondition; ) {                   //input for loop

            if(condition)
            {
                System.out.print("Enter Positive number here: ");
                number = scanner.nextInt();                             //take number input

                if (number <= 0) {                                  //check negetivity of the number
                    System.out.println("Enter valid number");           //if negetive repeat
                }
                else                                                                 //positive case
                {
                    condition=false;                                           //positive value ok assign condition to false
                }
            }
            if (!condition) {                                   //take speed value
                System.out.print("\nProgress speedSelection\n(1) Fast\n(2) Medium\n(3)Slow\nSelect the speedSelection: ");
                speedSelection = scanner.nextInt();
                if(speedSelection<=0 ||speedSelection>3)
                {
                    System.out.println("Enter valid speedSelection");
                }
                else mainCondition=false;                           //when two inputs ok set mainCondition to false to escape from the loop

            }

        }


        if(speedSelection==1) threadSpeed=100;              //Thread speed values assign according to selected speeds
        else if(speedSelection==2) threadSpeed=200;
        else threadSpeed=500;


        for (int i = 1; i <= 50; i++) {                         //filling bar
            int precentage = ((i * 100) / 50);                  //precentage

            String statement = "Progress: " + precentage + "% [";         //1st part of filling bar
            System.out.print(statement);

            for (int j = 1; j <= i; j++) {                  //colored fillings
                System.out.print("\u001b[41m \u001b[0m");

            }
            for (int k = 0; k < (50-i); k++) {              //blank filings
                System.out.print(" ");
            }
            int precentageNumber =precentage*number/100;            //last part of the bar
            String statement2="]  "+precentageNumber+"/"+number;
            System.out.print(statement2);

            Thread.sleep(threadSpeed);

            if(precentage!=100)                         //delete entire line
            {
                for (int j = 0; j < (statement.length()+50+statement2.length()); j++) {
                    System.out.print("\b");

                }

            }

        }
        System.out.println("\nCompleted !");                  //final message



    }
}
