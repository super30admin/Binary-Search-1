/**
 * Time Complexity : O(log(N) where N is total length of the input stream
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */

public class SearchInInfiniteSortedArray {
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7,8};
        ArrayReader reader = new ArrayReader(arr);
        int target = 2;

        System.out.println(Search.searchInStream(reader, target));
    }
}

class Search {
    public static int searchInStream(ArrayReader reader, int target) {
        int left = 0, right = 1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            int num = reader.get(mid);
            if(num == target){
                return mid;
            }else{
                if(target < num){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                    if(target > reader.get(right)){
                        right = right * 2;
                    }
                }
            }
        }
        return -1;
    }
}

class ArrayReader {

    int[] arr;
    public ArrayReader(int[] arr){
        this.arr = arr;
    }

    public int get(int index) {
        if(arr.length >= index){
            return Integer.MAX_VALUE;
        }else{
            return this.arr[index];
        }
    }
}
