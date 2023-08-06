#  baekjoon 알고리즘 1026
# 2023.08.04 이주현
import sys

num_of_a = int(sys.stdin.readline())

a_list = list(map(int , sys.stdin.readline().split()))

b_list = list(map(int , sys.stdin.readline().split()))


a_list = sorted(a_list )
b_list = sorted(b_list , reverse= True)

result = 0 
for i in range(num_of_a):
    result = result + a_list[i] * b_list[i]
print(result)