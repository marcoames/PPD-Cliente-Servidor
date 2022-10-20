
/**
 *  Cliente da Agencia
 */

import java.rmi.Naming;
import java.util.Scanner;

public class Agencia {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            // Procura pelo servico da calculadora no IP e porta definidos
            Administracao a = (Administracao) Naming.lookup("rmi://localhost:1099/AgService");

            System.out.println("1 - consulta");
            System.out.println("2 - deposito");
            System.out.println("3 - retirada");
            System.out.println("4 - autentica conta");
            System.out.println("5 - abre conta");
            System.out.println("6 - fecha conta");
            System.out.println("0 - sair");
            boolean exec = true;

            String result;

            while (exec) {

                int key = in.nextInt();
                switch (key) {
                    case 1:
                        result = a.consulta(in.nextInt());
                        System.out.println(result);
                        break;
                    case 2:
                        result = a.deposito(in.nextInt(), in.nextDouble());
                        System.out.println(result);
                        break;
                    case 3:
                        result = a.retirada(in.nextInt(), in.nextDouble());
                        System.out.println(result);
                        break;
                    case 4:
                        result = a.autenticaConta(in.nextInt());
                        System.out.println(result);
                        break;
                    case 5:
                        result = a.abreConta(in.nextInt());
                        System.out.println(result);
                        break;
                    case 6:
                        result = a.fechaConta(in.nextInt());
                        System.out.println(result);
                        break;
                    case 0:
                        exec = false;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
