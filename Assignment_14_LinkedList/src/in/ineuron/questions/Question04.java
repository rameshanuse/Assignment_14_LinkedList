package in.ineuron.questions;

import java.util.HashMap;
/*
	Question 4
	You are given a special linked list with **N** nodes where each node has a next pointer 
	pointing to its next node. You are also given **M** random pointers, where you will be 
	given **M** number of pairs denoting two nodes 
	**a** and **b**  **i.e. a->arb = b** (arb is pointer to random node)**.**
	Construct a copy of the given list. The copy should consist of exactly **N** 
	new nodes, where each new node has its value set to the value of its corresponding 
	original node. Both the next and random pointer of the new nodes should point to new nodes 
	in the copied list such that the pointers in the original list and copied list represent the 
	same list state. None of the pointers in the new list should point to nodes in the original 
	list.
	For example, if there are two nodes **X** and **Y** in the original list, 
	where **X.arb** **-->** **Y**, then for the corresponding two nodes **x** and **y** in 
	the copied list, **x.arb --> y. Return the head of the copied linked list.
	
	Example 1:
	Input:
	N = 4, M = 2
	value = {1,2,3,4}
	pairs = {{1,2},{2,4}}
	
	Output:1
	Explanation:In this test case, there
	are 4 nodes in linked list.  Among these
	4 nodes,  2 nodes have arbitrary pointer
	set, rest two nodes have arbitrary pointer
	as NULL. Second line tells us the value
	of four nodes. The third line gives the
	information about arbitrary pointers.
	The first node arbitrary pointer is set to
	node 2.  The second node arbitrary pointer
	is set to node 4.

 */
class Clone {
    //Function to clone a linked list with next and random pointer.
    int size(Node head){
        int count= 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    Node copyList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            map.put(temp,new Node(temp.data));
            temp = temp.next;
        }
        temp = head;
        Node nh = null;
        Node tail = null;
        while(temp != null){
            if(nh == null){
                nh = map.get(temp);
                tail = nh;
            }else{
                tail.next = map.get(temp);
                tail = tail.next;
            }
            temp = temp.next;
        }
        // System.out.println(size(nh)+" "+ "hell");
        temp = head;
        tail = nh;
        while(temp != null){
            if(temp.arb != null){
                tail.arb = map.get(temp.arb);
            }
            temp = temp.next;
            tail = tail.next;
        }
        return nh;
        
    }
}
