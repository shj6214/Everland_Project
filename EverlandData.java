package Everland;

import java.util.ArrayList;
import java.util.Scanner; 

public class EverlandData {

		public ArrayList<DataClass> arrData = new ArrayList<DataClass>();
				
		public int i=0;

		public int totalPrice=0, age=0;
		
		
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
			
			// 사용자의 이용 날짜와 패키지 배열 간 값이 일치할 경우, packName 변수에 패키지 종류 리턴 
			if(choose == 1) { // 나이 우대
				item.prefer="없음"; // 우대 사항 
				
				if(age >= 19 || (age >= 13 && age <= 18)) { // 대인/청소년
					item.kinds="대인/청소년"; 
					
					if(item.packName == "A") { // 이용날짜 
						item.price = 60000;
					}
					else if(item.packName == "B") {
						item.price = 56000;
					}
					else if(item.packName == "C") {
						item.price = 50000;
					}
				}
				else if(age >= 65 || (age >= 3 && age <= 12)){ // 소인 경로
					item.kinds="소인/경로";
										
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
			}else if(choose == 2) { // 장애인 
				item.prefer="장애인"; // 우대 사항 
					
				if(age >= 19) { // 대인
					item.kinds="대인";
						
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
				else if((age >= 13 && age <= 18) || (age >= 3 && age <= 12) || age >= 65 ){ // 청소년/소인/경로
					item.kinds="청소년/소인/경로";
						
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
			} else if(choose == 3) { // 국가 유공자 
				item.prefer="국가유공자";
					
				if(age >= 19) { // 대인
					item.kinds = "대인";
						
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
				else if((age >= 13 && age <= 18) || (age >= 3 && age <= 12) || age >= 65 ){ // 청소년 소인 경로
					item.prefer="청소년/소인/경로";
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
			} else if(choose == 4) { // 다자녀 
				item.prefer="다자녀";
					if(age >= 18 || (age >= 13 && age <= 18)) { // 대인/청소년
						item.kinds="대인/청소년";
						
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
					else if((age >= 3 && age <= 12) || age >= 65){ // 소인 경로
						item.kinds="소인/경로";
						
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
					
				}else if(choose == 5) { // 임산부
					item.prefer="임산부";
					
					if(age >= 19) { // 대인
						item.kinds="대인";
						
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
		
		public void printPrice() { // 가격 계산

			System.out.printf("총 가격은 %d원 입니다.감사합니다.\n", totalPrice);
			
			System.out.println("==================에버렌드==================");
			for(int idx=0; idx < arrData.size(); idx++) {
				System.out.printf("%s티켓 %s X %d %d %s 우대적용 \n",arrData.get(idx).packName, arrData.get(idx).kinds, arrData.get(idx).tcount,(arrData.get(idx).price*arrData.get(idx).tcount), arrData.get(idx).prefer );
				
				// 쿠폰 존재 여부
				if(arrData.get(idx).isEventCoupon == 1) {
					System.out.println("쿠폰 할인 적용");
				}else {
					System.out.println("쿠폰이 없습니다.");
				}
				
			}
			System.out.println("==========================================");
		}
	}


