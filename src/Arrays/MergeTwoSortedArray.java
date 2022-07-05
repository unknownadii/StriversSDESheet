package Arrays;

public class MergeTwoSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m+n];
        int i = 0;
        int j = 0;
        int k=0;
        while(i<m && j<n) {
            if(nums1[i]<nums2[j]) {
                arr[k] = nums1[i];
                i++;
                k++;
            }
            else if(nums1[i] > nums2[j]) {
                arr[k] = nums2[j];
                j++;
                k++;
            } else if(nums1[i] == nums2[j]){
                arr[k] = nums2[j];
                i++;
                j++;
                k++;
            }
        }
        while(i<m) {
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while(j<n) {
            arr[k] = nums2[j];
            j++;
            k++;
        }

        for(int a = 0;a<arr.length;a++) {
            System.out.print(arr[a]);
        }
    }
    public static void main(String[] args) {
        int arr1[] = {1,2,5};
        int arr2[] = {3,4,5,6,7,8};
        merge(arr1, arr1.length, arr2, arr2.length);
    }
}
