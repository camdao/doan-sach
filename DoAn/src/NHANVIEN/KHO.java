package NHANVIEN;

import java.util.Scanner;

public class KHO extends NHANVIEN{
	Scanner sc=new Scanner(System.in);
	String ngaykiemkho;
	public KHO() {
		ngaykiemkho="";
	}

	public void nhap() {
		super.nhap();
		boolean nhaplai=false;
	    while (!nhaplai) {
	    	System.out.println("Nhap ngay kiem kho: ");
            ngaykiemkho=sc.nextLine();
            if(!checkngaykiemkho(ngaykiemkho)){
            	System.out.println("Dinh dang ngay khong hop le. Su dung dinh dang dd/mm/yyyy!");
            }
            else{
                nhaplai = true;
            }
        }
	}
	public void xuat() {
		super.xuat();
		System.out.println("Cong viec: Kho");
		System.out.println("Ngay kiem kho: "+ngaykiemkho);
	}
	public static boolean checkngaykiemkho(String z) {
    	if(z.length() == 10){
    		try{
    			int day = Integer.parseInt(z.substring(0, 2));
                int month = Integer.parseInt(z.substring(3, 5));
                int year = Integer.parseInt(z.substring(6));
                boolean namnhuan=false;
                if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    namnhuan=true;
                }
                int songaytrongthang = 0;
                switch (month)
            	{
            	case 1:
            	case 3:
            	case 5:
            	case 7:
            	case 8:
            	case 10:
            	case 12: 
            		songaytrongthang = 31;
            		break;
            	case 4:
            	case 6:
            	case 9:
            	case 11: 
            		songaytrongthang = 30;
            		break;
            	case 2:
            		if(!namnhuan)
            		{
            			songaytrongthang = 28;
            		}
            		else
            		{
            			songaytrongthang = 29;
            		}
            		break;
            	}
            	if(day>=1 && day<=songaytrongthang && month>=1 && month<=12 && year>0) {
            		return true;
            	}
            } catch (NumberFormatException e) {
                // Xử lý nếu không chuyển được sang số
            }
    	}
    	return false;
    }
}