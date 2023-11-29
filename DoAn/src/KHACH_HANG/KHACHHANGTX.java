package KHACH_HANG;
import java.util.Scanner;

class KHACHHANGTX extends KHACHHANG{//kế thừa
        private int diemtichluy;
        Scanner sc=new Scanner(System.in);
        public KHACHHANGTX(){//khởi tạo
            super();
            diemtichluy = 0;
        }
        @Override
        public void nhap(){ 
            boolean flag=true;
            super.nhap();
            System.out.println("Nhap DIEM TICH LUY cua khach hang ");
            while(flag){
                if(sc.hasNextInt()){
                    diemtichluy=sc.nextInt();
                   if(diemtichluy>0)
                        flag=false;
                    else
                        System.out.println("~ Vui long nhap diem tich luy > 0 ~");
                    }
                else{
                    System.out.println("~ Vui long nhap so nguyen ~");
                    sc.next();
                }
            }
            sc.nextLine();
        }
        @Override
        public void xuat() {
            super.xuat();
            System.out.println("DIEM TICH LUY: " + diemtichluy);
            System.out.println("-----------------------------------------------------------------");
        }
        public int getDiemtichluy(){
            return diemtichluy;
        }
        public void setDiemtichluy(int diemtichluy){
            this.diemtichluy=diemtichluy;
        }
    }

