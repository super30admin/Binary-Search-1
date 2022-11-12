import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


//Time Complexity - O(logn)
//Space Complexity - O(1)
//Couldn't test it on Leetcode, as it is a premium question
/*Similar to normal Binary Search only need to use arrayreader instead of arrays*/
public class SearchInfiniteSortedArray {
    //https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

   
    public static int search(ArrayReader reader, int target){
        if(reader==null) return -1;
        int start = 0;
        int end = 9999-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target==reader.get(mid)) return mid;
            if(target>reader.get(mid)) start= mid+1;
            else end = mid-1;

        }
        return -1;
    }

}
