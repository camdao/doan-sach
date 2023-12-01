package SACH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import abstr_interf.CHECK;
import abstr_interf.MENU;

public class DSSach  extends MENU{
    public static ArrayList <SACH> DanhSachSach;
    Scanner sc = new Scanner(System.in); 

    public DSSach(){
        DanhSachSach = new ArrayList<SACH>(0);
    }

    public void them(){
        SACH sachmoi = new SACH();
        sachmoi.nhap();
        DanhSachSach.add(sachmoi);
        themsach(sachmoi.toString());
        SACH.updateKhoSach(sachmoi.getSoLuong());
        
    }
    public void xoa(){
        String MaSachXoa;
        boolean found=false;
        System.out.print("Nhap ma sach muon xoa: "); MaSachXoa=sc.nextLine();
        for (SACH sach : DanhSachSach)
            if (sach.getMaSach().equals(MaSachXoa)){
                found = true;
                SACH.updateKhoSach(-sach.getSoLuong());
                DanhSachSach.remove(sach);
                System.out.println("Da xoa !");
                break;
            }
        if (!found)
            System.out.println("Khong tim thay sach de xoa");
        else{
            luu();

        }
    }
    public void sua(){//sửa 3
        String MaSachSua;
        boolean found=false;
        System.out.print("Nhap ma sach muon sua: ");
        MaSachSua=sc.nextLine();

        for (SACH sach : DanhSachSach){//sửa 1
            if (sach.getMaSach().equals(MaSachSua)){
                found = true;
                sach.xuat();
                int lua_chon;
                String tmp;
                System.out.print("Chon thong tin can sua:\n 1)Ma sach\n 2)Ten sach\n 3)NXB\n 4)Tac gia\n 5)So trang\n 6)So Luong\n 7)Gia tien\n");
                tmp=sc.nextLine();
                while(true){
                    if(CHECK.isInteger(tmp)==true){
                    lua_chon=Integer.parseInt(tmp);
                    if(lua_chon>=1 && lua_chon <=7)
                        break;
                    else{
                        System.out.print("Nhap sai thong tin!!\nChon thong tin can sua:\n 1)Ma sach\n 2)Ten sach\n 3)NXB\n 4)Tac gia\n 5)So trang\n 6)So Luong\n 7)Gia tien\n");
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
                        System.out.print("Nhap ma sach moi: ");
                        sach.setMaSach(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhap ten sach moi: ");
                        sach.setTenSach(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Nhap NXB moi: ");
                        sach.setNXB(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Nhap tac gia moi: ");
                        sach.setTacGia(sc.nextLine());
                        break;
                    case 5://sửa 2
                        String tmp1;int sotrang;
                        System.out.println("Nhap so trang moi: ");
                            tmp1=sc.nextLine();
                        while(true){
                                if(CHECK.isInteger(tmp1)==true){
                                    sotrang=Integer.parseInt(tmp1);
                                    if(sotrang>=0){
                                        sach.setSoTrang(sotrang);
                                        break;
                                    }   
                                    else{
                                        System.out.println("So trang khong hop le\nNhap so trang moi: ");
                                        tmp1=sc.nextLine();
                                    }
                                }
                                else{
                                    System.out.println("Vui long nhap so nguyen");
                                    tmp1=sc.nextLine();
                                }   
                            }       
                        break;
                    case 6://sửa4
                        String tmp3;int soluong;
                        System.out.print("Nhap so luong moi: ");
                        tmp3=sc.nextLine();
                    while(true){
                        if(CHECK.isInteger(tmp3)==true){
                                soluong=Integer.parseInt(tmp3);
                                if(soluong>=0){
                                    sach.setSoLuong(soluong);
                                    break;
                                } 
                                else{
                                    System.out.print("Nhap sai thong tin!\nNhap so luong moi: ");
                                    tmp3=sc.nextLine();
                                }
                        }
                        else{
                                System.out.println("Vui long nhap so nguyen");
                                tmp3=sc.nextLine();
                        }   
                    }
                        break;
                    case 7:
                        String tmp2;int giatien;
                        System.out.println("Nhap gia tien moi: ");
                            tmp2=sc.nextLine();
                        while(true){
                                if(CHECK.isInteger(tmp2)==true){
                                    giatien=Integer.parseInt(tmp2);
                                    if(giatien>=0){
                                        sach.setGiaTien(giatien);
                                        break;
                                    }   
                                    else{
                                        System.out.println("Gia tien khong hop le\nNhap gia tien moi: ");
                                        tmp2=sc.nextLine();
                                    }
                                }
                                else{
                                    System.out.println("Vui long nhap so nguyen");
                                    tmp2=sc.nextLine();
                                }   
                            }               
                        System.out.println("Da sua !");
                        break;
                }
            }
        if (!found)
            System.out.println("Khong tim thay ma sach !");
        else
            luu();
        }
    }
    public void timkiem(){
        String MaSachTimKiem;
        boolean found=false;
        System.out.print("Nhap ma sach can tim: "); MaSachTimKiem=sc.nextLine();
        for (SACH sach : DanhSachSach){
            if (sach.getMaSach().equals(MaSachTimKiem)){
                found = true;
                sach.xuat();
                break;
            }
        }
        if (!found)
            System.out.println("Khong tim thay sach !");
    }

    public static void luu() {
        File file = new File("danh_sach_sach.txt");

        try {
        FileOutputStream fileStream = new FileOutputStream(file, false);
        PrintWriter writer = new PrintWriter(fileStream);
        writer.print("");
        writer.close();
        } catch (IOException e) {
            System.out.println("Xảy ra lỗi khi xóa nội dung của tệp tin: " + e.getMessage());
        }           
        for (SACH sach : DanhSachSach){
            themsach(sach.toString());
        }
    }
    public static void doc(){

        try {
            FileReader fileReader = new FileReader("danh_sach_sach.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                SACH sach = createSachFromLine(line);
                DanhSachSach.add(sach);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("loi tep");
        }
    }

    private static SACH createSachFromLine(String line) {
        String[] parts = line.split("\\|");
        SACH sach = new SACH(parts[0],parts[1],parts[2],parts[3],Integer.parseInt(parts[4]),Integer.parseInt(parts[5]),Integer.parseInt(parts[6]));
        return sach;
    }
    private static void themsach(String line) {
        try {
            File file = new File("danh_sach_sach.txt");
            boolean append = file.exists(); 

            FileWriter fileWriter = new FileWriter(file, append); 
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (IOException e) {

        }
    }
    public void danhsach() {
      int i=1;
        System.out.println("Danh sach co "+DanhSachSach.size()+" sach:");
        for (SACH sach : DanhSachSach) {
            System.out.print(i+"/ ");
            sach.xuat();
            System.out.println();
            i++;
        }
    }
}
