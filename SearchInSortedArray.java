// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : no, question was locked
// Any problem you faced while coding this :

import java.util.Scanner;
import java.util.*;

public class SearchInSortedArray {

    public int search(ArrayReader reader, int target) {
        int high = 0;
        while (reader.get(high) <= target){
            high = high *2;
        }
        int low = high/2;
        int mid =0;
        while (low <= high){
            mid = low + (high - low)/2;
            if (reader.get(mid) == target) return mid;
            else if (reader.get(mid) > target) high = mid -1;
            else low = mid +1;
        }
    }

}
