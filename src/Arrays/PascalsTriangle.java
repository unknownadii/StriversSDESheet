package Arrays;/*
Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 */


import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> row = null;
        List<Integer> preRow = null;
        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++)
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(preRow.get(j - 1) + preRow.get(j));
            preRow = row;
            list.add(row);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}

