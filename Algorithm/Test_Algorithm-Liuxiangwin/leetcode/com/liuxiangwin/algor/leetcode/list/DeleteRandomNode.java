package com.liuxiangwin.algor.leetcode.list;

public class DeleteRandomNode {
	/**
	 * �������Ǻ����׾��ܵõ���ɾ����㣬��B���ĺ�һ�����C��
	 * Ȼ��C��ֵ��ֵ��B����ֵ���൱������ɾ��ʱ��ĸ��ǣ�
	 * ����B����C���һģһ���ˣ����������൱���˰ɣ�
	 * ���ǲ�ɾB��ֱ������Bɾ��C�����ˣ������򵥣�ʱ��O(1)��
	 * @param cur
	 */
	private void deleteRandomNode(ListNode cur)
	{
	    //assert(cur != NULL);
	    if(cur.next != null); {
	    	//������β�ڵ�
		    ListNode pNext = cur.next;
		    cur.val = pNext.val;
		    cur.next = pNext.next;
		    pNext=null;
	    }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
