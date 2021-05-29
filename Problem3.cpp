// Time Complexity : O(n) for findBinary() and O(log n) for binary Search
// Space Complexity : O(1) no extra space used for any operation 
// Did this code successfully run on Leetcode : Do not have leetcode premium hence couldn't check
// Any problem you faced while coding this : No 


#include<iostream>

using namespace std;

int binarySearch(int arr[], int l, int h, int val){
    int mid = (l + (h-l))/2;    // to avoid integer overflow
    while(l<=h){
        if(arr[mid] == val){
            return mid;
        }
        else if(arr[mid] > val)
            h = mid - 1;
        else 
            l = mid + 1;
    }
    return -1;
}


int findBinary(int arr[], int key){
    int low = 0;
    int high = 1;
    int val = arr[0];

    while(val < key){
        low = high;
        high = high*2;
        val = arr[high];
    }

    return binarySearch(arr,low,high,key);
}
