package in.ineuron.questions;

/*
 	Question 5
 	
 	Given the `head` of a singly linked list, group all the nodes with odd indices together 
 	followed by the nodes with even indices, and return *the reordered list*.
	The **first** node is considered **odd**, and the **second** node is **even**, and so on.
	Note that the relative order inside both the even and odd groups should remain as it was 
	in the input. You must solve the problem in `O(1)` extra space complexity and `O(n)` time 
	complexity.
	
	Input: head = [1,2,3,4,5]
	Output: [1,3,5,2,4]
	
	Input: head = [2,1,3,5,6,4,7]
	Output: [2,3,6,7,1,5,4]

 */

//Definition for singly-linked list.
public class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class Question05 {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode e = head.next;
		ListNode i = e;
		ListNode j = i.next;
		ListNode last = j, prev = head;

		int k = 0;

		while (j != null) {
			prev.next = j;
			prev = i;
			i = i.next;
			last = j;
			j = j.next;
			k++;
		}
		if (k % 2 == 1) {
			prev.next = null;
			last.next = e;
			return head;
		}

		prev.next = e;
		return head;
	}
}