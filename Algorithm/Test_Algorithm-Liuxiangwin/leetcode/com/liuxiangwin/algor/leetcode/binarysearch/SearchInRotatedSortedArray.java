package com.liuxiangwin.algor.leetcode.binarysearch;
/**
 * 
 * @author liuxiangwin
 * 
 * Array1:{ 10, 15, 20, 0, 5}
 * Array2:{ 50, 5, 20, 30, 40}
 * 
 * 这个数组的中间元素是20,数组有一半元素是按照正常顺序排列的
 * Array1 中左侧元素(10)和中间元素(20) 10<20 左半边按照正常顺序
 * 
 * 
 * {2,  2, 2, 3,4, 2}
 *  如果左侧元素和中间元素完全相同，我们需要检查最右边的
 *  元素是否相同，如不同可以只搜索右边，否则两边都得搜索
 */
public class SearchInRotatedSortedArray {
	public static int search(int array[], int left, int right, int target) {
		int mid = (left + right) / 2;
		if (target == array[mid]) { // Found element
			return mid;
		}
		if (right < left) {
			return -1;
		}
		
		/* While there may be an inflection point due to the rotation, either the left or 
		 * right half must be normally ordered.  We can look at the normally ordered half
		 * to make a determination as to which half we should search. 
		 */
		if (array[left] < array[mid]) { // Left is normally ordered.
			if ( array[left]<= target && target <= array[mid]) { 
				return search(array, left, mid - 1, target);
			} else {
				return search(array, mid + 1, right, target);
			}
		} else if (array[mid] < array[left]) { // Right is normally ordered.
			if (array[mid]<= target && target <= array[right]) {
				return search(array, mid + 1, right, target);
			} else {
				return search(array, left, mid - 1, target);
			}				
		} else if (array[left] == array[mid]) { // Left is either all repeats OR loops around (with the right half being all dups)
			if (array[mid] != array[right]) { // If right half is different, search there
				return search(array, mid + 1, right, target);
			} else { // Else, we have to search both halves
				int result = search(array, left, mid - 1, target); 
				if (result == -1) {
					return search(array, mid + 1, right, target); 
				} else {
					return result;
				}
			}
		}
		return -1;
	}
	
	public static int findMin(int[] array) {
		int ans = array[0];
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] <= array[high]) // #min位于上升沿左侧
				high = mid - 1;
			else { // min位于左侧上升沿与右侧上升沿之间
				low = mid + 1;	
			}
			ans = Math.min(ans, array[mid]);
		}
		return ans;

	}
	
	
	public static int findMin(int[] array) {
		
	}(self, num):
	        mid, l, h = 0, 0, len(num) - 1
	        while num[l] >= num[h]:
	            if h - l <= 1:
	                return num[h]
	            mid = (l+h) >> 1
	            if num[mid] == num[l]:
	                l += 1
	            elif num[mid] > num[l]:
	                l = mid
	            elif num[mid] == num[h]:
	                h -= 1
	            else:
	                h = mid
	        return num[l]
	
	
	
	public static void main(String[] args) {
		int[] a = { 2, 3, 2, 2, 2, 2, 2, 2 , 2 , 2 };

		System.out.println(search(a, 0, a.length - 1, 2));
		System.out.println(search(a, 0, a.length - 1, 3));
		System.out.println(search(a, 0, a.length - 1, 4));
		System.out.println(search(a, 0, a.length - 1, 1));
		System.out.println(search(a, 0, a.length - 1, 8));
		
		System.out.println("--------------------");
		int[] b = { 10, 15, 20, 0, 5};
		System.out.println(findMin(b));
		
		int[] c = { 50, 5, 20, 30, 40};
		System.out.println(findMin(c));
		
	}
}
