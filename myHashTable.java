import java.util.ArrayList;

public class myHashTable {
    // choose m as a next prime number of the # of key entries * 1.3, and it is not too close to 2^p
    static final int m = 41;
    int size = 0;
    ArrayList<myLinkedList<Person>> table;

    /**
     * Constructor
     *
     */
    myHashTable() {
        table = new ArrayList<myLinkedList<Person>>();
        for (int i = 0; i < m; i ++) {
            table.add(new myLinkedList<Person>());
        }
    }

    /**
     * Converting name string to an integer hash code
     *
     * For example, “Kate”-> [75 * 128^3 + 97 * 128^2 + 116 * 128 + 101] % m
     = [[(75 * 128 + 97) * 128 + 116] * 128 + 101] % m
     = [[[((75 * 128 + 97) % m) * 128 + 116] % m] * 128 + 101] % m
     * @param key
     * @return
     */
    public int hashCode (String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); ++i) {
            // get each character's ASCII code
            char c  = key.charAt(i);
            // compute a hash code
            hash = (hash * 128 + c) % m;
        }
        return hash;
    }

    /**
     * Check empty
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Create a person record of the specific name
     *
     * Converting the string of name to a hash code and find a slot
     * if the slot is empty, add the new node to the list
     * otherwise add the new node as the first element in the list
     * @param name
     * @return
     */
    public boolean createPerson (String name) {
        int h = hashCode(name);
        if (table.get(h) == null) {
            table.set(h, new myLinkedList<Person>());
            Person p = new Person(name);
            table.set(h,new myLinkedList<Person>()).addFirst(p);
        }
        else {
            Person p = new Person (name);
            // if table dose not contain p
            if (!table.get(h).contains(p)) {
                table.get(h).addFirst(p);
            }
        }
        return true;
    }

    /**
     * Make a friend
     *
     * record a person as a new friend
     * @param name1
     * @param name2
     */
    public void makeFriends (String name1, String name2) {
        Person p1 = chainedHashSearch(name1);
        Person p2 = chainedHashSearch(name2);
        if (p1 != null && p2 != null) {
            // if person 2 is not in person 1's friend list, add
            if (!p1.friends.contains(name2)) {
                p1.friends.addFirst(name2);
            }
            // if person 1 is not in person 2's friend list,add
            if (!p2.friends.contains(name1)) {
                p2.friends.addFirst(name1);
            }
        }
    }

    /**
     * Given a name, search a person object or null
     * @param name
     * @return
     */
    public Person chainedHashSearch (String name) {
        int h = hashCode(name);
        if (table.get(h) != null) {
            myLinkedList.Node<Person> temp = table.get(h).head;
            while (temp != null) {
                if (temp.val.name.equals(name)) {
                    return temp.val;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    /**
     * Remove a person from the friend list
     * @param name1
     * @param name2
     */
    public void removeFriend (String name1, String name2) {
        Person p1 = chainedHashSearch(name1);
        Person p2 = chainedHashSearch(name2);
        if (p1 != null && p2 != null) {
            if (p1.friends.contains(name2)) {
                p1.friends.remove(name2);
            }
            if (p2.friends.contains(name1)) {
                p2.friends.remove(name1);
            }
        }
    }

    /**
     * List friends of a person and search a person to list the person's friends
     * @param name
     */
    public void listFriends (String name) {
        Person p1 = chainedHashSearch(name);
        System.out.println(p1);
    }

    /**
     * check whether two people are friends
     */
    public void checkFriends (String name1, String name2) {
        Person p1 = chainedHashSearch(name1);
        Person p2 = chainedHashSearch(name2);
        if (p1 != null && p2 != null) {
            if (p1.friends.contains(name2)) {
                System.out.println("Yes ");
            } else {
                System.out.println("No ");
            }
        }
    }

    /**
     * toString
     * @return
     */
    public String toString () {
        String s = "Hash Table\n";
        s += "-----------------------------------------------------------------------------------------------------\n";
        for (int i = 0; i < m; i++) {
            s += i + " " + table.get(i).toString() + "\n";
        }
        return s;
    }
}
