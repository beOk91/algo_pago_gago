# baekjoon 알고리즘 1037
# 2023.08.29 이주현
import sys

num_of_a = int(sys.stdin.readline())
array = list(map(int,sys.stdin.readline().split() ))

array = sorted(array)

print(array[0]* array[-1])