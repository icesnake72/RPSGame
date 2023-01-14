package RockPaperScissorsGame;

class RPSClass {
    private final byte ROCK;

    private final byte SCISSORS;
    private final byte PAPER;

    private final byte comsVal;

    public RPSClass() {
        this.ROCK = 0;
        this.SCISSORS = 1;
        this.PAPER = 2;
        this.comsVal = (byte) ((Math.random() * 10000) % 3);
        System.out.println("컴퓨터는 준비가 됐습니다. 이제 당신 차례입니다.");
    }

    public void GetHint() {
        if (comsVal == 0) {
            System.out.println("컴퓨터는 주먹을 냈습니다.");
        } else if (comsVal == 1) {
            System.out.println("컴퓨터는 가위를을 냈습니다.");
        } else {
            System.out.println("컴퓨터는 보자기를 냈습니다.");
        }
    }

    // 컴퓨터가 주먹을 냄
    private int RockVsUsers(byte nUsers) {
        if (nUsers == PAPER)
            return 1; // 당신의 승리
        else if (nUsers == SCISSORS) {
            return -1;  // 당신의 패배
        }

        return 0;
    }

    // 컴퓨터가 가위를 냄
    private int ScissorsVsUsers(byte nUsers) {
        if (nUsers == ROCK)
            return 1; // 당신의 승리
        else if (nUsers == PAPER) {
            return -1;  // 당신의 패배
        }

        return 0;
    }

    // 컴퓨터가 보자기를 냄
    private int PaperVsUsers(byte nUsers) {
        if (nUsers == SCISSORS)
            return 1;
        else if (nUsers == ROCK)
            return -1;

        return 0;
    }

    // 반환값이 -1이면 당신의 패, 1이면 당신의 승, 0이면 비김
    public int judge(byte nUsers) {
        switch (comsVal) {
            case 0:
                return RockVsUsers(nUsers);
            case 1:
                return ScissorsVsUsers(nUsers);
            case 2:
                return PaperVsUsers(nUsers);
        }

        return 0;
    }
}
