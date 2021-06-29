package Everland;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class EverlandInput {
	
	public int useDate=0, choose=0;
	

	public Calendar cal = Calendar.getInstance();
	public int year=0, month=0, day=0, currentYear=0, currentMonth=0, currentDay=0;
	public String pId=null, YN=null;
	
	public Scanner input = new Scanner(System.in);	
			
	public void inputDate()
	{
		System.out.println("이용날짜를 입력해주세요.");
		useDate = input.nextInt();
	}
		
	public void inputPid()
	{
		System.out.println("주민번호 입력 예) 950914 ");
		pId=input.next();

		year = Integer.parseInt(pId.substring(0,2));
		month= Integer.parseInt(pId.substring(2,4));
		day= Integer.parseInt(pId.substring(4,6));
			
		currentYear=cal.get(Calendar.YEAR);
		currentMonth=cal.get(Calendar.MONTH)+1; // 0부터 시작하므로 1추가 
		currentDay=cal.get(Calendar.DAY_OF_MONTH);
	}
		
	public void inputCount(ArrayList<Integer> count) {
		System.out.println("몇 개를 주문하시겠습니까?");
		count.add(input.nextInt());
	}
		
	public void inputPrefer() {
		System.out.print("우대사항을 선택하세요.\n");
		System.out.print(" 1. 없음\n 2. 장애인\n 3. 국가유공자\n 4. 다자녀\n 5. 임산부\n");
		choose = input.nextInt();
	}
		
	public void addTicket() { // 추가 구매
		System.out.println("추가 구매 Y / 종료 N (Y/N)");
		YN = input.next();	
	}
	
}
