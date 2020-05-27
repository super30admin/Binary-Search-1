// Time Complexity :O(log n)
// Space Complexity :o(n) n-length of the array
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach
class SearchInfiniteArray
{
public int end(int arr[],int target)
{
	int start=1;
	while(start<arr.length) 
	{
		if(arr[start]>=target)// finding the end for the binary search
		{
			break;
		}
		start*=2;
	}
	return start<arr.length-1?start:arr.length-1;//If the end is greater than arr.length then return arr.length
}

public int search(int arr[],int target)
{
    if(target==arr[0])
    return 0;
	int end=end(arr,target);
	int start=end/2; // calculating start
	
	//performing Binary Search
	while(start<=end)
	{
		int mid=start+(end-start)/2;
	
		if(arr[mid]==target)
			return mid;
		else if(target<arr[mid])
			end=mid-1;
		else
			start=mid+1;
	}
	return -1;
}

public static void main(String args[])
{
	SearchInfiniteArray s=new SearchInfiniteArray();
	int arr[]={2,4,8,12,15,19,23,26,50,55,57,60,70,300,400};
	int target=577;
	int result=s.search(arr,target);
	if(result!=-1)
	System.out.println("Element found at "+ result );
	else
	System.out.println("Element not found");
		
}
}