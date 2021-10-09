# Design HashSet

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.lst = []
        

    def add(self, key: int) -> None:
        if key not in self.lst:
            self.lst.append(key)
        

    def remove(self, key: int) -> None:
        if key in self.lst:
            self.lst.remove(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        if key in self.lst:
            return True
        else:
            False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)