import java.util.Scanner;

public class Loop2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[][] customer = new String[3][3];
        String customerID = null;
        String customerName=null;
        String customerNumber=null;


        int k=0;
        while (k < 3)

        {
            boolean validCostumerId=false;
            boolean validCostumerName=false;
            boolean validCostumerNumber=false;

            //Customer ID
            while (!validCostumerId) {
                System.out.printf("Enter Customer %s ID here: ",k+1);
                customerID=scanner.nextLine().trim();
                char [] charsId=customerID.toCharArray();
                var i=1;
                while (i < 4 && (validCostumerId = (charsId.length == 4 && Character.isDigit(charsId[i++])&&charsId[0]=='C')));
                if(!validCostumerId) System.out.println("ID format should be C123! ");

            }

            customer[k][0]=customerID;

            //customerID name
            while (!validCostumerName) {
                System.out.printf("Enter Customer %s Name: ",k+1);
                customerName=scanner.nextLine().trim();
                char [] charsName=customerName.toCharArray();
                var i=0;
                validCostumerName=(charsName.length>3);
                while ((validCostumerName = (validCostumerName &&
                        ((Character.isLetter(charsName[i])||Character.isSpaceChar(charsName[i])))))&&
                        (++i < charsName.length));

                if(!validCostumerName) System.out.println("Invalid Name");
            }
            customer[k][1]=customerName;

            //customerID number
            while (!validCostumerNumber) {
                System.out.printf("Enter Customer %s Number: ",k+1);
                customerNumber=scanner.nextLine().trim();
                char [] charsNumber=customerNumber.toCharArray();

                validCostumerNumber=((charsNumber.length==11)&&charsNumber[3]=='-');
                int i=0;
                int j=4;
                while ((validCostumerNumber = (validCostumerNumber) && Character.isDigit(charsNumber[i]))&&(++i<3));

                while((validCostumerNumber=((validCostumerNumber) &&Character.isDigit(charsNumber[j])))&&(++j<charsNumber.length));
                if(!validCostumerNumber) System.out.println("Invalid Number");
            }
            customer[k][2] = customerNumber;
            k++;

        }

        int i=0;
        System.out.println("+----------+----------+----------");
        System.out.println("+ ID       +    Name  +  Contact ");
        System.out.println("+----------+----------+----------");
        while (i < customer.length) {
            System.out.printf("   |%s   |%s\t%s\n",
                    customer[i][0],customer[i][1],customer[i][2]);
            i++;

        }










    }
}

