package kjy.week_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방_42888 {
    public String[] solution(String[] record) {
        List<String> messages = new ArrayList<>();
        Map<String, String> users = new HashMap<>();

        for (String str : record) {
            String[] command = str.split(" ");

            if (command[0].equals("Enter")) {
                users.put(command[1], command[2]);
                messages.add(command[1] + ";님이 들어왔습니다.");
            } else if(command[0].equals("Leave")) {
                messages.add(command[1] + ";님이 나갔습니다.");
            } else if (command[0].equals("Change")) {
                users.put(command[1], command[2]);
            }
        }

        String[] answer = new String[messages.size()];
        for (int i = 0; i < messages.size(); i++) {
            String[] message = messages.get(i).split(";");
            answer[i] = users.get(message[0]) + message[1];
        }

        return answer;
    }
}
