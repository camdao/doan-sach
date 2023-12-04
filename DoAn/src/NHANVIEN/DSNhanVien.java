package NHANVIEN;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import abstr_interf.*;


public class DSNhanVien extends MENU{
	public static ArrayList<NHANVIEN> DanhSachNhanVien;
	public DSNhanVien() {
		DanhSachNhanVien = new ArrayList<NHANVIEN>(0);
	}
    Scanner sc = new Scanner(System.in);
    
    public void them() {
    	int choose=0;
    	String tmp;
    	System.out.println("Nhap cong viec cua nhan vien: \n1.Thu ngan. \n2.Kho. \n3.Bao ve."); tmp=sc.nextLine();
        while(true){
            if(CHECK.isInteger(tmp)==true){
                 choose=Integer.parseInt(tmp);
                 if(choose==1 || choose==2 || choose==3)
                     break;
                 else{
                     System.out.println("Nhap sai thong tin! \nNhap cong viec cua nhan vien: \n1.Thu ngan. \n2.Kho. \n3.Bao ve.");
                     tmp=sc.nextLine();
                 }
            }
            else{
                 System.out.println("Vui long nhap so nguyen!");
                 System.out.println("Nhap cong viec cua nhan vien: \n1.Thu ngan. \n2.Kho. \n3.Bao ve.");
                 tmp=sc.nextLine();
            }   
         }
		if(choose==1) {
			boolean nhaplaimanv=false;
			NHANVIEN x=new THUNGAN();
		    while (!nhaplaimanv) {
		    	System.out.println("Nhap ma nhan vien: ");
	            x.manv = sc.nextLine();
	            if(check_manv(x.manv) == -1){
	            	System.out.println("Da co ma nhan vien nay roi!");
	            }
	            else{
	                nhaplaimanv = true;
	            }
	        }
			x.nhap();
			boolean nhaplaisdt=false;
			while (!nhaplaisdt) {
				System.out.println("Nhap so dien thoai:");
				x.sdtnv = sc.nextLine();
				if(check_sdtnv(x.sdtnv)==-1) {
					System.out.println("Trung so dien thoai voi nhan vien khac!");
				}
				else {
					nhaplaisdt=true;
				}
			}
			DanhSachNhanVien.add(x);
		}
		else if(choose==2) {
		    boolean nhaplai = false;
            NHANVIEN x = new KHO();
            while (!nhaplai) {
                System.out.println("Nhap ma nhan vien: ");
                x.manv = sc.nextLine();
                if (check_manv(x.manv) == -1) {
                    System.out.println("Da co ma nhan vien nay roi!");
                } else {
                    nhaplai = true;
                }
            }
            x.nhap();
            boolean nhaplaisdt=false;
			while (!nhaplaisdt) {
				System.out.println("Nhap so dien thoai:");
				x.sdtnv = sc.nextLine();
				if(check_sdtnv(x.sdtnv)==-1) {
					System.out.println("Trung so dien thoai voi nhan vien khac!");
				}
				else {
					nhaplaisdt=true;
				}
			}
			DanhSachNhanVien.add(x);
		}
		else if(choose==3) {
		    boolean nhaplai = false;
            NHANVIEN x = new BAOVE();
            while (!nhaplai) {
                System.out.println("Nhap ma nhan vien: ");
                x.manv = sc.nextLine();
                if (check_manv(x.manv) == -1) {
                    System.out.println("Da co ma nhan vien nay roi!");
                } else {
                    nhaplai = true;
                }
            }
            x.nhap();
            boolean nhaplaisdt=false;
			while (!nhaplaisdt) {
				System.out.println("Nhap so dien thoai:");
				x.sdtnv = sc.nextLine();
				if(check_sdtnv(x.sdtnv)==-1) {
					System.out.println("Trung so dien thoai voi nhan vien khac!");
				}
				else {
					nhaplaisdt=true;
				}
			}
			DanhSachNhanVien.add(x);
		}
    }
    public void xoa(){
        String MaNVXoa;
        boolean found=false;
		System.out.print("Nhap ma nhan vien muon xoa: "); 
        MaNVXoa=sc.nextLine();
        for (NHANVIEN NhanVien : DanhSachNhanVien)
            if (NhanVien.manv.equals(MaNVXoa)){
                DanhSachNhanVien.remove(NhanVien);
                found = true;
                System.out.println("Da xoa !");
                break;
            }
        if (!found)
            System.out.println("Khong tim thay nhan vien de xoa");
    }
    public void sua(){
    	int sua=0;
    	String MaNVSua;
        boolean found=false;
        System.out.print("Nhap ma nhan vien muon sua: "); 
        MaNVSua=sc.nextLine();   
        for (NHANVIEN NhanVien : DanhSachNhanVien)
            if (NhanVien.manv.equals(MaNVSua)){
            	if(NhanVien instanceof THUNGAN) {	            	
	            	found=true;
	            	String tmp;
	            	System.out.println("Chon muc can sua: \n1.Ma nhan vien. \n2.Ten nhan vien. \n3.Ngay sinh nhan vien. \n4.SDT nhan vien. \n5.Dia chi. \n6.Luong. \n7.Ngay ban hang.");
	                tmp=sc.nextLine();	                
	                while(true){
	                    if(CHECK.isInteger(tmp)==true){
	                        sua=Integer.parseInt(tmp);
	                        if(sua>=1&&sua<=7)
	                            break;
	                        else{
	                           System.out.println("Nhap sai lua chon\n1.Ma nhan vien. \n2.Ten nhan vien. \n3.Ngay sinh nhan vien. \n4.SDT nhan vien. \n5.Dia chi. \n6.Luong. \n7.Ngay ban hang.");
	                            tmp=sc.nextLine();
	                        }
	                    }
	                    else{
	                        System.out.println("Vui long nhap so nguyen");
	                        tmp=sc.nextLine();
	                    }
	                }
	                if (sua == 1) {
	                    String k;
	                    boolean checkvar=true;
	                    while (checkvar==true) {
	                        System.out.println("Nhap ma nhan vien cap nhat: ");
	                        k=sc.nextLine();
	                        int flag1 = check_manv(k);
	                        if (flag1 == -1)
	                            System.out.println("Ma nhan vien da ton tai!");
	                        else if (flag1 == 0) {
	                            NhanVien.manv = k;
	                            checkvar=false;
	                        }
	                    }
					}
					else if(sua==2) {
						System.out.println("Nhap ten nhan vien cap nhat: ");
						NhanVien.tennv=sc.nextLine();
					}
					else if(sua==3){				
						boolean nhaplaingaysinh=false;
					    while (!nhaplaingaysinh) {				    	
					    	System.out.println("Nhap ngay sinh nhan vien cap nhat: ");
					    	NhanVien.ngaysinhnv=sc.nextLine();
				            if(!checkngaysinh(NhanVien.ngaysinhnv)){
				            	System.out.println("Dinh dang ngay sinh khong hop le. Su dung dinh dang dd/mm/yyyy!");
				            }
				            else{
								nhaplaingaysinh = true;
				            }
				        }
					}
					else if(sua==4) {
						String n;
						boolean nhaplaisdt=true;
						while (nhaplaisdt==true) {
							System.out.println("Nhap so dien thoai cap nhat:");
							n=sc.nextLine();
							int flag3=check_sdtnv(n);
							if(flag3==-1)
								System.out.println("So dien thoai bi trung voi nhan vien khac!");						
							else if(flag3 == 0){
								NhanVien.sdtnv=n;
								nhaplaisdt=false;
							}
						}		   
					}
					else if(sua==5){
						System.out.println("Nhap dia chi nhan vien cap nhat: ");
						NhanVien.diachinv=sc.nextLine();
					}
					else if(sua==6) {
						System.out.println("Nhap luong cap nhat: ");
						NhanVien.luong=sc.nextLine();
					}
					else if(sua==7) {
						boolean nhaplai=false;
					    while (!nhaplai) {
					    	System.out.println("Nhap ngay ban hang cap nhat: ");
					    	((THUNGAN)NhanVien).ngaybanhang=sc.nextLine();
				            if(!checkngaysinh(((THUNGAN)NhanVien).ngaybanhang)){
				            	System.out.println("Dinh dang ngay khong hop le. Su dung dinh dang dd/mm/yyyy!");
				            }
				            else{
				                nhaplai = true;
				            }
				        }
					}
            	}
				else if(NhanVien instanceof KHO) {
					found=true;
					String tmp;
					System.out.println("Chon muc can sua: \n1.Ma nhan vien. \n2.Ten nhan vien. \n3.Ngay sinh nhan vien. \n4.SDT nhan vien. \n5.Dia chi. \n6.Luong. \n7.Ngay kiem kho.");
					tmp=sc.nextLine();	                
					while(true){
						if(CHECK.isInteger(tmp)==true){
							sua=Integer.parseInt(tmp);
							if(sua>=1&&sua<=7)
								break;
							else{
								System.out.println("Nhap sai lua chon\n1.Ma nhan vien. \n2.Ten nhan vien. \n3.Ngay sinh nhan vien. \n4.SDT nhan vien. \n5.Dia chi. \n6.Luong \n7.Ngay kiem kho.");
								tmp=sc.nextLine();
							}
						}
						else{
							System.out.println("Vui long nhap so nguyen");
							tmp=sc.nextLine();
						}
					}
					if (sua == 1) {
						String k;
						boolean checkvar=true;
						while (checkvar==true) {
							System.out.println("Nhap ma nhan vien cap nhat: ");
							k=sc.nextLine();
							int flag1 = check_manv(k);
							if (flag1 == -1)
								System.out.println("Ma nhan vien da ton tai!");
							else if (flag1 == 0) {
								NhanVien.manv = k;
								checkvar=false;
							}
}
					}
					else if(sua==2) {
						System.out.println("Nhap ten nhan vien cap nhat: ");
						NhanVien.tennv=sc.nextLine();
					}
					else if(sua==3){				
						boolean nhaplaingaysinh=false;
						while (!nhaplaingaysinh) {				    	
							System.out.println("Nhap ngay sinh nhan vien cap nhat: ");
							NhanVien.ngaysinhnv=sc.nextLine();
							if(!checkngaysinh(NhanVien.ngaysinhnv)){
								System.out.println("Dinh dang ngay sinh khong hop le. Su dung dinh dang dd/mm/yyyy!");
							}
							else{
								nhaplaingaysinh = true;
							}
						}
					}
					else if(sua==4) {
						String n;
						boolean nhaplaisdt=true;
						while (nhaplaisdt==true) {
							System.out.println("Nhap so dien thoai cap nhat:");
							n=sc.nextLine();
							int flag3=check_sdtnv(n);
							if(flag3==-1)
								System.out.println("So dien thoai bi trung voi nhan vien khac!");						
							else if(flag3 == 0){
								NhanVien.sdtnv=n;
								nhaplaisdt=false;
							}
						}		                 
					}
					else if(sua==5){
						System.out.println("Nhap dia chi nhan vien cap nhat: ");
						NhanVien.diachinv=sc.nextLine();
					}
					else if(sua==6) {
						System.out.println("Nhap luong cap nhat: ");
						NhanVien.luong=sc.nextLine();
					}
					else if(sua==7) {
						boolean nhaplai=false;
						while (!nhaplai) {
							System.out.println("Nhap ngay kiem kho cap nhat: ");
							((KHO)NhanVien).ngaykiemkho=sc.nextLine();
							if(!checkngaysinh(((KHO)NhanVien).ngaykiemkho)){
								System.out.println("Dinh dang ngay khong hop le. Su dung dinh dang dd/mm/yyyy!");
							}
							else{
								nhaplai = true;
							}
						}
					}
				}
				else if(NhanVien instanceof BAOVE) {
					found=true;
					String tmp;
					System.out.println("Chon muc can sua: \n1.Ma nhan vien. \n2.Ten nhan vien. \n3.Ngay sinh nhan vien. \n4.SDT nhan vien. \n5.Dia chi. \n6.Luong. \n7.Ca truc.");
					tmp=sc.nextLine();	                
					while(true){
						if(CHECK.isInteger(tmp)==true){
							sua=Integer.parseInt(tmp);
							if(sua>=1&&sua<=7)
								break;
							else{
								System.out.println("Nhap sai lua chon\n1.Ma nhan vien. \n2.Ten nhan vien. \n3.Ngay sinh nhan vien. \n4.SDT nhan vien. \n5.Dia chi. \n6.Luong. \n7.Ca truc.");
								tmp=sc.nextLine();
							}
						}
						else{
							System.out.println("Vui long nhap so nguyen");
							tmp=sc.nextLine();
						}
					}
					if (sua == 1) {
						String k;
						boolean checkvar=true;
						while (checkvar==true) {
							System.out.println("Nhap ma nhan vien cap nhat: ");
							k=sc.nextLine();
							int flag1 = check_manv(k);
							if (flag1 == -1)
								System.out.println("Ma nhan vien da ton tai!");
							else if (flag1 == 0) {
								NhanVien.manv = k;
								checkvar=false;
							}
						}
					}
					else if(sua==2) {
						System.out.println("Nhap ten nhan vien cap nhat: ");
						NhanVien.tennv=sc.nextLine();
					}
					else if(sua==3){				
						boolean nhaplaingaysinh=false;
						while (!nhaplaingaysinh) {				    	
							System.out.println("Nhap ngay sinh nhan vien cap nhat: ");
							NhanVien.ngaysinhnv=sc.nextLine();
							if(!checkngaysinh(NhanVien.ngaysinhnv)){
								System.out.println("Dinh dang ngay sinh khong hop le. Su dung dinh dang dd/mm/yyyy!");
							}
							else{
								nhaplaingaysinh = true;
							}
						}
					}
					else if(sua==4) {
						String n;
						boolean nhaplaisdt=true;
						while (nhaplaisdt==true) {
							System.out.println("Nhap so dien thoai cap nhat:");
							n=sc.nextLine();
							int flag3=check_sdtnv(n);
							if(flag3==-1)
								System.out.println("So dien thoai bi trung voi nhan vien khac!");						
							else if(flag3 == 0){
								NhanVien.sdtnv=n;
								nhaplaisdt=false;
							}
						}		   
					}
					else if(sua==5){
						System.out.println("Nhap dia chi nhan vien cap nhat: ");
						NhanVien.diachinv=sc.nextLine();
					}
					else if(sua==6) {
						System.out.println("Nhap luong cap nhat: ");
						NhanVien.luong=sc.nextLine();
					}
					else if(sua==7) {
						System.out.println("Nhap ca truc cap nhat: ");
						((BAOVE)NhanVien).catruc=sc.nextLine();
					}
				}
					System.out.println("Du lieu cua nhan vien sau khi sua: ");
					NhanVien.xuat();
	                break;
            }
        if (!found)
            System.out.println("Khong tim thay nhan vien de sua !");
    }
    public void danhsach(){
        int i=1;
        System.out.println("Danh sach co "+DanhSachNhanVien.size()+" nhan vien:");
        for (NHANVIEN nv : DanhSachNhanVien) {
            System.out.print(i+"/ ");
            nv.xuat();
            System.out.println();
            i++;
        }
    }
    public void timkiem(){
        String MaNVTimKiem;
        boolean found=false;
        System.out.print("Nhap ma nhan vien can tim: "); MaNVTimKiem=sc.nextLine();
        for (NHANVIEN NhanVien : DanhSachNhanVien){
            if (NhanVien.manv.equals(MaNVTimKiem)){
                found = true;
                NhanVien.xuat();
                break;
            }
		}
        if (!found)
            System.out.println("Khong tim thay nhan vien !");
    }
    public static void WriteFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("datanhanvien.txt"))) {
            for (NHANVIEN x : DanhSachNhanVien) {
                writer.write(x.manv + ",");
                writer.write(x.tennv + ",");
                writer.write(x.ngaysinhnv + ",");
                writer.write(x.sdtnv + ",");
                writer.write(x.diachinv + ",");
                writer.write(x.luong + ",");
                if(x instanceof THUNGAN) {
                	writer.write("1,");
                	writer.write( ((THUNGAN)x).ngaybanhang + ",");
                }
                if(x instanceof KHO) {
                	writer.write("2,");
                	writer.write( ((KHO)x).ngaykiemkho + ",");
                }
                if(x instanceof BAOVE) {
                	writer.write("3,");
                	writer.write( ((BAOVE)x).catruc + ",");
                }
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void ReadFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("datanhanvien.txt"))) {
        	String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String maNV = parts[0];
                String tenNV = parts[1];
                String ngaySinhNV = parts[2];
                String sdtNV = parts[3];
                String diaChiNV = parts[4];
                String luongNV = parts[5];
                String currentRole = parts[6];
                NHANVIEN nv ;
                if (currentRole.equals("1")) {
                	nv = new THUNGAN();
                    ((THUNGAN)nv).ngaybanhang = parts[7];
                    nv.manv = maNV;
                    nv.tennv = tenNV;
                    nv.ngaysinhnv = ngaySinhNV;
                    nv.sdtnv = sdtNV;
                    nv.diachinv = diaChiNV;
                    nv.luong = luongNV;
                   
                    DanhSachNhanVien.add(nv);
                } else if (currentRole.equals("2")) {
                    nv = new KHO();
                    ((KHO)nv).ngaykiemkho = parts[7]; 
                    nv.manv = maNV;
                    nv.tennv = tenNV;
                    nv.ngaysinhnv = ngaySinhNV;
                    nv.sdtnv = sdtNV;
                    nv.diachinv = diaChiNV;
                    nv.luong = luongNV;
                   
                    DanhSachNhanVien.add(nv);
                } else if (currentRole.equals("3")) {
                    nv = new BAOVE();
                    ((BAOVE)nv).catruc = parts[7];
                    nv.manv = maNV;
                    nv.tennv = tenNV;
					nv.ngaysinhnv = ngaySinhNV;
                    nv.sdtnv = sdtNV;
                    nv.diachinv = diaChiNV;
                    nv.luong = luongNV;
                   
                    DanhSachNhanVien.add(nv);
                }            
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int check_manv(String y){
        for(NHANVIEN x : DanhSachNhanVien){
           if(x.manv.equals(y))
               return -1;
       }
       return 0;
    }
    public static int check_sdtnv(String y){
        for(NHANVIEN x : DanhSachNhanVien){
           if(x.sdtnv.equals(y))
               return -1;
       }
       return 0;
    }
    public static boolean checkngaysinh(String z) {
    	if(z.length() == 10){
    		try{
    			int day = Integer.parseInt(z.substring(0, 2));
                int month = Integer.parseInt(z.substring(3, 5));
                int year = Integer.parseInt(z.substring(6));
                boolean namnhuan=false;
                if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    namnhuan=true;
                }
                int songaytrongthang = 0;
                switch (month)
            	{
            	case 1:
            	case 3:
            	case 5:
            	case 7:
            	case 8:
            	case 10:
            	case 12: 
            		songaytrongthang = 31;
            		break;
            	case 4:
            	case 6:
            	case 9:
            	case 11: 
            		songaytrongthang = 30;
            		break;
            	case 2:
            		if(!namnhuan)
            		{
            			songaytrongthang = 28;
            		}
            		else
            		{
            			songaytrongthang = 29;
            		}
            		break;
            	}
            	if(day>=1 && day<=songaytrongthang && month>=1 && month<=12 && year>0) {
            		return true;
            	}
            } catch (NumberFormatException e) {
            }
    	}
    	return false;
    }
}