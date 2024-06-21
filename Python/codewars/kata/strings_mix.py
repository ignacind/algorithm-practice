def mix(s1, s2):

    def getDict(s):
        dicc = {}
        for char in s:
            if char.isalpha() and char.islower():
                dicc[char] = dicc.get(char, 0) + 1
        dicc = {k: v for k, v in dicc.items() if v>1}
        return dicc
    
    d1 = getDict(s1)
    d2 = getDict(s2)

   
    
    dictMerged = {char: (d1.get(char, 0), d2.get(char, 0)) for char in set(d1) | set(d2)}

    output = []

    for k, v in dictMerged.items():
        if v[0] > v[1]:
            output.append(f"1:{k * v[0]}")
        elif v[0] < v[1]:
            output.append(f"2:{k * v[1]}")
        else:
            output.append(f"=:{k * v[0]}")

    # output = sorted(output, key=lambda elem: (-len(elem), elem))
    output.sort(key=lambda elem: (-len(elem), elem))


    return '/'.join(output)


s1 = "A cccc ffff aaaa gggg bb c"
s2 = "& bbb aaaa   c d"
# Output expected: 1:ccccc/1:ffff/1:gggg/=:aaaa/2:bbb
# Output received: 1:ccccc/1:ffff/1:gggg/2:bbb/=:aaaa
print(mix(s1, s2))

a = {1:2}

b = {2:1}

print(set(a).union(set(b)))



