package NHANVIEN;
import java.util.Scanner;
import abstr_interf.CHECK;


public class QuanLyDSNhanVien {
    public DSNhanVien dsNhanVien;
    Scanner sc = new Scanner(System.in);
    public QuanLyDSNhanVien(){
    	dsNhanVien = new DSNhanVien();
    }
    public void Menu(){
        boolean flag=true;
        while(flag){//vòng lặp lặp lại việc chọn thao tác
            int lua_chon=0;
            String tmp;
                System.out.println(" 1/Them nhan vien.\n 2/Xoa nhan vien.\n 3/Sua nhan vien.\n 4/Xuat danh sach nhan vien.\n 5/Tim kiem nhan vien.\n 6.Quay lai.\n 7.Thoat\n");
                System.out.print("Lua chon: ");    
                tmp=sc.nextLine();
            while(true){
                if(CHECK.isInteger(tmp)==true){
                    lua_chon=Integer.parseInt(tmp);
                    if(lua_chon>=1 && lua_chon<=7)
                        break;
                    else{
                        System.out.println("Nhap sai cu phap!\n1/Them nhan vien.\n 2/Xoa nhan vien.\n 3/Sua nhan vien.\n 4/Xuat danh sach nhan vien.\n 5/Tim kiem nhan vien.\n 6.Quay lai.\n 7.Thoat\n");
                        System.out.print("Lua chon: ");
                        tmp=sc.nextLine();
                    }
                }
                else{
                    System.out.println("Vui long nhap so nguyen");
                    System.out.print("Lua chon: ");
                    tmp=sc.nextLine();
                }
            }
            switch(lua_chon){
                case 1:
                    dsNhanVien.them();
                    break;
                case 2:
                    dsNhanVien.xoa();
                    break;
                case 3:
                    dsNhanVien.sua();
                    break;
                case 4:
                    dsNhanVien.danhsach();
                    break;
                case 5:
                    dsNhanVien.timkiem();
                    break;
                case 6:
                    DSNhanVien.WriteFile();
                    flag=false;
                    break;
                case 7:
                    DSNhanVien.WriteFile();
                    flag=false;
                    System.exit(0);
            }
        }
    }
}