public class HashCodes {
    public static void main(String[] args) {

        User user1 = new User(1, "Sagara", "Colombo");
//        User user2 = new User(1, "Sagara", "Colombo");

        System.out.println("User 1 Hashcode:" + user1.hashCode());

        user1.setName("Kamal");
        user1.setCity("Kaduwela");
        user1.setId(3);

        System.out.println("User 1 Hashcode after modified:" + user1.hashCode());
        System.out.println(user1.getName());



    }
}
