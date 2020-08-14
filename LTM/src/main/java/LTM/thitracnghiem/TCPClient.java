package LTM.thitracnghiem;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws ClassNotFoundException,IOException, SQLException{
        Message receivesms;
        Scanner sc = new Scanner(System.in);
    int times = 0;
    while(times < 4){
        Socket socket = new Socket("localhost",8888);
        if (times < 3) {
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
            receivesms = (Message) inFromServer.readObject();
            List<Exam> listExam = receivesms.getListExam();

            for (Exam e : listExam) {
                System.out.println(e.getQuestion());
                System.out.println(e.getAns1() + "      " + e.getAns2() + "       " + e.getAns3() + "         " + e.getAns4());
            }
            System.out.println("Ban chon: ");
            dOut.writeUTF(sc.nextLine());
            dOut.flush();
        }if (times == 3){
            DataInputStream DIn = new DataInputStream(socket.getInputStream());
            String result = DIn.readUTF();
            System.out.println("====> KẾT QUẢ :" + result);
        }
        times += 1;
    }
    }

}
