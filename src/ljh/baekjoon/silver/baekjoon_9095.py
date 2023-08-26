# baekjoon 알고리즘 9095
# 2023.08.26 이주현

import sys

def cal(num):
    if num == 1:
        return 1
    if num == 2:
        return 2
    if num == 3:
        return 4
    return cal(num-1) + cal(num-2) + cal(num-3)

num_of_testcase = int( sys.stdin.readline() )

for _ in range(num_of_testcase):

    num = int( sys.stdin.readline())
    count = 0

    count = cal(num)
    print(count)
