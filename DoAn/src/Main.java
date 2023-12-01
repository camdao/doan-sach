import java.util.Scanner;

import HOADON.*;
import KHACHHANG.*;
import SACH.*;
import abstr_interf.CHECK;
import NHANVIEN.*;

public class Main {
    public static void main(String[] args) {
        QuanLyDSHoaDon qlHoaDon = new QuanLyDSHoaDon();
        QuanLyDSSach qlSach =new QuanLyDSSach();
        QuanLyDSNhanVien qlNhanVien = new QuanLyDSNhanVien();
        QL_DSKHACHHANG qlKhachHang = new QL_DSKHACHHANG();

        DSHoaDon.ReadFile();
        DSKHACHHANG.doc();
        DSSach.doc();
        DSNhanVien.ReadFile();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
        
           int lua_chon;
            String tmp;
            System.out.print(" 1)Quan ly sach\n 2)Quan ly nhan vien\n 3)Quan ly hoa don\n 4)Quan ly khach hang\n 5)Thoat\n");
            System.out.print("Lua chon: ");

            tmp=sc.nextLine();
            while(true){
                if(CHECK.isInteger(tmp)==true){
                    lua_chon=Integer.parseInt(tmp);
                    if(lua_chon>=1 && lua_chon<=5)
                        break;
                    else{
                        System.out.println("!!! Nhap sai lua chon");
                        System.out.print(" 1)Quan ly sach\n 2)Quan ly nhan vien\n 3)Quan ly hoa don\n 4)Quan ly khach hang\n 5)Thoat\n");
                        System.out.print("Lua chon: ");
                        tmp=sc.nextLine();
                    }
                }
                else{
                    System.out.println("Vui long nhap so nguyen");
                    tmp=sc.nextLine();
                }
            }

            switch (lua_chon) {
                case 1:
                    qlSach.Menu();
                    break;
                case 2:
                    qlNhanVien.Menu();
                    break;
                case 3:
                    qlHoaDon.Menu();
                    break;
                case 4:
                    qlKhachHang.Menu();
                    break;
                case 5:
                    flag=false;
                    break;
            }
        }
    }
}

