package LTM.thitracnghiem;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TCPServer {
    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("Hệ thống trắc nghiệm online");

        ServerSocket serverSK = new ServerSocket(8888);
        Socket sk;

        DataInputStream inFromClient;
        DataOutputStream reFromServer;
        ObjectOutputStream outFromServer;

        Message sendsms;
        String result = "Trượt!";
        int times = 0;
        int countCorrect = 0;

        while (times < 3) {
            sk = serverSK.accept();
            List<Exam> examList = getListItem();
            String rsServer = examList.get(0).getChoice();
            sendsms = new Message(examList);
            outFromServer = new ObjectOutputStream(sk.getOutputStream());
            outFromServer.writeObject(sendsms);
            outFromServer.flush();

            inFromClient = new DataInputStream(sk.getInputStream());
            String clientChoice = inFromClient.readUTF();

            if (clientChoice.toUpperCase().equalsIgnoreCase(rsServer)) {
                countCorrect += 1;
                System.out.println("Chính xác");
            }
            times += 1;
        }
        sk = serverSK.accept();
        if (countCorrect == 3) {
                 result = "Đậu";
        }
        reFromServer = new DataOutputStream(sk.getOutputStream());
        reFromServer.writeUTF(result);
        reFromServer.flush();
        System.out.println("Thi xong!");
        sk.close();
    }

    public static List<Exam> getListItem() throws  SQLException{
        ArrayList<Exam> ListExam = new ArrayList<Exam>();
        ResultSet rs ;
        Connection conn = getConnection();

        String sql = "SELECT * FROM tracnghiem ORDER BY RAND() LIMIT 1;";
        Statement st = conn.createStatement();
        rs = st.executeQuery(sql);

        while (rs.next()){
            Exam exam = new Exam();

            exam.setId(rs.getInt("id"));
            exam.setQuestion(rs.getString("question"));
            exam.setAns1(rs.getString("ans1"));
            exam.setAns2(rs.getString("ans2"));
            exam.setAns3(rs.getString("ans3"));
            exam.setAns4(rs.getString("ans4"));
            exam.setChoice(rs.getString("ans"));

            ListExam.add(exam);
        }
        conn.close();
        rs.close();
        return ListExam;
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
