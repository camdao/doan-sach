package KHACHHANG;
import java.util.Scanner;
import abstr_interf.CHECK;

public class KHACHHANGTX extends KHACHHANG{
        private int diemtichluy;
        Scanner sc=new Scanner(System.in);
        public KHACHHANGTX(){
            super();
            diemtichluy = 0;
        }
        @Override
        public void nhap(){ 
            String tmp;
            super.nhap();
            System.out.println("Nhap DIEM TICH LUY cua khach hang ");
            tmp=sc.nextLine();
            while(true){
                if(CHECK.isInteger(tmp)==true){
                    diemtichluy=Integer.parseInt(tmp);
                    if(diemtichluy>=0)
                        break;
                    else{
                        System.out.println("vui long nhap diem tich luy > 0");
                        tmp=sc.nextLine();
                    } 
                }
                else{
                    System.out.println("vui long nhap so nguyen");
                    tmp=sc.nextLine();
                }
            }
        }
        @Override
        public void xuat() {
            super.xuat();
            System.out.println("DIEM TICH LUY: " + diemtichluy);
            System.out.println("-------------------------------------------------");
        }
        public int getDiemtichluy(){
            return diemtichluy;
        }
        public void setDiemtichluy(int diemtichluy){
            this.diemtichluy=diemtichluy;
        }
    }

