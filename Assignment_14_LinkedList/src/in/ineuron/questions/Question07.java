package in.ineuron.questions;

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

public class Question07 {
	public int[] nextLargerNodes(ListNode head) {
        int n = size(head);
        int arr[] = new int[n];
        ListNode curr = head;
        int i=0;
        while(curr!=null)
        {
            ListNode temp = curr.next;
            while(temp!=null)
            {
                if(temp.val>curr.val)
                    break;
                temp = temp.next;
            }
            if(temp==null)
                arr[i++]=0;
            else
                arr[i++]=temp.val;
            curr = curr.next;
        }
        return arr;
    }
    public int size(ListNode temp)
    {
        int n = 0;
        while(temp!=null){
            temp = temp.next;
            n++;
        }
        return n;
    }
    
}