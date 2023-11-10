// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : got wrong with operations ><= in initial try


// Your code here along with comments explaining your approach in three sentences only

//as array is rotated there should be one half sorted array 
const search = function(nums, target) {
    let low = 0,high = nums.length - 1
    while(low <= high){
        let mid =low + Math.floor((high - low)/2)
        if(nums[mid] === target) return mid
        if(nums[low] <= nums[mid]){
            //left sort by checking mid and low
            if(nums[low] <= target && target < nums[mid]){
                //since left sort target should btw low and mid
                high = mid-1
            }else{
                low = mid +1
            }
        }
        else{
            if(nums[mid] < target && target <= nums[high]){
               low = mid+1
            }else{
                high = mid -1
            }
        }
    }
    return -1

};

let nums = [4,5,6,7,0,1,2]
let target = 0
const result = search(nums,target);

console.log(`Index of ${target}: ${result}`); 

