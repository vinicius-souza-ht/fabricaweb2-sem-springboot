package br.com.fabricadeprogramador.entidade;

import org.primefaces.model.chart.ChartSeries;

public class LinhaGrafico {

    //Tratar ID, se salvo no banco, esse valor sera automaticamente gerado pelo Hibernate
    int id;
    ChartSeries linha = new ChartSeries();

    public void adicionarValor(Object label, Number valor){
        linha.set(label, valor);
    }

    public void adicionarLabel(String label){
        linha.setLabel(label);
    }

    public ChartSeries getLinha() {
        return linha;
    }

    public void setLinha(ChartSeries linha) {
        this.linha = linha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
