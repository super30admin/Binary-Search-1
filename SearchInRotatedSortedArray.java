package com.BinarySearch1;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {


        int targetIndex = 0;

        for(int num: nums){
            if(num == target){
                return targetIndex;
            }
            targetIndex++;
        }

        return -1;

    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray ss = new SearchInRotatedSortedArray ();
        int[] arr = new int[]{4,5,6,7,0,1,2};
        System.out.println (ss.search (arr,0));
        System.out.println (ss.search (arr,3));
    }
}
