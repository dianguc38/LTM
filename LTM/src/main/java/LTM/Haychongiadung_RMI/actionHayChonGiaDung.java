package LTM.Haychongiadung_RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class actionHayChonGiaDung extends UnicastRemoteObject implements hayChonGiaDung {

    protected actionHayChonGiaDung() throws RemoteException {
    }

    @Override
    public MatHang getMatHang() {
        MatHang matHang = null;

        String sql = "SELECT * FROM mathang ORDER BY RAND() LIMIT 1";
        try{
            Connection conn = LTM.Haychongiadung_RMI.conn.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                matHang = new MatHang(rs.getInt("id"),rs.getString("name"),rs.getFloat("coat"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return matHang;
    }


    @Override
    public int check(float giaDoan, float giaMatHang) throws RemoteException {
        int result = 0;
        if (giaDoan < giaMatHang){
            result = -1;
        }
        if (giaDoan == giaMatHang){
            result = 0;
        }
        if (giaDoan > giaMatHang){
            result = 1;
        }
        return result;
    }
}
