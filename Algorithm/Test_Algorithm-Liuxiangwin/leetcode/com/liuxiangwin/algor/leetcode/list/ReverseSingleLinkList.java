package com.liuxiangwin.algor.leetcode.list;

public class ReverseSingleLinkList {
     /**
      * �ڶ��ַ���������������ָ�룬�ֱ�ָ��ǰһ���ڵ�͵�ǰ�ڵ㣬
      * ÿ�����굱ǰ�ڵ����һ���ڵ�ķ�ת�󣬰������ڵ������ƣ�ֱ���������ڵ㡣
      * @param head
      * @return
      * 
      * ��һ�ַ������ǰ�ÿ��Node����˳����뵽һ��stack���棬
      * �����������һ�������������ˡ�Ȼ�󣬰�ÿһ����ȡ����������˳��ͻ������ˡ�
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
