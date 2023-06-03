import util.Node;

import java.util.HashMap;

public class LinkedLists {

    public void removeDuplicates(Node head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        while(head != null) {
            map.put(head.data, 1);
            if(head.next != null) {
                if(map.get(head.next.data) != null) {
                    head.next = head.next.next;
                }
            }
            head = head.next;
        }
    }
}
