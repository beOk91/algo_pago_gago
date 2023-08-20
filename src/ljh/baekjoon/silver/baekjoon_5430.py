# baekjoon 알고리즘 5430
# 2023.08.20 이주현

import sys

num_of_testcase = int(sys.stdin.readline())

for _ in range(num_of_testcase):
    
    function_p = sys.stdin.readline().strip()
    num_of_list = int(sys.stdin.readline())
    list_x = sys.stdin.readline().rstrip()[1:-1].split(sep=',')
    if num_of_list == 0 :
        list_x = list()

    reverse = False
    error = False

    for func in function_p:
        if func == 'R':
            reverse = not reverse
        if func == 'D':
            if len(list_x) == 0:
                print("error")
                error = True
                break
            else:
                if reverse:
                    list_x.pop()
                else:
                    list_x.pop(0)

    if not error:
        if reverse:
            list_x.reverse()
        print("[" + ",".join(list_x) + "]")

'''
3

1 0
5

4 2
1 2 3 4

6 0
1 1 9 1 1 1

'''