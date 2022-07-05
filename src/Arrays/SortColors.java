package Arrays;

public class SortColors {
    public static void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
            }
        }
        int size = count0 + count1 + count2;
        for (int i = 0; i < size; i++) {
            if (i >= 0 && i < count0) {
                nums[i] = 0;
            } else if (i >= count0 && i < count0 + count1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }

    }

    public static void dutchNationalFlagAlgorithm(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        int temp;
        while (mid <= hi) {
            switch (nums[mid]) {
                case 0: {
                    temp = nums[lo];
                    nums[lo] = nums[mid];
                    nums[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = nums[mid];
                    nums[mid] = nums[hi];
                    nums[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 0, 0, 1, 2, 2, 2, 0};
        dutchNationalFlagAlgorithm(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
