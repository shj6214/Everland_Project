
import java.util.Calendar;
import java.util.Scanner;


public class Everland {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String pId,prefer = null, YN = null, packName = null,kinds = new String();
		int useDate=0, count=0, totalPrice=0, choose=0;
		int year=0, month=0, day=0, currentYear=0, currentMonth=0, currentDay=0, age=0;
		
		Calendar cal = Calendar.getInstance();
		currentYear=cal.get(Calendar.YEAR);
		currentMonth=cal.get(Calendar.MONTH)+1; // 0���� �����ϹǷ� 1�߰� 
		currentDay=cal.get(Calendar.DAY_OF_MONTH);
		
		// Ķ���� ��¥ A ��Ű�� B ��Ű�� C ��Ű��  
		int[] A = {20210904,20210905,20210911,20210912,20210918,20210919,20210920,20210921,
				20210922,20210925,20210926,20211002,20211003,20211009,20211010,20211016,
				20211017,20211023,20211024,20211030,20211031,20211106,20211107}; 
				
		int[] B = {20210601,20210602,20210603,20210604,20210605,20210606,
				20210607,20210608,20210609,20210610,20210611,20210612,20210613,
				20210619,20210620,20210626,20210627,
				20210703,20210704,20210710,20210711,20210717,20210718, 
	            20210724,20210725,20210729,20210730,20210731,
	            20210801,20210802,20210803,20210807,20210808,20210814,
	            20210815,20210821,20210822,20210828,20210829,
	            20210903,20210906,20210907,20210908,20210909,20210910,
	            20210913,20210914,20210915,20210916,20210917,20210923,
	            20210924,20210927,20210928,20210929,20210930,
	            20211001,20211004,20211005,20211006,20211007,20211008,
	            20211011,20211012,20211013,20211114,20211015,20211018,
	            20211019,20211020,20211021,20211022,20211025,20211026,
	            20211027,20211028,20211029,
	            20211101,20211102,20211103,20211104,20211105,20211108,
	            20211109,20211110,20211111,20211112,20211113,20211114,
	            20211120,20211121,20211127,20211128}; 
		
		int[] C = { 20210614,20210615,20210616,20210617,20210618,20210621,
				20210622,20210623,20210624,20210625,20210628,20210629,20210630,
				20210701,20210702,20210705,20210706,20210707,20210708, 
	            20210709,20210712,20210713,20210714,20210715,20210716, 
	            20210719,20210720,20210721,20210722,20210723,20210726, 
	            20210727,20210728,20210804,20210805,20210806,20210809, 
	            20210810,20210811,20210812,20210813,20210816,20210817, 
	            20210818,20210819,20210820,20210823,20210824,20210825, 
	            20210826,20210827,20210830,20210831,20210901,20210902,
	            20211115,20211116,20211117,20211118,20211119,20211122,
	            20211123,20211124,20211125,20211126,20211129,20211130}; 
		
		while(true) { 
			// �̿볯¥ 
			System.out.println("�̿볯¥�� �Է����ּ���.");
			useDate = input.nextInt();
			
			// System.out.printf("%d",(int)Math.log10(useDate)+1);
			
			if((int)Math.log10(useDate)+1 < 8 || (int)Math.log10(useDate)+1 > 8) { // �̿볯¥ �Է� ���� �ʰ� �� ex) 202109095
				System.out.println("�ٽ� �Է����ּ���");
				continue;
			}
			
			// �ֹι�ȣ �Է� �� �⵵, ��, �� ���� 
			System.out.println("�ֹι�ȣ �Է� ��) 950914 ");
			pId=input.next();
				
			if(pId.length() < 6 || pId.length() > 6) { // �ֹι�ȣ �Է� ���� �ʰ� ��
				System.out.println("�ٽ� �Է����ּ���");
				continue;
			}
			
			year = Integer.parseInt(pId.substring(0,2));
			month= Integer.parseInt(pId.substring(2,4));
			day= Integer.parseInt(pId.substring(4,6));
			
			// �� ���� ��� 
			if(year < 21){
				age = currentYear - year - 2000;
				//System.out.println(age);
				if (currentMonth > month || (currentMonth == month && currentDay > day )) {
					age++;
				}  
			} else {
				age = currentYear - year - 1900;
				//System.out.println(age);
				if (currentMonth > month || (currentMonth == month && currentDay > day )) {
					age++;
				} 
			}
			
			// Ƽ�� �ֹ� ����
			System.out.println("�� ���� �ֹ��Ͻðڽ��ϱ�?");
			count = input.nextInt();
			
			// ��� ���� ���� 
			System.out.print("�������� �����ϼ���.\n");
			System.out.print(" 1. ����\n 2. �����\n 3. ����������\n 4. ���ڳ�\n 5. �ӻ��\n");
			choose = input.nextInt();
			
			if(choose < 1 || choose > 5) { // ������ ���� ���� �� 5������ Ŭ ���
				System.out.println("�ٽ� �Է����ּ���.");
				continue;
			}
			
			// ������� �̿� ��¥�� ��Ű�� �迭 �� ���� ��ġ�� ���, packName ������ ��Ű�� ���� ���� 
			for(int idx=0; idx<A.length; idx++) {
				if(useDate == A[idx])
					packName = "A";
			}
			
			for(int idx=0; idx<B.length; idx++) {
				if(useDate == B[idx])
					packName = "B";
			}
			
			for(int idx=0; idx<C.length; idx++) {
				if(useDate == C[idx])
					packName = "C";
			}
			
			if(choose == 1) { // ���� ���
				prefer = "����"; // ��� ���� 
				
				if(age >= 19 || (age >= 13 && age <= 18)) { // ����/û�ҳ�
					kinds = "����/û�ҳ�"; 
					
					if(packName == "A") { // �̿볯¥ 
						totalPrice += 60000;
					}
					else if(packName == "B") {
						totalPrice += 56000;
					}
					else if(packName == "C") {
						totalPrice += 50000;
					}
				}
				
				else if(age >= 65 || (age >= 3 && age <= 12)){ // ���� ���
					kinds="����/���";
										
					if(packName == "A") {
						totalPrice += 48000;
					}
					else if(packName == "B") {
						totalPrice += 44000;
					}
					else if(packName == "C") {
						totalPrice += 40000;
					}
					
				}
			} else if(choose == 2) { // ����� 
				prefer = "�����"; // ��� ���� 
				
				if(age >= 19) { // ����
					kinds="����";
					
					if(packName == "A") {
						totalPrice += 36000;
					}
					else if(packName == "B") {
						totalPrice += 33000;
					}
					else if(packName == "C") {
						totalPrice += 30000;
					}
				}
				else if((age >= 13 && age <= 18) || (age >= 3 && age <= 12) || age >= 65 ){ // û�ҳ�/����/���
					kinds="û�ҳ�/����/���";
					
					if(packName == "A") {
						totalPrice += 28000;
					}
					else if(packName == "B") {
						totalPrice += 26000;
					}
					else if(packName == "C") {
						totalPrice += 24000;
					}
				}
			} else if(choose == 3) { // ���� ������ 
				prefer = "����������";
				
				if(age >= 19) { // ����
					kinds="����";
					
					if(packName == "A") {
						totalPrice += 30000;
					}
					else if(packName == "B") {
						totalPrice += 28000;
					}
					else if(packName == "C") {
						totalPrice += 25000;
					}
				}
				else if((age >= 13 && age <= 18) || (age >= 3 && age <= 12) || age >= 65 ){ // û�ҳ� ���� ���
					prefer = "û�ҳ�/����/���";
					if(packName == "A") {
						totalPrice += 24000;
					}
					else if(packName == "B") {
						totalPrice += 22000;
					}
					else if(packName == "C") {
						totalPrice += 20000;
					}
				}
			} else if(choose == 4) { // ���ڳ� 
				prefer = "���ڳ�";
				if(age >= 18 || (age >= 13 && age <= 18)) { // ����/û�ҳ�
					kinds="����/û�ҳ�";
					
					if(packName == "A") {
						totalPrice += 48000;
					}
					else if(packName == "B") {
						totalPrice += 44000;
					}
					else if(packName == "C") {
						totalPrice += 40000;
					}
				}
				else if((age >= 3 && age <= 12) || age >= 65){ // ���� ���
					kinds = "����/���";
					
					if(packName == "A") {
						totalPrice += 38000;
					}
					else if(packName == "B") {
						totalPrice += 35000;
					}
					else if(packName == "C") {
						totalPrice += 32000;
					}
				}
				
			} else if(choose == 5) { // �ӻ��   
				prefer = "�ӻ��";
				
				if(age >= 19) { // ����
					kinds="����";
					
					if(packName == "A") {
						totalPrice += 51000;
					}
					else if(packName == "B") {
						totalPrice += 47000;
					}
					else if(packName == "C") {
						totalPrice += 42000;
					}
				}
				
			}
			
			// ��� 
			totalPrice = totalPrice * count;
			
			System.out.printf("������ %d�� �Դϴ�.�����մϴ�.\n", totalPrice);
			
			System.out.println("==================��������==================");
			System.out.printf("%sƼ�� %s X %d %s ������� \n",packName, kinds , count, prefer );
			System.out.println("==========================================");
			
			System.out.println("�ٽ� �Է��Ͻðڽ��ϱ�? (Y/N)");
			YN = input.next();
			
			
			// Y�� ��� while�� ������� N�� ��� ���α׷� ���� 
			if(YN.equals("y") || YN.equals("Y")) {
				continue;
			} else {
				break;
			}
			
		} 
		input.close();
		
	}

}
