import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Case1 {
    public static void main(String[] args) {
        seleçao();
    }

    static void seleçao() {
        System.out.println("Salario Processo Seletivo");
        String[] candidatos = {"Lucas", "Mariana", "Pedro", "Aline", "Gustavo", "Bianca", "Rafael", "Camila", "Felipe", "Juliana"};
        List<String> selecionados = new ArrayList<>();
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou o salário de " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                selecionados.add(candidato);
                candidatosSelecionados++;
                ligacao(candidato);
            }
            candidatoAtual++;
        }

        System.out.println("\nCandidatos selecionados:");
        for (String nome : selecionados) {
            System.out.println("- " + nome);
        }
    }

    static void ligacao(String candidato) {
        int ligacoes = 1;
        boolean continuarLig = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            if (!atendeu) {
                System.out.println("Tentativa " + ligacoes + ": " + candidato + " não atendeu.");
                ligacoes++;
            } else {
                System.out.println("Tentativa " + ligacoes + ": " + candidato + " atendeu.");
                System.out.println("Contato com " + candidato + " realizado com sucesso.");
                continuarLig = false;
            }
        } while (continuarLig && ligacoes <= 3);

        if (!atendeu) {
            System.out.println("Não conseguimos contato com " + candidato + " após 3 tentativas.");
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    public static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
}
