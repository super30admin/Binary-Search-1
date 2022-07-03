// Time Complexity :O(logn)
// Space Complexity : O(1) constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public int search(ArrayReader reader, int target) {
    int low=0; // setting lower bound because it is fixed
    int high=1; // setting higher bound because it is not fixed but we will increase it logarithmic
    
    while(reader.get(high) < target){ // searching the range in the array in which the 
        low = high; // increasing the lower bound to high
        high *= 2; // doubling the higher bound for logarithmic search
    }
    
    while(low<=high){ // binary search
        int mid = low + ((high-low)/2);
        if(target == reader.get(mid)){
            return mid;
        } else if(target > reader.get(mid)){
            low = mid+1;
        } else{
            high = mid-1;
        }
    }
    return -1;
}