# baekjoon 알고리즘 1644
# 2023.09.17 이주현

import sys
import math

num = int(sys.stdin.readline())

# 에라토스테네스의 체 => 다시 보기
check_array=[False,False] + [True for i in range(num-1)]
for i in range(2, int(num**0.5)+1): 
    check_array[i*2::i] = [False]*((num-i)//i) 

prime_list = []
for i in range(num +1):
    if check_array[i]:
        prime_list.append(i)


answer = 0
start = 0
end = 0
while end <= len(prime_list):
    tmp = sum(prime_list[start:end])
    if tmp == num:
        answer += 1
        end += 1
    elif tmp < num:
        end += 1
    else:
        start += 1

print(answer)
