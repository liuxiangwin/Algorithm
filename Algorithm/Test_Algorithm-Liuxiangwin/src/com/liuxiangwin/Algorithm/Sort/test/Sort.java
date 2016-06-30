package com.liuxiangwin.Algorithm.Sort.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

public class Sort {
	public static void main(String[] args) {
		testSuc(); // �ɹ�����
		testRun(10000, 100000, 10000); // ���ܲ���
	}

	public static void testRun(int start, int end, int step) {
		for (int i = start; i <= end; i = step + i) {
			final int[] data = ArrayUtils.toPrimitive(getRundom(i, true));
			BubbleSort(data);
			SelectSort(data);
			InsertSort(data);
			radixSort(data); // ��������ֻ���ţ���������
			MergeSort(data);
			InsertSplitSort(data);
			HeapSort(data);
			QuickSort(data);
			System.out.println("");
		}
	}

	public static void testSuc() {
		final int[] data = ArrayUtils.toPrimitive(getRundom(50, true));
		System.out.println(Arrays.toString(data));
		System.out.println("��������:");
		System.out.println(Arrays.toString(InsertSort(data)));
		System.out.println(Arrays.toString(InsertSplitSort(data)));
		System.out.println("ѡ������:");
		System.out.println(Arrays.toString(SelectSort(data)));
		System.out.println(Arrays.toString(HeapSort(data)));
		System.out.println("��������:");
		System.out.println(Arrays.toString(BubbleSort(data)));
		System.out.println(Arrays.toString(QuickSort(data)));

		System.out.println(Arrays.toString(MergeSort(data)));
		System.out.println(Arrays.toString(radixSort(data))); // ��������ֻ���ţ���������
	}

	// ======================================

	public static int[] InsertSort(int[] sz) {
		int[] data = sz;
		long beginTime = System.currentTimeMillis();
		for (int i = 1; i < data.length; i++) {
			for (int j = i; (j > 0) && (data[j] < data[j - 1]); j--) {
				swap(data, j, j - 1);
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.print("ֱ�Ӳ���[" + (endTime - beginTime) + "]\t\t");
		return data;
	}

	public static int[] InsertSplitSort(int[] sz) {
		int[] data = sz;
		long beginTime = System.currentTimeMillis();
		for (int i = 1; i < data.length; i++) {
			int tmp = data[i];
			int min = 0;
			int big = i - 1;
			while (big >= min) {
				int mid = (min + big) / 2;
				if (tmp > data[mid]) {
					min = mid + 1;
				} else {
					big = mid - 1;
				}
			}
			for (int j = i; j > min; j--) {
				data[j] = data[j - 1];
			}
			data[big + 1] = tmp;
		}
		long endTime = System.currentTimeMillis();
		System.out.print("�۰����[" + (endTime - beginTime) + "]\t\t");
		return data;
	}

	public static int[] BubbleSort(int[] sz) {
		int[] data = sz;
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j <= data.length - 1; j++) {
				if (data[i] > data[j]) {
					swap(data, i, j);
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.print("ð��[" + (endTime - beginTime) + "]\t\t");
		return data;
	}

	public static int[] SelectSort(int[] sz) {
		int[] data = sz;
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < data.length; i++) {
			int beginIndex = i;
			for (int j = data.length - 1; j > i; j--) {
				if (data[j] < data[beginIndex]) {
					beginIndex = j;
				}
			}
			swap(data, i, beginIndex);
		}
		long endTime = System.currentTimeMillis();
		System.out.print("ѡ��[" + (endTime - beginTime) + "]\t\t");
		return data;
	}

	public static int[] HeapSort(int[] sz) {
		int[] data = sz;
		long beginTime = System.currentTimeMillis();
		int n = data.length;
		for (int i = n / 2; i >= 0; i--) {
			keepHeap(data, n, i);
		}
		while (n > 0) {
			swap(data, 0, n - 1);
			keepHeap(data, --n, 0);
		}
		long endTime = System.currentTimeMillis();
		System.out.print("������[" + (endTime - beginTime) + "]\t\t");
		return data;
	}

	private static void keepHeap(int[] a, int n, int i) {
		int x = a[i];
		int j = 2 * i + 1;
		while (j <= n - 1) {
			if (j < n - 1 && a[j] < a[j + 1])
				++j;
			if (a[j] > x) {
				a[i] = a[j];
				i = j;
				j = 2 * i;
			} else {
				break;
			}
		}
		a[i] = x;
	}

	public static int[] ShellSort(int[] sz) {
		int[] data = sz;
		long beginTime = System.currentTimeMillis();
		int span = data.length / 7;
		if (span == 0)
			span = 1;
		while (span >= 1) {
			for (int i = 0; i < span; i++) {
				for (int j = i; j < data.length; j = j + span) {
					// ����ֱ�Ӳ�������
					int p = j - span;
					int temp = data[j];
					while (p >= 0 && data[p] > temp) {
						data[p + span] = data[p];
						p -= span;
					}
					data[p + span] = temp;
				}
			}
			span = span / 2;
		}
		long endTime = System.currentTimeMillis();
		System.out.print("ϣ��[" + (endTime - beginTime) + "]\t\t");
		return data;
	}

	private static int[] QuickSort(int[] sz) {
		int[] data = sz;
		long beginTime = System.currentTimeMillis();
		int begin = 0;
		int end = data.length - 1;
		if (begin < end) {
			// ȡ�е�
			int mid = (begin + end) / 2;
			if (data[end] < data[begin]) {
				swap(data, end, begin);
			}
			if (data[end] < data[mid]) {
				swap(data, end, mid);
			}
			if (data[mid] < data[begin]) {
				swap(data, mid, begin);
			}
			int min = begin + 1;
			int big = end;
			while (true) {
				while (min < big && data[min] < data[begin]) {
					min++;
				}
				while (min < big && data[big] >= data[begin]) {
					big--;
				}
				if (min >= big) {
					break;
				}
				swap(data, min, big);
			}
			if (data[begin] > data[min]) {
				swap(data, begin, min);
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.print("����[" + (endTime - beginTime) + "]\t\t");
		return data;
	}

	public static int[] MergeSort(int[] sz) {
		int[] data = sz;
		long beginTime = System.currentTimeMillis();
		int[] result = merge_sort(data, 0, data.length - 1);
		for (int i = 0; i < result.length; i++) {
			data[i] = result[i];
		}
		long endTime = System.currentTimeMillis();
		System.out.print("�鲢[" + (endTime - beginTime) + "]\t\t");
		return data;
	}

	private static int[] merge_sort(int[] array, int start, int end) {
		int[] result = new int[end - start + 1];
		if (start < end) {
			int mid = (start + end) / 2;
			int[] left = merge_sort(array, start, mid);
			int[] right = merge_sort(array, mid + 1, end);
			result = merge(left, right);
		} else if (start == end) {
			result[0] = array[start];
			return result;
		}
		return result;
	}

	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				result[k++] = left[i++];
			} else {
				result[k++] = right[j++];
			}
		}
		while (i < left.length) {
			result[k++] = left[i++];
		}
		while (j < right.length) {
			result[k++] = right[j++];
		}
		return result;
	}

	public static int[] radixSort(int[] sz) {
		int[] data = sz;
		long beginTime = System.currentTimeMillis();
		// ����ȷ�����������;
		int max = data[0];
		for (int i = 1; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}
		int time = 0;
		// �ж�λ��;
		while (max > 0) {
			max /= 10;
			time++;
		}
		// ����10������;
		List<ArrayList> queue = new ArrayList<ArrayList>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> queue1 = new ArrayList<Integer>();
			queue.add(queue1);
		}
		// ����time�η�����ռ�;
		for (int i = 0; i < time; i++) {
			// ��������Ԫ��;
			for (int j = 0; j < data.length; j++) {
				// �õ����ֵĵ�time+1λ��;
				int x = data[j] % (int) Math.pow(10, i + 1)
						/ (int) Math.pow(10, i);
				ArrayList<Integer> queue2 = queue.get(x);
				queue2.add(data[j]);
				queue.set(x, queue2);
			}
			int count = 0;// Ԫ�ؼ�����;
			// �ռ�����Ԫ��;
			for (int k = 0; k < 10; k++) {
				while (queue.get(k).size() > 0) {
					ArrayList<Integer> queue3 = queue.get(k);
					data[count] = queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.print("����[" + (endTime - beginTime) + "]\t\t");
		return data;
	}

	// ====== ����λ�� ===============================
	private static void swap(int[] data, int x, int y) {
		int temp = data[x];
		data[x] = data[y];
		data[y] = temp;
	}

	// ====== ��ȡ����� ===============================
	private static Integer[] getRundom(long num, boolean math) { // math==true
																	// ֻΪ����
		List<Integer> list = new ArrayList<Integer>();
		for (long i = 0; i < num; i++) {
			int k;
			if (Math.random() > 0.5) {
				k = (int) (Math.random() * Integer.MAX_VALUE);
			} else {
				k = (int) (Math.random() * Integer.MIN_VALUE);
				if (math)
					k = (int) (Math.random() * Integer.MAX_VALUE);
			}
			list.add(k);
		}
		return list.toArray(new Integer[list.size()]);
	}
	// 1.�ȶ��ԱȽ�
	//
	// ��������ð�����򡢶��������򡢶�·�鲢�������������������ȶ���
	//
	// ѡ������ϣ�����򡢿������򡢶������ǲ��ȶ���
	//
	// 2.ʱ�临���ԱȽ�
	//
	// ��������ð������ѡ�������ʱ�临����ΪO(n2)
	//
	// ���������������ʱ�临����ΪO(nlog2n)
	//
	// ���������ʱ�临����ΪO(n);
	//
	// 3.�����ռ�ıȽ�
	//
	// �������򡢶�·�鲢����ĸ����ռ�ΪO(n),��������ĸ����ռ�ΪO(1);
	//
	// 4.�����Ƚ�
	//
	// ���롢ð��������ٶȽ��������μ���������оֲ�����������ʱ�����������ܴﵽ�Ͽ���ٶȡ�
	//
	// ��������������£��������򷴶����ˡ�
	//
	// ��n��Сʱ�����ȶ��Բ���Ҫ��ʱ����ѡ�����򣬶��ȶ�����Ҫ��ʱ���ò����ð������
	//
	// ��������ļ�¼�Ĺؼ�����һ���������޷�Χ��ʱ,�ҿռ���������Ͱ����
	//
	// ��n�ϴ�ʱ���ؼ���Ԫ�رȽ���������ȶ���ûҪ�����ÿ�������
	//
	// ��n�ϴ�ʱ���ؼ���Ԫ�ؿ��ܳ��ֱ���������ģ����ȶ�����Ҫ��ʱ���ռ����������¡�
	//
	// ���ù鲢����
	//
	// ��n�ϴ�ʱ���ؼ���Ԫ�ؿ��ܳ��ֱ���������ģ����ȶ���û��Ҫ��ʱ���ö�����
	//
	// *************************************************************************************

}