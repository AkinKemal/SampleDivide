public class LinkedList implements LinkedListInterface {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Node head = null;

    //Listenin ilk başına eleman ekleme
    @Override
    public void addBegin(int data) {
        Node element = new Node(data);
        if (head == null) {
            head = element;
            printNewLinkedList();
            printAddData(data);
        } else {
            element.next = head;
            head = element;
            printAddData(data);
        }
    }

    //Listenin en sonuna eleman ekleme
    @Override
    public void addEnd(int data) {
        Node element = new Node(data);
        if (head == null) {
            head = element;
            printNewLinkedList();
            printAddData(data);
        } else {
            Node walk = head;
            while (walk.next != null) {
                walk = walk.next;
            }
            walk.next = element;
            element.next = null;
            printAddData(data);
        }
    }

    //Listeye belirlenen indexleri ekleme
    @Override
    public void addIndex(int data, int index) {
        if (index < size()) {
            Node element = new Node(data);
            if (head == null && index == 0) {
                head = element;
                printNewLinkedList();
                printAddData(data);
            } else if (head != null && index == 0) {
                element.next = head;
                head = element;
                printAddData(data);
            } else if (size() == index) {
                Node walk = head;
                Node prev = null;
                while (walk.next != null) {
                    prev = walk;
                    walk = walk.next;
                }
                prev.next = element;
                element.next = walk;
                printAddData(data);
            } else {
                int counter = 0;
                Node walk = head;
                Node prev = null;
                while (walk != null) {
                    if (counter == index) {
                        break;
                    }
                    prev = walk;
                    walk = walk.next;
                    counter++;
                }
                element = prev.next;
                element.next = walk;
                printAddData(data);
            }
        } else {
            System.out.println(ANSI_RED + "WARNING!" + ANSI_RESET + " The specified index could not be found.");
        }
    }

    //LinkedList neredeyse eşit büyüklükte iki alt listeye bölme
    @Override
    public LinkedList divideMid() {
        int sum = sum(this);
        LinkedList l3 = new LinkedList();
        Node walk = null;
        if (head != null) {
            walk = head;
        }
        while (walk != null) {
            if (sum(this) > sum(l3) && sum(l3) + walk.data <= (sum / 2)) {
                l3.addEnd(walk.data);
                remove(walk.data);
            }
            walk = walk.next;
        }
        return l3;
    }

    public int sum(LinkedList list) {
        int sumList = 0;
        Node walk = null;
        if (head != null) {
            walk = list.head;
        }
        while (walk != null) {
            sumList = sumList + walk.data;
            walk = walk.next;
        }
        return sumList;
    }

    @Override
    public boolean remove(int data) {
        Node walk = head, prev = null;

        while (walk != null) {
            if (walk.data == data)
                break;
            prev = walk;
            walk = walk.next;
        }
        if (walk != null) {
            if (walk == head) {
                head = head.next;
            } else {
                prev.next = walk.next;
            }
            System.out.println("Deletion successful");
            return true;
        }
        System.out.println("Deletion not successful");
        return false;
    }

    @Override
    public int size() {
        Node walk = null;
        int counter = 0;
        if (head != null) {
            walk = head;
            while (walk.next != null) {
                counter++;
                walk = walk.next;
            }
        }
        return counter;
    }

    @Override
    public void printList() {
        Node walk = null;
        if (head != null) {
            walk = head;
            System.out.print("head" + ANSI_RED + " -> " + ANSI_RESET);
            while (walk != null) {
                System.out.print(walk.data + ANSI_RED + " -> " + ANSI_RESET);
                walk = walk.next;
            }
            System.out.println("null");
        }
    }

    public void printAddData(int data) {
        System.out.println(ANSI_GREEN + "✅" + ANSI_RESET + " " + data + ", " + ANSI_GREEN + "successfully" + ANSI_RESET + " prepended.");
    }

    public void printNewLinkedList() {
        System.out.println(ANSI_GREEN + "✅" + ANSI_RESET + " A new LinkedList has been " + ANSI_GREEN + "successfully" + ANSI_RESET + " created.");
    }
}
