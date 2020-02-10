class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
        {
            return -1;
        }
        return binarySearch(nums, 0, nums.length-1, target);
    }
    private int binarySearch(int arr[], int l, int h, int target)
    {
    if(h < l) return -1;
    int m = l+(h-l)/2;
    if (arr[m] == target)
        return m; 
    if (arr[l] <= arr[m])
    {
        if (arr[l] <= target && target <= arr[m])
            h=m-1;
        else
            l=m+1;
    }
    else
    {
        if (arr[m] < target && target <= arr[h])
            l=m+1;
        else
            h=m-1;
    }
        return binarySearch(arr, l, h, target);
}
}
