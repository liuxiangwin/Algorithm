package com.liuxiangwin.algor.leetcode.list;

public class DeleteRandomNode {
	/**
	 * 首先我们很容易就能得到待删除结点，即B结点的后一个结点C，
	 * 然后将C的值赋值给B结点的值，相当于数组删除时候的覆盖，
	 * 现在B结点和C结点一模一样了，接下来就相当简单了吧，
	 * 我们不删B，直接利用B删掉C就行了，方法简单，时间O(1)。
	 * @param cur
	 */
	private void deleteRandomNode(ListNode cur)
	{
	    //assert(cur != NULL);
	    if(cur.next != null); {
	    	//不能是尾节点
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
