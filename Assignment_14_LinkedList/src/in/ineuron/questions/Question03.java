package in.ineuron.questions;
/*	
 	Question 3
 	
 	Given a Linked List of size N, where every node represents a sub-linked-list and 
 	contains two pointers:(i) a next pointer to the next node,(ii) a bottom pointer 
 	to a linked list where this node is head.Each of the sub-linked-list is in sorted order.
 	Flatten the Link List such that all the nodes appear in a single level while maintaining 
 	the sorted order. Note: The flattened list will be printed using the bottom pointer instead 
 	of next pointer.
 	
 	Example 1:
 	Input:
	5 -> 10 -> 19 -> 28
	|     |     |     |
	7     20    22   35
	|           |     |
	8          50    40
	|                 |
	30               45
	
	Output: 5-> 7-> 8- > 10 -> 19-> 20->
	22-> 28-> 30-> 35-> 40-> 45-> 50.
	
	Explanation:
	The resultant linked lists has every
	node in a single level.(Note:| represents the bottom pointer.)
	
	Example 2:
	Input:
	5 -> 10 -> 19 -> 28
	|          |
	7          22
	|          |
	8          50
	|
	30

	Output: 5->7->8->10->19->22->28->30->50
	Explanation:
	The resultant linked lists has every
	node in a single level.

	(Note:| represents the bottom pointer.)

	
 */
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
public class Question03 {
	 Node flatten(Node node)
	    {
		// Your code here
		    Node merged = node.next;
		    while(merged!=null){
		        Node second = merged;
		        merged=merged.next;
		        second.next=null;
		         node = merge(second,node);
		        
		    }
		    return node;
		    
	    }
	    
	    Node merge(Node p1, Node p2){
	        Node head = new Node(0);
	        Node curr = head;
	        while(p1!=null && p2!=null){
	            if(p1.data<=p2.data){
	                curr.bottom = p1;
	                p1=p1.bottom;
	            }
	            else{
	                
	                curr.bottom = p2;
	                p2=p2.bottom;
	            }
	            curr=curr.bottom;
	        }
	        
	        if (p1!=null){
	            curr.bottom = p1;
	        }
	        if(p2!=null){
	            curr.bottom = p2;
	        }
	        
	        return head.bottom;
	    }
}
