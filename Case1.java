import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;

public class Case1 {
    public static void main (String[] args ){
        seleçao();
    }
    static void seleçao(){
        System.out.println("Salario Processo Seletivo");
        String[] candidatos = {"Lucas", "Mariana", "Pedro", "Aline", "Gustavo", "Bianca", "Rafael", "Camila","Felipe", "Juliana"};
        List <String> selecionados = new ArrayList<>();
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("o candidato"+ candidato+ "solicitou o salario de "+salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.println("o candidato"+candidato+"foi selecionado para a vaga");
                selecionados.add(candidato);
            }
            candidatoAtual ++;   
        }
        System.out.println("\n cadidatos selecionados:");
        for (String nome : selecionados){
            System.out.println("-"+ nome);
        }

    }
    
    public static double valorPretendido(){
    return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

}
        
    
    
        
    

