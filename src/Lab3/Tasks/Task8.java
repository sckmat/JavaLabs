package Lab3.Tasks;



public class Task8 {
    private Node head;
    private Node tail;

    // ================== Методы с использованием циклов ==================

    public void createHead(int[] values) {
        for (int i = values.length - 1; i >= 0; i--) {
            head = new Node(values[i], head);
            if (tail == null) tail = head;
        }
    }

    public void createTail(int[] values) {
        for (int value : values) {
            addLast(value);
        }
    }

    public void addFirst(int data) {
        head = new Node(data, head);
        if (tail == null) tail = head;
    }

    public void addLast(int data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insert(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current != null) {
            current.next = new Node(data, current.next);
            if (current.next.next == null) tail = current.next;
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
            if (head == null) tail = null;
        }
    }

    public void removeLast() {
        if (head == null) return;

        if (head.next == null) {
            head = tail = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        tail = current;
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current != null && current.next != null) {
            current.next = current.next.next;
            if (current.next == null) tail = current;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

    // ================== Рекурсивные методы ==================

    public void createHeadRec(int[] values) {
        head = createHeadRecHelper(values, 0);
        updateTail();
    }

    private Node createHeadRecHelper(int[] values, int index) {
        return (index < values.length)
                ? new Node(values[index], createHeadRecHelper(values, index + 1))
                : null;
    }

    public void createTailRec(int[] values) {
        head = createTailRecHelper(values, 0);
        updateTail();
    }

    private Node createTailRecHelper(int[] values, int index) {
        if (index >= values.length) return null;
        Node newNode = new Node(values[index], null);
        newNode.next = createTailRecHelper(values, index + 1);
        return newNode;
    }

    public String toStringRec() {
        return toStringRecHelper(head).trim();
    }

    private String toStringRecHelper(Node node) {
        return (node == null) ? "" : node.value + " " + toStringRecHelper(node.next);
    }

    private void updateTail() {
        tail = head;
        if (tail == null) return;
        while (tail.next != null) {
            tail = tail.next;
        }
    }

    // ================== Тестирование ==================
    public static void main(String[] args) {
        Task8 list = new Task8();

        System.out.println("=== Циклические методы ===");
        list.createHead(new int[]{1, 2, 3});
        System.out.println("createHead(1,2,3): " + list);

        list.createTail(new int[]{4, 5, 6});
        System.out.println("createTail(4,5,6): " + list);

        list.addFirst(0);
        System.out.println("addFirst(0): " + list);

        list.addLast(7);
        System.out.println("addLast(7): " + list);

        list.insert(3, 99);
        System.out.println("insert(3,99): " + list);

        list.removeFirst();
        System.out.println("removeFirst: " + list);

        list.removeLast();
        System.out.println("removeLast: " + list);

        list.remove(2);
        System.out.println("remove(2): " + list);

        System.out.println("\n=== Рекурсивные методы ===");
        Task8 listRec = new Task8();

        listRec.createHeadRec(new int[]{30, 20, 10});
        System.out.println("createHeadRec(30,20,10): " + listRec.toStringRec());

        listRec.createTailRec(new int[]{40, 50, 60});
        System.out.println("createTailRec(40,50,60): " + listRec.toStringRec());
    }
}