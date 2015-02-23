package com.liuxiangwin.algor.leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;

import com.liuxiangwin.algor.leetcode.uitl.Interval;

public class InsertIntervalVsMergeIntervals {

	/**
	 * Insert Interval��Merge Intervals��һ���������⣬�ȿ�����ôMerge
	 * 
	 * Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * For example, Given [1,3],[2,6],[8,10],[15,18], return
	 * [1,6],[8,10],[15,18].
	 * 
	 * @param args
	 */
	public class MergeIntervals implements Comparator<Interval> {

		public ArrayList<Interval> mergeIntervals(ArrayList<Interval> interList) {
			ArrayList<Interval> result = new ArrayList<Interval>();
			if (interList.size() == 0) {
				return result;
			}
			Collections.sort(interList, new MergeIntervals());

			Interval ref = interList.get(0);
			// [1,3],[2,6],[8,10],[15,18]
			for (int i = 1; i < interList.size(); i++) {
				Interval cur = interList.get(i);
				if (cur.end < ref.start) {
					result.add(cur); // ˭С��˭�Ž�ȥ
				} else if (ref.end < cur.start) {
					result.add(ref); // ˭С��˭�Ž�ȥ
					ref = cur;
				} else {
					// ��ʾ�����������ص��� �ҿ�ʼ����Сֵ�����������ֵ
					ref = new Interval(Math.min(ref.start, cur.start),
							Math.max(ref.end, cur.end));
				}
			}
			result.add(ref);
			return result;
		}

		@Override
		public int compare(Interval i1, Interval i2) {
			if (i1.start == i2.start) {
				return i1.end - i2.end;
			}
			return i1.start - i2.start;
		}

	}

	/**
	 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
	 * [1,5],[6,9].
	 * 
	 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9]
	 * in as [1,2],[3,10],[12,16].
	 * 
	 * @author liuxiangwin
	 *
	 */
	public class InsertInterval {

		public ArrayList<Interval> insert(ArrayList<Interval> interList,
				Interval newInterval) {
			Interval ref = newInterval;
			ArrayList<Interval> result = new ArrayList<Interval>();

			for (Interval current : interList) {
				if (current.end < ref.start) {
					result.add(current);
				} else if (ref.end < current.start)
				{
					result.add(ref);// ref��С��Ԫ�� Ȼ��ֱ�Ӱ�ref�ӽ�ȥ Ȼ��ref��Ϊcurrent
					ref = current;
				} else {
					ref = new Interval(Math.min(ref.start, current.start),
							Math.max(ref.end, current.end));
				}
			}
			result.add(ref);
			return result;
		}
	}

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(3, 4));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(1, 10));

		System.out
				.println(new InsertIntervalVsMergeIntervals().new MergeIntervals()
						.mergeIntervals(intervals));

		ArrayList<Interval> intervals2 = new ArrayList<Interval>();
		intervals2.add(new Interval(1, 3));
		intervals2.add(new Interval(6, 9));
		// intervals.add(new Interval(1,10));

		System.out
				.println(new InsertIntervalVsMergeIntervals().new InsertInterval()
						.insert(intervals2, new Interval(2, 5)));

	}

}
