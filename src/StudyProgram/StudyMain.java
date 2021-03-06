package StudyProgram;

import java.util.Scanner;

public class StudyMain {
	final static int SIZE = 100;

	public static void main(String[] args) {

		StudyInfoIm info = new StudyInfoIm();
		StudyVO std[] = new StudyVO[SIZE];

		int menu;

		while (true) {

			menu();

			Scanner scan = new Scanner(System.in);

			System.out.print("메뉴 선택 :");
			menu = scan.nextInt();
			System.out.println();

			switch (menu) {
			case 1:
				join(info, std);
				break;
			case 2:
				input(info, std);
				break;
			case 3:
				update(info, std);
				break;
			case 4:
				delete(info, std);
				break;
			case 5:
				outputFine(info, std);
				break;
			case 6:
				outputStudy(info, std);
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요!!!\n");
			}
		}

	}

	static void menu() {
		System.out.println("메뉴");
		System.out.println(" 1.스터디가입");
		System.out.println(" 2.정보입력");
		System.out.println(" 3.정보수정");
		System.out.println(" 4.스터디탈퇴");
		System.out.println(" 5.벌금현황");
		System.out.println(" 6.스터디현황");
		System.out.println(" 7.종료");
		System.out.println();
	}

	static void join(StudyInfoIm info, StudyVO[] std) {
		std[info.cnt] = new StudyVO();
		info.joinStudy(std);
	}

	static void input(StudyInfoIm info, StudyVO[] std) {
		info.inputStudy(std);
		info.fineChk(std);
	}

	static void update(StudyInfoIm info, StudyVO[] std) {
		info.updateStudy(std);
		info.fineChk(std);
	}

	static void delete(StudyInfoIm info, StudyVO[] std) {
		info.deleteStudy(std);
	}

	static void outputFine(StudyInfoIm info, StudyVO[] std) {
		int totFine = 0;
		int noFineCnt = 0;
		System.out.println("===============================");
		System.out.println("            벌금내역");
		System.out.println("===============================");
		System.out.println("회원번호 | 회원이름 | 스터디날짜 | 벌금");
		System.out.println("-------------------------------");
		info.outputFine(std);
		for (int i = 0; i < info.cnt; i++) {
			if (std[i].getFine() == 0) {
				noFineCnt++;
			}else {
				totFine += std[i].getFine();				
			}
		}
		System.out.printf("총 인원 : %s 총 벌금 : %4d", info.cnt - noFineCnt, totFine);
		System.out.println();
	}

	static void outputStudy(StudyInfoIm info, StudyVO[] std) {

		int totDeposit = 0;
		int totFine = 0;
		int totBalance = 0;

		System.out.println("============================================================================");
		System.out.println("                                 스터디관리");
		System.out.println("============================================================================");
		System.out.println("회원번호 | 회원이름 | 보증금 | 스터디날짜 | 챕터정리 | 과제 | 중간점검 | 최종점검 | 벌금 | 잔액");
		System.out.println("----------------------------------------------------------------------------");
		info.outputStudy(std);
		for (int i = 0; i < info.cnt; i++) {

			totDeposit += std[i].getDeposit();
			totFine += std[i].getFine();
			totBalance += std[i].getBalance();

		}
		System.out.printf("\t\t 총 보증금 : %4d 총 벌금 : %4d 총 잔액 : %4d", totDeposit, totFine, totBalance);
		System.out.println();
	}
}
