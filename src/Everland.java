package Everland;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Everland {
	
	public static void main(String[] args) {
		EverlandInput everInput = new EverlandInput(); // EverlandProcess�κ��� �������� ���� 
		EverlandData everData = new EverlandData();
		EverlandVariable everVariable = new EverlandVariable();
		DataClass everDC = new DataClass();
		
		while(true) {
			everInput.inputDate(); // �̿볯¥	
			if((int)Math.log10(everInput.useDate)+1 < 8 || (int)Math.log10(everInput.useDate)+1 > 8) { // �̿볯¥ �Է� ���� �̸� Ȥ�� �ʰ� ��
				System.out.println("�ٽ� �Է����ּ���");
				continue;
			}

			everInput.inputPid(); // �ֹι�ȣ �Է� �� �⵵, ��, �� ����		
			everData.ProcessPid(everInput.year, everInput.month, everInput.day, everInput.currentYear, everInput.currentMonth, everInput.currentDay);
			if(everInput.pId.length() < 6 || everInput.pId.length() > 6) { // �ֹι�ȣ �Է� ���� �̸� Ȥ�� �ʰ� ��
				System.out.println("�ٽ� �Է����ּ���");
				continue;
			}
			
			everInput.inputCount(); // Ƽ�� �ֹ� ����
			everInput.inputPrefer(); // ��� ���� ����
			everInput.InputCoupon(); // ���� ���� ����
			everData.ProcessPrefer(everVariable.A, everVariable.B, everVariable.C, everInput.useDate, everInput.choose, everDC.prefer,everDC.packName, everDC.kinds, everDC.tcount, everDC.price, everDC.isEventCoupon, everInput.count, everInput.coupon); // ��� ���� ó�� 
			if(everInput.choose < 1 || everInput.choose > 5) { // ������ ���� ���� �� 5������ Ŭ ��� 
				System.out.println("�ٽ� �Է����ּ���.");
				continue;
			}
			
			everData.printPrice(); // ��� 
			everInput.addTicket(); // �߰� ���� �Է�
			if(everInput.YN.equals("y") || everInput.YN.equals("Y")) { continue; } // Y �Է½� �߰� Ƽ�� ����, N �Է½� ���α׷� ���� 
			else { System.out.println("���α׷��� ���� �մϴ�!"); break;}
		} 
		everInput.input.close(); // ��ĳ�� ��ü �޸� ��ȯ 
	}
}