package Programmerslv2;

public class 광물캐기 {
    int answer;
    int[] picks;
    String[] minerals;

    public int solution(int[] picks, String[] minerals) {
        this.answer = Integer.MAX_VALUE;
        this.picks = picks;
        this.minerals = minerals;

        for (int i = 0; i < picks.length; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                dfs(i, 0, 0);
                picks[i]++;
            }
        }

        return answer;
    }

    public void dfs(int pickType, int idx, int cost) {
        if (idx >= minerals.length) {
            answer = Math.min(answer, cost);
            return;
        }

        for (int i = idx; i < Math.min(idx + 5, minerals.length); i++) {
            if (pickType == 0) {
                cost++;
            } else if (pickType == 1) {
                if ("diamond".equals(minerals[i])) {
                    cost += 5;
                } else {
                    cost++;
                }
            } else if (pickType == 2) {
                if ("diamond".equals(minerals[i])) {
                    cost += 25;
                } else if ("iron".equals(minerals[i])) {
                    cost += 5;
                } else {
                    cost++;
                }
            }
        }

        for (int i = 0; i < picks.length; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                dfs(i, idx + 5, cost);
                picks[i]++;
            }
        }

        for (int i = 0; i < picks.length; i++) {
            if (picks[i] > 0) return;
        }

        answer = Math.min(answer, cost);
    }

    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
    }
}
