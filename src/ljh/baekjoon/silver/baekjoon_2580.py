# baekjoon 알고리즘 2580
# 2023.09.09 이주현

import sys

# i , j 확인 제대로 하기!! 
# pypy3로 timeout 해결? 

def is_row_valid(num, i ):
    for j in range(9):
        if sudoku_array[i][j] == num:
            return False
    return True

def is_col_valid(num, j ):

    for i in range(9):
        if sudoku_array[i][j] == num:
            return False
    return True

def is_rect_valid(num, i, j ):
    i_tmp = i // 3 
    j_tmp = j // 3

    for a in range(3*i_tmp,(i_tmp+1)*3):
        for b in range(3*j_tmp,(j_tmp+1)*3):
            if sudoku_array[a][b] == num:
                return False
    
    return True

def fill_blank(n):

    if len(blank_l) == n :
        for i in range(9):
            print(*sudoku_array[i])
        exit()
    
    i = blank_l[n][0]
    j = blank_l[n][1]

    for num in range(1, 10):
        if is_row_valid(num, i) and is_col_valid(num, j) and is_rect_valid(num , i, j):
            sudoku_array[i][j] = num
            fill_blank(n + 1)
            sudoku_array[i][j] = 0

sudoku_array = list()
blank_l = list()

for i in range(9):
    row = list(map(int,sys.stdin.readline().split()))

    sudoku_array.append(row)
    for j in range(9):
        if row[j] == 0:
            blank_l.append((i,j))

fill_blank(0)