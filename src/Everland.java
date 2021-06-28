
import java.util.Calendar;
import java.util.Scanner;


public class Everland {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		// String pId,prefer = null, YN = null, packName = null,kinds = new String();
		String pId, prefer []= new String[100], YN = null, packName [] = new String[100], kinds[] = new String[100];
		int[] count = new int[100];
		int useDate=0, price []=new int[100],totalPrice=0, choose=0,i=0;
		int year=0, month=0, day=0, currentYear=0, currentMonth=0, currentDay=0, age=0;
		
		Calendar cal = Calendar.getInstance();
		currentYear=cal.get(Calendar.YEAR);
		currentMonth=cal.get(Calendar.MONTH)+1; // 0부터 시작하므로 1추가 
		currentDay=cal.get(Calendar.DAY_OF_MONTH);
		
		// 캘린더 날짜 A 패키지 B 패키지 C 패키지  
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
			
			// 이용날짜
			System.out.println("이용날짜를 입력해주세요.");
			useDate = input.nextInt();
				
  		    // 이용날짜 입력 길이 미만 혹은 초과 시
			if((int)Math.log10(useDate)+1 < 8 || (int)Math.log10(useDate)+1 > 8) {
				System.out.println("다시 입력해주세요");
				continue;
			}
			
			// 주민번호 입력 및 년도, 월, 일 추출
			System.out.println("주민번호 입력 예) 950914 ");
			pId=input.next();
			
			// 주민번호 입력 길이 미만 혹은 초과 시
			if(pId.length() < 6 || pId.length() > 6) { 
				System.out.println("다시 입력해주세요");
				continue;
			}
									
			year = Integer.parseInt(pId.substring(0,2));
			month= Integer.parseInt(pId.substring(2,4));
			day= Integer.parseInt(pId.substring(4,6));
			
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
			
			// 티켓 주문 갯수
			System.out.println("몇 개를 주문하시겠습니까?");
			count[i] = input.nextInt();
			
			// 우대 사항 선택 
			System.out.print("우대사항을 선택하세요.\n");
			System.out.print(" 1. 없음\n 2. 장애인\n 3. 국가유공자\n 4. 다자녀\n 5. 임산부\n");
			choose = input.nextInt();
			
			// 우대사항 선택 사항 수 5개보다 클 경우
			if(choose < 1 || choose > 5) { 
				System.out.println("다시 입력해주세요.");
				continue;
			}
			
			// 사용자의 이용 날짜와 패키지 배열 간 값이 일치할 경우, packName 변수에 패키지 종류 리턴 
			for(int idx=0; idx<A.length; idx++) {
				if(useDate == A[idx])
					packName[i] = "A";
			}
			
			for(int idx=0; idx<B.length; idx++) {
				if(useDate == B[idx])
					packName[i] = "B";
			}
			
			for(int idx=0; idx<C.length; idx++) {
				if(useDate == C[idx])
					packName[i] = "C";
			}
			
			if(choose == 1) { // 나이 우대
				prefer[i] = "없음"; // 우대 사항 
				
				if(age >= 19 || (age >= 13 && age <= 18)) { // 대인/청소년
					kinds[i] = "대인/청소년"; 
					
					if(packName[i] == "A") { // 이용날짜 
						price[i] += 60000;
					}
					else if(packName[i] == "B") {
						price[i] += 56000;
					}
					else if(packName[i] == "C") {
						price[i] += 50000;
					}
				}
				
				else if(age >= 65 || (age >= 3 && age <= 12)){ // 소인 경로
					kinds[i]="소인/경로";
										
					if(packName[i] == "A") {
						price[i] += 48000;
					}
					else if(packName[i] == "B") {
						price[i] += 44000;
					}
					else if(packName[i] == "C") {
						price[i] += 40000;
					}
					
				}
			} else if(choose == 2) { // 장애인 
				prefer[i] = "장애인"; // 우대 사항 
				
				if(age >= 19) { // 대인
					kinds[i]="대인";
					
					if(packName[i] == "A") {
						price[i] += 36000;
					}
					else if(packName[i] == "B") {
						price[i] += 33000;
					}
					else if(packName[i] == "C") {
						price[i] += 30000;
					}
				}
				else if((age >= 13 && age <= 18) || (age >= 3 && age <= 12) || age >= 65 ){ // 청소년/소인/경로
					kinds[i]="청소년/소인/경로";
					
					if(packName[i] == "A") {
						price[i] += 28000;
					}
					else if(packName[i] == "B") {
						price[i] += 26000;
					}
					else if(packName[i] == "C") {
						price[i] += 24000;
					}
				}
			} else if(choose == 3) { // 국가 유공자 
				prefer[i] = "국가유공자";
				
				if(age >= 19) { // 대인
					kinds[i]="대인";
					
					if(packName[i] == "A") {
						price[i] += 30000;
					}
					else if(packName[i] == "B") {
						price[i] += 28000;
					}
					else if(packName[i] == "C") {
						price[i] += 25000;
					}
				}
				else if((age >= 13 && age <= 18) || (age >= 3 && age <= 12) || age >= 65 ){ // 청소년 소인 경로
					prefer[i] = "청소년/소인/경로";
					if(packName[i] == "A") {
						price[i] += 24000;
					}
					else if(packName[i] == "B") {
						price[i] += 22000;
					}
					else if(packName[i] == "C") {
						price[i] += 20000;
					}
				}
			} else if(choose == 4) { // 다자녀 
				prefer[i] = "다자녀";
				if(age >= 18 || (age >= 13 && age <= 18)) { // 대인/청소년
					kinds[i]="대인/청소년";
					
					if(packName[i] == "A") {
						price[i] += 48000;
					}
					else if(packName[i] == "B") {
						price[i] += 44000;
					}
					else if(packName[i] == "C") {
						price[i] += 40000;
					}
				}
				else if((age >= 3 && age <= 12) || age >= 65){ // 소인 경로
					kinds[i] = "소인/경로";
					
					if(packName[i] == "A") {
						price[i] += 38000;
					}
					else if(packName[i] == "B") {
						price[i] += 35000;
					}
					else if(packName[i] == "C") {
						price[i] += 32000;
					}
				}
				
			} else if(choose == 5) { // 임산부   
				prefer[i] = "임산부";
				
				if(age >= 19) { // 대인
					kinds[i]="대인";
					
					if(packName[i] == "A") {
						price[i] += 51000;
					}
					else if(packName[i] == "B") {
						price[i] += 47000;
					}
					else if(packName[i] == "C") {
						price[i] += 42000;
					}
				}
				
			}
			
			// 계산 
			price[i] = price[i] * count[i];
			totalPrice += price[i];
			i++;
			
			System.out.printf("총 가격은 %d원 입니다.감사합니다.\n", totalPrice);
			
			// 각 변수 배열화 packName, kinds, count, prefer
			System.out.println("==================에버렌드==================");
			for(int idx=0; idx < i; idx++) {
				System.out.printf("%s티켓 %s X %d %d %s 우대적용 \n",packName[idx], kinds[idx], count[idx],price[idx], prefer[idx] );
			}
			System.out.println("==========================================");
			
		
			// 추가 구매하고자할 때 Y 입력 => while문 상단으로 이동 / N 입력 시 프로그램 종료 
			System.out.println("추가 구매 Y / 종료 N (Y/N)");
			YN = input.next();
			
			if(YN.equals("y") || YN.equals("Y")) {
				continue;
			} else {
				break;
			}
			
		} 
		input.close();
		
	}

}
