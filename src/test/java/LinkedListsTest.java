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


}