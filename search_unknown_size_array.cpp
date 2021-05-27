// Time Complexity : O(2*logn) //Depending on size of element
// Space Complexity : O(n) //In-place
// Did this code successfully run on Leetcode : Not yet done on Leetcode. Will subscribe to Premium :)
// Any problem you faced while coding this 

#include<iostream>
#include<vector>
#include<math.h>

using namespace std;

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

int main()
{
    vector<int> nums {1,3,5,8,13,17,20,25,36,39,41,48,54,62,64,69,73};
    int target;
    int exp;

    cout << endl << "Enter Target  ";
    cin >> target;

    exp = 1;

    while(target > nums[pow(2,exp) - 1])
    {
        exp++;
    }

    cout << exp << endl;

    int index = binarySearch(nums, 0, pow(2,exp)-1, target);

    cout << index << endl;

    return 0;
}