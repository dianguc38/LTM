package LTM.Haychongiadung_RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        actionHayChonGiaDung haychongiadung = new actionHayChonGiaDung();
        LocateRegistry.createRegistry(9999);
        Naming.rebind("rmi://localhost:9999/haychongiadung",haychongiadung);
        System.out.println("Kết nối thành công!");
    }
}
