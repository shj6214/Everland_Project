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
		System.out.println("�̿볯¥�� �Է����ּ���.");
		useDate = input.nextInt();
	}
		
	public void inputPid()
	{
		System.out.println("�ֹι�ȣ �Է� ��) 950914 ");
		pId=input.next();

		year = Integer.parseInt(pId.substring(0,2));
		month= Integer.parseInt(pId.substring(2,4));
		day= Integer.parseInt(pId.substring(4,6));
			
		currentYear=cal.get(Calendar.YEAR);
		currentMonth=cal.get(Calendar.MONTH)+1; // 0���� �����ϹǷ� 1�߰� 
		currentDay=cal.get(Calendar.DAY_OF_MONTH);
	}
		
	public void inputCount(ArrayList<Integer> count) {
		System.out.println("�� ���� �ֹ��Ͻðڽ��ϱ�?");
		count.add(input.nextInt());
	}
		
	public void inputPrefer() {
		System.out.print("�������� �����ϼ���.\n");
		System.out.print(" 1. ����\n 2. �����\n 3. ����������\n 4. ���ڳ�\n 5. �ӻ��\n");
		choose = input.nextInt();
	}
		
	public void addTicket() { // �߰� ����
		System.out.println("�߰� ���� Y / ���� N (Y/N)");
		YN = input.next();	
	}
	
}
