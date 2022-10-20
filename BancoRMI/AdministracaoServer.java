
/**
 *  Servidor Administracao
 */

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class AdministracaoServer {
    public AdministracaoServer() {
        try {
            // Definicao do ip onde o servico ira funcionar
            System.setProperty("java.rmi.server.hostname", "localhost");
            // Registro do servico em uma porta
            LocateRegistry.createRegistry(1099);
            // Cria o objeto que implementa os metodos que serao servidos
            Administracao a = new AdministracaoImp();
            // Coloca na porta registrada o servico da calculadora
            Naming.bind("AgService", (Remote) a);
            System.out.println("Conexao estabelecida.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AdministracaoServer();
    }
}
