package kh.programmers.순위_검색;

import java.util.*;

class Solution {

    private static class Applicant implements Comparable<Applicant> {
        String lang;
        String position;
        String career;
        String soulFood;
        Integer score;

        private boolean pass(String query) {
            String[] split = query.split(" ");

            return (split[0].equals("-") || split[0].equals(this.lang))
                    && (split[2].equals("-") || split[2].equals(this.position))
                    && (split[4].equals("-") || split[4].equals(this.career))
                    && (split[6].equals("-") || split[6].equals(this.soulFood))
                    && (Integer.parseInt(split[7]) <= this.score);
        }

        Applicant(String lang, String position, String career, String soulFood, int score) {
            this.lang = lang;
            this.position = position;
            this.career = career;
            this.soulFood = soulFood;
            this.score = score;
        }

        @Override
        public int compareTo(Applicant o) {
            return this.score.compareTo(o.score);
        }
    }



    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        List<Applicant> applicantList = new ArrayList<>();
        Map<String, List<Applicant>> queryMap = new HashMap<>();


        for (String applicantInfo : info) {
            applicantList.add(getApplicant(applicantInfo));
        }

        for (String q : query) {
            queryMap.put(getQueryKey(q), new ArrayList<>());
        }

        for (Applicant applicant : applicantList) {
            register(applicant, queryMap, "", 0);
        }
        for (List<Applicant> applicants : queryMap.values()) {
            Collections.sort(applicants);
        }

        for (int i = 0; i < answer.length; i++) {
            String q = query[i];
            String queryKey = getQueryKey(q);
            int targetScore = getTargetScore(q);

            List<Applicant> applicants = queryMap.get(queryKey);

            int start = 0;
            int end = applicants.size() - 1;
            int mid = (start + end) / 2;
            int val = mid;

            while(start < end) {
                mid = (start + end) / 2;
                if (applicants.get(mid).score < targetScore) {
                    start = mid + 1;
                    val = start;
                }
                else {
                    end = mid;
                    val = end;
                }
            }

            if (!applicants.isEmpty()) {
                if (applicants.get(val).pass(q)) {
                    answer[i]++;
                }
                answer[i] += applicants.size() - 1 - val;
            }
        }
        return answer;
    }

    private int getTargetScore(String query) {
        return Integer.parseInt(query.split(" ")[7]);
    }

    private void register(Applicant applicant, Map<String, List<Applicant>> queryMap, String query, int lev) {
        if (lev == 4 && queryMap.get(query) != null) {
            queryMap.get(query).add(applicant);
            return;
        }

        if (lev == 0) {
            register(applicant, queryMap, applicant.lang + " and ", lev + 1);
            register(applicant, queryMap, "- and ", lev + 1);
        }
        else if (lev == 1) {
            register(applicant, queryMap, query + applicant.position + " and ", lev + 1);
            register(applicant, queryMap, query + "- and ", lev + 1);
        }
        else if (lev == 2) {
            register(applicant, queryMap, query + applicant.career + " and ", lev + 1);
            register(applicant, queryMap, query + "- and ", lev + 1);
        }
        else if (lev == 3) {
            register(applicant, queryMap, query + applicant.soulFood, lev + 1);
            register(applicant, queryMap, query + "-", lev + 1);
        }
    }
    private String getQueryKey(String query) {
        String[] split = query.split(" ");
        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(split[0]).append(" and ")
                .append(split[2]).append(" and ")
                .append(split[4]).append(" and ")
                .append(split[6]);

        return keyBuilder.toString();
    }

    private Applicant getApplicant(String applicantInfo) {
        String[] split = applicantInfo.split(" ");

        return new Applicant(split[0], split[1], split[2], split[3], Integer.parseInt(split[4]));
    }
}

public class Main {

    public static void main(String[] args) {

        Solution s = new Solution();

        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] solution = s.solution(info, query);

        for (int i : solution) {
            System.out.println("i = " + i);
        }

    }
}
