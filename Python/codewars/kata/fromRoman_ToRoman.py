class RomanNumerals:
    
    @staticmethod
    def to_roman(val): 
        roman_dictionary = {
            "M": 1000,
            "CM": 900,
            "D": 500,
            "CD": 400,
            "C": 100,
            "XC": 90,
            "L": 50,
            "XL": 40,
            "X": 10,
            "IX": 9,
            "V": 5,
            "IV": 4,
            "I": 1
        }
        res = ""

        for r in roman_dictionary:
            while val - roman_dictionary[r] >= 0:
                val -= roman_dictionary[r]
                res += r

        return res

    @staticmethod
    def from_roman(roman_num):
        roman_dictionary = {
            "M": 1000,
            "CM": 900,
            "D": 500,
            "CD": 400,
            "C": 100,
            "XC": 90,
            "L": 50,
            "XL": 40,
            "X": 10,
            "IX": 9,
            "V": 5,
            "IV": 4,
            "I": 1
        }
        res = 0
        i = 0
        while i < len(roman_num):
            if i+1 < len(roman_num) \
            and (roman_num[i] + roman_num[i+1]) in roman_dictionary:
                
                res += roman_dictionary[roman_num[i] + roman_num[i+1]]
                i += 2
            else:
                res += roman_dictionary[roman_num[i]]
                i += 1
        return res
    

print(RomanNumerals.to_roman(2009))
print(RomanNumerals.from_roman("MMIX"))

"""Otra Forma"""
def romanToint(s):
    dic = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    result = 0

    for i in range(len(s)):
        if i + 1 < len(s) and dic[s[i]] < dic[s[i + 1]]:
            result += - dic[s[i]]
        else:
            result += dic[s[i]]
    return result

