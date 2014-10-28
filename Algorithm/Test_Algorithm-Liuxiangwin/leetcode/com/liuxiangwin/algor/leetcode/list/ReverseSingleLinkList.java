package com.liuxiangwin.algor.leetcode.list;

public class ReverseSingleLinkList {
     /**
      * 第二种方法就是利用两个指针，分别指向前一个节点和当前节点，
      * 每次做完当前节点和下一个节点的反转后，把两个节点往下移，直到到达最后节点。
      * @param head
      * @return
      * 
      * 第一种方法就是把每个Node按照顺序存入到一个stack里面，
      * 这样，最后面一个就在最上面了。然后，把每一个再取出来，这样顺序就换过来了。
      */
	private  ListNode reverseLinklist(ListNode head) {

		ListNode previous = null;

    	while (head != null) {
    		ListNode nextNode = head.next;
    		head.next = previous;//set the null
    		previous = head;
    		head = nextNode;
    	}
    		
    	return previous;
	}
	
	public void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		ReverseSingleLinkList reverseLinkList = new ReverseSingleLinkList();
		reverseLinkList.printList(head);
		ListNode resultNode =reverseLinkList.reverseLinklist(head);
		reverseLinkList.printList(resultNode);
	}

}
