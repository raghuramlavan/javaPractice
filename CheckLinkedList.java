package javaPractice;

import java.util.LinkedList;
import java.util.ListIterator;

class CheckLinkedList {

    private LinkedList<Integer> lists;

    public CheckLinkedList() {
        lists = new LinkedList<Integer>();
    }

    public static void main(String[] a) {
        CheckLinkedList cll = new CheckLinkedList();
        ListIterator<Integer> li = cll.lists.listIterator(0);
        cll.lists.add(1);
        cll.lists.add(2);
        System.out.println(cll.lists);
        int index = cll.lists.indexOf(2);
        cll.lists.remove(index);
        // li.remove(li.indexOf(2));
        cll.lists.addFirst(2);
        System.out.println(cll.lists);
    }

}