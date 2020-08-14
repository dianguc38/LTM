package LTM.TuDien_RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class actionTuDien extends UnicastRemoteObject implements tuDien {

    actionTuDien() throws RemoteException{
        super();
    }
    public List<fullData> getAllData() throws SQLException{
        List<fullData> listData = new ArrayList<fullData>();
        Connection conn = LTM.TuDien_RMI.conn.getConnection();
        String sql = "SELECT * FROM tudien";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()){
            fullData fulldata = new fullData();

            fulldata.setEng(rs.getString("eng"));
            fulldata.setViet(rs.getString("viet"));
            fulldata.setMean(rs.getString("mean"));

            listData.add(fulldata);
        }
        return listData;
    }

    @Override
    public String eng_to_viet(String eng) throws RemoteException,SQLException {
        String eng_to_viet = null;
        for (fullData item : getAllData()){
            if(item.getEng().equalsIgnoreCase(eng)){
                eng_to_viet = item.getViet();
            }
        }
        return eng_to_viet;
    }

    @Override
    public String viet_to_eng(String viet) throws RemoteException,SQLException {
        String viet_to_eng = null;
        for (fullData item : getAllData()){
            if(item.getViet().equalsIgnoreCase(viet)){
                viet_to_eng = item.getEng();
            }
        }
        return  viet_to_eng;
    }

    @Override
    public String ismean(String eng) throws RemoteException,SQLException {
        String ismean = null;
        for (fullData item : getAllData()){
            if(item.getEng().equalsIgnoreCase(eng)){
                ismean = item.getMean();
            }
        }
        return ismean;
    }
}
