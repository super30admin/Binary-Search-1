// Time Complexity : O(log n) - Binary Search
// Space Complexity : O(1) no extra space
// Did this code successfully run on Leetcode : No, It was Premium problem
// Any problem you faced while coding this : Nothing SPecific, but looking forward to various possible solutions class

//As the size is not known, we take low=0 and h=1 , at each step we try to increase the size(upper limit) by 2 
//until the target is less than element at higher index
//when we find that target value is within the bounds, we do a binary search with those limits

class SearchInfiniteArray{
int binarySearch(int[] arr,int l,int h,int target){
    
    while(l<=h){
    int mid=l+(h-l)/2;
    if(arr[mid]==target) return mid;
    if(arr[mid]>target){
    h=mid-1;
    }
    else{
        l=mid+1;
    }   
    } return -1;
}
 int posUpper(int[] arr, int target){
    int l=0;int h=1;
    int val=arr[l];
    while(val<target){
        l=h;
        h=2*h;
        val=arr[h];
    }
    return binarySearch(arr,l,h,target);
}

}