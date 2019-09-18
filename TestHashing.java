import java.util.Scanner;

/**
 * This class contains main function
 */
public class TestHashing {
    public static void main(String[] args) {
        // create an object
        myHashTable ht = new myHashTable();
        // List of persons
        ht.createPerson("Nancy");
        ht.createPerson("Jake");
        ht.createPerson("Lisa");
        ht.createPerson("Lily");
        ht.createPerson("Hua");
        ht.createPerson("Peter");
        ht.createPerson("Duo");
        ht.createPerson("Boo");
        ht.createPerson("Jessie");
        ht.createPerson("William");

        ht.createPerson("Mike");
        ht.createPerson("Tong");
        ht.createPerson("Yuan");
        ht.createPerson("Yu");
        ht.createPerson("Xin");
        ht.createPerson("Von");
        ht.createPerson("Selina");
        ht.createPerson("David");
        ht.createPerson("Huo");
        ht.createPerson("Ming");

        ht.createPerson("Lucy");
        ht.createPerson("Hope");
        ht.createPerson("Tiffany");
        ht.createPerson("Catie");
        ht.createPerson("Jessica");
        ht.createPerson("Luna");
        ht.createPerson("Jason");
        ht.createPerson("Marry");
        ht.createPerson("Dongdong");
        ht.createPerson("Ella");

        // Making friends of two persons
        ht.makeFriends("Nancy", "Catie");
        ht.makeFriends("Nancy", "Jake");
        ht.makeFriends("Nancy", "Ella");
        ht.makeFriends("Nancy", "Ming");
        ht.makeFriends("Jake", "Catie");
        ht.makeFriends("Jake", "Ella");
        ht.makeFriends("Jake", "David");
        ht.makeFriends("Lisa", "Catie");
        ht.makeFriends("Lisa", "Ella");
        ht.makeFriends("Lisa", "Jessica");
        ht.makeFriends("Lisa", "DongDong");
        ht.makeFriends("Lily", "Catie");
        ht.makeFriends("Lily", "Ella");
        ht.makeFriends("Lily", "Nancy");
        ht.makeFriends("Hua", "Jason");
        ht.makeFriends("Hua", "Luna");
        ht.makeFriends("Hua", "Boo");
        ht.makeFriends("Peter", "Lisa");
        ht.makeFriends("Peter", "Catie");
        ht.makeFriends("Peter", "David");
        ht.makeFriends("Peter", "Boo");
        ht.makeFriends("Duo", "Lisa");
        ht.makeFriends("Duo", "Jason");
        ht.makeFriends("Duo", "Xin");
        ht.makeFriends("Boo", "Catie");
        ht.makeFriends("Boo", "Von");
        ht.makeFriends("Boo", "Mike");
        ht.makeFriends("Jessie", "Yu");
        ht.makeFriends("Jessie", "Lisa");
        ht.makeFriends("William", "Luna");
        ht.makeFriends("William", "Boo");
        ht.makeFriends("William", "Mike");
        ht.makeFriends("Mike", "Luna");
        ht.makeFriends("Mike", "Jason");
        ht.makeFriends("Mike", "Ella");
        ht.makeFriends("Mike", "Yu");
        ht.makeFriends("Tong", "Yu");
        ht.makeFriends("Yuan", "Yu");
        ht.makeFriends("Xin", "Luna");
        ht.makeFriends("Xin", "Selina");
        ht.makeFriends("Von", "Luna");
        ht.makeFriends("Selina", "Mike");
        ht.makeFriends("David", "Selina");
        ht.makeFriends("Huo", "Selina");
        ht.makeFriends("Lucy", "Luna");
        ht.makeFriends("Lucy", "Huo");
        ht.makeFriends("Hope", "Lucy");
        ht.makeFriends("Tiffany", "Hope");
        ht.makeFriends("Marry", "Tiffany");
        ht.makeFriends("Marry", "Hope");

        System.out.println(ht);
        // Remove a friend from a person's friends list
        ht.removeFriend("Nancy", "Catie");
        ht.removeFriend("Lily", "Ella");
        ht.removeFriend("Peter", "David");
        // Showing table after deleting friends
        System.out.println("After deleting friends (Nancy, Catie), (Lily, Ella), (Peter, David) \n" + ht);
        // Check whether two persons are friends
        System.out.println("-----------------------------------------------------------------------------------------\n"
                + "Check whether Nancy and Catie are friends:");
        ht.checkFriends("Nancy","Catie");
        System.out.println( "Check whether Mike and Yu are friends:");
        ht.checkFriends("Mike","Yu");

        Scanner sc = new Scanner(System.in);
        // a while loop that provide options for users to test
        while (true) {
            System.out.println("-----------------------------------------------------------------------------------\n");
            System.out.println("Users have following options, choose a number to test the function:\n");
            System.out.println("Options: 1. Search a person and list his/her friends; 2. Make friends; 3. Delete a " +
                    "friend; 4. Check whether two persons are friends 0. Exit;");

            String input = sc.nextLine();
            // If user choose 0, exit
            if (input.compareTo("0") == 0) {
                break;
            }
            // if user choose option 1, search a person and list friends
            else if (input.compareTo("1") == 0) {
                System.out.println("Enter a name of the name list: ");
                String name = sc.nextLine();
                System.out.println( name + "'s friends: " + ht.chainedHashSearch(name).friends);

            }
            // if user choose option 2, make friends
            else if (input.compareTo("2") == 0) {
                System.out.println("Enter name 1: ");
                String s1 = sc.nextLine();
                System.out.println("Enter name 2: ");
                String s2 = sc.nextLine();
                ht.makeFriends(s1,s2);
                System.out.println("Congratulations! " + s1 + " and " + s2 + " are new friends now!");
                System.out.println(ht);
            }
            // if user choose option 3, delete a friend
            else if (input.compareTo("3") == 0) {
                System.out.println("Enter name 1: ");
                String s1 = sc.nextLine();
                System.out.println("Enter name 2: ");
                String s2 = sc.nextLine();
                ht.removeFriend(s1,s2);
                System.out.println(s1 + " and " + s2 + " are not friends now!");
                System.out.println(ht);
            }
            // if user choose option 4, check friends
            else if (input.compareTo("4") == 0) {
                System.out.println("Enter name 1: ");
                String s1 = sc.nextLine();
                System.out.println("Enter name 2: ");
                String s2 = sc.nextLine();
                if (s1.equals("")) {
                    break;
                }
                if (s2.equals("")) {
                    break;
                } else {
                    System.out.println("Are " + s1 + " and " + s2 + " friends?");
                    ht.checkFriends(s1, s2);
                }
            }
        }
    }
}
