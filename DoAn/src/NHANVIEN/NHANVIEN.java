package NhanVien;
import java.util.Scanner;
public class NhanVien implements INhap_IXuat{
	String manv;
	String tennv;
	String ngaysinhnv;
	String sdtnv;
	String diachinv;
	String luong;
	public NhanVien() {
		manv="";
		tennv="";
		ngaysinhnv="";
		sdtnv="";
		diachinv="";
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin nhan vien: ");
//        System.out.print("Ma nhan vien: "); manv=sc.nextLine();
        System.out.print("Ten nhan vien: "); tennv=sc.nextLine();
        System.out.print("Ngay sinh nhan vien: "); ngaysinhnv=sc.nextLine();
//        System.out.print("SDT nhan vien: "); sdtnv=sc.nextLine();
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
}
