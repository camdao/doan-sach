package KHACHHANG;
import java.util.Scanner;
import abstr_interf.CHECK;

public class QL_DSKHACHHANG {
    Scanner sc=new Scanner(System.in);
    DSKHACHHANG x;
    public QL_DSKHACHHANG(){
        x=new DSKHACHHANG();
    }
    public void Menu(){
        boolean flag=true;
        while(flag){//vòng lặp lặp lại việc chọn thao tác
            System.out.println("\nCHON THAO TAC:\n1:Them moi\n2:Sua thong tin\n3:Tim kiem\n4:Xoa\n5:Hien thi danh sach\n6:Quay lai\n7:Thoat");
            System.out.print("Lua chon: ");
            int choose=0;
            String tmp=sc.nextLine();
            while(true){
                if(CHECK.isInteger(tmp)==true){
                    choose=Integer.parseInt(tmp);
                    if(choose<=7 && choose>=1)
                        break;
                    else{
                        System.out.println("!!! Nhap sai thong tin\nCHON THAO TAC:\n1:Them moi\n2:Sua thong tin\n3:Tim kiem\n4:Xoa\n5:Hien thi danh sach\n6:Quay lai\n7:Thoat");
                        System.out.print("Lua chon: ");
                        tmp=sc.nextLine();
                    }
                }
                else{
                    System.out.println("vui long nhap so nguyen");
                    System.out.print("Lua chon: ");
                    tmp=sc.nextLine();
                }
            }
            switch (choose){
                case 1:
                    x.them();
                    break;
                case 2:
                    x.sua();
                    break;
                case 3:
                    x.timkiem();
                    break;
                case 4:
                    x.xoa();
                    break;
                case 5:
                    x.danhsach();
                    break;
                case 6:
                    DSKHACHHANG.luu();
                    flag=false;
                    break;
                case 7:
                    DSKHACHHANG.luu();
                    flag=false;
                    System.exit(0);
            }
        }
    }
}