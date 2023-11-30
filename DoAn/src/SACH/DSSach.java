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
import java.util.InputMismatchException;
import java.util.Scanner;

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
    public void sua(){
        String MaSachSua;
        boolean found=false;
        System.out.print("Nhap ma sach muon sua: "); MaSachSua=sc.nextLine();

        for (SACH sach : DanhSachSach){
            if (sach.getMaSach().equals(MaSachSua)){
                found = true;
                sach.xuat(); System.out.println();
                System.out.println("Chon thong tin can sua: ");
                System.out.print(" 1)Ma sach\n 2)Ten sach\n 3)NXB\n 4)Tac gia\n 5)So trang\n 6)So Luong\n 7)Gia tien\n");
                int lua_chon=sc.nextInt(); sc.nextLine();
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
                    case 5:
                        while (true) {
                            try{
                                System.out.print("Nhap so trang moi: ");
                                sach.setSoTrang(sc.nextInt());
                                sc.nextLine();
                                break;
                                }
                            catch(InputMismatchException ex){
                                System.out.println("Nhap Sai Du Lieu So Trang,vui long nhap so");
                                sc.nextLine();
                            }
                        }        
                        break;
                    case 6:
                        while (true) {
                            try{
                                int SoLuongCu=sach.getSoLuong();
                                System.out.print("Nhap so luong moi: ");
                                sach.setSoLuong(sc.nextInt());
                                SACH.updateKhoSach(sach.getSoLuong()-SoLuongCu);
                                sc.nextLine();
                                break;
                                }
                            catch(InputMismatchException ex){
                                System.out.println("Nhap Sai Du Lieu So Luong,vui long nhap so");
                                sc.nextLine();
                            }
                        }        
                        break;
                    case 7:
                        while (true) {
                            try{
                                System.out.print("Nhap gia tien moi: ");
                                sach.setGiaTien(sc.nextInt());
                                sc.nextLine();
                                break;
                                }
                            catch(InputMismatchException ex){
                                System.out.println("Nhap Sai Du Lieu So Luong,vui long nhap so");
                                sc.nextLine();
                            }
                        }  
                        break;                      
                }
                System.out.println("Da sua !");
                break;
            }
        }
        if (!found)
            System.out.println("Khong tim thay ma sach !");
        else{
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
