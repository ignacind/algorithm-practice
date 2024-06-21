class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.prev = self.next = None

class LRUCache:

    def __init__(self, capacity):
        self.cache = {} # {key: node}
        self.capacity = capacity
        self.left, self.right = Node(0, 0), Node(0, 0) # Left= LRU / Right= Most Recent
        self.left.next, self.right.prev = self.right, self.left

    def remove_node(self, node): # remove node from list
        prev, next = node.prev, node.next
        prev.next, next.prev = next, prev

    def insert_node(self, node): # insert node at Right
        prev, next = self.right.prev, self.right
        prev.next = next.prev = node
        node.prev, node.next = next, prev

    def get(self, key):
        if key not in self.cache: return -1

        return self.cache[key].val

    def put(self, key, value):
        if key in self.cache:
            self.remove_node(self.cache[key])
        self.cache[key] = Node(key, value)
        self.insert_node(self.cache[key])

        if len(self.cache) > self.capacity:
            lru = self.left.next
            self.remove_node(lru)
            del self.cache[lru.key]