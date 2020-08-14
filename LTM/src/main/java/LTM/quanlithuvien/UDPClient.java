package LTM.quanlithuvien;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        DatagramSocket Socket = new DatagramSocket();
        DatagramPacket sendPacket;
        DatagramPacket receivePacket;
        InetAddress ip = InetAddress.getByName("localhost");
        int port = 9999;

        byte[] receiveData = new byte[1024];
        byte[] choiceToByte = new byte[1024];

        Scanner sc = new Scanner(System.in);
        Message receiveMessage;
        String choice = null;

        while (true) {
            menu();
            System.out.println("Bạn chọn: ");
            choice = sc.nextLine();
            choiceToByte = choice.getBytes();

            if (choice.equalsIgnoreCase("1")){
                sendPacket = new DatagramPacket(choiceToByte,choiceToByte.length,ip,port);
                Socket.send(sendPacket);

                receivePacket = new DatagramPacket(receiveData,receiveData.length,ip,port);
                Socket.receive(receivePacket);
                ByteArrayInputStream byIn = new ByteArrayInputStream(receiveData);
                ObjectInputStream inFromServer = new ObjectInputStream(byIn);
                receiveMessage = (Message) inFromServer.readObject();

                List<Book> listBook = receiveMessage.getListbooks();
                for (Book i : listBook){
                    System.out.println(i.toString());
                }
            } if((choice.substring(0,1)).equalsIgnoreCase("2") ||(choice.substring(0,1)).equalsIgnoreCase("3") ){
                sendPacket = new DatagramPacket(choiceToByte,choiceToByte.length,ip,port);
                Socket.send(sendPacket);

                receivePacket = new DatagramPacket(receiveData,receiveData.length,ip,port);
                Socket.receive(receivePacket);
                String res = new String(receiveData);
                System.out.println(res);
            }if (choice.equalsIgnoreCase("4")){
                System.exit(0);
            }
        }

    }

    public static void menu() {
        System.out.println("-----------OoOMenuOoO------------");
        System.out.println("1. Hiển thị thông tin sách");
        System.out.println("2. Mượn sách");
        System.out.println("3. Trả sách");
        System.out.println("4. Thoát");
        System.out.println("---------------------------------");
    }
}
