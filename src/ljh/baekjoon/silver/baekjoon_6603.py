# baekjoon 알고리즘 6603
# 2023.08.24 이주현

# 나중에 보기!!
import sys

def dfs(depth, idx , s_list , length  , out_list ):
    
    if depth == 6:
        print(*out_list)
        return

    for i in range(idx, length):
        out_list.append(s_list[i])
        dfs(depth + 1, i + 1, s_list, length, out_list)
        out_list.pop()


while True:
    n_list = list(map(int , sys.stdin.readline().split()))

    if n_list[0] == 0:
        break
    
    num = n_list[0]
    S_list = n_list[1:]
    out_list = []
    dfs(0, 0 , S_list , num, out_list)
    
    print()
    


