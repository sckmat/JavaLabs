package Lab3.Tasks;

class Node {
    public int value;
    public Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

public class Task7 {
    private static Node buildFromHead() {
        Node head = null;
        for (int i = 9; i >= 0; i--) {
            head = new Node(i, head);
        }
        return head;
    }

    private static Node buildFromTail() {
        Node head = null;
        Node tail = null;
        for (int i = 0; i <= 9; i++) {
            Node newNode = new Node(i, null);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Список с головы:");
        printList(buildFromHead());

        System.out.println("\nСписок с хвоста:");
        printList(buildFromTail());
    }
}