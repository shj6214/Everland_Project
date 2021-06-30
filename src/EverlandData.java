package Everland;

import java.util.ArrayList;
import java.util.Scanner; 

public class EverlandData {

		public ArrayList<DataClass> arrData = new ArrayList<DataClass>();
				
		public int i=0;

		public int totalPrice=0, age=0;
		
		
		public void ProcessPid(int year, int month, int day, int currentYear, int currentMonth, int currentDay){
			// �� ���� ���
				if(year < 21){
					age = currentYear - year - 2000;
					if (currentMonth > month || (currentMonth == month && currentDay > day )) {
						age++;
					} 
				} else {
					age = currentYear - year - 1900;
					if (currentMonth > month || (currentMonth == month && currentDay > day )) {
						age++;
				} 
			}
		}
		
		public void ProcessPrefer(int[] A, int[] B, int[] C, int useDate, int choose, String prefer, String packName, String kinds, int price, int tcount , int isEventCoupon, int count, int coupon) {
			
			DataClass item = new DataClass();
			
			item.prefer = prefer;
			item.packName = packName;
			item.kinds = kinds;
			item.tcount = tcount;
			item.price = price;
			item.isEventCoupon = isEventCoupon;			
			item.tcount = count;
			item.isEventCoupon = coupon;
			
			for(int idx=0; idx<A.length; idx++) {
				if(useDate == A[idx])
					item.packName = "A";
			}
			
			for(int idx=0; idx<B.length; idx++) {
				if(useDate == B[idx])
					item.packName = "B";
			}
			
			for(int idx=0; idx<C.length; idx++) {
				if(useDate == C[idx])
					item.packName = "C";
			}
			
			// ������� �̿� ��¥�� ��Ű�� �迭 �� ���� ��ġ�� ���, packName ������ ��Ű�� ���� ���� 
			if(choose == 1) { // ���� ���
				item.prefer="����"; // ��� ���� 
				
				if(age >= 19 || (age >= 13 && age <= 18)) { // ����/û�ҳ�
					item.kinds="����/û�ҳ�"; 
					
					if(item.packName == "A") { // �̿볯¥ 
						item.price = 60000;
					}
					else if(item.packName == "B") {
						item.price = 56000;
					}
					else if(item.packName == "C") {
						item.price = 50000;
					}
				}
				else if(age >= 65 || (age >= 3 && age <= 12)){ // ���� ���
					item.kinds="����/���";
										
					if(packName == "A") {
						item.price = 48000;
					}
					else if(item.packName == "B") {
						item.price = 44000;
					}
					else if(item.packName == "C") {
						item.price = 40000;
					}
				}
			}else if(choose == 2) { // ����� 
				item.prefer="�����"; // ��� ���� 
					
				if(age >= 19) { // ����
					item.kinds="����";
						
					if(item.packName == "A") {
						item.price = 36000;
					}
					else if(item.packName == "B") {
						item.price = 33000;
					}
					else if(item.packName == "C") {
						item.price = 30000;
					}
				}
				else if((age >= 13 && age <= 18) || (age >= 3 && age <= 12) || age >= 65 ){ // û�ҳ�/����/���
					item.kinds="û�ҳ�/����/���";
						
					if(item.packName == "A") {
						item.price = 28000;
					}
					else if(item.packName == "B") {
						item.price = 26000;
					}
					else if(item.packName == "C") {
						item.price = 24000;
					}
				}
			} else if(choose == 3) { // ���� ������ 
				item.prefer="����������";
					
				if(age >= 19) { // ����
					item.kinds = "����";
						
					if(item.packName == "A") {
						item.price = 30000;
					}
					else if(item.packName == "B") {
						item.price = 28000;
					}
					else if(item.packName == "C") {
						item.price = 25000;
					}
				}
				else if((age >= 13 && age <= 18) || (age >= 3 && age <= 12) || age >= 65 ){ // û�ҳ� ���� ���
					item.prefer="û�ҳ�/����/���";
					if(item.packName == "A") {
						item.price = 24000;
					}
					else if(item.packName == "B") {
						item.price = 22000;
					}
					else if(item.packName == "C") {
						item.price = 20000;
					}
				}
			} else if(choose == 4) { // ���ڳ� 
				item.prefer="���ڳ�";
					if(age >= 18 || (age >= 13 && age <= 18)) { // ����/û�ҳ�
						item.kinds="����/û�ҳ�";
						
						if(item.packName == "A") {
							item.price = 48000;
						}
						else if(item.packName == "B") {
							item.price = 44000;
						}
						else if(item.packName == "C") {
							item.price = 40000;
						}
					}
					else if((age >= 3 && age <= 12) || age >= 65){ // ���� ���
						item.kinds="����/���";
						
						if(item.packName == "A") {
							item.price = 38000;
						}
						else if(item.packName == "B") {
							item.price = 35000;
						}
						else if(item.packName == "C") {
							item.price = 32000;
						}
					}
					
				}else if(choose == 5) { // �ӻ��
					item.prefer="�ӻ��";
					
					if(age >= 19) { // ����
						item.kinds="����";
						
						if(item.packName == "A") {
							item.price = 51000;
						}
						else if(item.packName == "B") {
							item.price = 47000;
						}
						else if(item.packName == "C") {
							item.price = 42000;
						}
					}
				}

				arrData.add(item);
				//System.out.print(arrData.get(i).isEventCoupon);
				totalPrice += arrData.get(i).price * arrData.get(i).tcount;
				i++;
				
			
				
			}
		
		public void printPrice() { // ���� ���

			System.out.printf("�� ������ %d�� �Դϴ�.�����մϴ�.\n", totalPrice);
			
			System.out.println("==================��������==================");
			for(int idx=0; idx < arrData.size(); idx++) {
				System.out.printf("%sƼ�� %s X %d %d %s ������� \n",arrData.get(idx).packName, arrData.get(idx).kinds, arrData.get(idx).tcount,(arrData.get(idx).price*arrData.get(idx).tcount), arrData.get(idx).prefer );
				
				// ���� ���� ����
				if(arrData.get(idx).isEventCoupon == 1) {
					System.out.println("���� ���� ����");
				}else {
					System.out.println("������ �����ϴ�.");
				}
				
			}
			System.out.println("==========================================");
		}
	}


