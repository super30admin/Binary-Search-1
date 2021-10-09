# Min Stack

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.lst = []
        

    def push(self, val: int) -> None:
        if not self.lst:
            self.lst.append((val,val))
        else:
            self.lst.append((val, min(val, self.lst[-1][1])))

    def pop(self) -> None:
        return self.lst.pop()
        

    def top(self) -> int:
        return self.lst[-1][0]
        

    def getMin(self) -> int:
        
        return self.lst[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()