public class Application {

    public static void main(String[] args) {
        LinkedList MyList = new LinkedList();
        LinkedList SubList;

        //taslak1
        //22 34 56 4 19 2 89 90 0 14 32 88 125 56 11 43 55
        MyList.addEnd(22);
        MyList.addEnd(34);
        MyList.addEnd(56);
        MyList.addEnd(19);
        MyList.addEnd(89);
        MyList.addEnd(90);
        MyList.addEnd(0);
        MyList.addEnd(14);
        MyList.addEnd(32);
        MyList.addEnd(88);
        MyList.addEnd(125);
        MyList.addEnd(56);
        MyList.addEnd(11);
        MyList.addEnd(43);
        MyList.addEnd(55);

        //taslak2
        //5 3 1 3 9 9
        /*MyList.addEnd(5);
        MyList.addEnd(3);
        MyList.addEnd(1);
        MyList.addEnd(3);
        MyList.addEnd(9);
        MyList.addEnd(9);
        MyList.printList();*/

        design();
        SubList = MyList.divideMid();
        design();
        System.out.print("New MyList: ");
        MyList.printList();
        System.out.println("MyList Sum:" + MyList.sum(MyList));
        design();
        System.out.print("New SubList: ");
        SubList.printList();
        System.out.println("Sublist Sum:" + SubList.sum(SubList));
        design();
    }

    public static void design() {
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
