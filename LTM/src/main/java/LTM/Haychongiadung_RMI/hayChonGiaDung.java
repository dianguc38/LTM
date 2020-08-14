package LTM.Haychongiadung_RMI;

        import java.rmi.Remote;
        import java.rmi.RemoteException;

public interface hayChonGiaDung extends Remote {
    public MatHang getMatHang() throws RemoteException;

    int check(float giaDoan, float giaMatHang) throws RemoteException;
}
