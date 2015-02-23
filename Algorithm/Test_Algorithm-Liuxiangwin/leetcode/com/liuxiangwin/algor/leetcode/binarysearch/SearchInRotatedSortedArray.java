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
    /**
     * You may assume no duplicate exists in the array.
     */
	public int search(int[] A, int target) {
		int low = 0;
		int high = A.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (A[mid] == target)
				return mid;
			else {
				if (A[low] <= A[mid]) {
					if (target >= A[low] && target < A[mid]) {
						high = mid - 1;
					} else {
						low = mid + 1;
					}
				} else {
					if (target <= A[high] && target > A[mid]) {
						low = mid + 1;
					} else {
						high = mid - 1;
					}
				}
			}
		}
		return -1;
	}
    /**
     *  if  array contains duplicates element
     */
	public boolean searchDuplicate(int[] A, int target) {
		int low = 0;
		int high = A.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (A[mid] == target)
				return true;
			else if (A[low] != A[high]) {
				if (A[low] <= A[mid]) {
					if (target >= A[low] && target < A[mid]) {
						high = mid - 1;
					} else {
						low = mid + 1;
					}
				} else {
					if (target <= A[high] && target > A[mid]) {
						low = mid + 1;
					} else {
						high = mid - 1;
					}
				}
			} else {//The only difference is here search whole 
				for (int k = low; k < high; k++) {
					if (A[k] == target)
						return true;
				}
				return false;
			}
		}
		return true;
	}
	
	
	public static int search(int array[], int left, int right, int target) {
		int mid = (left + right) / 2;
		if (target == array[mid]) { // Found element
			return mid;
		}
		if (right < left) {
			return -1;
		}

		/*
		 * While there may be an inflection point due to the rotation, either
		 * the left or right half must be normally ordered. We can look at the
		 * normally ordered half to make a determination as to which half we
		 * should search.
		 */
		if (array[left] < array[mid]) { // Left is normally ordered.
			if (array[left] <= target && target <= array[mid]) {
				return search(array, left, mid - 1, target);
			} else {
				return search(array, mid + 1, right, target);
			}
		} else if (array[mid] < array[left]) { // Right is normally ordered.
			if (array[mid] <= target && target <= array[right]) {
				return search(array, mid + 1, right, target);
			} else {
				return search(array, left, mid - 1, target);
			}
		} // Left is either all repeats OR loops around
			// (with the right half being all dups)
		else if (array[left] == array[mid]) { //
			if (array[mid] != array[right]) { // If right half is different,
												// search there
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

	public static int searchWithTarget(int array[], int left, int right,
			int target) {
		int mid = (left + right) / 2;
		if (target == array[mid]) { // Found element
			return mid;
		}
		// { 10, 15, 20, 0, 5}
		// { 50, 5, 20, 30, 40}
		// {2, 2, 2, 4, 2}
		// int[] test = { 4, 5, 6, 7, 0, 1, 2};
		while (left <= right) {
			if (array[mid] < array[right]) {// right is order
				if (array[mid] <= target && target <= array[right]) {
					return searchWithTarget(array, mid + 1, right, target);
				} else {
					return searchWithTarget(array, left, mid - 1, target);
				}
			} else if (array[mid] > array[right]) {// left is order
				if (array[left] <= target && target <= array[mid]) {
					return search(array, left, mid - 1, target);
				} else {
					return search(array, mid + 1, right, target);
				}
			} else if (array[mid] == array[right]) {
				if (array[mid] != array[left]) { // If right half is different,
													// search there
					return searchWithTarget(array, left, mid - 1, target);
				} else {// need search left and righ both
					int result = searchWithTarget(array, left, mid - 1, target);
					if (result == -1) {
						return searchWithTarget(array, mid + 1, right, target);
					} else {
						return result;
					}
				}
			}
		}
		return -1;
	}

	public static int searchMinUnSorted(int[] array) {
		int ans = array[0];
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] <= array[high]) { // #min位于上升沿左侧
				ans = Math.min(ans, array[mid]);
				high = mid - 1;
			} else { // min位于左侧上升沿与右侧上升沿之间//{ 10, 15, 20, 0, 5};
				ans = Math.min(ans, array[low]);
				low = mid + 1;
			}
			// ans = Math.min(ans, array[mid]);
		}
		return ans;
	}

	public static int searchMinDuplicate(int[] array, int low, int high) {
		int ans = array[0];

		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] < array[high]) { // min位于上升沿左侧
				ans = Math.min(ans, array[mid]);// { 50, 5, 20, 30, 40};
				high = mid - 1;

			} else if (array[mid] > array[high]) { // min位于左侧上升沿与右侧上升沿之间
				ans = Math.min(ans, array[low]);// { 10, 15, 20, 0, 5};
				low = mid + 1;

			} else { // array[mid] = array[high]
				low++;
			}
		}
		ans = Math.min(array[low], ans);
		ans = Math.min(array[high], ans);
		return ans;

	}

	public int findMin(int[] array) {

		int low = 0;
		int right = array.length - 1;

		int min = array[0];

		while (low < right) {
			int mid = (low + right) / 2;
			if (mid == low || mid == right)
				break;
			else if (array[low] < array[mid]) {
				min = Math.min(array[low], min);
				low = mid + 1;
			} else if (array[mid] < array[right]) {
				min = Math.min(array[mid], min);
				right = mid - 1;
			} else {
				++low;
			}
		}

		min = Math.min(array[low], min);
		min = Math.min(array[right], min);
		return min;
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 2, 2, 2, 2, 2, 2, 2, 2 };

		System.out.println(search(a, 0, a.length - 1, 2));
		System.out.println(search(a, 0, a.length - 1, 3));
		System.out.println(search(a, 0, a.length - 1, 4));
		System.out.println(search(a, 0, a.length - 1, 1));
		System.out.println(search(a, 0, a.length - 1, 8));

		System.out.println("--------------------");
		int[] test = { 4, 5, 6, 7, 0, 1, 2 };

		System.out.println(search(test, 0, test.length - 1, 2));
		System.out.println(searchWithTarget(test, 0, test.length - 1, 2));

		System.out.println("--------------------");
		int[] test2 = { 10, 15, 20, 0, 5 };
		int[] test3 = { 50, 5, 20, 30, 40 };
		int[] test4 = { 2, 3, 2, 4, 2 };
		System.out.println(searchWithTarget(test2, 0, test2.length - 1, 5));
		System.out.println(searchWithTarget(test3, 0, test3.length - 1, 5));
		System.out.println(searchWithTarget(test4, 0, test4.length - 1, 3));

		System.out.println("--------------------");
		int[] b = { 10, 15, 20, 0, 5 };
		System.out.println("searchMinUnSorted noduplicate "
				+ searchMinUnSorted(b));

		int[] c = { 50, 5, 20, 30, 40 };
		System.out.println("searchMinUnSorted noduplicate "
				+ searchMinUnSorted(c));

		System.out.println("--------------------");
		System.out.println("------search  min with duplicate--------------");

		int[] test5 = { 3, 5, 6, 3, 0, 1, 3 };
		System.out.println("the min array in array "
				+ searchMinDuplicate(test5, 0, test5.length - 1));

	}
}
