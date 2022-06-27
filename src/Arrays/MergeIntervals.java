package Arrays;

import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] arr) {
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);

        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < pairs.length; i++) {
            if (i == 0) {
                st.push(pairs[i]);
            } else {
                Pair top = st.peek();
                Pair curr = pairs[i];

                if (curr.st > top.et) {
                    st.push(curr);
                } else {
                    top.et = Math.max(top.et, pairs[i].et);
                }
            }
        }

        Stack<Pair> rs = new Stack<>();
        while (st.size() > 0) {
            rs.push(st.pop());
        }
        int[][] retArr = new int[rs.size()][2];
        int i = 0;
        while (rs.size() > 0) {
            Pair p = rs.pop();
            retArr[i][0] = p.st;
            retArr[i][1] = p.et;
            i++;
        }
        return retArr;
    }
    public static class Pair implements Comparable<Pair> {
        int st;
        int et;

        public Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }

        public int compareTo(Pair other) {
            if (this.st != other.st) {
                return this.st - other.st;
            } else {
                return this.et - other.et;
            }
        }
    }


    private static ArrayList<List< Integer >> merge(ArrayList <List< Integer >> intervals) {

        Collections.sort(intervals, (a, b) -> a.get(0) - b.get(0));
        ArrayList < List < Integer >> merged = new ArrayList < > ();

        for (int i = 0; i < intervals.size(); i++) {
            if (merged.isEmpty() || merged.get(merged.size() - 1).get(1) < intervals.get(i).get(0)) {
                ArrayList < Integer > v = new ArrayList < > ();
                v.add(intervals.get(i).get(0));
                v.add(intervals.get(i).get(1));

                merged.add(v);
            } else {

                merged.get(merged.size() - 1).set(1, Math.max(merged.get(merged.size() - 1).get(1), intervals.get(i).get(1)));

            }
        }

        return merged;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 6}};
        int[][] returnArray = merge(arr1);

        for (int i = 0; i < returnArray.length; i++) {

            System.out.print(returnArray[i][0] + " ");
            System.out.print(returnArray[i][1] + " ");
            System.out.println();
        }


        //-------------------------------------------------------------------------------------------------
        ArrayList < List < Integer >> arr = new ArrayList < > ();
        arr.add(Arrays.asList(new Integer[]{1,3}));
        arr.add(Arrays.asList(new Integer[]{2,4}));
        arr.add(Arrays.asList(new Integer[]{2,6}));
        arr.add(Arrays.asList(new Integer[]{8,9}));
        arr.add(Arrays.asList(new Integer[]{8,10}));
        arr.add(Arrays.asList(new Integer[]{9,11}));
        arr.add(Arrays.asList(new Integer[]{15,18}));
        arr.add(Arrays.asList(new Integer[]{16,17}));
        ArrayList < List < Integer >> ans = merge(arr);
        System.out.println("Merged Overlapping Intervals are ");
        for (List < Integer > it: ans) {
            System.out.println(it.get(0) + " " + it.get(1));
        }

    }
}
