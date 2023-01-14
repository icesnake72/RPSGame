package RockPaperScissorsGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int nWin = 0;
        int nLose = 0;
        int nDraw = 0;

        System.out.println("가위 바위 보 게임에 오신걸 환영합니다.");
        System.out.println("숫자 0은 주먹, 1는 가위, 2는 보자기 입니다.");

        Scanner scanner = new Scanner(System.in);

        do
        {
            RPSClass ComRPC = new RPSClass();
            ComRPC.PrintOut();
            System.out.println("당신의 선택은?");

            byte nUsers = 0;

            do {
                nUsers = scanner.nextByte();
                if (nUsers >= 0 && nUsers < 3) {
                    switch ( nUsers ){
                        case 0: System.out.println("당신이 선택한 입력은 바위입니다."); break;
                        case 1: System.out.println("당신이 선택한 입력은 가위입니다."); break;
                        case 2: System.out.println("당신이 선택한 입력은 보자기입니다."); break;
                    }

                    break; // 입력을 받기위한 do~while() 루프 탈출
                }
                System.out.println("잘 못 입력하셨습니다.숫자 0~2까지 입력해주세요.");
            } while(true);



            switch ( ComRPC.judge(nUsers) )
            {
                case -1:
                    System.out.println("당신이 졌습니다.");
                    ++nLose;
                    break;

                case 1:
                    System.out.println("당신이 이겼습니다.");
                    ++nWin;
                    break;

                case 0:
                    System.out.println("비겼습니다.");
                    ++nDraw;
                    break;

                default:
                    System.out.println("잘못된 입력입니다.");

            }

            System.out.println("게임이 종료되었습니다.");

            System.out.println("다시 도전하시려면 9키를 눌러주세요");

        } while( scanner.nextByte()==9 );

        System.out.println("당신의 최종 성적은 " + nWin + "승" + nDraw + "무" + nLose + "패 입니다." );

        float fTotal = (float)(nWin + nDraw + nLose);
        float fWinRate = ((float)nWin / fTotal) * 100.F;
        System.out.println("승률은 " + fWinRate + "% 입니다." );

        System.out.println("게임을 종료합니다. 이용해 주셔서 감사합니다.");
        scanner.close();
    }

}