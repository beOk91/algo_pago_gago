# baekjoon 알고리즘 9012
# 2023.08.11 이주현

import sys

num_of_ps = int(sys.stdin.readline())

for _ in range(num_of_ps):
    ps = sys.stdin.readline()

    check_list = [ps[0]]
    isVPS = True
    for s in ps[1:]:
        if s == '(':
            check_list.append('(')
        if s == ')':
            if len(check_list) == 0 :
                isVPS = False
                break
            pair = check_list.pop()
            if pair != '(':
                isVPS = False
                break

    if len(check_list) > 0 :
        isVPS = False

    if isVPS:
        print("YES")
    else:
        print("NO")
   