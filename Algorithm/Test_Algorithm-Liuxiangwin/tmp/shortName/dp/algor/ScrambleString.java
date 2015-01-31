package shortName.dp.algor;
/** 
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 *
 * Below is one possible representation of s1 = "great":
 *
 *      great
 *     /    \
 *    gr    eat
 *   / \    /  \
 *  g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 *
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 *
 *       rgeat
 *      /    \
 *     rg    eat
 *    / \    /  \
 *   r   g  e   at
 *             / \
 *            a   t
 * We say that "rgeat" is a scrambled string of "great".
 *
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 *
 *       rgtae
 *      /    \
 *     rg    tae
 *    / \    /  \
 *   r   g  ta  e
 *         / \
 *        t   a
 * We say that "rgtae" is a scrambled string of "great".
 *
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
//http://blog.unieagle.net/2012/10/23/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Ascramble-string%EF%BC%8C%E4%B8%89%E7%BB%B4%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92/
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		if (s1.equals(s2))
			return true;

		int[] A = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			++A[s1.charAt(i) - 'a'];
		}

		for (int j = 0; j < s2.length(); j++) {
			--A[s2.charAt(j) - 'a'];
		}

		for (int k = 0; k < 26; k++) {
			if (A[k] != 0)
				return false;
		}

		for (int i = 1; i < s1.length(); i++) {
			boolean result = isScramble(s1.substring(0, i), s2.substring(0, i))
					&& isScramble(s1.substring(i), s2.substring(i));
			result = result
					|| (isScramble(s1.substring(0, i),
							s2.substring(s2.length() - i, s2.length())) && isScramble(
							s1.substring(i), s2.substring(0, s2.length() - i)));
			if (result)
				return true;
		}
		return false;
	}
}