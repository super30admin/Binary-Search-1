// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/*
Input: array = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Input: array = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
*/

class SearchInAnInfiniteSortedArray {
    public int search(ArrayReader reader, int target) {
        int left=0,right=1,mid=0;
        while(reader.get(right)<target){  //if the element at right index is less than the target we left shift the index value of right
            right<<=1;
        }
        left=right>>1;  // we update left by shifting right by 1 bit so that we have the target value between left and right
        while(left<=right){
            mid=left+(right-left)/2;
            if(reader.get(mid)==target) return mid;
            if(reader.get(mid)<target)  left=mid+1; //update the left so as to skip the elements which are not required to search
            else    right=mid-1;  //update the left so as to skip the elements which are not required to search
        }
        return -1;
    }
}
