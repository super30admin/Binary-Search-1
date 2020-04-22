// Time Complexity :
// Space Complexity : 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :Calculating time and space complexities


// Your code here along with comments explaining your approach

#include <iostream>
using namespace std;

int binarysearch(int A[100],int low,int high,int target)
{
    while(low<=high)
    {
        int mid=(low+high)/2;
        if(A[mid]==target)
        return mid;
        else if(A[mid]>target)
            high=mid-1;
        else
            low=mid+1;
    }
    return mid;
}

int main() {
	// your code goes here
	int target=10; //element that has to be searched
	int A[];
	int l=0,r=1; //considering an interval of 3 so that we can identify the upper bound.
	while(target>A[r]) //Runs in exponential order...not sure of time complexity
	{
	    l=r;
	    r=r*2;
	}
	int x=binarysearch(A,l,r,target); //Binary search once we identify our limits which happens in O(logn)
	cout<<x;
	return 0;
}