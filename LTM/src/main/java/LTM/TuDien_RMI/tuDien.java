package LTM.TuDien_RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface tuDien extends Remote {
    public String eng_to_viet(String eng)throws RemoteException, SQLException;
    public String viet_to_eng(String viet)throws RemoteException,SQLException;
    public String ismean(String eng) throws RemoteException,SQLException;
}
