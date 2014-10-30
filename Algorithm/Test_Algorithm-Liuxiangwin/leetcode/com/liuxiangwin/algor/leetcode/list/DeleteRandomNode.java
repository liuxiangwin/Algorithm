package com.liuxiangwin.algor.leetcode.list;

public class DeleteRandomNode {
	/**
	 * �������Ǻ����׾��ܵõ���ɾ����㣬��B���ĺ�һ�����C��
	 * Ȼ��C��ֵ��ֵ��B����ֵ���൱������ɾ��ʱ��ĸ��ǣ�
	 * ����B����C���һģһ���ˣ����������൱���˰ɣ�
	 * ���ǲ�ɾB��ֱ������Bɾ��C�����ˣ������򵥣�ʱ��O(1)��
	 * @param cur
	 */
	private void deleteRandomNode(ListNode head,ListNode cur)
	{
	    if(cur.next != null){
	    	//������β�ڵ�
		    ListNode next = cur.next;
		    cur.val = next.val;
		    cur.next = next.next;
		    next=null;
	    }
	    else {	// ���p��ĩβ���, ���ҵ�p��ǰһ�����Ȼ������ɾ��
            while(head.next != cur)
            {
            	head = head.next;            
            }	 
            // deleted pToBeDeleted
            head.next = null;
            cur=null;
	          
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
