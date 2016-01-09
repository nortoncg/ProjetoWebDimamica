/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario.negocio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//Leia mais em: Criando e Gravando dados em Txt com Java http://www.devmedia.com.br/criando-e-gravando-dados-em-txt-com-java/23060#ixzz3u24pY5X2
/**
 *
 * @author norton
 */
public class Estudante {

    int idEstudante;
    String nome;
    boolean matriculado;
    String estado;
    String dataNascimento;
    String senha;

    public void exportarParaTXT(int idEstudante, String estudantes) {
        try {
            String caminho = "c:\\Users\\norton\\Downloads\\";
            FileWriter arq = new FileWriter(caminho + idEstudante + ".txt");

            //Grava o arquivo no disco rígido
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf("+--Resultado--+%n");

            gravarArq.printf(estudantes);
            gravarArq.printf("+-------------+%n");
            arq.close();

            System.out.printf("\nArquivo gravada com sucesso em " + caminho);

        } catch (IOException ex) {
            Logger.getLogger(Estudante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isMatriculado() {
        return matriculado;
    }

    public void setMatriculado(boolean matriculado) {
        this.matriculado = matriculado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    String observacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
