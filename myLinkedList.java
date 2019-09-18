/**
 * myLinkedList class
 * creating a generic Linked list class, and it would be used both in a person and his or her friends
 * and the hash table chaining
 * @param <E>
 */
public class myLinkedList<E> {
    Node<E> head = null;
    Node<E> tail = null;
    int size = 0;
    /**
     * Define a node class
     * @param <E>
     */
    public static class Node<E> {
        E val;
        Node<E> next;

        // Constructor
        public Node (E n) {
            val = n;
        }
    }

    /**
     * Add a new node at the end of the list
     * @param n
     */
    public void addLast(E n) {
        Node<E> newNode = new Node<E>(n);
        // only one node in the list
        if (tail == null) {
            head = tail = newNode;
        }
        else {
            // link the new node with last node
            tail.next = newNode;
            // tail points to the last node
            tail = tail.next;
        }
        // increase size
        size++;
    }

    /**
     * Add a new node at the head of the list
     * @param n
     */
    public void addFirst(E n) {
        if (contains(n)) {
            return;
        }
        Node<E> newNode = new Node<E>(n);
        // link the new node with the head
        newNode.next = head;
        // head points to the new node
        head = newNode;
        // increase list size
        size++;
        // the new node is the only node in the list
        if (tail == null) {
            tail = head;
        }
    }

    /**
     * Check whether a string contained in the list
     * @param x
     * @return
     */
    public boolean contains (E x) {
        Node<E> temp = head;
        while (temp != null) {
            if (temp.val.equals(x)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * Remove a node out of the list
     * @param x
     */
    public void remove(E x) {
        Node<E> previous = null;
        Node<E> temp = head;
        while (temp != null) {
            if (temp.val.equals(x)) {
                if (previous == null) {
                    head = temp.next;
                    temp.next = null;
                } else {
                    previous.next = temp.next;
                    temp.next = null;
                }
                return;
            }
            previous = temp;
            temp = temp.next;
        }
    }

    /**
     *  Linked list toString
     * @return
     */
    public String toString () {
        String s = "";
        Node<E> temp = head;
        // list is not empty
        while (temp != null) {
            s += temp.val.toString() + " -> ";
            temp = temp.next;
        }
        s += "null";
        return s;
    }
}

