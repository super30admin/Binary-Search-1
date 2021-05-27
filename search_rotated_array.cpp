// Time Complexity : O(2*logn)  Find pivot + Binary Search
// Space Complexity : O(n) - In-place
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this 

// P.S. Will follow up with a better edited and styled code

class Solution {
public:
int binarySearch(vector<int>& arr, int l, int r, int x) 
{   
    if(l == r)
    {
        if(arr[l] == x)
        {
            return l;
        }
        else
        {
            return -1;
        }
    }
    
    //Get the Mid Point
    int m = floor((l + r) / 2);
    
    //Found the element
    if(arr[m] == x)
    {
        return m;
    }
    //Smaller element
    else if(x < arr[m])
    {
        return binarySearch(arr, l, m, x);
    }
    //Larger element
    else
    {
        return binarySearch(arr,m+1, r, x);
    }
    
    cout << "\nShouldn't come here" << endl;
    return -1;
} 
    
    
    int findPivot(vector<int>& nums, int l, int r)
    {
        if(l == r)
        {
            cout << "Problem";
            return -1; //testing
        }
        
        int m = floor((l+r)/2);
        
        if(nums[m] > nums[m+1])
        {
            return m;
        }
        else if(nums[l] > nums[m])
        {
            return findPivot(nums, l, m);
        }
        else if(nums[m+1] > nums[r]) // >
        {
            return findPivot(nums, m+1, r);
        }
        else
        {
            cout << "Shouldn't come here";
            return -1;
        }
    }
    
    
    int search(vector<int>& nums, int target) {
        
        int pivotIdx = findPivot(nums, 0, nums.size()-1);
        
        cout << "pivotIdx  " << pivotIdx;
        
        if(pivotIdx == -1)
        {
            return binarySearch(nums, 0, nums.size()-1, target);
        }
        
        int index = -1;
        
        if(target >= nums[0])
        {
            index = binarySearch(nums, 0, pivotIdx, target);
        }
        else
        {
            index = binarySearch(nums, pivotIdx+1, nums.size()-1, target);
        }
        
        return index;
        
    }
};