package in.ineuron.questions;
/*
 	**Question 2**

	A number **N** is represented in Linked List such that each digit corresponds 
	to a node in linked list. You need to add 1 to it.

	Example 1:
	Input:
	LinkedList: 4->5->6
	Output:457
	
	Example 2:
	Input:
	LinkedList: 1->2->3
	Output:124

 */
class Node {
	public int val;
	public Node next;

	public Node(int val) {
		this.val = val;
	}
}

public class Question02 {
	static Node reverse(Node head)
    {
        Node prev = null;
        Node curr = head;
        while(curr != null)
        {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public static Node addOne(Node head) 
    { 
        head=reverse(head);
        int carry=1;
        Node curr=head;
        Node dummy=new Node(0);
        Node end=dummy;
        while(curr!=null)
        {
            int sum=(curr.val+carry)%10;
            carry=(curr.val+carry)/10;
            Node temp=new Node(sum);
            end.next=temp;
            end=end.next;
            if(carry==0)
            {
                temp.next=curr.next;
                break;
            }
            if(curr.next==null && carry!=0)
            {
                Node t=new Node(carry);
                end.next=t;
            }
            curr=curr.next;
        }
        head=dummy.next;
        head=reverse(head);
        return head;

    }
}
