#include<bits/stdc++.h>

class Solution {
public:
    int binarySearch (std::vector <int> arr, int low, int high, int target){
        
        while (low <= high) {
            int mid = (low+high)/2;
            
            if (arr[mid] == target) return mid;
            
            if (arr[mid] > target)
                high = mid -1;
            else
                low = mid + 1;
        }
        return -1;
    }
    
    int SearchArry(std::vector<int> arr, int target) {
        int s = 0, e = 1;

        while (arr[e] < target){
            s = e+1;
            e = e*2;
        }

        return binarySearch(arr, s, e, target);
        
    }
};