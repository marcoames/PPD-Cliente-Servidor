
/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

//UnicastRemoteObject permite que a implementacao da classe possa ser estabelecida como um servico remoto
public class AdministracaoImp extends UnicastRemoteObject implements Administracao {

    // private double[] memory = new double[10];
    ArrayList<Conta> contas = new ArrayList<Conta>();

    public AdministracaoImp() throws RemoteException {
        super();
    }

    @Override
    public String consulta(int c) throws RemoteException {
        if (contas.size() <= 0) {
            return "Nenhuma conta cadastrada";
        }
        for (Conta conta : contas) {
            if (conta.getNumero() == c) {
                String retorno = "Conta: " + conta.getNumero() + " Saldo: " + conta.getSaldo();
                return retorno;
            }
        }
        return "Conta não encontrada";

    }

    @Override
    public synchronized String deposito(int c, double valor) throws RemoteException {
        if (valor <= 0) {
            return "Valor inválido";
        }
        for (Conta conta : contas) {
            if (conta.getNumero() == c) {

                conta.setSaldo(conta.getSaldo() + valor);

                String retorno = "Deposito realizado com sucesso" + "\n"
                        + "Saldo atual: " + conta.getSaldo();

                return retorno;
            }
        }

        return "Conta não encontrada";

    }

    @Override
    public synchronized String retirada(int c, double valor) throws RemoteException {
        if (valor <= 0) {
            return "Valor inválido";
        }
        for (Conta conta : contas) {
            if (conta.getNumero() == c) {

                conta.setSaldo(conta.getSaldo() - valor);

                String retorno = "Retirada realizada com sucesso!" + "\n"
                        + "Saldo atual: " + conta.getSaldo();

                return retorno;
            }
        }

        return "Conta não encontrada";

    }

    @Override
    public String autenticaConta(int c) throws RemoteException {
        for (Conta conta : contas) {
            if (conta.getNumero() == c) {
                String retorno = "Conta: " + conta.getNumero() + " autenticada com sucesso!";
                return retorno;
            }
        }
        return "Conta não encontrada";

    }

    @Override
    public synchronized String abreConta(int numero) throws RemoteException {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return "Conta já cadastrada";
            }
        }

        Conta conta = new Conta(numero, 0);
        contas.add(conta);
        String retorno = "Conta " + conta.getNumero() + " aberta com sucesso!";
        return retorno;
    }

    @Override
    public String fechaConta(int numero) throws RemoteException {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                contas.remove(conta);
                String retorno = "Conta " + conta.getNumero() + " fechada com sucesso!";
                return retorno;
            }
        }
        return "Conta não encontrada";
    }

}
