class Solution {
public int search (int[] nums, int target) {
int mid;
int left = 0;
int right = nums.length - 1;
while(left <= right){
mid = (left + right)/2;
if(nums[mid] == target) return mid;
// if left array is sorted
if(nums[left] <= nums [mid]){
if(nums[left] <= target && nums [mid] >= target) right= mid -1;
else left = mid + 1;
}

//right array is sorted
else {
if(nums[right] >= target && nums[mid] <= target) left = mid +1; 
else right = mid - 1;
}
}
return -1;
}
}


class Solution1 {
public int search (int[] nums, int target) { 
return binarySearch(nums, 0 ,nums.length - 1, target);
}
public int binarySearch(int[] nums, int low, int high, int target)
{
// base condition
if(low > high) return -1;
int mid = low + (high-low)/2;
if(nums[mid] == target) return mid;
if(nums[low] <= nums[mid]) // left sorted
{
if(nums[low] <= target && nums [mid] >= target) high = mid-1; 
else low = mid + 1;
} else {
if(nums[mid] <= target && nums[high] >= target) low = mid + 1;
else high = mid - 1;
}
return binarySearch(nums, low, high, target);
}
}