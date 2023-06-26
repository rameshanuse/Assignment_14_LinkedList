package in.ineuron.questions;

import java.util.HashMap;
import java.util.Map;

/*
 	Question 7
 	You are given the `head` of a linked list with `n` nodes.
	For each node in the list, find the value of the **next greater node**. That is, for each node, 
	find the value of the first node that is next to it and has a **strictly larger** value than it.
	Return an integer array `answer` where `answer[i]` is the value of the next greater node of 
	the `ith` node (**1-indexed**). If the `ith` node does not have a next greater node, 
	set `answer[i] = 0`.
	
	Example 1:
	Input: head = [2,1,5]
	Output: [5,5,0]

	Example 2:
	Input: head = [2,7,4,3,5]
	Output: [7,0,5,5,0]
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