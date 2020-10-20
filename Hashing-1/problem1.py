// Time Complexity :O(nlogn)*O(n) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : 
Have to go through the prime method


// Your code here along with comments explaining your approach

sort the key and place the equivalent element in the value as list 
return the list 



class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        
        
        res={}
        l=[]
        
        for i in strs:
            if ''.join(sorted(i)) not in res:
                res[''.join(sorted(i))]=[i]
                
            else:
                res[''.join(sorted(i))].append(i)
        
        
        for k in res.values():
            l.append(k)
            
        return l
