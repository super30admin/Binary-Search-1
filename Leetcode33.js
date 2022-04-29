// Time Complexity : O(log n) since it's binary search
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach : It's straightforward binary approach as mentioned in question itself that need algorith with O(log n) approach which is binary search itself.So followed same approach divided array into 2 halfs.started indexing from 0 to mid and from mid to extreme right until target is not equivalent to index of mid.

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    var left = 0,right = nums.length-1;
    while(left<=right)
    {
       var mid = Math.floor((left+right)/2);
        if(nums[mid]===target)
        
          { return mid;}
        
        
        if(nums[left]<=nums[mid])
        {
            if(nums[left]<=target && target<=nums[mid])
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }
        else 
        {
            if(nums[mid]<=target && target<=nums[right])
            {   
                left = mid+1;
                
            }
            else
            {
                right = mid-1;
            }
        }
    }
    return -1;
};