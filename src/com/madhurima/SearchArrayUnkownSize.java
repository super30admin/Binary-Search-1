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
        int high = 9999;
        int mid;
        Integer err = 2147483647;

        while(low <= high){
            mid = low + (high - low)/2; //to prevent integer overflow

            if(target == reader.get(mid)){
                return mid;
            }

            if(reader.get(mid) == err || target <= reader.get(mid)){
                high = mid - 1;
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
