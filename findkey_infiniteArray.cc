// Time Complexity : Order log but n not defined
// Space Complexity : O(1) since we are not initializing data structure
// Did this code successfully run on Leetcode : Runs on my terminal
// Any problem you faced while coding this : None
#include <bits/stdc++.h>

int binarySearch(int low, int high, std::vector<int>& nums, int target){
	if(low > high){
		return -1;
	}
	int mid = low + (high - low)/2;
	if(nums[mid] == target){
		return mid;
	}
	else if(nums[low] <= target && target < nums[mid]){
		return binarySearch(low, mid - 1, nums, target);
	}
	else{
		return binarySearch(mid + 1, high, nums, target);
	}
}

int main(){
	std::vector<int> nums = {3,5,6,9,11,14,17,19,23,25,32,45,64,68,72,76,84,90,95,98,100};
	int target = 19;
	int slow = 0;
	int fast = 1;
	while(nums[fast] < target){
		slow = fast;
		fast = 2 * fast;
	}
	std::cout << "Searched target " << target << " found at position: " << binarySearch(slow, fast, nums, target) << "\n";
	return 0;
}
