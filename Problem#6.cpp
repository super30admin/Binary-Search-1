#include <iostream>

using namespace std;

// Binary search using recursive function 
int binarySearch(int sortedarr[], int start, int end, int target) 
{ 
    if (end>=start) 
    { 
        int mid = start + (end - start)/2; 
        if (sortedarr[mid] == target) 
            return mid; 
        if (sortedarr[mid] > target) 
            return binarySearch(sortedarr, start, mid-1, target); 
        return binarySearch(sortedarr, mid+1, end, target); 
    } 
    return -1; 
} 

int findPos(int sortedarr[], int key) 
{ 
    int start = 0, end = 1; 
    int val = sortedarr[0]; 
  
    // Find end to do binary search 
    while (val < key) 
    { 
        start = end;            // store previous high 
        end = 2*end;            // double high index 
        val = sortedarr[end];   // update new val 
    } 
  
    return binarySearch(sortedarr, start, end, key); 
}

// Driver program 

int main() 
    { 
        int sortedarr[] = {3, 10, 7, 9, 10, 90, 100, 130,  
                               10, 160, 170}; 
        int ans = findPos(sortedarr, 10); 
        if (ans==-1) 
            cout << "Element not found"<<endl; 
        else

            cout << "Element found at index " << ans<<endl; 
        return 0; 
    } 