// Time Complexity: O(log m) + O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only


public int searchMatrix(ArrayReader reader, int target) {
    int low = 0; 
    int high = 1;
    while(reader.get(high) < target){ //log m
        low = high;
        high = 2 * high;
    }
    while(low<=high){ //log N
        int mid=low+(high-low)/2;
        if(reader.get(mid) == target){
            return mid;
        }else if(reader.get(mid) > target){
            high = mid - 1;
        }else{
            low = mid + 1;
        }
    }
    return -1;
}