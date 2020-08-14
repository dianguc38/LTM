package LTM.TuDien_RMI;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.sql.SQLException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args)throws IOException, NotBoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        Remote remote = Naming.lookup("rmi://localhost:9999/tudien");
        tuDien tudien = (tuDien) remote;
        while (true) {
            menu();

            System.out.println("Bạn chọn: ");
            Integer choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Từ tiếng Anh cần dịch nghĩa: ");
                    String eng = sc.nextLine();
                    String viet = tudien.eng_to_viet(eng);
                    System.out.println("dịch sang tiếng Việt: " + viet);
                    break;
                case 2:
                    System.out.println("Từ tiếng Việt cần dịch nghĩa: ");
                    String viet_ = sc.nextLine();
                    String eng_ = tudien.viet_to_eng(viet_);
                    System.out.println("dịch sang tiếng Anh: " + eng_);
                    break;
                case 3:
                    System.out.println("Bạn cần biết nghĩa của từ tiếng Anh: ");
                    String eng__ = sc.nextLine();
                    String mean = tudien.ismean(eng__);
                    System.out.println("Nghĩa của từ tiếng anh này : " + mean);
                    break;
                case 4:
                    System.out.println("Ngắt kết nối từ điển");
                    System.exit(0);
            }
        }
    }

    public static void menu(){
        System.out.println("=========TỪ ĐIỂN ANH-VIỆT=========");
        System.out.println("1.Dịch từ Anh sang Việt");
        System.out.println("2.Dịch từ Việt sang Anh");
        System.out.println("3.Xem nghĩa của từ");
        System.out.println("4.Thoát");
        System.out.println("==================================");
    }
}
