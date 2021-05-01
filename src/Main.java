import java.util.Scanner;

public class Main {
    public static void menu(CustomerManager cus){
        Scanner sc = new Scanner(System.in);
        int x=0;
        while (x!=7){
            System.out.println("Chao mung ban den voi he thong quan ly khach hang\n" +
                    "Bấm 1 để nhập khách hang\n" +
                    "Bấm 2 để tim kiem khach hang\n" +
                    "Bam 3 de in thong khach hang\n" +
                    "Bam 4 de in toan bo danh sach khach hang\n" +
                    "Bam 5 de in ra mang da sap xep \n"+
                    "Bam 6 de tang so don hang cho khach\n" +
                    "Bam 0 de thoat"
            );
            x = sc.nextInt();
            sc.nextLine();
            switch (x){
                case 1:{
                    System.out.println("Input Name:");
                    String name = sc.nextLine();
                    System.out.println("Input Adress:");
                    String address = sc.nextLine();
                    System.out.println("Input phone:");
                    String phone = sc.nextLine();
                    System.out.println("Input Email:");
                    String email = sc.nextLine();
                    System.out.println("Input Gender:");
                    String gender = sc.nextLine();
                    System.out.println("Input Number-Order:");
                    int orderNumber = sc.nextInt();
                    sc.nextLine();
                    cus.add(new Customer(name,address,phone,email,gender,orderNumber));
                    System.out.println("Chon menu de thuc hien tiep");
                    break;
                }
                case 2:{
                    System.out.println("Input phone ");
                    String phone = sc.nextLine();
                    cus.searchInfor(phone);
                    System.out.println("Chon menu de thuc hien tiep");
                    break;
                }
                case 3:{
                    System.out.println("Input phone");
                    String phone =sc.nextLine();
                    cus.getInfor(phone);
                    System.out.println("Chon menu de thuc hien tiep");
                }
                case 4:{
                    cus.display();
                    System.out.println("Chon menu de thuc hien tiep");
                    break;
                }
                case 5:{
                    cus.sort();
                    System.out.println("Chon menu de thuc hien tiep");
                }
                case 6:{
                    System.out.println("Input phone");
                    String phone = sc.nextLine();
                    System.out.println("Input number order add : ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    cus.addNumberOrder(phone,n);
                    System.out.println("Chon menu de thuc hien tiep");
                    break;
                }
                case 0:{
                    System.exit(0);
                }
                default:
                    System.out.println("Found");
                    System.out.println("Chon menu de thuc hien tiep");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        Customer ct1 = new Customer("Khanh","Hue","0782222595","phuockhanh1010@gmail.com","Male",5);
        Customer ct2 = new Customer("Duong","Hue","0905234289","duongvat@gmail.com","Male",6);
        Customer ct3 = new Customer("Phong","Hue","0364334561","phongpro113@gmail.com","Male",7);
        Customer ct4 = new Customer("Han","Hue","0356754546","hanny@gmail.com","Male",1);
        Customer ct5 = new Customer("Thien","Hue","09324456782","thienpro@gmail.com","Male",2);

        CustomerManager cus = new CustomerManager();
        cus.add(ct1);
        cus.add(ct2);
        cus.add(ct3);
        cus.add(ct4);
        cus.add(ct5);
        menu(cus);
    }
}
