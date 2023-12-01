package NHANVIEN;

import java.util.Scanner;
import abstr_interf.*;


public class NHANVIEN implements INhap,IXuat{
	Scanner sc=new Scanner(System.in);

	public String manv;
	public String tennv;
	public String ngaysinhnv;
	public String sdtnv;
	public String diachinv;
	public String luong;
	public NHANVIEN() {
		manv="";
		tennv="";
		ngaysinhnv="";
		sdtnv="";
		diachinv="";
	}
	public void nhap() {
        System.out.println("Nhap thong tin nhan vien: ");
        System.out.print("Ten nhan vien: "); tennv=sc.nextLine();
		boolean nhaplaingaysinh=false;
	    while (!nhaplaingaysinh) {
	    	System.out.println("Ngay sinh nhan vien: ");
            ngaysinhnv=sc.nextLine();
            if(!isValidNgaySinh(ngaysinhnv)){
            	System.out.println("Dinh dang ngay sinh khong hop le. Su dung dinh dang dd/mm/yyyy!");
            }
            else{
                nhaplaingaysinh = true;
            }
        }
        System.out.print("Dia chi nhan vien: "); diachinv=sc.nextLine();
        System.out.print("Luong: "); luong=sc.nextLine();

	}
	public void xuat() {
		System.out.println("Ma nhan vien: "+manv);
		System.out.println("Ten nhan vien: "+tennv);
		System.out.println("Ngay sinh nhan vien: "+ngaysinhnv);
		System.out.println("SDT nhan vien: "+sdtnv);
		System.out.println("Dia chi nhan vien: "+diachinv);
		System.out.println("Luong: "+luong);
		
	}
    public static boolean isValidNgaySinh(String ngaysinhnv) {
    	int check1=2;//Vi tri dau / thu nhat;
    	char c1=ngaysinhnv.charAt(check1);
    	String c11=String.valueOf(c1);
    	int check2=5;//Vi tri dau / thu 2;
    	char c2=ngaysinhnv.charAt(check2);
    	String c22=String.valueOf(c2);
    	if(ngaysinhnv.length() == 10 && c11.equals("/") && c22.equals("/")){
    		try{
    			int day = Integer.parseInt(ngaysinhnv.substring(0, 2));
                int month = Integer.parseInt(ngaysinhnv.substring(3, 5));
                int year = Integer.parseInt(ngaysinhnv.substring(6));
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