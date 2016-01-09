package sistemabancario.negocio;

import java.util.Date;

public class Pessoas {
    private String nome;
    private int idade;

    public void calcularAniversario() {
        Date dataAtual = new Date();        
        System.out.println(dataAtual.getYear()-this.idade);
    }

    public void imprimir() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
