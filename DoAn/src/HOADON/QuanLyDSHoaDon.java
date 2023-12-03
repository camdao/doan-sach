package HOADON;

import java.util.Scanner;
import abstr_interf.CHECK;

public class QuanLyDSHoaDon{
    public DSHoaDon dsHoaDon;

    public QuanLyDSHoaDon (){
        dsHoaDon = new DSHoaDon();
    }
    Scanner sc =new Scanner(System.in);
    public void Menu(){
        boolean flag = true;
        while(flag){ 
            System.out.println(" 1)Them hoa don\n 2)Tim kiem hoa don\n 3)Xoa hoa don\n 4)Xuat danh sach hoa don\n 5)Quay lai\n 6)Thoat");
            System.out.print("Lua chon: "); String temp = sc.nextLine();
            int lua_chon;
            if (!CHECK.isInteger(temp)) lua_chon=0;
            else lua_chon=Integer.parseInt(temp);
            switch (lua_chon) {
                case 1:
                    dsHoaDon.them();
                    break;
                case 2:
                    dsHoaDon.timkiem();
                    break;
                case 3:
                    dsHoaDon.xoa();
                    break;
                case 4:
                    dsHoaDon.danhsach();
                    break;
                case 5:
                    flag = false;
                    DSHoaDon.WriteFile();
                    break;
                case 6:
                    DSHoaDon.WriteFile();
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong hop le !");
                    break;
            }
        }
    }
}

