
import java.util.Random;

public class ClassManagement {
	
	String[] firstname = {"An","Anh","Bằng","Bảo","Châu","Chi","Dung","Dương","Dũng","Giang",
	"Hà","Hạnh","Hiếu","Hiền","Hoàng","Hiệp","Hùng","Hưng","Hương","Huy",
	"Huyền","Hoa","Khanh","Khánh","Khoa","Khôi","Kiên","Lâm","Lan","Linh",
	"Ly","Liên","Lộc","Long","Minh","Mạnh","Mai","My","Nam","Nga",
	"Ngọc","Phương","Phong","Sơn","Trung","Tùng","Tú","Trang","Thu","Việt"
	};
	String[] lastname = {"Nguyễn","Trần","Lê","Phạm","Hoàng","Huỳnh","Phan","Vũ","Võ","Đặng",
	"Bùi","Đỗ","Hồ","Ngô","Lý"
	};
	String[] middlename = {"An","Bảo","Bích","Công","Đăng","Đình","Dạ","Duy","Gia","Hữu",
	"Hoàng","Hồng","Khánh","Linh","Mai","Minh","Ngân","Ngọc","Nhật","Mạnh",
	"Nghĩa","Quang","Thái","Tiến","Trí","Nam","Việt","Thanh","Thu","Thúy" 
	};
	
	private static int randInt(int min, int max) {
		Random rand = new Random();
		int rd = rand.nextInt((max - min) + 1) + min;	
		return rd;
	}
		
	private static boolean isExist(String[] ar,String vl){
		for(int i=0;i<ar.length;i++){
			if(vl.equals(ar[i])){
				return true;
			}
		}
		return false;
	}
	
	public String[] nameCreate(int num){
		String[] stdName = new String[num];
		for(int i=0;i<num;i++){
			String nameoutput;
			do{
				int fnindex = randInt(0,49);
				int mnindex = randInt(0,29);
				int lnindex = randInt(0,14);
				nameoutput = lastname[lnindex]+" "+middlename[mnindex]+" "+firstname[fnindex];
			}
			while(isExist(stdName,nameoutput));
			
			stdName[i] = nameoutput;
		}
		
		return stdName;
	}
	
	public String[] idCreate(int num){
		String[] stdID = new String[num];
		for(int i=0;i<num;i++){
			String IDoutput;
			do{			
				int id1 = randInt(0,9);
				int id2 = randInt(0,9);
				int id3 = randInt(0,9);
				int id4 = randInt(0,9);
				int id5 = randInt(0,9);
				int id6 = randInt(0,9);
				int id7 = randInt(0,9);
				IDoutput = "HV" + id1 + id2 + id3 + id4 + id5 + id6 + id7;
			}
			while(isExist(stdID,IDoutput));
			
			stdID[i] = IDoutput;
		}
		return stdID;
	}
	
	public String[] birthCreate(int num){
		String[] stdBirth = new String[num];
		for(int i=0;i<num;i++){
			String birthoutput;
			do{
				int year = 1991;
				int monthTemp = randInt(2,12);
				int dayTemp = 0;
				switch(monthTemp){
					case 2: 
						dayTemp = randInt(1,28);
						break;
					case 3: case 5: case 7: case 8: case 10: case 12: 
						dayTemp = randInt(1,31);
						break;
					case 4: case 6: case 9: case 11: 
						dayTemp = randInt(1,30);
						break;
				}
				
				String month = "" ;
				String day = "";
				if(monthTemp<10){
					month = ("0"+String.valueOf(monthTemp));
				}
				else{
					month = String.valueOf(monthTemp);
				}
				
				if(dayTemp<10){
					day = ("0"+String.valueOf(dayTemp));
				}
				else{
					day = String.valueOf(dayTemp);
				}
				
				birthoutput = (day + "/" + month + "/" + String.valueOf(year));			
			}
			while(isExist(stdBirth,birthoutput));
			
			stdBirth[i] = birthoutput;
		}
		return stdBirth;
	}
		
	public int[] markCreate(int num ,int a , int b , int c , int d){
		int[] score = new int[num];
		int count = 0;
		int position = 0;
		for(int i =0;i<num;i++){
			score[i] = 0;
		}
		// 8 - 10
		while(count<a){
			position = randInt(0,num-1);
			if(score[position]==0){
				score[position] = (int)randInt(8,10);
				count++;
			} 
		}
		// 5 - 7
		while(count<a+b){
			position = randInt(0,num-1);
			if(score[position]==0){
				score[position] = (int)randInt(5,7);
				count++;
			}
		}
		// 3 - 4
		while(count<a+b+c){
			position = randInt(0,num-1);
			if(score[position]==0){
				score[position] = (int)randInt(3,4);
				count++;
			}
		}
		// 1 - 2
		while(count<a+b+c+d){
			position = randInt(0,num-1);
			if(score[position]==0){
				score[position] = (int)randInt(1,2);
				count++;
			}
		}
		// 0
		return score;
	}

	public static void main(String[] args){
		ClassManagement mng = new ClassManagement();
		String[] stdlist = mng.nameCreate(25);
		String[] idlist = mng.idCreate(25);
		String[] birthlist = mng.birthCreate(25);
		int[] markRA = mng.markCreate(25,3,13,6,2);
		int[] markSD = mng.markCreate(25,3,13,6,2);
		int[] markCP = mng.markCreate(25,3,13,6,2);
		int[] markCUT = mng.markCreate(25,3,13,6,2);
		int[] markFMT = mng.markCreate(25,3,13,6,2);	
		
		System.out.println("");	
		System.out.println("  STT    Họ Tên\t\t      ID\t Ngày Sinh\tRA\tSD\tCP\tCUT\tFMT\tĐiểmTB\t   Loại\t\t Điểm liệt ");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------\n");
		
		for(int i=0;i<25;i++){				
			float avg = (float)(markRA[i]+markSD[i]+markCP[i]+markCUT[i]+markFMT[i])/5;			
			String rank;		
			if(avg>=8){
				rank = "Giỏi";
			}
			else if(avg>=6.5&&avg<=7.9){
				rank = "Khá";
			}
			else if(avg>=5&&avg<=6.4){
				rank = "Trung bình";
			}
			else if(avg>=3.1&&avg<=4.9){
				rank = "Yếu";
			}
			else{ 
				rank = "Kém";
			}
			
			String fail;
			if(markRA[i]<=3||markSD[i]<=3||markCP[i]<=3||markCUT[i]<=3||markFMT[i]<=3){
				fail = " X ";
			}
			else{
				fail = "";	
			}
			
			System.out.printf("   %-5d%-20s%-13s%-16s%1d\t%1d\t%1d\t%1d\t%1d\t%.1f\t   %-13s%7s\n",i+1,stdlist[i],idlist[i],birthlist[i],markRA[i],markSD[i],markCP[i],markCUT[i],markFMT[i],avg,rank,fail);			
		}	
	}
}