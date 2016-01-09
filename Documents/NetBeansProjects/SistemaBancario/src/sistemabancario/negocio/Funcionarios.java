package sistemabancario.negocio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Funcionarios extends Pessoas {

    private String nomeFuncionario;

    private String departamento;

    private double salario;

    private String dataEntrada;

    private String RG;

    private boolean presente;

    public void imprimirNome(){
        System.out.println(getDepartamento() + getNome());
    }
    
    public void mostrar() {
        System.out.println("Nome do Funcionário: " + getNomeFuncionario());
        System.out.println("Departamento: " + getDepartamento());
        System.out.println("Salário: " + getSalario());
        System.out.println("Data de Entrada: " + getDataEntrada());
        System.out.println("RG: " + getRG());
        System.out.println("Está na empresa: " + isPresente());
    }

    public void calcularTempoServico() {
        Date dataIn = new Date(this.dataEntrada);
        Date dataOut = new Date();

        System.out.println((dataIn.getYear() - dataOut.getYear()) * 365
                + (dataIn.getMonth() - dataOut.getMonth()) * 30
                + dataIn.getDay() - dataOut.getDay());
    }

    public void imprimirData() {
        Date dataHoje = new Date();
        System.out.println(dataHoje);
    }

    public void imprimirDataCalendar() {
        Calendar calendario = Calendar.getInstance();
        calendario.set(2015, 11, 12);

        Date dataCalendario = calendario.getTime();

        System.out.println(dataCalendario);
    }

    public void imprimirDataGregoriana() {
        GregorianCalendar dataGC = new GregorianCalendar();
        //Mostra o dia da semana: 1 = Domingo, 2 = Segunda-Feira, etc
        System.out.println(dataGC.get(dataGC.DAY_OF_WEEK));
        //Verifica se o ano é bissexto
        System.out.println(dataGC.isLeapYear(2009));
        //Atribui uma data diferente da atual
        dataGC.set(2015, 11, 12);
    }

    public void compararDatas() {
        Date dataUm = new Date();

        Calendar calendario = Calendar.getInstance();
        calendario.set(2015, 10, 25);

        Date dataDois = calendario.getTime();

        boolean dataSaoIguais = dataUm.equals(dataDois);
        boolean dataDoisPosterior = dataUm.after(dataDois);
        boolean dataDoisAnterior = dataUm.before(dataDois);
    }

    public void formataData() {
        Date dataUm = new Date();
        SimpleDateFormat formataDatas = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formataDatas.format(dataUm);
        System.out.println(dataFormatada);

    }

    public void converterStringParaData() {
        String dataString = "15/11/2014";
        SimpleDateFormat formataDatas = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try {
            data = formataDatas.parse(dataString);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        System.out.println(data);
    }

    public void dataInternacional() {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();

        Locale brasil = new Locale("pt", "BR"); //Retorna do país e a língua
        Locale eua = Locale.US;

        DateFormat f2 = DateFormat.getDateInstance(DateFormat.FULL, brasil);
        System.out.println("Data e hora brasileira: " + f2.format(data));

        DateFormat f3 = DateFormat.getDateInstance(DateFormat.FULL, eua);
        System.out.println("Data e hora americana: " + f3.format(data));
    }

    public void diferencaEntreDatas() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        try {
            Date date1 = sdf.parse("05/09/2003");
            Date date2 = sdf.parse("06/09/2003");
            long differenceMilliSeconds = date2.getTime() - date1.getTime();
            System.out.println("diferenca em milisegundos: " + differenceMilliSeconds);
            System.out.println("diferenca em segundos: " + (differenceMilliSeconds / 1000));
            System.out.println("diferenca em minutos: " + (differenceMilliSeconds / 1000 / 60));
            System.out.println("diferenca em horas: " + (differenceMilliSeconds / 1000 / 60 / 60));
            System.out.println("diferenca em dias: " + (differenceMilliSeconds / 1000 / 60 / 60 / 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para comparar as das e retornar o numero de dias de diferença
     * entre elas
     *
     * Compare two date and return the difference between them in days.
     *
     * @param dataLow The lowest date
     * @param dataHigh The highest date
     *
     * @return int
     */
    public static int dataDiff(java.util.Date dataLow, java.util.Date dataHigh) {

        GregorianCalendar startTime = new GregorianCalendar();
        GregorianCalendar endTime = new GregorianCalendar();

        GregorianCalendar curTime = new GregorianCalendar();
        GregorianCalendar baseTime = new GregorianCalendar();

        startTime.setTime(dataLow);
        endTime.setTime(dataHigh);

        int dif_multiplier = 1;

        // Verifica a ordem de inicio das datas  
        if (dataLow.compareTo(dataHigh) < 0) {
            baseTime.setTime(dataHigh);
            curTime.setTime(dataLow);
            dif_multiplier = 1;
        } else {
            baseTime.setTime(dataLow);
            curTime.setTime(dataHigh);
            dif_multiplier = -1;
        }

        int result_years = 0;
        int result_months = 0;
        int result_days = 0;

        // Para cada mes e ano, vai de mes em mes pegar o ultimo dia para import acumulando  
        // no total de dias. Ja leva em consideracao ano bissesto  
        while (curTime.get(GregorianCalendar.YEAR) < baseTime.get(GregorianCalendar.YEAR)
                || curTime.get(GregorianCalendar.MONTH) < baseTime.get(GregorianCalendar.MONTH)) {

            int max_day = curTime.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
            result_months += max_day;
            curTime.add(GregorianCalendar.MONTH, 1);

        }

        // Marca que é um saldo negativo ou positivo  
        result_months = result_months * dif_multiplier;

        // Retirna a diferenca de dias do total dos meses  
        result_days += (endTime.get(GregorianCalendar.DAY_OF_MONTH) - startTime.get(GregorianCalendar.DAY_OF_MONTH));

        return result_years + result_months + result_days;
    }

    private void guardar() {

    }

    private void alterar() {

    }

    private void apagar() {

    }

    private void buscar() {

    }

    public void bonificar() {

    }

    public void demitir() {

    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    /**
     * Calcula a diferença de duas datas em dias
     * <br>
     * <b>Importante:</b> Quando realiza a diferença em dias entre duas datas,
     * este método considera as horas restantes e as converte em fração de dias.
     *
     * @param dataInicial
     * @param dataFinal
     * @return quantidade de dias existentes entre a dataInicial e dataFinal.
     */
    public static double diferencaEmDias(Date dataInicial, Date dataFinal) {
        double result = 0;
        long diferenca = dataFinal.getTime() - dataInicial.getTime();
        double diferencaEmDias = (diferenca / 1000) / 60 / 60 / 24; //resultado é diferença entre as datas em dias  
        long horasRestantes = (diferenca / 1000) / 60 / 60 % 24; //calcula as horas restantes  
        result = diferencaEmDias + (horasRestantes / 24d); //transforma as horas restantes em fração de dias  

        return result;
    }

    /**
     * Calcula a diferença de duas datas em horas
     * <br>
     * <b>Importante:</b> Quando realiza a diferença em horas entre duas datas,
     * este método considera os minutos restantes e os converte em fração de
     * horas.
     *
     * @param dataInicial
     * @param dataFinal
     * @return quantidade de horas existentes entre a dataInicial e dataFinal.
     */
    public static double diferencaEmHoras(Date dataInicial, Date dataFinal) {
        double result = 0;
        long diferenca = dataFinal.getTime() - dataInicial.getTime();
        long diferencaEmHoras = (diferenca / 1000) / 60 / 60;
        long minutosRestantes = (diferenca / 1000) / 60 % 60;
        double horasRestantes = minutosRestantes / 60d;
        result = diferencaEmHoras + (horasRestantes);

        return result;
    }

    /**
     * Calcula a diferença de duas datas em minutos
     * <br>
     * <b>Importante:</b> Quando realiza a diferença em minutos entre duas
     * datas, este método considera os segundos restantes e os converte em
     * fração de minutos.
     *
     * @param dataInicial
     * @param dataFinal
     * @return quantidade de minutos existentes entre a dataInicial e dataFinal.
     */
    public static double diferencaEmMinutos(Date dataInicial, Date dataFinal) {
        double result = 0;
        long diferenca = dataFinal.getTime() - dataInicial.getTime();
        double diferencaEmMinutos = (diferenca / 1000) / 60; //resultado é diferença entre as datas em minutos  
        long segundosRestantes = (diferenca / 1000) % 60; //calcula os segundos restantes  
        result = diferencaEmMinutos + (segundosRestantes / 60d); //transforma os segundos restantes em minutos  

        return result;
    }

}
