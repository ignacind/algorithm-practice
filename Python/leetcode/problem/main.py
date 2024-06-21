import collections
import math
import ntpath
import random
from collections import *
from functools import cmp_to_key
from math import *
from leetcode.Class.TreeNode import TreeNode
from leetcode.Class.ListNode import ListNode

MAX_32BITS = 2 ** 31 - 1
MIN_32BITS = -2 ** 31



def twoSum(nums, target):
    seen = {}
    for i in range(len(nums)):
        if target - nums[i] in seen:
            return [seen[target - nums[i]], i]
        seen[nums[i]] = i


def palindromeInt(x):
    num = 0
    copy = x
    while x != 0:
        num = num * 10 + x % 10
        x = x // 10
    return num == copy


def romanToint(s):
    dic = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    result = 0

    for i in range(len(s)):
        if i + 1 < len(s) and dic[s[i]] < dic[s[i + 1]]:
            result += - dic[s[i]]
        else:
            result += dic[s[i]]
    return result


def longestCommonPrefix(strs):
    prefix = strs[0]

    for s in strs[1:]:
        while prefix != s[0:len(prefix)]:
            prefix = prefix[:-1]

            if len(prefix) == 0:
                return ""
    return prefix


# print(longestCommonPrefix(["flower","flow","flight"]))

def validParentheses(s):
    if len(s) < 2:
        return False
    closeToOpen_brackets = {')': '(', '}': '{', ']': '['}
    stack = []
    for b in s:
        if b in closeToOpen_brackets:
            if stack and stack[-1] == closeToOpen_brackets[b]:
                stack.pop()
            else:
                return False
        else:
            stack.append(b)

    return True if not stack else False


# print(validParentheses("()[]{}"))


def removeDuplicates(nums):
    k = 1
    for i in range(1, len(nums)):
        if nums[i] != nums[i - 1]:
            nums[k] = nums[i]
            k += 1
    return k


# print(removeDuplicates([1, 1, 2, 2, 4, 6]))

def plusOne(digits):
    strings = ""
    for d in digits:
        strings += str(d)
    numSum = str(int(strings) + 1)
    return [int(x) for x in numSum]


# print(plusOne([4,9,9,9]))

# def climbStairs(n):
#     if n == 1:
#         return 1
#     if n == 2:
#         return 2
#
#     return climbStairs(n-1) + climbStairs(n-2)

def climbStairs(n):
    one, two = 1, 1

    for i in range(n - 1):
        temp = one
        one += two
        two = temp

    return one


# print(climbStairs(4))

def mergeSortedArrays(nums1, m, nums2, n):
    i, f, k = 0, 0, 0
    temp = nums1.copy()
    while i < m and f < n:
        if temp[i] < nums2[f]:
            nums1[k] = temp[i]
            i += 1
        else:
            nums1[k] = nums2[f]
            f += 1
        k += 1

    while i < m or f < n:
        if i < m:
            nums1[k] = temp[i]
            i += 1
        else:
            nums1[k] = nums2[f]
            f += 1
        k += 1


# mergeSortedArrays(nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3)

def showPascalTriangle(numRows):
    '''Print Pascal's triangle with numRows.'''
    for i in range(numRows):
        print(' ' * (numRows - i), end='')
        # compute power of 11
        print(' '.join(str(11 ** i)))


def pascalTriangle(numsRow):
    triangle = [[1]]

    for i in range(numsRow - 1):
        temp = [0] + triangle[-1] + [0]
        triangle.append([])
        for j in range(len(triangle[i]) + 1):
            triangle[i + 1].append(temp[j] + temp[j + 1])

    return triangle


# print(pascalTriangle(1))
def maxProfit(prices):
    # day_profit = {}
    # price = prices[0]
    # for i in range(len(prices)):
    #     profit = -price
    #     if profit + prices[i] > 0:
    #         day_profit[prices[i] + profit] = i + 1
    #
    #     if price > prices[i] and i != len(prices) - 1:
    #         price = prices[i]
    #
    # if not day_profit:
    #     return 0
    #
    # return max(day_profit)
    l, r = 0, 1  # left = buy, right = sell
    maxProf = 0
    while r < len(prices):
        if prices[l] < prices[r]:
            maxProf = max(maxProf, prices[r] - prices[l])
        else:
            l = r  # Best solution
        r += 1

    return maxProf


# print(maxProfit([4, 2, 5, 1, 6, 8]))


def isPalindromeSTR(s):
    # s = ''.join([x for x in s if x.isalnum()]).lower()
    # print(s)
    # j = len(s) - 1
    #
    # for i in range(len(s)):
    #     if s[i] == s[j]:
    #         j -= 1
    #     else:
    #         return False
    #
    # return True
    s = ''.join([x for x in s if x.isalnum()]).lower()
    return s == s[::-1]


# print(isPalindromeSTR(s="A man, a plan, a canal: Panama"))

def singleNumber(nums):
    xor = 0  # n ^ 0 = n
    for num in nums:
        xor ^= num
        print(xor)
    return xor


# print(singleNumber([4,1,2,1,2]))

def majorityElement_Dictionary(nums):
    hashMap = {}
    for i in nums:
        hashMap = hashMap.get(i, 0) + 1
    elem = max(hashMap, key=hashMap.get)

    return elem if hashMap.get(elem) > len(nums) / 2 else None


# print(majorityElement_Dictionary([2,2,1,1,1,2,2]))

def majorityElement_BooyerMoore(nums):
    res, count = 0, 0
    for n in nums:
        res = n if count == 0 else res
        count += (1 if n == res else -1)

    return res


# print(majorityElement_BooyerMoore([2, 2, 1, 1, 1, 2, 2]))
def titleToNumber(columnTitle):
    columnTitle = columnTitle[::-1]
    return sum([(ord(columnTitle[i]) - 64) * 26 ** i for i in range(len(columnTitle))])


# print(titleToNumber("AB"))

def reverseBits(n):
    return int((('{0:032b}'.format(n))[::-1]), 2)


# print(reverseBits(0b00000010100101000001111010011100))

def number_1bits(nums):
    suma = 0
    for i in '{0:032b}'.format(nums):
        if i == '1':
            suma += 1
    return suma


# print(number_1bits(0b00000000000000000000000000001011))

def sumSquares(n):  # Usar para Happy Number
    res = 0
    while n > 0:
        res += (n % 10) ** 2
        n //= 10
    return res


def happyNumber_set(n):
    seen = set()
    while n not in seen:
        seen.add(n)
        n = sumSquares(n)
        if n == 1:
            return True
    return False


# print(happyNumber(19))

def hasCycle(head):
    slow, fast = head, head
    while fast and fast.next:
        fast = fast.next.next
        slow = slow.next
        if fast is slow:
            return True
    print(head)

    return False

    # hashSet = set()
    # current = head
    # while True:
    #     if current is None:
    #         return False
    #     current = head.next
    #     head = head.next
    #     if current not in hashSet:
    #         hashSet.add(current)
    #     else:
    #
    #         return True


def happyNumber_LinkedList(n):
    head = ListNode(n)
    dummy = head
    cont = 0
    while cont < 10:
        head.next = ListNode(sumSquares(head.val))
        head = head.next
        cont += 1
        if hasCycle(dummy):
            return False

    return True


# print(happyNumber_LinkedList(19))
# print(happyNumber_LinkedList(2))

def reverseLinkedList_Iterative(head):
    cur, prev = head, None
    while cur:
        temp = cur.next
        cur.next = prev
        prev = cur
        cur = temp

    return prev


def reverseLinkedList_Recursive(head, prev=None):
    if not head:
        return prev

    tail = reverseLinkedList_Recursive(head.next, head)
    head.next = prev
    return tail


# head = ListNode(1)
# dummy = head
#
# head.next = ListNode(2)
# head = head.next
# head.next = ListNode(3)
# head = head.next
# head.next = ListNode(4)
# head = head.next
# head.next = ListNode(5)
# head = head.next
# #print(reverseLinkedList_Iterative(dummy))
# print(reverseLinkedList_Recursive(dummy))

def containsDuplicateBool(nums):
    # nums.sort()
    # k = 1
    # for i in range(1, len(nums)):
    #     if nums[i - 1] == nums[k]:
    #         return True
    #     k += 1
    # return False
    seen = set()
    for i in nums:
        if i in seen:
            return True
        seen.add(i)
    return False


# print(containsDuplicateBool([1, 1, 1, 3, 3, 4, 3, 2, 4, 2]))

def isPalindrome_LinkedList(head):
    # Con lista O(n) en memoria
    # nums = []
    # while head:
    #     nums.append(head.val)
    #     head = head.next
    # return nums == nums[::-1]

    # Con pointers O(1)

    slow, fast = head, head
    # encontrar el medio
    while fast and fast.next:
        fast = fast.next.next
        slow = slow.next

    reversedMid = reverseLinkedList_Iterative(slow)
    left, right = head, reversedMid

    while right:
        if left.val != right.val:
            return False
        left = left.next
        right = right.next
    return True


# head = ListNode(1)
# dummy = head
# head.next = ListNode(2)
# head = head.next
# head.next = ListNode(2)
# head = head.next
# head.next = ListNode(1)
# head = head.next
# print(isPalindrome_LinkedList(dummy))

def isAnagram(s, t):
    sMap = {}
    tMap = {}
    if len(s) != len(t):
        return False
    for char in range(len(s)):
        sMap[s[char]] = sMap.get(s[char], 0) + 1
        tMap[t[char]] = tMap.get(t[char], 0) + 1

    return sMap == tMap


# s = "anagrm❤"
# t = "anagr❤m"
# print(isAnagram(s, t))


def addTwoNumbers(l1, l2):
    l1sum, l2sum = "", ""

    while l1 or l2:
        l1sum += str(l1.val) if l1.val else l1sum
        l2sum += str(l2.val) if l2.val else l2sum
        l1 = l1.next if l1 else None
        l2 = l2.next if l2 else None

    res = str(int(l1sum[::-1]) + int(l2sum[::-1]))
    head = ListNode(int(res[-1]))
    dummy = head
    res = res[:-1]

    while res:
        head.next = ListNode(int(res[-1]))
        head = head.next
        res = res[:-1]

    return dummy


# l1 = ListNode(2)
# head1 = l1
# l1.next = ListNode(4)
# l1 = l1.next
# l1.next = ListNode(3)
# l1 = l1.next
# l2 = ListNode(5)
# head2 = l2
# l2.next = ListNode(6)
# l2 = l2.next
# l2.next = ListNode(4)
# l2 = l2.next
# print(addTwoNumbers(head1, head2))

def length_Longest_Substring(s):
    chars = set()
    res = 0
    i = 0
    for char in s:
        while char in chars:
            chars.remove(s[i])
            i += 1
        chars.add(char)

        res = max(res, len(chars))
    return res


# print(length_Longest_Substring("pwwkew"))

def missingNumber(nums):
    xor = len(nums)

    for i in range(len(nums)):
        xor ^= i ^ nums[i]

    return xor


# print(missingNumber([1,0,3]))

def longestPalindrome_substring(s):
    rPointer = 0
    lPointer = 0

    for i in range(len(s)):
        l, r = i, i
        while l >= 0 and r < len(s) and s[l] == s[r]:
            if r - l > rPointer - lPointer:
                rPointer = r
                lPointer = l
            l -= 1
            r += 1

        l, r = i, i + 1
        while l >= 0 and r < len(s) and s[l] == s[r]:
            if r - l > rPointer - lPointer:
                rPointer = r
                lPointer = l
            l -= 1
            r += 1

    return s[lPointer:rPointer + 1]


# print(longestPalindrome_substring("cbbdza"))


def moveZeroes(nums):
    for i in reversed(range(len(nums))):
        if nums[i] == 0:
            nums.pop(i)
            nums.append(0)

    return nums


# print(moveZeroes([0,0,1]))


def powerOf_Three(n):
    # return math.log(n, 3).is_integer() #USANDO MATH.LOG (LOGARITMO)
    x = 0
    while n > 3 ** x:
        x += 1
    return 3 ** x == n


# return (n>0) and (3**19) % n == 0

# print(powerOf_Three(9))

def reverseString_list(s):
    z = -1
    for i in range(len(s) // 2):
        s[i], s[z] = s[z], s[i]
        z -= 1
    return s


# print(reverseString_list(lista))

def intersect(nums1, nums2):
    counts = {}
    for num in nums1:
        counts[num] = counts.get(num, 0) + 1
    res = []
    for num in nums2:
        if num in counts and counts[num] > 0:
            res.append(num)
            counts[num] -= 1
    return res


# print(intersect([1,2,2,1], [2,2]))

def firstUniqChar(s):
    count = {}
    for char in s:
        count[char] = count.get(char, 0) + 1
    for i in range(len(s)):
        if count[s[i]] == 1:
            return i

    return -1


# print((firstUniqChar("leetcode")))


def reverse32bitsNum(x):
    x = str(x)
    if x[0] == '-':
        x = - int(x[1:][::-1])
    else:
        x = int(x[::-1])
    if x > (2 ** 31) - 1 or x < (-2 ** 31):
        return 0
    return x


# print(reverse32bitsNum(123))
def myAtoi(s):
    s = s.strip()

    if not s or (s[0] not in ['+', '-'] and not s[0].isdigit()):
        return 0

    sign = -1 if s[0] == '-' else 1
    if s[0] in ['+', '-']:
        s = s[1:]

    res = 0
    for char in s:
        if not char.isdigit():
            break
        res = res * 10 + int(char)

    res *= sign

    return max(min(res, 2 ** 31 - 1), -2 ** 31)


# print(myAtoi("   -42"))


def letterCombinations(digits):
    num_letter = {"2": "abc",
                  "3": "def",
                  "4": "ghi",
                  "5": "jkl",
                  "6": "mno",
                  "7": "pqrs",
                  "8": "tuv",
                  "9": "wxyz"}
    combinations = []

    def backtracking(comb, digits):
        if len(digits) == 0:
            combinations.append(comb)
        else:
            for char in num_letter[digits[0]]:
                backtracking(comb + char, digits[1:])

    backtracking("", digits)

    return combinations


# print(letterCombinations("23"))
# output = ["ad","ae","af","bd","be","bf","cd","ce","cf"]

def removeNode_fromEnd(head, n):
    # if n == 1 and not head.next: # Esta solucion Es O(2n)
    #     return head.next
    #
    # def reverseList(head):
    #     cur, prev = head, None
    #     while cur:
    #         temp = cur.next
    #         cur.next = prev
    #         prev = cur
    #         cur = temp
    #     return prev
    #
    # head = reverseList(head)
    # if n == 1:
    #     return reverseList(head.next)
    #
    # cur = head
    # count = 1
    #
    # while cur and cur.next:
    #     if count + 1 == n:
    #         cur.next = cur.next.next
    #     cur = cur.next
    #     count += 1
    #
    # return reverseList(head)
    dummy = ListNode(0)
    dummy.next = head
    fast = slow = dummy

    for i in range(n):
        fast = fast.next

    while fast.next:
        fast = fast.next
        slow = slow.next

    slow.next = slow.next.next

    return dummy.next


# head = ListNode(1)
# dummy = head
# head.next = ListNode(2)
# head = head.next
# head.next = ListNode(3)
# head = head.next
# head.next = ListNode(4)
# head = head.next
# head.next = ListNode(5)
# head = head.next
# print(removeNode_fromEnd(dummy, 2))

def generateParenthesis(n):
    combinations = []

    def backtracking(cOpen, cClose, comb):  # c = Count
        if cOpen + cClose == n * 2:
            combinations.append(comb)
        else:
            backtracking(cOpen + 1, cClose, comb + '(') if cOpen < n else cOpen
            backtracking(cOpen, cClose + 1, comb + ')') if cClose < cOpen else cClose

    backtracking(0, 0, "")

    return combinations


# print(generateParenthesis(3))

def needle_In_Haystack(haystack, needle):
    # res_index = -1
    # for i in range(len(haystack)):
    #     j = 0
    #     pointer = i
    #     while pointer < len(haystack) and j < len(needle) and haystack[pointer] == needle[j]:
    #         if j == len(needle) - 1:
    #             res_index = pointer - (len(needle) - 1)
    #         j += 1
    #         pointer += 1
    #
    #     if res_index != -1:
    #         break
    #
    # return res_index
    return haystack.find(needle)  # Solucion con find


# print(needle_In_Haystack("sadbutsad", "sad"))

def divide_withoutDivision(dividend, divisor):
    # quotient = 0
    # div_sor = abs(divisor)
    # divi_dend = abs(dividend)
    # while divi_dend >= div_sor:
    #     divi_dend -= div_sor
    #     quotient += 1
    #
    # quotient = -quotient if (dividend<0 and divisor>= 0) or (divisor<0 and dividend>= 0) else quotient
    # return min(max(quotient, MIN_32BITS), MAX_32BITS)

    negative = (dividend > 0) ^ (divisor > 0)
    dividend, divisor = abs(dividend), abs(divisor)
    quotient = 0
    temp = 0
    for i in range(31, -1, -1):
        if temp + (divisor << i) <= dividend:
            temp += (divisor << i)
            quotient |= 1 << i
    if negative:
        quotient *= -1

    return max(min(quotient, MAX_32BITS), MIN_32BITS)


# print(divide_withoutDivision(10, 3))

def maxArea(height):
    area = 0
    l, r = 0, len(height) - 1
    while l < r:
        area = max(area, (r - l) * min(height[l], height[r]))
        if height[l] < height[r]:
            l += 1
        else:
            r -= 1

    return area


# print(maxArea([1,2,1]))

def ThreeSum(nums):
    res = []
    nums.sort()

    for i in range(len(nums)):

        if nums[i] > 0:
            break
        l, r = i + 1, len(nums) - 1

        if i > 0 and nums[i] == nums[i - 1]:
            continue

        while l < r:
            ans = nums[i] + nums[l] + nums[r]
            if ans > 0:
                r -= 1
            elif ans < 0:
                l += 1
            else:
                res.append([nums[i], nums[l], nums[r]])
                l += 1

                while l < r and nums[l] == nums[l - 1]:
                    l += 1

    return res


# print(ThreeSum([-1,0,1,0]))

def twoSumSorted(numbers, target):
    l, r = 0, len(numbers) - 1
    while l < r:
        if numbers[l] + numbers[r] == target:
            return [l + 1, r + 1]
        elif numbers[l] + numbers[r] > target:
            r -= 1
        else:
            l += 1


def search(nums, target):
    l, r = 0, len(nums) - 1

    while l <= r:
        mid = (l + r) // 2
        if target == nums[mid]:
            return mid

        if nums[mid] >= nums[l]:
            if nums[mid] < target or target < nums[l]:
                l = mid + 1
            else:
                r = mid - 1
        else:
            if nums[mid] > target or target > nums[r]:
                r = mid - 1
            else:
                l = mid + 1

    return -1


# print(search([4,5,6,7,0,1,2], target = 0)) # Output = 4

def searchRange(nums, target):
    return [binSearchRange(nums, target, True), binSearchRange(nums, target, False)]


def binSearchRange(nums, target, search_L_R):
    l, r = 0, len(nums) - 1
    i = -1
    while l <= r:
        mid = (l + r) // 2
        if nums[mid] > target:
            r = mid - 1
        elif nums[mid] < target:
            l = mid + 1
        else:
            i = mid
            if search_L_R:
                r = mid - 1
            else:
                l = mid + 1
    return i


# print(searchRange([5,7,7,8,8,10], 8)) # Output = [3, 4]


def valid_Sudoku(board):
    for r in board:
        if not valid_set(r):
            return False
    for c in range(9):
        col = [board[r][c] for r in range(9)]
        if not valid_set(col):
            return False
    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            square = [board[r][c] for r in range(i, i + 3) for c in range(j, j + 3)]
            if not valid_set(square):
                return False
    return True


def valid_set(nums):
    nums = [n for n in nums if n != '.']
    return len(nums) == len(set(nums))


# board = \
# [["5","3",".",".","7",".",".",".","."]
# ,["6",".",".","1","9","5",".",".","."]
# ,[".","9","8",".",".",".",".","6","."]
# ,["8",".",".",".","6",".",".",".","3"]
# ,["4",".",".","8",".","3",".",".","1"]
# ,["7",".",".",".","2",".",".",".","6"]
# ,[".","6",".",".",".",".","2","8","."]
# ,[".",".",".","4","1","9",".",".","5"]
# ,[".",".",".",".","8",".",".","7","9"]]

# print(valid_Sudoku(board))


def permute(nums):
    permutations = []

    def backtracking(comb, nums):
        if len(nums) == 0:
            permutations.append(comb)
        for x in range(len(nums)):
            backtracking(comb + [nums[x]], nums[:x] + nums[x + 1:])

    backtracking([], nums)

    return permutations


# Input: nums = [1,2,3]
# Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
# print(permute([1,2,3]))


def longestConsecutiveSequence(nums):
    numsSet = set(nums)
    length = 0
    for n in nums:
        if n - 1 not in numsSet:
            count = 1
            while n + count in numsSet:
                count += 1
            length = max(length, count)

    return length


# nums = [100, 4, 200, 1, 3, 2]
# print(longestConsecutiveSequence(nums))


def kFrequentElements(nums, k):
    frequent = {}
    res = []
    for n in nums:
        frequent[n] = frequent.get(n, 0) + 1
    for i in range(k):
        elem = max(frequent, key=frequent.get)
        res.append(elem)
        frequent.pop(elem)
    return res


# print(kFrequentElements([1,1,1,2,2,3], k = 2))

def groupAnagrams(strs):
    sMap = {}
    for s in strs:
        std = "".join(sorted(s))
        sMap[std] = sMap.get(std, [])
        sMap[std].append(s)

    res = list(sMap.values())
    return res


# print(groupAnagrams(strs = ["eat","tea","tan","ate","nat","bat"]))
# Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

def productExceptSelf(nums):
    answer = [1] * len(nums)
    prefix = 1
    for i in range(len(nums)):
        answer[i] = prefix
        prefix *= nums[i]
    print(answer)
    postfix = 1

    for i in reversed(range(len(nums))):
        answer[i] *= postfix
        postfix *= nums[i]

    return answer


# print(productExceptSelf([1,2,3,4]))


def canJump(nums):
    goal = len(nums) - 1
    for i in reversed(range(len(nums))):
        if i + nums[i] >= goal:
            goal = i
    return goal == 0


# print(canJump([2,0,1,3]))

def rangeofNumbers(start, end):
    if start > end:
        return []
    arr = rangeofNumbers(start, end - 1)
    arr.append(end)
    return arr


# print(rangeofNumbers(6,9))

def rotateMatrix(matrix):
    l, r = 0, len(matrix) - 1

    while l < r:
        for i in range(r - l):
            top, bottom = l, r

            tempTopLeft = matrix[top][l + i]

            matrix[top][l + i] = matrix[bottom - i][l]

            matrix[bottom - i][l] = matrix[bottom][r - i]

            matrix[bottom][r - i] = matrix[top + i][r]

            matrix[top + i][r] = tempTopLeft
        l += 1
        r -= 1

    return matrix


# matrix = [[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]]
# print(rotateMatrix(matrix))


def searchMatrix2D(matrix, target):
    m, n = len(matrix), len(matrix[0])
    top, bottom = 0, m - 1

    while top <= bottom:
        midRow = (top + bottom) // 2
        if matrix[midRow][-1] < target:
            top = midRow + 1
        elif matrix[midRow][0] > target:
            bottom = midRow - 1
        else:
            break
    l, r = 0, n - 1
    if m == 1:
        midRow = 0
    while l <= r:
        mid = (r + l) // 2
        if matrix[midRow][mid] == target:
            return True
        elif matrix[midRow][mid] < target:
            l = mid + 1
        else:
            r = mid - 1

    return False


# matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
# print(searchMatrix2D(matrix, 3))


def myPow(x, n):
    def recursion(base=x, exponent=abs(n)):
        if exponent == 0:
            return 1
        elif exponent % 2 == 0:
            return recursion(base * base, exponent // 2)
        else:
            return base * recursion(base * base, (exponent - 1) // 2)

    res = recursion()

    return float(res) if n >= 0 else 1 / res


# print(myPow(2.00000, -2))

def maxSubArray(nums):  # Given an integer array nums, find the subarray with the largest sum, and return its sum.
    res = nums[0]
    end_sum = nums[0]
    for i in range(1, len(nums)):
        end_sum = max(nums[i], end_sum + nums[i])
        res = max(res, end_sum)
    return res


# print(maxSubArray(nums = [-2,1,-3,4,-1,2,1,-5,4]))


def mergeIntervals(intervals):
    current = intervals[0]
    res = []
    for i in range(1, len(intervals)):
        nxt = intervals[i]
        if current[1] >= nxt[0]:
            current = [current[0], nxt[1]]
        else:
            res.append([current[0], current[1]])
            current = nxt

    res.append([current[0], current[1]])
    return res


# print(mergeIntervals(intervals = [[1,3],[2,6],[8,10],[15,18]]))

def sortColors(nums):
    l, cur, r = 0, 0, len(nums) - 1

    while cur <= r:

        if nums[cur] == 0:
            nums[l], nums[cur] = nums[cur], nums[l]
            l += 1
            cur += 1
        elif nums[cur] == 2:
            nums[r], nums[cur] = nums[cur], nums[r]
            r -= 1
        else:
            cur += 1
    return nums


# print(sortColors(nums = [2,0,2,1,1,0]))
# OutPut = [0,0,1,1,2,2]

def decodeWays(
        s):  # 91 # A message containing letters from A-Z can be encoded into numbers using the following mapping:
    dp = {len(s): 1}

    def dfs(i):
        if i in dp:
            return dp[i]
        if s[i] == '0':
            return 0
        res = dfs(i + 1)
        if i + 1 < len(s) and int(s[i] + s[i + 1]) <= 26:
            res += dfs(i + 2)
        dp[i] = res
        return res

    return dfs(0)


# print(decodeWays("11106"))


def houseRobber(nums):
    prevRob, curRob = 0, 0
    for n in nums:
        temp = max(n + prevRob, curRob)
        prevRob = curRob
        curRob = temp
    return curRob


# print(houseRobber(nums = [1,2,3,1])) # Output = 4

def sortArrayEVEN_ODD(nums):
    l, curr, r = 0, 0, len(nums) - 1

    while curr <= r:
        if nums[curr] % 2 == 0:
            nums[curr], nums[l] = nums[l], nums[curr]
            curr += 1
            l += 1
        else:
            nums[curr], nums[r] = nums[r], nums[curr]
            r -= 1
    return nums


# print(sortArrayEVEN_ODD(nums = [3,1,2,4]))

def palindromePartitioning(s):
    res = []
    partition = []

    def dfs(i):
        if i >= len(s):
            res.append(partition.copy())

        for j in range(i, len(s)):
            if palindrome(s, i, j):
                partition.append(s[i:j + 1])
                dfs(j + 1)
                partition.pop()

    def palindrome(s, l, r):
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True

    dfs(0)
    return res


# print(palindromePartitioning("aab"))

def spiralMatrix(matrix):
    res = []
    left, top = 0, 0
    right, bottom = len(matrix[0]), len(matrix)

    while left < right and top < bottom:
        # get every i in the top row
        for i in range(left, right):
            res.append(matrix[top][i])
        top += 1
        # get every i in the right column
        for i in range(top, bottom):
            res.append(matrix[i][right-1])
        right -= 1

        if not (left < right and top < bottom):
            break

        # get every i in the bottom row
        for i in reversed(range(left, right)): # for i in range(right-1, left-1, -1):
            res.append(matrix[bottom-1][i])
        bottom -= 1

        # get every i in the left column
        for i in reversed(range(top, bottom)):  # for i in range(bottom-1, top-1, -1):
            res.append(matrix[i][left])
        left += 1

    return res
# res = spiralMatrix(matrix=[[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]])
# print(res)
# Output = [1,2,3,4,8,12,11,10,9,5,6,7]
# print(True if Output == res else False)
'''
[ 1  2  3  4
  5  6  7  8
  9 10 11 12
'''


def subSets(nums):
    res = []
    subset = []
    def dfs(i):
        if i >= len(nums):
            res.append(subset.copy())
            return

        # decision to include nums[i]
        subset.append(nums[i])
        dfs(i + 1)
        # decision NOT to include nums[i]
        subset.pop()
        dfs(i + 1)

    dfs(0)

    # Iterative solution
    '''
def subSets(nums):
    res = [[]]
    for n in nums:
        res += [x + [n] for x in res]
    return res
    '''
    return res

# print(subSets(nums = [1,2,3]))

def matrix_to_zeros(matrix):
    m, n = len(matrix), len(matrix[0])
    rowZero = False
    colZero = False
    for r in range(m):
        for c in range(n):
            if matrix[r][c] == 0:
                if c == 0:
                    colZero = True
                if r == 0:
                    rowZero = True
                matrix[r][0] = 0
                matrix[0][c] = 0

    for r in range(1, m):
        for c in range(1, n):
            if matrix[0][c] == 0 or matrix[r][0] == 0:
                matrix[r][c] = 0
    if rowZero:
        for c in range(n):
            matrix[0][c] = 0
    if colZero:
        for r in range(m):
            matrix[r][0] = 0

    return matrix

# print(matrix_to_zeros([[0,1,2,0],[3,4,5,2],[1,3,1,5]]))
'''
1 1 1      1 0 1
1 0 1  --> 0 0 0
1 1 1      1 0 1
'''
def fibonacci(n):
    a = 0
    b = 1

    if n == 0 or n == 1:
        return n

    count = 2
    while count <= n:
        c = a + b
        a = b
        count += 1
        b = c
    return c

# print(fibonacci(10))


def powerOfTwo(n, chk=1, i=1):
    if chk > n:
        return False
    if chk == n:
        return True
    return powerOfTwo(n, 2**i ,i + 1)

# print(powerOfTwo(16)) # return n & (n-1) == 0

# 0x55555555 ODD 1 NUMBERS # 0xaaaaaaaa EVEN 1 NUMBERS

def binaryTreePaths(root):
    res = []

    def dfs(root, path):
        if not root:
            return
        if not root.left and not root.right:
            res.append("".join(path) + str(root.val))
            return
        path.append(str(root.val) + "->")
        dfs(root.left, path)
        dfs(root.right, path)
        path.pop()

    dfs(root, [])

    return res
def sameTree(root1, root2):
    if not root1 and not root2:
        return True
    if (not root1 or not root2) or (root1.val != root2.val):
        return False


    return sameTree(root1.left, root2.left) and \
           sameTree(root1.right, root2.right)


# root = TreeNode(1); root1 = TreeNode(1)
# a = TreeNode(2); a1 = TreeNode(2)
# b = TreeNode(3); b1 = TreeNode(3)
# c = TreeNode(5); c1 = TreeNode(5)
# root.left = a; root1.left = a1
# root.right = b; root1.right = b1
# a.right = c; a1.right = c1
#
# print(binaryTreePaths(root))
# print(sameTree(root, root1))


def majorityElement(nums, left, right):
    if left == right:
        return nums[left]
    mid = (left+right) // 2
    leftNum = majorityElement(nums, left, mid)
    rightNum = majorityElement(nums, mid+1, right)
    if leftNum == rightNum:
        return leftNum
    leftCount = count(nums, left, right, leftNum)
    rightCount = count(nums, left, right, rightNum)
    return leftNum if leftCount > rightCount else rightNum

def count(nums, left, right, n):
    res = 0
    for i in range(left, right+1):
        if nums[i] == n:
            res += 1
    return res

# nums = [2,2,1,1,2]
# print(majorityElement(nums, 0, len(nums)-1))

# nums = [2,2,1,1,2]
# l = 0 r = 4 mid = 2

n = [1,2,3,1]

def removeElements(nums, val):
    k = 0

    for i in range(len(nums)):
        if nums[i] != val:
            nums[k], nums[i] = nums[i], nums[k]
            k += 1

    return k

# print(removeElements([3,2,2,3], 3))


def searchInsert(nums, target):
    left, right = 0, len(nums) - 1

    while left <= right:
        mid = (left+right) // 2

        if nums[mid] == target:
            return mid
        elif nums[mid] > target:
            right = mid - 1

        elif nums[mid] < target:
            left = mid + 1

    return left


# print(searchInsert([1, 2, 2, 4, 6], 7))

def lengthOfLastWord(s):
    count = 0
    for i in reversed(range(len(s))):
        if s[i] == " ":
            return count
        count += 1
    return count

# print(lengthOfLastWord("ASD ASD World"))


def maxProfit_Part2(prices):
    # profit = 0
    # for i in range(1, len(prices)):
    #     if prices[i-1] < prices[i]:
    #         profit += prices[i] - prices[i-1]
    #
    # return profit
    return sum([prices[i] - prices[i-1] for i in range(1, len(prices)) if prices[i-1] < prices[i]])


# print(maxProfit_Part2([7,1,5,3,6,4]))
class LargerNumberKey(str):
    def __lt__(n1, n2):
        return n1+n2 > n2+n1
def largestNumber(nums):
    # for i in range(len(nums)):
    #     nums[i] = str(nums[i])
    # def compare(num1, num2):
    #     if num1+num2 > num2+num1:
    #         return -1
    #     else:
    #         return 1
    #
    # nums = sorted(nums, key=cmp_to_key(compare))
    #
    # return "".join(nums)
    for i in range(len(nums)):
        nums[i] = str(nums[i])
    nums.sort(key=LargerNumberKey)
    return "".join(nums)

# print(largestNumber([10,2]))

def rotateArray(nums, k):
    # Solution 1
    '''
    for i in range(k):
        nums.insert(0, nums.pop())
    return nums
    '''
    # Solution 2
    '''
    n = len(nums)
    help = [0] * n
    for i in range(n):
        if i+k < n:
            help[i+k] = nums[i]
        else:
            help[(i+k) % n] = nums[i]
    nums = help.copy()
    return nums
    '''
    # Solution 3
    n = len(nums)
    k = k % n
    def helper(left, right):
        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1 ; right -= 1
    helper(0, n-1)
    helper(0, k-1)
    helper(k, n-1)
    return nums

# print(rotateArray(nums = [1,2,3,4,5], k = 2))

def subList_MaxProduct(nums):
    if not nums: return 0
    res = curMax = curMin = nums[0]

    for i in range(1, len(nums)):
        temp = curMax
        curMax = max(nums[i], curMax * nums[i], curMin * nums[i])
        curMin = min(nums[i], temp * nums[i], curMin * nums[i])

        res = max(res, curMax)

    return res

# print(subList_MaxProduct([-2,4,-5,-3, 0]))

def addBinary(a, b):
    ans = ""
    carry = 0
    a, b = a[::-1], b[::-1]
    for i in range(max(len(a), len(b))):
        a_digit = int(a[i]) if i < len(a) else 0
        b_digit = int(b[i]) if i < len(b) else 0

        total = a_digit + b_digit + carry
        char = str(total % 2)

        ans = char + ans
        carry = total // 2

    ans = "1"+ans if carry else ans

    return ans

# print(addBinary("11", "1"))

def containsNearbyDuplicate(nums, k):
    seen = {}
    for i in range(len(nums)):
        if (nums[i] in seen) and abs(seen[nums[i]]-i) <= k:
            return True
        seen[nums[i]] = i
        print(seen)
    return False

# print(containsNearbyDuplicate([1,0,1,1],1))

def summaryRanges(nums):
    res = []
    start, end, current = nums[0], None, nums[0]

    for i in range(1, len(nums)):
        current += 1
        if nums[i] != current:
            res.append(f"{start}->{end}") if end else res.append(str(start))
            end = None
            start = nums[i]
            current = nums[i]
        else:
            end = nums[i]

    res.append(f"{start}->{end}") if end else res.append(str(start))

    return res
# print(summaryRanges([0,1,2,4,5,7]))

def isSubsequence(s, t):
    i = 0
    j = 0
    while i < len(t) and j < len(s):
        if t[i] == s[j]:
            j += 1
        i += 1

    return j == len(s)

# print(isSubsequence("axc", t = "ahbgdc"))

def trapWater(height):
    #  [0,1,0,2,1,0,1,3,2,1,2,1]
    ans = 0
    left, right = 0, len(height)-1
    maxLeft, maxRight = height[left], height[right]

    while left < right:
        if maxLeft < maxRight:
            left += 1
            maxLeft = max(maxLeft, height[left])
            ans += maxLeft - height[left]
        else:
            right -= 1
            maxRight = max(maxRight, height[right])
            ans += maxRight - height[right]

    return ans

# print(trapWater([0,1,0,2,1,0,1,3,2,1,2,1]))

def wordBreak(s, wordDict):
    dp = [False] * (len(s) + 1)
    dp[len(s)] = True

    for i in reversed(range(len(s))):
        for word in wordDict:
            if i + len(word) <= len(s) and s[i: i+len(word)] == word:
                dp[i] = dp[i + len(word)]
            if dp[i]: break


    return dp[0]
# print(wordBreak("cars", ["car","ca","rs"]))

def gas_station(gas, cost):

    totalGas = 0
    res = 0
    remainingGas = 0
    for i in range(len(gas)):
        difference = gas[i] - cost[i]
        totalGas += difference
        remainingGas += difference

        if remainingGas < 0:
            res = i + 1
            remainingGas = 0

    return res if totalGas >= 0 else -1



# print(gas_station(gas = [1,2,3,4,5], cost = [3,4,5,1,2]))



def licenseKeyFormatting(s, k):
    res = ""
    s = "".join(s.split("-")).upper()
    n = k


    for char in reversed(s):

        if n == 0:
            res += '-' + char
            n = k - 1
        else:
            res += char
            n -= 1

    return res[::-1]

# print(licenseKeyFormatting(s="2-5g-3-J", k=2))
# output = "2-5G-3J"

def longestNiceSubstring(s):
    def isNice(s):
        charSet = set()
        for char in s:
            charSet.add(char)
        for char in s:
            if char.upper() not in charSet or \
                char.lower() not in charSet:
                return False

        return True
    longestSub = ""
    for i in range(len(s)):
        for j in range(1, len(s)):
            newSub = s[i:j+1]
            if len(longestSub) <= len(newSub) and isNice(newSub):
                longestSub = newSub

    return longestSub


# print(longestNiceSubstring("YazaAay"))


def jump2(nums):
    count = 0
    n = len(nums)
    for i in range(n):
        for j in range(1, n):
            pass

    return count

# print(jump2([2,3,1,1,4]))



# def uniquePaths(m, n):
#
#     def dfs(path, i, j):
#         if i - 1 == m and j - 1 == n:
#             allPaths.append(path)
#         else:
#             for k in range(m):
#
#
#     allPaths = []
#     dfs([], i, j)
#
#     return len(allPaths)