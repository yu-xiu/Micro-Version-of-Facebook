/**
 * This class stored the friends of each person in a linked list
 *
 */
public class Person {
    String name;
    myLinkedList<String> friends;

    /**
     * Constructor
     * @param name
     */
    Person(String name) {
        this.name = name;
        friends = new myLinkedList<String>();
    }

    /**
     * toString
     * Making the list a string
     * @return
     */
    public String toString () {
        String s = "{ Name: " + name + ", Friends: " + friends.toString() + " }";
        return s;
    }
}

