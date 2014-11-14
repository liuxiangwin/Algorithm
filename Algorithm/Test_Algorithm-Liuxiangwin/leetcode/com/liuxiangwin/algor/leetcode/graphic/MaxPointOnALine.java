package com.liuxiangwin.algor.leetcode.graphic;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class MaxPointOnALine {
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		}

		int maxCnt = 1;
		// select a starting point
		for (int i = 0; i < points.length; i++) {
			Map<Double, Integer> map = new HashMap<Double, Integer>();
			int duplicateCnt = 0; // the # of duplicate points
			int localMaxCnt = 0; // the maximum count for a starting point
			
			// select an ending point
			for (int j = 0; j < points.length; j++) {
				if (i == j)
					continue;
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					duplicateCnt++;
				} else {
					double slope;
					if (points[i].x != points[j].x) {
						slope = (double) (points[i].y - points[j].y)
								/ (points[i].x - points[j].x);
					} else {
						slope = Double.MAX_VALUE;

					}
					if (map.containsKey(slope)) {
						int count = map.get(slope) + 1;
						map.put(slope, count);
						localMaxCnt = Math.max(localMaxCnt, count);
					} else {
						map.put(slope, 1);
						localMaxCnt = Math.max(localMaxCnt, 1);
					}
				}
			}
			// add the # of duplicate points and itself
			localMaxCnt += duplicateCnt + 1;
			maxCnt = Math.max(localMaxCnt, maxCnt);
		}
		return maxCnt;
	}
}