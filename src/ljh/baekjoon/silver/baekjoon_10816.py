#  baekjoon 알고리즘 10816
# 2023.08.11 이주현

import sys
num_of_cards = int(sys.stdin.readline())

cards_list = list(map(int, sys.stdin.readline().split()))

num_of_q = int(sys.stdin.readline())
q_arr = list(map(int, sys.stdin.readline().split()))

card_dict = {}
for card in cards_list:
    if card in card_dict.keys():
        card_dict[card] = card_dict[card] + 1
    else:
        card_dict[card] = 1

for q in q_arr:
    if q in card_dict.keys():
        print(card_dict[q] , end = ' ')
    else:

        print(0, end = ' ')

#count 함수 경우 n^2 시간이 걸려 사용할 수 X