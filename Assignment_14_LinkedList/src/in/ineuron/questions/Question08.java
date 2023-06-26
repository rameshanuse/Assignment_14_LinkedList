package in.ineuron.questions;

import java.util.HashMap;
import java.util.Map;

/*
 	Question 7
 	Given the `head` of a linked list, we repeatedly delete consecutive sequences of nodes 
 	that sum to `0` until there are no such sequences.
	After doing so, return the head of the final linked list.  You may return any such answer.
	(Note that in the examples below, all sequences are serializations of `ListNode` objects.)
	
	Example 1:
	Input: head = [1,2,-3,3,1]
	Output: [3,1]
	Note: The answer [1,2,1] would also be accepted.

	Example 2:
	Input: head = [1,2,3,-3,4]
	Output: [1,2,4]
	
	Example 3:
	Input: head = [1,2,3,-3,-2]
	Output: [1]

 */

public class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { 
		this.val = val; 
	}
	ListNode(int val, ListNode next) { 
		this.val = val; 
		this.next = next; 
	}
}

public class Question08 {
public ListNode removeZeroSumSublists(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int prefix = 0;
        ListNode curr = dummy;
        Map<Integer, ListNode> seen = new HashMap<>();
        seen.put(prefix, dummy);
        
        while (curr != null) {
            prefix += curr.val;
            seen.put(prefix, curr);
            curr = curr.next;
        }
        
        prefix = 0;
        curr = dummy;
        while (curr != null) {
            prefix += curr.val;
            curr.next = seen.get(prefix).next;
            curr = curr.next;
        }
        
        return dummy.next;
    }
    
}