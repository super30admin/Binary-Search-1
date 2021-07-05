class Solution(object):
    def wordPattern(self, pattern, strings):
        """
        Split the strings and store them in a list
        create a hashmap to store character of pattern and corresponding string
        check len of s and len of t and len of set of s and len of set of t
        iterate through all the characters and store their corresponding value in the hashmap if it does not exist
        while iterating, if we find that key again, verify the value in hashmap is equal to the current value of list string
        """
        list_str = strings.split(' ')
        # print(list_str)
        # print(set(pattern))
        # print(len(set(pattern)))
        # print(set(list_str))
        if len(pattern) != len(list_str):
            return False
        
        if len(set(pattern)) != len(set(list_str)):
            return False
        
        lookup = {}
        for i in range(len(pattern)):
            if pattern[i] not in lookup:
                lookup[pattern[i]] = list_str[i]
                print(lookup)
            else:
                if lookup[pattern[i]] != list_str[i]:
                    return False
        return True

obj = Solution()
pattern , string =  "abba", "dog cat cat dog"
print(obj.wordPattern(pattern, string))