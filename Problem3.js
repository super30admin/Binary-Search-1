// Search in Infinite sorted array: 
// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach in three sentences only
let search = (reader,target) =>{
    // Time Complexity : O(log(n))
// Space Complexity : O(1)
    let left = 0
    let right = 1
    //while value we are at is less than target we keep on pushing 2 pointers
    while(reader.get(right)<target){
        left = right
        right = right*2
    }
    //We are out of while loop as, right is now greater than target 
    //and left is less than target
    //Hence now we perform the binary search
    while (left<=right) {
        let mid = Math.floor(left + (right - left) / 2)
        if(reader.get(mid) == target){
            return mid
        }
        else if(reader.get(mid) < target){
            left = mid+1
        }
        else{
            right = mid-1
        }

    }
    return -1
}