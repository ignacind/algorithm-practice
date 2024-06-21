class MinStack:

    def __init__(self):
        self.stack = list()
        self.minStack = list()

    def __str__(self):
        return str(self.stack)

    def push(self, val):
        self.stack.append(val)
        if not self.minStack:
            self.minStack.append(val)
        else:
            self.minStack.append(min(self.minStack[-1], val))

    def pop(self):
        self.stack.pop()
        self.minStack.pop()

    def top(self):
        return self.stack[-1]

    def getMin(self):
        return self.minStack[-1]

