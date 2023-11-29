package NhanVien;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


class DSNhanVien extends Menu{
	public static ArrayList<NhanVien> DSNhanVien;
	public DSNhanVien() {
		DSNhanVien = new ArrayList<NhanVien>(0);
	}
    Scanner sc = new Scanner(System.in);
    
    public void them() {
    	String choose;
    	System.out.println("Nhap cong viec cua nhan vien: \n1.Thu ngan. \n2.Kho. \n3.Bao ve."); choose=sc.nextLine();
		if(choose.equals("1")) {
			boolean nhaplaimanv=false;
			NhanVien x=new ThuNgan();
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
			DSNhanVien.add(x);
		}
		else if(choose.equals("2")) {
		    boolean nhaplai = false;
            NhanVien x = new Kho();
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
			DSNhanVien.add(x);
		}
		else if(choose.equals("3")) {
		    boolean nhaplai = false;
            NhanVien x = new BaoVe();
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
			DSNhanVien.add(x);
		}
    }
    public void xoa(){
        String MaNVXoa;
        boolean found=false;
        System.out.print("Nhap ma nhan vien muon xoa: "); MaNVXoa=sc.nextLine();
        for (NhanVien NhanVien : DSNhanVien)
            if (NhanVien.manv.equals(MaNVXoa)){
                DSNhanVien.remove(NhanVien);
                found = true;
                System.out.println("Da xoa !");
                break;
            }
        if (!found)
            System.out.println("Khong tim thay nhan vien de xoa");
    }
    public void sua(){
        String MaNVSua;
        int sua=0;
        boolean found=false;
        System.out.print("Nhap ma nhan vien muon sua: "); 
        MaNVSua=sc.nextLine();   
        for (NhanVien NhanVien : DSNhanVien) {
            if (NhanVien.manv.equals(MaNVSua)) {
                Scanner sc = new Scanner(System.in);
                found=true;
                System.out.println("Chon muc can sua: \n1.Ma nhan vien. \n2.Ten nhan vien. \n3.Ngay sinh nhan vien. \n4.SDT nhan vien. \n5.Dia chi. ");
                sua=sc.nextInt();
                while(sua < 1 || sua > 5) {
                	System.out.println("Vui long nhap dung cu phap!");
                }
                if (sua == 1) {
                    String k;
                    sc.nextLine();
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
					sc.nextLine();
					System.out.println("Nhap ten nhan vien cap nhat: ");
					NhanVien.tennv=sc.nextLine();
				}
				else if(sua==3){
					sc.nextLine();
					System.out.println("Nhap ngay sinh nhan vien cap nhat: ");
					NhanVien.ngaysinhnv=sc.nextLine();
				}
				else if(sua==4){
					sc.nextLine();
					System.out.println("Nhap dia chi nhan vien cap nhat: ");
					NhanVien.diachinv=sc.nextLine();
				}
				System.out.println("Du lieu cua nhan vien sau khi sua: ");
				NhanVien.xuat();
			}
                break;
        }
        if (!found)
            System.out.println("Khong tim thay nhan vien de sua !");
    }
    public void danhsach(){
        int i=1;
        System.out.println("Danh sach co "+DSNhanVien.size()+" nhan vien:");
        for (NhanVien nv : DSNhanVien) {
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
        for (NhanVien NhanVien : DSNhanVien){
            if (NhanVien.manv.equals(MaNVTimKiem)){
                found = true;
                NhanVien.xuat();
                break;
            }
        }
        if (!found)
            System.out.println("Khong tim thay nhan vien !");
    }
    public void WriteFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("datanhanvien.txt"))) {
            for (NhanVien x : DSNhanVien) {
                writer.write(x.manv + ",");
                writer.write(x.tennv + ",");
                writer.write(x.ngaysinhnv + ",");
                writer.write(x.sdtnv + ",");
                writer.write(x.diachinv + ",");
                writer.write(x.luong + ",");
                if(x instanceof ThuNgan) {
                	writer.write("1,");
                	writer.write( ((ThuNgan)x).ngaybanhang + ",");
                }
                if(x instanceof Kho) {
                	writer.write("2,");
                	writer.write( ((Kho)x).ngaykiemkho + ",");
                }
                if(x instanceof BaoVe) {
                	writer.write("3,");
                	writer.write( ((BaoVe)x).catruc + ",");
                }
                writer.newLine(); // Xuống dòng cho mỗi nhân viên
                
            }
            System.out.println("Ghi file thanh cong!");
     
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ReadFile() {
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
                NhanVien nv ;
                if (currentRole.equals("1")) {
                	nv = new ThuNgan();
                    ((ThuNgan)nv).ngaybanhang = parts[7];
                    nv.manv = maNV;
                    nv.tennv = tenNV;
                    nv.ngaysinhnv = ngaySinhNV;
                    nv.sdtnv = sdtNV;
                    nv.diachinv = diaChiNV;
                    nv.luong = luongNV;
                   
                    DSNhanVien.add(nv);
                } else if (currentRole.equals("2")) {
                    nv = new Kho();
                    ((Kho)nv).ngaykiemkho = parts[7]; 
                    nv.manv = maNV;
                    nv.tennv = tenNV;
                    nv.ngaysinhnv = ngaySinhNV;
                    nv.sdtnv = sdtNV;
                    nv.diachinv = diaChiNV;
                    nv.luong = luongNV;
                   
                    DSNhanVien.add(nv);
                } else if (currentRole.equals("3")) {
                    nv = new BaoVe();
                    ((BaoVe)nv).catruc = parts[7];
                    nv.manv = maNV;
                    nv.tennv = tenNV;
                    nv.ngaysinhnv = ngaySinhNV;
                    nv.sdtnv = sdtNV;
                    nv.diachinv = diaChiNV;
                    nv.luong = luongNV;
                   
                    DSNhanVien.add(nv);
                }            
            }   
            System.out.println("Doc file thanh cong!");
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int check_manv(String y){
        for(NhanVien x : DSNhanVien){
           if(x.manv.equals(y))
               return -1;
       }
       return 0;
    }
    public static int check_sdtnv(String y){
        for(NhanVien x : DSNhanVien){
           if(x.sdtnv.equals(y))
               return -1;
       }
       return 0;
    }
}
