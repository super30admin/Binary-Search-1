// Search in Infinite sorted array: 

// Time Complexity : O(log(n))
// Space Complexity : O(1)


// Given a sorted array of unknown length and a number to search for,
// return the index of the number in the array. Accessing an element out of 
// bounds throws exception. If the number occurs multiple times, return the index of any occurrence. 
// If it isn’t present, return -1.
//there is no function to know the length of array

function search(arr, target) {
      let right = 1;
      let left = 0
      while(arr[right] < target) {
          right *= 2; 
      }
  
      while(left <= right) {
          mid = Math.floor((left + right) / 2);
          if(arr[mid] > target) right--;
          if(arr[mid] === target) return mid;
          else if(arr[mid] > target) {
              right = mid - 1; 
          }
          else {
              left = mid + 1;
          }
      }
      return -1;
  }
  
  search([1,2,3,4,8,100], 8)