package lk.ijse.dep10.oop.exersice;

public class Exersice1 {
    public static void main(String[] args) {
        Costumer c1 = new Costumer();
        c1.id=1;
        c1.name = "Kasun";
        c1.address = "Panadura";

        Costumer c2 = c1;
        c2.address = "Galle";
        System.out.println(c1.id + ", " + c1.name + ", " + c1.address);

    }

}

class Costumer{
    int id;
    String name;
    String address;
}
