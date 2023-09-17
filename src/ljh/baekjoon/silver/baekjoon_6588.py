# baekjoon 알고리즘 6588
# 2023.09.17 이주현

import sys
import math

### 반례 찾기 -> 아무리봐도 모르겟다..!

check_array = [False, False] + [True]*1000000

for i in range(2, 1000000):
    if check_array[i]:
        for j in range(2*i, 1000000, i):
            check_array[j] = False

while True:
    num = int(sys.stdin.readline())

    if num == 0:
        break

    is_correct = False

    a = num - 2
    b = num - a
    
    while a >= b:

        if check_array[a] and check_array[b]:
            is_correct = True
            print(num , " = " , b , " + " , a)
            break
        a -= 1
        b = num - a

    if not is_correct:
        print("Goldbach's conjecture is wrong.")
