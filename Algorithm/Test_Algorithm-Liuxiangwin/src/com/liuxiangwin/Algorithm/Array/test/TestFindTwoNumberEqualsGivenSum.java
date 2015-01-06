package com.liuxiangwin.Algorithm.Array.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TestFindTwoNumberEqualsGivenSum {

	/**http://www.lifeincode.net/programming/leetcode-two-sum-3-sum-3-sum-closest-and-4-sum-java/
	 * 
	 * The complexity of this method is better than brute force method. 
	 * Sorting the array costs O(nlogn).
	 *  So, for Two Sum, it costs O(nlogn).
	 *  
	 *  For 3 Sum, it costs O(nlogn) +  O(n2) =  O(n2). 
	 *  
	 *  For 4 sum, it costs  O(n3).
	 * 
	 * 
	 * HashMap

		We can use HashMap to improve this algorithm.
		 For example, it can improve Two Sum from O(nlogn) to O(n).
		  That is, saving every number in the HashMap as well as its position. 
		  And then we can go through the array and 
		  check for the existence number target ®C i in O(1). 
		  So we only need O(n). Similarly, with HashMap we can solve 3 Sum in O(n2) and 4
		   Sum in O(n2).
	 * 
	 * Find the two number equals the given sum in the array
	 * with help of supplementary  array
	 */
	//K sum problem
	private static HashMap<Integer, Integer> resultMap  = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sortedArray =   { 1,  2,  4,  7, 11, 15 };		
		int[] compare = { 14, 13, 11, 8, 4, 0 };
		int number = 15;
		// System.out.println(Arrays.toString(findArray(array,number)));

		System.out.println(Arrays.toString(findTwoNumberArray(sortedArray, number)));
		
		int expectNumber=20;
		System.out.println("The sum expect with 15 "+isTwoNumberEqualsExpect(sortedArray, number));
		System.out.println(("The sum expect with 20 "+isTwoNumberEqualsExpect(sortedArray, expectNumber)));
		
		int[] threeSum = {1, 0, -1 ,0 ,-2, 2};
		new ThreeSum().threeSum(threeSum);
		
		int[] threeClosed = {-1, 2 ,1, -4};
		new ThreeSum().threeSumClosest(threeClosed, 2);
		
		

	}

	private static int[] findTwoNumberArray(int[] array, int number) {
		int[] compareArray = new int[array.length];

		for (int k = 0; k < array.length; k++) {
			compareArray[k] = number - array[k];
		}		
		int i = 0;
		int j = array.length - 1;

		while (i != array.length - 1 && j != 0) // focus the conditon
		{
			if (array[i] > compareArray[j]) {
				j--;
			} else if (array[i] < compareArray[j]) {
				i++;
			} else {
				System.out.println("find " + array[i] + " " + compareArray[j]);
				
				resultMap.put(i, array[i]);
				i++;
				j--;

			}
		}
		return null;
	}
	
	
	private static boolean isTwoNumberEqualsExpect(int[] array, int expectSum) {
		int[] compareArray = new int[array.length];

		for (int k = 0; k < array.length; k++) {
			compareArray[k] = expectSum - array[k];

		}
		// Original array 	     [1,   2,  4, 7, 11,15];
		// Allocate compareArray [14, 13, 11, 8, 4, 0];
	    //Compare the two array from beign and end
		//Which element is smaller,then index ++;			     
		//Only the element equals in the two different array,then it is answer
		//while in the two array which is smaller and the move frist
		int i = 0;
		int j = array.length - 1;
		while (i != array.length - 1 && j != 0) 
		{
			if (array[i] > compareArray[j]) {
				j--;
			} else if (array[i] < compareArray[j]) {
				i++;
			} else {
				System.out.println("find " + array[i] + " " + compareArray[j]);
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				map.put(i, array[i]);				
				i++;
				j--;
				return true;

			}
		}

		return false;

	}
	
	
	//Two Sum II - Input array is sorted 
	//http://www.cnblogs.com/higerzhang/p/4189418.html
	/*vector<int> twoSum(vector<int> &numbers, int target){
        vector<int> ans;
        int left = 1, right = numbers.size();

        while(left < right){
            if (numbers[left-1] + numbers[right-1] == target){
                ans.push_back(left);
                ans.push_back(right);
                return ans;
            }else if (numbers[left-1] + numbers[right-1] > target){
                right--;
            }else{
                left++;
            }
        }
        return ans;
    }*/
	//Two Sum III - Data structure design 
	//http://www.cnblogs.com/x1957/p/4186171.html
	
	//http://tech-wonderland.net/blog/summary-of-ksum-problems.html
	//http://www.2cto.com/kf/201310/248433.html
	//http://blog.csdn.net/nanjunxiao/article/details/12524405
	
	/*private  ArrayList<int[]> KSum(int[] num, int K, int target, int start) {
		
		        //List< > vecResults;
		        //ArrayList<int[]> vecResults;
		        ArrayList<ArrayList<Integer>> vecResults = new ArrayList<ArrayList<Integer>>();
		        if (K == 2) { // base case
		            int[] res = new int[2]; 
		            int i = start;////Õ∑÷∏’Î
		            int j = num.length - 1;	//Œ≤÷∏’Î
		            while (i < j) {	
		                if (i > start && num[i] == num[i - 1]) {	
		                    ++i;		
		                    continue;
		                }	
		                int sum = num[i] + num[j];
		                if (sum == target) {	
		                	res[0] = num[i++];	
		                	res[1] = num[j--];	
		                	vecResults.add(res);	
		                }	
		                else if (sum > target) {		
		                    --j;	
		                }	
		                else {	
		                    ++i;		
		                }	
		            }	
		            return vecResults;	
		        }		
		        // K > 2		
		        for (int i = start; i < num.length(); i++) {
		        	
		            if (i > start && num[i] == num[i - 1]) continue;
		
		            ArrayList<int[]> K1Sum = KSum(num, K - 1, target - num[i], i + 1);
	
		            for (auto it = K1Sum.begin(); it != K1Sum.end(); ++it) {
		            	for () {	
		
		                vector<int> tuple;
	
		                tuple.push_back(num[i]);
	
		                tuple.insert(tuple.end(), it->begin(), it->end());
	
		                vecResults.push_back(tuple);
		                vecResults
		            }
	
		        }
		        return vecResults;
		
		    }
*/
	
	
	

	/**
	 * The Complex is N*N
	 * 
	 * @param array
	 * @param check
	 * @return
	 */
	private static int[] findArray(int[] array, int check) {
		int[] tep = null;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				int temp = array[i] + array[i + 1 + j];
				if (temp == check) {
					System.out.println("find " + array[i] + " "
							+ array[i + 1 + j]);
					int[] result = { array[i], array[i + 1 + j] };
					tep = result;

				}
			}
		}
		return tep;
	}

}
	
	/**
	 * Given an array S of n integers, are there elements a, b, c in S such that a +
	 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
	 * 
	 * Note:
	 * 
	 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ?
	 * c) The solution set must not contain duplicate triplets.
	 * 
	 * For example, given array S = {-1 0 1 2 -1 -4},
	 * 
	 * A solution set is: (-1, 0, 1) (-1, -1, 2)
	 */
class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (num.length < 3)
			return result;
		// sort array
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			// //avoid duplicate solutions
			if (i == 0 || num[i] > num[i - 1]) {

				int negate = -num[i];

				int start = i + 1;
				int end = num.length - 1;

				while (start < end) {
					// case 1
					if (num[start] + num[end] == negate) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[start]);
						temp.add(num[end]);

						result.add(temp);
						start++;
						end--;
						// avoid duplicate solutions
						while (start < end && num[end] == num[end + 1])
							end--;

						while (start < end && num[start] == num[start - 1])
							start++;
						// case 2
					} else if (num[start] + num[end] < negate) {
						start++;
						// case 3
					} else {
						end--;
					}
				}

			}
		}

		return result;
	}

	public List<List<Integer>> threeSum_2(int[] num) {
		Arrays.sort(num);
		LinkedList<List<Integer>> ret = new LinkedList<List<Integer>>();
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1;
			int end = num.length - 1;
			while (start < end) {
				if (num[i] + num[start] + num[end] == 0) {
					LinkedList<Integer> oneResult = new LinkedList<Integer>();
					oneResult.add(num[i]);
					oneResult.add(num[start]);
					oneResult.add(num[end]);
					set.add(oneResult);
					start++;
					end--;
				} else {
					if (num[i] + num[start] + num[end] < 0)
						start++;
					else
						end--;
				}
			}
		}
		ret.addAll(set);
		return ret;
	}
	/**
	 *  For example, given array S = {-1 2 1 -4}, and target = 1.

       The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	
	 */
	public int threeSumClosest(int[] num, int target) {
		int closest = num[0] + num[1] + num[2];
		int diff = Math.abs(closest - target);
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1;
			int end = num.length - 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				int newDiff = Math.abs(sum - target);
				if (newDiff < diff) {
					diff = newDiff;
					closest = sum;
				}
				if (sum < target)
					start++;
				else
					end--;
			}
		}
		return closest;
	}
}

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? 
 * 
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d) The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 */
	class FourSum {		
		 public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		        // Start typing your Java solution below
		        // DO NOT write main() function
		        Arrays.sort(num);

		        int i = 0;
		        int z = 1;
		        int j ;
		        int k ;
		        Set set = new HashSet();
		        //= num.length;
		        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		        if (num.length < 4)
		            return res;

		        for (i=0; i < num.length - 3; i++) {
		            for (z=i+1; z < num.length - 2; z++) {
		                int left = target -(num[i] + num[z]);
		                j = z+1;
		                k = num.length - 1;
		                while (j<k) {
		                    if (num[j] + num[k] == left) {
		                        ArrayList<Integer> result = new ArrayList<Integer>();                    
		                        result.add(num[i]);
		                        result.add(num[z]);
		                        result.add(num[j]);
		                        result.add(num[k]);
		                        if (set.add(result))
		                            res.add(result);
		                        j++;
		                        k--;
		                    } else if (num[j] + num[k] < left) {
		                        j++;

		                    } else
		                        k--;
		                }
		            }
		        }
		        return res;
		    }
	}
		