/*
 * Time Complexity : O(log(n))
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No


 ? Your code here along with comments explaining your approach
   I start with an initial guess for the upper bound for example
   1 and double the index until you either find an element greater
   than the target or trigger an out-of-bounds exception.
   This step helps in finding a range within which the target
   might exist. Then do a binary search on that range to find
   the target.
*/

// Simple binary search algorithm
int binarySearch(int arr[], int l, int r, int x)
{
    if (r>=l)
    {
        int mid = l + (r - l)/2;
        if (arr[mid] == x)
            return mid;
        if (arr[mid] > x)
            return binarySearch(arr, l, mid-1, x);
        return binarySearch(arr, mid+1, r, x);
    }
    return -1;
}

// function takes an infinite size array and a key to be
//  searched and returns its position if found else -1.
// We don't know size of arr[] and we can assume size to be
// infinite in this function.
// NOTE THAT THIS FUNCTION ASSUMES arr[] TO BE OF INFINITE SIZE
// THEREFORE, THERE IS NO INDEX OUT OF BOUND CHECKING
int findPos(int arr[], int key)
{
    int l = 0, h = 1;
    int val = arr[0];

    // Find h to do binary search
    while (val < key)
    {
        l = h;        // store previous high
        h = 2*h;      // double high index
        val = arr[h]; // update new val
    }

    // at this point we have updated low and
    // high indices, Thus use binary search
    // between them
    return binarySearch(arr, l, h, key);
}