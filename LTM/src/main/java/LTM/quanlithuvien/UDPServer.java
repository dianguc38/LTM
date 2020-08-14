package LTM.quanlithuvien;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UDPServer {

    public static void main(String[] args) throws IOException,SQLException,ClassNotFoundException{
        System.out.println("QUẢN LÍ THƯ VIỆN");
        DatagramSocket socket = new DatagramSocket(9999);

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        byte[] cont = new byte[1024];
        ObjectOutputStream outFromServer;

        ByteArrayOutputStream byOut;

        Message sendMessage;
        Message receiveMessage;


        while (!false){
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
            socket.receive(receivePacket);

            String choice = new String(receiveData);
            sendMessage = new Message();

            //get ip and port
            InetAddress ip = receivePacket.getAddress();
            int port = receivePacket.getPort();

            //Switch case to select options
            String choice_ = choice.substring(0,1);
            switch (choice_){
                case "1":
                    List<Book> listBook = getBook();
                    sendMessage.setListbooks(listBook);
                    byOut = new ByteArrayOutputStream(1024);

                    outFromServer = new ObjectOutputStream(byOut);
                    outFromServer.writeObject(sendMessage);
                    outFromServer.flush();
                    sendData = byOut.toByteArray();

                    DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,ip,port);
                    socket.send(sendPacket);
                    break;
                case "2":
                    cont = "Mượn sách thất bại!".getBytes();
                    StringTokenizer st = new StringTokenizer(choice,"#");
                    st.nextToken();
                    String id  = st.nextToken();
                    boolean res = borrow_return(choice,id.substring(0,1));
                    if (res == true){
                        cont = "Mượn sách thành công!".getBytes();
                    }
                    DatagramPacket sendPacket_ = new DatagramPacket(cont,cont.length,ip,port);
                    socket.send(sendPacket_);
                    break;
                case "3":
                    cont = "Trả sách thất bại!".getBytes();
                    StringTokenizer st_ = new StringTokenizer(choice,"#");
                    st_.nextToken();
                    String id_  = st_.nextToken();
                    boolean res_ = borrow_return(choice_,id_.substring(0,1));
                    if (res_ == true){
                        cont = "Trả sách thành công!".getBytes();
                    }
                    DatagramPacket sendPacket__ = new DatagramPacket(cont,cont.length,ip,port);
                    socket.send(sendPacket__);
                    break;
                default:
                    break;
            }
        }
    }

    public static List<Book> getBook() throws SQLException{
        ArrayList<Book> listBook = new ArrayList<Book>();

        Connection conn = getConnection();

        String sql="SELECT * FROM books";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()){
            Book book = new Book();

            book.setId(rs.getInt("id"));
            book.setName(rs.getString("name"));
            book.setAuthor(rs.getString("author"));
            book.setTotal(rs.getInt("total"));
            book.setRemain(rs.getInt("remain"));

            listBook.add(book);
        }

        conn.close();
        rs.close();

        return listBook;
    }

    public static boolean borrow_return(String choice,String id) throws SQLException{
        boolean res = false;
        int ori = 0;
        int modify = 0;
        Connection conn = getConnection();
        int id_ = Integer.parseInt(id);
        String sql = "SELECT remain FROM books WHERE id= ?";

        PreparedStatement preSt = conn.prepareStatement(sql);
        preSt.setInt(1, id_);
        ResultSet rs = preSt.executeQuery();
        while (rs.next()) {
            ori = rs.getInt("remain");
            res = true;
        }
        if (choice.equalsIgnoreCase("2")){
             modify = ori - 1;
        }else{
            modify = ori + 1;
        }
        String sql_ = "UPDATE books SET remain= ? WHERE id= ?";
        PreparedStatement preSt_ = conn.prepareStatement(sql_);
        preSt_.setInt(1,modify);
        preSt_.setInt(2,id_);
        preSt_.executeUpdate();

        return res;
    }


    public static Connection getConnection(){
        Connection conn = null;
        String jdbcUrl="jdbc:mysql://localhost:3306/LTM?serverTimezone=UTC";
        String user = "root";
        String pwd  = "";

        try{
            conn = DriverManager.getConnection(jdbcUrl,user,pwd);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
