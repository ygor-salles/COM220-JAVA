
import java.io.*;
import java.util.*;

public class EmpregadasDomestica {

    public static void main(String[] args) {
        ArrayList<EmpDomestica> emps = new ArrayList<EmpDomestica>();
        EmpDomestica empB;
        int i = 0, count = 0;
        double salario = 0;

        emps.add(new Horista("Barbara", 3651, 160, 10));
        emps.add(new Diarista("Suzana", 3652, 20, 55));
        emps.add(new Mensalista("Patricia", 3653, 1000));

        for (EmpDomestica a : emps) {
            System.out.println("\nNome: " + a.getNome() + "\nTelefone: " + a.getTelefone() + "\nSalario: " + a.getSalario());
            if (salario == 0 || salario > a.getSalario()) {
                count = i;
                salario = a.getSalario();
            }
            i++;
        }

        System.out.println("\nA mais barata para a república é:\nNome: " + (emps.get(count)).getNome() + "\nTelefone: " + (emps.get(count)).getTelefone() + "\nSalario: " + (emps.get(count)).getSalario());

    }
}
