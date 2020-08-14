package LTM.Haychongiadung_RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        float giaDoan;

        Scanner sc = new Scanner(System.in);
        Remote remote = Naming.lookup("rmi://localhost:9999/haychongiadung");
        hayChonGiaDung haychongiadung = (LTM.Haychongiadung_RMI.hayChonGiaDung) remote;
        MatHang matHang = haychongiadung.getMatHang();
        System.out.println("Dự đoán giá cho sản phẩm: " + matHang.getTenMatHang());
        System.out.println("Bạn có 7 lượt đoán!");
        for (int i = 1; i <=7 ;i++){
            System.out.println("Lần đoán thứ: " + i);
            System.out.println("Bạn đoán: ");
            giaDoan = Float.parseFloat(sc.nextLine());

            int result = haychongiadung.check(giaDoan,matHang.getGiaMatHang());
            if (result == -1){
                System.out.println("Bạn đoán cao hơn giá phẩm");
            }
            if (result == 1){
                System.out.println("Bạn đoán thấp hơn giá phẩm");
            }
            if (result == 0){
                System.out.println("Bạn đoán đúng giá phẩm");
                break;
            }
        }
        System.out.println("Chương trình đoán giá kết thúc!!!");
        sc.close();
    }
}
