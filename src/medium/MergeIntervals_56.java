package medium;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 心得: 要多使用排序
 */
public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0||intervals.length ==1){
            return intervals;
        }
        //先将二维数组排序，按第一列排序，int[]a, int[]b的第一个元素相等，则按照第二个元素排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]){
                    return a[1] - b[1];
                }else {
                    return a[0] - b[0];
                }
            }
        });

        List<int[]> newList = new ArrayList<>();
        int i = 0;
        int[] interval1 = intervals[i];
        int[] interval2;
        i++;
        while (i < intervals.length) {
            interval2 = intervals[i];
            //比如[1,5],[3,6], 5比2大，interval1[1]比interval[0]的大，说明重叠，需要合并，
            // 将合并的interval赋值给interval1, 循环下一次
            if (interval1[1] >= interval2[0]) {
                interval1 = new int[]{Math.min(interval1[0],interval2[0]),
                        Math.max(interval1[1],interval2[1])};
            } else {
                //如果[2,6][8,10]没有重叠，则没有interval1什么事了，将其加入到list.
                //将interval2赋值给interval1，循环下一次
                newList.add(interval1);
                interval1 = interval2;
            }
            i++;
        }
        newList.add(interval1);
        int[][]newArray = new int[newList.size()][2];
        for (int j = 0; j < newList.size(); j++) {
            newArray[j] = newList.get(j);
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {3,5},{15,18}};
        MergeIntervals_56 mergeIntervals = new MergeIntervals_56();
        mergeIntervals.merge(intervals);
    }
}
