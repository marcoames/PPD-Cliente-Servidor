
/**
    Interface Calculadora com assinatura dos métodos 
 */

import java.rmi.*;

public interface Administracao extends Remote {
    public String consulta(int c) throws RemoteException;

    public String deposito(int c, double valor) throws RemoteException;

    public String retirada(int c, double valor) throws RemoteException;

    public String abreConta(int numero) throws RemoteException;

    public String fechaConta(int numero) throws RemoteException;

    public String autenticaConta(int c) throws RemoteException;

}