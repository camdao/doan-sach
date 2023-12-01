package SACH;
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
        //sửa 1
        String tmp1;
        System.out.print("So trang: "); 
            tmp1=sc.nextLine();
        while(true){
               if(CHECK.isInteger(tmp1)==true){
                    SoTrang=Integer.parseInt(tmp1);
                    if(SoTrang>=0)
                        break;
                    else{
                        System.out.print("Nhap sai thong tin\nSo trang: "); 
                        tmp1=sc.nextLine();
                    }
               }
               else{
                    System.out.println("Vui long nhap so nguyen");
                    tmp1=sc.nextLine();
               }   
            }
        //sửa 2
        String tmp2;
        System.out.print("So luong: ");  
            tmp2=sc.nextLine();
        while(true){
               if(CHECK.isInteger(tmp2)==true){
                    SoLuong=Integer.parseInt(tmp2);
                    if(SoLuong>=0){
                        KhoSach+=SoLuong;
                        break;
                    }  
                    else{
                        System.out.print("Nhap sai thong tin\nSo luong: "); 
                        tmp2=sc.nextLine();
                    }
               }
               else{
                    System.out.println("Vui long nhap so nguyen");
                    tmp2=sc.nextLine();
               }   
            }
        //sửa 3
        String tmp3;
        System.out.print("Gia Tien ");  
            tmp3=sc.nextLine();
        while(true){
               if(CHECK.isInteger(tmp3)==true){
                    GiaTien=Integer.parseInt(tmp3);
                    if(GiaTien>=0)
                        break;
                    else{
                        System.out.print("Nhap sai thong tin\nGia Tien "); 
                        tmp3=sc.nextLine();
                    }
               }
               else{
                    System.out.println("Vui long nhap so nguyen");
                    tmp3=sc.nextLine();
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

    public void setSoTrang(int SoTrang) {
        this.SoTrang = SoTrang;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(int GiaTien) {
        this.GiaTien = GiaTien;
    }
}

