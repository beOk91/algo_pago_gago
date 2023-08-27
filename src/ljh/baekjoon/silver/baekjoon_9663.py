# baekjoon 알고리즘 9663
# 2023.08.26 이주현

## 확인해볼 것 : PyPy3 로 했을 때는 통과 / Python3로 했을 때는 시간 초과 => 시간 복잡도 줄이는 방법 확인!
import sys

N = int( sys.stdin.readline())
count = 0
N_array = [0] * N

def is_valid( q ):
    for i in range(q): ## 범위 설정 중요 - 과거에 놓인 Queen 과의 관계
        if N_array[q] == N_array[i] or abs(N_array[q] - N_array[i]) == abs(q - i): 
            return False
    return True
 
def place_Queen(num_of_queen):
    global count

    if num_of_queen == N:
        count = count +  1
        return 
    else:
        for queen in range(N):
            N_array[num_of_queen] = queen
            
            if is_valid(num_of_queen):
                place_Queen(num_of_queen+1)
            

place_Queen(0)
print(count)

