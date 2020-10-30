
import ControleBancario.Conta;
import java.util.*;

/**
 *
 * @author Jean
 */
public class TestaAplic {

    public static void main(String args[]) {
        Conta c1 = new Conta(1234, "Jose da Silva", 1000, "senha1");
        c1.adicionaDeposito(5000, new Date(), "Antonio Maia");

        if (!c1.adicionaSaque(2000, new Date(), "senha1")) {
            System.out.println("Não foi possivel realizar o saque no valor de 2000");
        }
        if (!c1.adicionaSaque(1000, new Date(), "senha-errada")) {
            System.out.println("Não foi possivel realizar o saque no valor de 1000");
        }

        Conta c2 = new Conta(43210, "Joao de Deus", 1000, "senha2");
        c2.adicionaDeposito(3000, new Date(), "Maria da Cruz");
        if (!c2.adicionaSaque(1500, new Date(), "senha2")) {
            System.out.println("Não foi possivel realizar o saque no valor de 1500");
        }
        if (!c2.adicionaTransf(5000, new Date(), "senha2", c1)) {
            System.out.println("Não foi possivel realizar a transferencia no valor de 5000");
        }
        if (!c2.adicionaTransf(800, new Date(), "senha2", c1)) {
            System.out.println("Não foi possivel realizar a transferencia no valor de 800");
        }

        System.out.println("---------------");
        System.out.println("Saldo de c1 = "+c1.calculaSaldo());
        System.out.println("Saldo de c2 = "+c2.calculaSaldo());
    }
}
