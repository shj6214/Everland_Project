package Everland;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Everland {
	
	public static void main(String[] args) {
		EverlandInput everInput = new EverlandInput(); // EverlandProcess로부터 가져오기 위함 
		EverlandData everData = new EverlandData();
		EverlandVariable everVariable = new EverlandVariable();
		
		while(true) {
		
			everInput.inputDate(); // 이용날짜	
			if((int)Math.log10(everInput.useDate)+1 < 8 || (int)Math.log10(everInput.useDate)+1 > 8) { // 이용날짜 입력 길이 미만 혹은 초과 시
				System.out.println("다시 입력해주세요");
				continue;
			}

			everInput.inputPid(); // 주민번호 입력 및 년도, 월, 일 추출		
			everData.ProcessPid(everInput.year, everInput.month, everInput.day, everInput.currentYear, everInput.currentMonth, everInput.currentDay);
			if(everInput.pId.length() < 6 || everInput.pId.length() > 6) { // 주민번호 입력 길이 미만 혹은 초과 시
				System.out.println("다시 입력해주세요");
				continue;
			}
			
			everInput.inputCount(everData.count); // 티켓 주문 갯수
			everInput.inputPrefer(); // 우대 사항 선택
			everData.ProcessPrefer(everVariable.A, everVariable.B, everVariable.C, everInput.useDate, everInput.choose); // 우대 사항 처리 
			if(everInput.choose < 1 || everInput.choose > 5) { // 우대사항 선택 사항 수 5개보다 클 경우 
				System.out.println("다시 입력해주세요.");
				continue;
			}
			
			everData.printPrice(); // 계산 
			everInput.addTicket(); // 추가 구매 입력
			if(everInput.YN.equals("y") || everInput.YN.equals("Y")) { continue; } // Y 입력시 추가 티켓 구매, N 입력시 프로그램 종료 
			else { System.out.println("프로그램을 종료 합니다!"); break;}
		} 
		everInput.input.close(); // 스캐너 객체 메모리 반환 
	}
}