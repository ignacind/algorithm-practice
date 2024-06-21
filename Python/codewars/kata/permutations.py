def permutations(s):
    perms = []

    def backtracking(comb, s1):
        if len(s1) == 0:
            perms.append(comb)

        for i in range(len(s1)):
            backtracking(comb+s1[i], s1[:i]+s1[i+1:])

    backtracking("", s)

    return sorted(list(set(perms)))

print(permutations('abcd'))


'''
In this kata, your task is to create all permutations of a non-empty input string and remove duplicates, if present.

Create as many "shufflings" as you can!

Examples:

With input 'a':
Your function should return: ['a']

With input 'ab':
Your function should return ['ab', 'ba']

With input 'abc':
Your function should return ['abc','acb','bac','bca','cab','cba']

With input 'aabb':
Your function should return ['aabb', 'abab', 'abba', 'baab', 'baba', 'bbaa']
Note: The order of the permutations doesn't matter.

Good luck!
'''