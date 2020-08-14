package LTM.TuDien_RMI;

import LTM.Haychongiadung_RMI.actionHayChonGiaDung;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        tuDien tudien = new actionTuDien();
        LocateRegistry.createRegistry(9999);
        Naming.rebind("rmi://localhost:9999/tudien",tudien);
        System.out.println("Kết nối thành công!");
    }
}
