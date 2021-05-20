package com.ps.프로그래머스.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class 오픈채팅방 {

    static class UserActionLog {
        String uid;
        String command;

        public UserActionLog(String uid, String command) {
            this.uid = uid;
            this.command = command;
        }
    }

    public String[] solution(String[] record) {
        String[] answer = {};


        List<UserActionLog> userActionLogs = new ArrayList<>();
        Map<String, String> uidMappingMap = new HashMap<>();//<uid, nickname>
        List<String> answerList = new ArrayList<>();


        for (int i = 0; i < record.length; i++) {
            String s = record[i];
            StringTokenizer st = new StringTokenizer(s, " ");
            String command = st.nextToken();
            String uid = st.nextToken();
            userActionLogs.add(new UserActionLog(uid, command));

            if(st.hasMoreTokens()){
                String nickname = st.nextToken();
                uidMappingMap.put(uid, nickname);
            }
        }

        for (int i = 0; i < record.length; i++) {
            StringBuilder sb = new StringBuilder();
            UserActionLog userActionLog = userActionLogs.get(i);

            sb.append(uidMappingMap.get(userActionLog.uid)).append("님이 ");
            if(userActionLog.command.equals("Enter")){
                sb.append("들어왔습니다.");
                answerList.add(sb.toString());
            } else if(userActionLog.command.equals("Leave")) {
                sb.append("나갔습니다.");
                answerList.add(sb.toString());
            }
        }

        answer = answerList.toArray(String[]::new);
//        for (int i = 0; i < answer.length; i++) {
//            System.out.println(answer[i]);
//        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        오픈채팅방 proposal = new 오픈채팅방();

        /*디버깅용 입출력 */
//        System.setIn(new FileInputStream("src/com/ps/프로그래머스/level2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        proposal.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }

}
