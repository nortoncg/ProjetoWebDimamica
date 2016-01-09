/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import sistemabancario.negocio.Funcionarios;

/**
 *
 * @author norton
 */
public class SistemaBancario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Instanciar a classe funcionario
        Funcionarios objFuncionario = new Funcionarios();
        
        objFuncionario.setDataEntrada("17/10/2013");
        objFuncionario.setDepartamento("Lab03");
        objFuncionario.setNomeFuncionario("Fulano de Tal");
        objFuncionario.setPresente(true);
        objFuncionario.setRG("45454545");
        objFuncionario.setSalario(10000.00);
        
        objFuncionario.imprimirNome();
        
        if (objFuncionario.getRG().length() == 11){
            System.out.println("Tem 11 digitos");
        }else{
            System.out.println("Não tem 11 digitos");
        }
        
        String[] data = objFuncionario.getDataEntrada().split("/");      
        if (data[0].length() == 2 && data[1].length() == 2 && data[2].length() == 4){
            System.out.println("A data está correta");
        }
        
        //objFuncionario.calcularTempoServico();
        //objFuncionario.calcularAniversario();
        objFuncionario.dataInternacional();
        
        System.out.println(objFuncionario.getNomeFuncionario());

        /*
        objFuncionario.mostrar();
        
        Funcionarios objFuncionario2 = new Funcionarios();
        objFuncionario2.setNome("Fulaninho");
        objFuncionario2.setIdade(23);
        objFuncionario2.imprimir(); 
        */
    }
    
}
