class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        return f"ListNode{{val: {self.val}, next: {self.next}}}"