package SACH;

import java.util.InputMismatchException;
import java.util.Scanner;

import abstr_interf.*;

public class SACH implements INhap,IXuat{
    Scanner sc = new Scanner(System.in);
    
    private String MaSach;
    private String TenSach;
    private String NXB;
    private String TacGia;
    private int SoTrang;
    private int SoLuong;
    private int GiaTien;

    private static int KhoSach;
    public static int getKhoSach(){
        return KhoSach;
    }
    public static void updateKhoSach(int n){//n la so luong sach muon them hoac giam 
        KhoSach+=n;
    }
    public SACH(){
        MaSach=NXB=TacGia="";
        SoLuong=SoTrang=GiaTien=0;
    }
    public SACH(String MaSach,String TenSach,String NXB,String TacGia,int SoTrang,int SoLuong,int GiaTien){
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.NXB = NXB;
        this.TacGia = TacGia;
        this.SoTrang = SoTrang;
        this.SoLuong = SoLuong; 
        KhoSach+=SoLuong;
        this.GiaTien = GiaTien;
    }

    public void xuat(){
        System.out.print("Ma sach: "+MaSach+", Ten sach: "+TenSach+", Nha xuat ban: "+NXB+", Tac gia: "+TacGia+", So Trang: "+SoTrang+", So luong:"+SoLuong+", Gia Tien: "+GiaTien);
    }

    public void nhap(){
        System.out.println("Nhap cac thong tin cua sach: ");
        System.out.print("Ma sach: "); MaSach=sc.nextLine();
        System.out.print("Ten sach: "); TenSach=sc.nextLine();
        System.out.print("Nha xuat ban: "); NXB=sc.nextLine();
        System.out.print("Tac gia: "); TacGia=sc.nextLine();
        while (true) {
            try{
                System.out.print("So trang: "); 
                SoTrang=sc.nextInt();
                sc.nextLine();
                break;
                }
            catch(InputMismatchException ex){
                System.out.println("Nhap Sai Du Lieu So Trang,vui long nhap so");
                sc.nextLine();
            }
        }
        while (true) {
            try{
                System.out.print("So luong: "); SoLuong=sc.nextInt(); 
                KhoSach+=SoLuong;
                sc.nextLine();
                break;
                }
            catch(InputMismatchException ex){
                System.out.println("Nhap Sai Du Lieu So luong,vui long nhap so");
                sc.nextLine();
            }
        }
        while (true) {
            try{
                System.out.print("Gia tien: "); GiaTien=sc.nextInt();
                sc.nextLine();
                break;
                }
            catch(InputMismatchException ex){
                System.out.println("Nhap Sai Du Lieu Gia tien,vui long nhap so");
                sc.nextLine();
            }
        }    
    }

    @Override
    public String toString() {
        return MaSach + "|" + TenSach + "|" + NXB+ "|" + TacGia + "|" + SoTrang+ "|" + SoLuong + "|" + GiaTien;
    }
    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String maSach) {
        MaSach = maSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }
    
    public String getNXB() {
        return NXB;
    }

    public void setNXB(String nxb) {
        NXB = nxb;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String tacGia) {   
        TacGia = tacGia;
    }

    public int getSoTrang() {
        return SoTrang;
    }

    public void setSoTrang(int soTrang) {
        SoTrang = soTrang;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(int giaTien) {
        GiaTien = giaTien;
    }
}

