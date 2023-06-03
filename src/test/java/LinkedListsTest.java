import org.junit.jupiter.api.Test;
import util.Node;

import java.util.HashMap;
import java.util.LinkedList;

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
}