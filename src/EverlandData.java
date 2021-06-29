package Everland;

import java.util.ArrayList;
import java.util.Scanner;

public class EverlandData {

		public ArrayList<String> prefer = new ArrayList<String>();
		public ArrayList<String> packName = new ArrayList<String>();
		public ArrayList<String> kinds = new ArrayList<String>();
		public ArrayList<Integer> count = new ArrayList<Integer>();
		public ArrayList<Integer> price = new ArrayList<Integer>();
		
		public int i = 0, totalPrice=0, age=0; 
		
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
		
		public void ProcessPrefer(int[] A, int[] B, int[] C, int useDate, int choose) {
			
			for(int idx=0; idx<A.length; idx++) {
				if(useDate == A[idx])
					packName.add("A");
			}
			
			for(int idx=0; idx<B.length; idx++) {
				if(useDate == B[idx])
					packName.add("B");
			}
			
			for(int idx=0; idx<C.length; idx++) {
				if(useDate == C[idx])
					packName.add("C");
			}
			
			// ������� �̿� ��¥�� ��Ű�� �迭 �� ���� ��ġ�� ���, packName ������ ��Ű�� ���� ���� 
			if(choose == 1) { // ���� ���
				prefer.add("����"); // ��� ���� 
				
				if(age >= 19 || (age >= 13 && age <= 18)) { // ����/û�ҳ�
					kinds.add("����/û�ҳ�"); 
					
					if(packName.get(i) == "A") { // �̿볯¥ 
						price.add(60000);
					}
					else if(packName.get(i) == "B") {
						price.add(56000);
					}
					else if(packName.get(i)  == "C") {
						price.add(50000);
					}
				}
				else if(age >= 65 || (age >= 3 && age <= 12)){ // ���� ���
					kinds.add("����/���");
										
					if(packName.get(i) == "A") {
						price.add(48000);
					}
					else if(packName.get(i) == "B") {
						price.add(44000);
					}
					else if(packName.get(i) == "C") {
						price.add(40000);
					}
				}
			}else if(choose == 2) { // ����� 
				prefer.add("�����"); // ��� ���� 
					
				if(age >= 19) { // ����
					kinds.add("����");
						
					if(packName.get(i)  == "A") {
						price.add(36000);
					}
					else if(packName.get(i) == "B") {
						price.add(33000);
					}
					else if(packName.get(i) == "C") {
						price.add(30000);
					}
				}
				else if((age >= 13 && age <= 18) || (age >= 3 && age <= 12) || age >= 65 ){ // û�ҳ�/����/���
					kinds.add("û�ҳ�/����/���");
						
					if(packName.get(i) == "A") {
						price.add(28000);
					}
					else if(packName.get(i) == "B") {
						price.add(26000);
					}
					else if(packName.get(i) == "C") {
						price.add(24000);
					}
				}
			} else if(choose == 3) { // ���� ������ 
				prefer.add("����������");
					
				if(age >= 19) { // ����
					kinds.add("����");
						
					if(packName.get(i) == "A") {
						price.add(30000);
					}
					else if(packName.get(i) == "B") {
						price.add(28000);
					}
					else if(packName.get(i) == "C") {
						price.add(25000);
					}
				}
				else if((age >= 13 && age <= 18) || (age >= 3 && age <= 12) || age >= 65 ){ // û�ҳ� ���� ���
					prefer.add("û�ҳ�/����/���");
					if(packName.get(i) == "A") {
						price.add(24000);
					}
					else if(packName.get(i) == "B") {
						price.add(22000);
					}
					else if(packName.get(i) == "C") {
						price.add(20000);
					}
				}
			} else if(choose == 4) { // ���ڳ� 
					prefer.add("���ڳ�");
					if(age >= 18 || (age >= 13 && age <= 18)) { // ����/û�ҳ�
						kinds.add("����/û�ҳ�");
						
						if(packName.get(i) == "A") {
							price.add(48000);
						}
						else if(packName.get(i) == "B") {
							price.add(44000);
						}
						else if(packName.get(i) == "C") {
							price.add(40000);
						}
					}
					else if((age >= 3 && age <= 12) || age >= 65){ // ���� ���
						kinds.add("����/���");
						
						if(packName.get(i) == "A") {
							price.add(38000);
						}
						else if(packName.get(i) == "B") {
							price.add(35000);
						}
						else if(packName.get(i) == "C") {
							price.add(32000);
						}
					}
					
				}else if(choose == 5) { // �ӻ��   
					prefer.add("�ӻ��");
					
					if(age >= 19) { // ����
						kinds.add("����");
						
						if(packName.get(i) == "A") {
							price.add(51000);
						}
						else if(packName.get(i) == "B") {
							price.add(47000);
						}
						else if(packName.get(i) == "C") {
							price.add(42000);
						}
					}
				}
				totalPrice += price.get(i) * count.get(i);
				i++;
			}
		
		public void printPrice() { // ���� ���
			
			
			System.out.printf("�� ������ %d�� �Դϴ�.�����մϴ�.\n", totalPrice);
			
			System.out.println("==================��������==================");
			for(int idx=0; idx < count.size(); idx++) {
				System.out.printf("%sƼ�� %s X %d %d %s ������� \n",packName.get(idx), kinds.get(idx), count.get(idx),(price.get(idx)*count.get(idx)), prefer.get(idx) );
			}
			System.out.println("==========================================");
		}

		

	}


