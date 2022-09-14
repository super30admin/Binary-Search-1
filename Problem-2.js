//Ran Successfully on leetCode - solution accepted
//Time: O(log(n)) n is the length of the array, Space O(1)
var search = function(nums, target) {
    let low = 0, high = nums.length-1;
    while(low<=high){
        let mid = low + Math.floor((high-low)/2);
        if(nums[mid] == target){
            return mid;
        }
        if(nums[low] <= nums[mid]){
            if(target >= nums[low] && target < nums[mid]){ 
                high = mid - 1
            }else{
                low = mid + 1
            }
        }else{
            if(target <= nums[high] && target > nums[mid]){
                 low = mid + 1
               }else{
                high = mid - 1
            }
        } 
    }
    return -1
};