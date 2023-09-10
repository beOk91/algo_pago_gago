package kh.programmers.오픈채팅방;

import java.util.*;
import java.util.Map.Entry;

class Solution {
    public String[] solution(String[] record) {
        int n = record.length;
        int ansCnt = n;

        // id : nickname
        HashMap<String, String> db = new HashMap<>();
        HashMap<String, Boolean> session = new HashMap<>();

        String[][] ops = new String[n][];

        for (int i = 0; i < n; i++) ops[i] = record[i].split(" ");


        for (int i = 0; i < n; i++) {

            String[] cur = ops[i];


            if (cur[0].equals("Enter")) {
                String id = cur[1];
                String nickname = cur[2];

                String savedNickName = db.get(id);

                if (savedNickName == null) db.put(id, nickname);
                else db.replace(id, nickname);
                session.put(id, true);
            }
            else if(cur[0].equals("Leave")) session.remove(cur[1]);
            else if(cur[0].equals("Change")) {
                db.replace(cur[1], cur[2]);
                ansCnt--;
            }
        }
        String[] answer = new String[ansCnt];

        int ansIdx = 0;
        for (int i = 0; i < n; i++) {
            String[] op = ops[i];
            if (ansIdx == ansCnt) break;
            answer[ansIdx] = "";
            if (op[0].equals("Enter")) {
                answer[ansIdx] += db.get(op[1]) + "님이 들어왔습니다.";
                ansIdx++;
            }
            else if (op[0].equals("Leave")) {
                answer[ansIdx] += db.get(op[1]) + "님이 나갔습니다.";
                ansIdx++;
            }
        }

        return answer;
    }
}
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[] answer = s.solution(record);

        System.out.println("answer = " + answer);
    }
}
