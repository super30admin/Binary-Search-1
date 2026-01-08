//
//  SearchInUnknownSizedTotatedSortedArray.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 12/31/25.
//


class SearchInUnknownSizedRotatedSortedArray {
    
    
    /*
     //Naive approach - iterate over the whole array. O(n) complexity for linear search.
     low = 0, high = pow(2, 31) - 1, can reduce but space & time complexity will be too much
     
     Final approach - take a low & high pointer. low = 0, high = 1. Check if the element is within the range [low, high].
     If it's not, low = high, high = 2 * high - check if the element exist within that range. ....and go on
     apply binary search algorithm
     
     time complexity = O(log K) where k - range which was used to apply the binary search algorithm
     time complexity of doubling the range - O(log m), m is the range to find the element
     wither you decrease the search space  by half or increase by half, time complexity will be logarithmic.
     
     While doubling down the range, if we go out of bounds, pow(2, 31) - 1 will be returned. Since it's greater than the target, we will update "high to mid - 1". If new mid is out of bounds, then again "high = mid - 1". Doing so will take you withing the range. Hence, we can find the target even if we go out of bounds.
     
     We have to maintain a balance between by what factor we have to increase the range and in what range we are applying the binary search. Then the time complexity will be O(log m) + O(log k)
     If we increase the range by factor 3 or greater, the range on which to apply the binary search will be applied will be reduced. But the greater time complexity will be considered the complexity of the algorithm.
     */
   
    
    func search(target: Int) -> Int {
        var low = 0
        var high = 1
        while (high < target) {
            low = high
            high = 2 * high
        }
        while (low < high) {
            let mid = low + (high - low) / 2
            if (mid == target) {
                return mid
            } else if (mid > target) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return -1
    }
    
    init() {
        let index = search(target: 5)
        print("index \(index)")
    }
}
