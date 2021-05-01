import java.util.*;

public class CustomerManager {
    HashMap<String,Customer> hashMap = new HashMap<>();
    public void add(Customer ct){
        if(hashMap.containsKey(ct.getPhone()) && hashMap.get(ct.getPhone()).getEmail().equals(ct.getEmail())){
            System.out.println("Khach hang da ton tai, He thong vua update thong tin\n");
        }
        else{
            hashMap.put(ct.getPhone(),ct);
            System.out.println("Ban vua them moi < "+ct.getName()+" > Thanh cong");
        }
    }
    public void searchInfor(String phone){
        System.out.println("He thong dang tim kiem... ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(hashMap.containsKey(phone)){
            System.out.println("Ket qua: ");
            System.out.println(hashMap.get(phone).toString2());
        }
        else{
            System.out.println("Khong ton tai khach hang");
        }
    }
    public void getInfor(String phone){
        System.out.println("He thong dang tim kiem... ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(hashMap.containsKey(phone)){
            System.out.println("Thong tin : ");
            System.out.println(hashMap.get(phone).toString());
        }
        else{
            System.out.println("Khong ton tai khach hang");
        }
    }
    public void addNumberOrder(String phone, int n){
        if(hashMap.containsKey(phone)){
            hashMap.get(phone).setOrderNum(hashMap.get(phone).getOrderNum()+n);
            System.out.println("thong tin cua khach hang sau khi tang "+n +" don hang");
            System.out.println(hashMap.get(phone).toString());
        }
        else{
            System.out.println("Khong tim thay ");
        }
    }
    public void sort(){
        List<Map.Entry<String,Customer>> list = new ArrayList<Map.Entry<String, Customer>>();
        list.addAll(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Customer>>() {
            @Override
            public int compare(Map.Entry<String, Customer> o1, Map.Entry<String, Customer> o2) {
                return o1.getValue().getName().compareTo(o2.getValue().getName());
            }
        });
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).getValue().toString());
        }
    }
    public void display(){
        int count =0;
        if(hashMap.isEmpty()){
            System.out.println("khong co thong tin");
        }
        else{
            for (Map.Entry<String,Customer> entry:hashMap.entrySet()) {
                System.out.print(++count +"."+ entry.getValue().toString());
            }
            System.out.println("Tong co "+hashMap.size()+" khach hang trong he thong");
        }

    }
}
