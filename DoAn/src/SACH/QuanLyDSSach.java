package SACH;

import java.util.Scanner;

import abstr_interf.CHECK;

public class QuanLyDSSach{
    private DSSach dsSach = new DSSach();
    Scanner sc=new Scanner(System.in);

    public void Menu(){
        int lua_chon=0;
        boolean flag = true;
        while(flag){
            System.out.print(" 1)Them sach\n 2)Xoa sach\n 3)Sua sach\n 4)Xuat danh sach sach\n 5)Tim kiem sach\n 6)Kho sach\n 7)Quay lai\n 8)Thoat\n");
            System.out.print("Lua chon: ");
            String tmp;
            tmp=sc.nextLine();
        while(true){
               if(CHECK.isInteger(tmp)==true){
                    lua_chon=Integer.parseInt(tmp);
                    if(lua_chon>=1 && lua_chon<=8)
                        break;
                    else{
                        System.out.print("Nhap sai thong tin\n1)Them sach\n 2)Xoa sach\n 3)Sua sach\n 4)Xuat danh sach sach\n 5)Tim kiem sach\n 6)Kho sach\n 7)Quay lai\n 8)Thoat\n");
                        System.out.print("Lua chon: ");
                        tmp=sc.nextLine();
                    }
               }
               else{
                    System.out.println("Vui long nhap so nguyen");
                    tmp=sc.nextLine();
               }   
            }
            switch(lua_chon){
                case 1:
                    dsSach.them();
                    break;
                case 2:
                    dsSach.xoa();
                    break;
                case 3:
                    dsSach.sua();
                    break;
                case 4:
                    dsSach.danhsach();
                    break;
                case 5:
                    dsSach.timkiem();
                    break;
                case 6:
                    System.out.println("So luong sach co trong kho: "+SACH.getKhoSach());
                    break;
                case 7:
                    flag = false;
                    DSSach.luu();
                    break;
                case 8:
                    DSSach.luu();
                    System.exit(0);

            }
        }
    }
}