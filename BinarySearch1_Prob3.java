class Solution
{
public int search(ArrayReader reader, int target)
{
// doubling the index of high since the array is of unknown size

// TC - O(logn)
//SC - O(1) - no extra space
int low = 0,high = 1;

while(reader.get(high) <= target)
{
low = high;
high = high*2;
}
return binarySearch(reader,target,low,high);
}

// creating a binary search method to perform the standard search

private int binarySearch(ArrayReader reader,int target,int low, int high)
{
while(low<=high)
{
int mid = low + (high-low)/2;

if(reader.get(mid) == target)
    return mid;
else if(reader.get(mid) > target)
    high = mid - 1;
else
    low = mid+1;
}
}
}
