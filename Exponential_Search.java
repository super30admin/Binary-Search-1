/* Time Complexity : 
Assuming the position of element = i
If we perform k steps to reach the range where A[i] is located  (i = 2^k -> the last position) = (2^k) steps
=> k = log i
To perform binary search once we reach the range => O(log i) where i is the position of the target.
Total Time complexity = O(k) steps + O (log i) binary search = O(log i) +  O(log i) = O(log i) 

This is called Exponential search. We can increase the interval by constant, etc but exponentially yields us the better time complexity.
*/
// Space Complexity : O(1) iterative approah
// Did this code successfully run on Leetcode : Pseudo Code
// Any problem you faced while coding this : Referred the internet but its a good question (understood)

/* Your code here along with comments explaining your approach
Start with 0 and the upper bound, you can take some constant C. Increment end by C interval till you find the element that belongs
to your range. You can increment exponentially to yield better search complexity. Once the number comes in range, do a Binary search.
*/

public int infiniteArray(int A[], int target){
    int start = 0, end = 1;
    while(A[end] < target){
        start = end;
        end = 2 * end;
    }
    return  BinarySearch(start, end, target, A);
}

public int BinarySearch(int start, int end, int target, int nums[]){
    while(start <= end){
     int mid = ((start+end)/2);
     if(nums[mid] == target){
         return mid;
     } else if(nums[mid] > target) {
         end = mid-1;
     } else {
         start = mid + 1;
    }
}
    return -1;
}