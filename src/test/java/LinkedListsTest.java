import org.junit.jupiter.api.Test;
import util.Node;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListsTest {
    LinkedLists linkedListsProblems = new LinkedLists();

    @Test
    void removeDuplicatesTest() {
        Node list = new Node(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(5);
        list.appendToTail(6);
        list.appendToTail(6);

        linkedListsProblems.removeDuplicates(list);

        HashMap<Integer, Integer> map = new HashMap<>();

        Node head = list;
        while(head != null) {
            map.put(head.data, 1);
            head = head.next;
        }

        for(int val : map.values()) {
            assertEquals(1, val);
        }
    }

    @Test
    public void kthToLastTest() {
        Node list = new Node(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(5);
        list.appendToTail(6);
        list.appendToTail(6);

        int thirdToLast = linkedListsProblems.kthToLast(list, 3);
        assertEquals(5, thirdToLast);

        int last = linkedListsProblems.kthToLast(list, 1);
        assertEquals(6, last);

        int fifthToLast = linkedListsProblems.kthToLast(list, 5);
        assertEquals(1, fifthToLast);
    }

    @Test
    public void deleteMiddleNodeTest() {
        Node list = new Node(1);
        list.appendToTail(1);
        Node middleNode = new Node(3);
        list.appendToTail(middleNode);
        list.appendToTail(5);
        list.appendToTail(6);

        linkedListsProblems.deleteMiddleNode(middleNode);

        Node head = list;
        assertEquals(1, head.data);
        head = head.next;
        assertEquals(1, head.data);
        head = head.next;
        assertEquals(5, head.data);
        head = head.next;
        assertEquals(6, head.data);
    }

    @Test
    public void partitionTest() {
        Node list = new Node(3);
        list.appendToTail(5);
        list.appendToTail(8);
        list.appendToTail(5);
        list.appendToTail(10);
        list.appendToTail(2);
        list.appendToTail(1);

        linkedListsProblems.partition(list, 5);

        Node firstFive = list.findFirst(5);

        while(firstFive != null) {
            assertTrue(firstFive.data >= 5);
            firstFive = firstFive.next;
        }
    }

    @Test
    public void sumListsTest() {
        Node list = new Node(7);
        list.appendToTail(1);
        list.appendToTail(6);

        Node list2 = new Node(5);
        list2.appendToTail(9);
        list2.appendToTail(2);

        Node sumList = linkedListsProblems.sumLists(list, list2);

        assertEquals(2, sumList.data);
        sumList = sumList.next;
        assertEquals(1, sumList.data);
        sumList = sumList.next;
        assertEquals(9, sumList.data);

        Node list3 = new Node(9);
        list3.appendToTail(9);
        list3.appendToTail(9);

        Node list4 = new Node(9);
        list4.appendToTail(9);
        list4.appendToTail(9);

        Node sumList2 = linkedListsProblems.sumLists(list3, list4);

        assertEquals(8, sumList2.data);
        sumList2 = sumList2.next;
        assertEquals(9, sumList2.data);
        sumList2 = sumList2.next;
        assertEquals(9, sumList2.data);
        sumList2 = sumList2.next;
        assertEquals(1, sumList2.data);
    }



}