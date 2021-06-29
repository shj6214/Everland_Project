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
			// 만 나이 계산
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
			
			// 사용자의 이용 날짜와 패키지 배열 간 값이 일치할 경우, packName 변수에 패키지 종류 리턴 
			if(choose == 1) { // 나이 우대
				prefer.add("없음"); // 우대 사항 
				
				if(age >= 19 || (age >= 13 && age <= 18)) { // 대인/청소년
					kinds.add("대인/청소년"); 
					
					if(packName.get(i) == "A") { // 이용날짜 
						price.add(60000);
					}
					else if(packName.get(i) == "B") {
						price.add(56000);
					}
					else if(packName.get(i)  == "C") {
						price.add(50000);
					}
				}
				else if(age >= 65 || (age >= 3 && age <= 12)){ // 소인 경로
					kinds.add("소인/경로");
										
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
			}else if(choose == 2) { // 장애인 
				prefer.add("장애인"); // 우대 사항 
					
				if(age >= 19) { // 대인
					kinds.add("대인");
						
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
				else if((age >= 13 && age <= 18) || (age >= 3 && age <= 12) || age >= 65 ){ // 청소년/소인/경로
					kinds.add("청소년/소인/경로");
						
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
			} else if(choose == 3) { // 국가 유공자 
				prefer.add("국가유공자");
					
				if(age >= 19) { // 대인
					kinds.add("대인");
						
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
				else if((age >= 13 && age <= 18) || (age >= 3 && age <= 12) || age >= 65 ){ // 청소년 소인 경로
					prefer.add("청소년/소인/경로");
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
			} else if(choose == 4) { // 다자녀 
					prefer.add("다자녀");
					if(age >= 18 || (age >= 13 && age <= 18)) { // 대인/청소년
						kinds.add("대인/청소년");
						
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
					else if((age >= 3 && age <= 12) || age >= 65){ // 소인 경로
						kinds.add("소인/경로");
						
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
					
				}else if(choose == 5) { // 임산부   
					prefer.add("임산부");
					
					if(age >= 19) { // 대인
						kinds.add("대인");
						
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
		
		public void printPrice() { // 가격 계산
			
			
			System.out.printf("총 가격은 %d원 입니다.감사합니다.\n", totalPrice);
			
			System.out.println("==================에버렌드==================");
			for(int idx=0; idx < count.size(); idx++) {
				System.out.printf("%s티켓 %s X %d %d %s 우대적용 \n",packName.get(idx), kinds.get(idx), count.get(idx),(price.get(idx)*count.get(idx)), prefer.get(idx) );
			}
			System.out.println("==========================================");
		}

		

	}


