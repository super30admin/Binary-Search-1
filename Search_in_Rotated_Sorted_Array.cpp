// Search_in_Rotated_Sorted_Array.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Time Complexity O(logN), N being number of elemnts in array
// Space complexity o(1)

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        /*find the pivot element (minimum element) position in the array by tweaking binary search algorithm
         compare middle element with right most elemnt of array. if it is greater than nums[size()-1] then 
         search to the right of the mid elemnt else to the left of the mid element. At the end of loop will have the position of pivot elemnt.
        }*/

        //[5,1,2] [6,7,1,2,3,4,5] [5,6,7,8,1,2,3]
        if (nums.size() == 0)
            return -1;
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= nums[right])
                left = mid + 1;
            else
                right = mid;
        }

        //store the pivot element position
        int pivot = left;
        left = 0;
        right = nums.size() - 1;

        /*if target is greater than pivot elemnt search to the 
        right of pivot else to the left of the pivot    */
        if (target >= nums[pivot] && target <= nums[right]) {
            left = pivot;
        }
        else
            right = pivot;

        //Iterative binary search to find the element    
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
};

int main()
{
    //std::cout << "Hello World!\n";
    vector<int> nums{6,7,3,4,5};
    int target = 6;
    Solution s;
    cout << s.search(nums, target) << endl;
   /* cout << s.search(nums, 2) << endl;
    cout << s.search(nums, 3) << endl;
    cout << s.search(nums, 4) << endl;
    cout << s.search(nums, 5) << endl;
    cout << s.search(nums, 6) << endl;
    cout << s.search(nums, 7) << endl;*/
    
    return 0;
}
