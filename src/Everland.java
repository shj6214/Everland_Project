package Everland;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Everland {
	
	public static void main(String[] args) {
		EverlandInput everInput = new EverlandInput(); // EverlandProcess�κ��� �������� ���� 
		EverlandData everData = new EverlandData();
		
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
			
			everInput.inputCount(everData.count); // Ƽ�� �ֹ� ����
			everInput.inputPrefer(); // ��� ���� ����
			everData.ProcessPrefer(everInput.A, everInput.B, everInput.C, everInput.useDate, everInput.choose); // ��� ���� ó�� 
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