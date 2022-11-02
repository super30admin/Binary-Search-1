/*
    Time Complexity = O(logN)
    Space Complexity = O(1)
    Did this code successfully run on Leetcode : yes
 */


package com.madhurima;

interface ArrayReader{
    public int get(int index);
}


public class SearchArrayUnkownSize implements ArrayReader{

    int[] arr;

    public SearchArrayUnkownSize(int[] arr){
        this.arr = arr;
    }

    @Override
    public int get(int index) {
        if(index < arr.length){
            return arr[index];
        }else{
            return Integer.MAX_VALUE;
        }
    }

}

class Solution2 {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(target > reader.get(high)){
            low = high;
            high = high * 2; // increasing high in power of two making it logN
        }

        return binarySearch(reader, target, low, high);
    }

    private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target){
                return mid;
            }else if(target < reader.get(mid)){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        int target = 9;
        Solution2 s = new Solution2();
        SearchArrayUnkownSize array = new SearchArrayUnkownSize(arr);
        System.out.println(s.search(array,target));
    }
}
