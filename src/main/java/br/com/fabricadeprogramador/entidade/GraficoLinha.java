package br.com.fabricadeprogramador.entidade;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;

import java.util.ArrayList;
import java.util.List;

public class GraficoLinha {

    LineChartModel grafico;
    List<LinhaGrafico> linhas = new ArrayList<>();

    public void setTitulo(String titulo){
        grafico.setTitle(titulo);
    }

    public void setEixoY(int min, int max){
        Axis eixoY =  grafico.getAxis(AxisType.Y);
        eixoY.setMin(min);
        eixoY.setMax(max);
    }

    public void setEixoX(int min, int max){
        Axis eixoX =  grafico.getAxis(AxisType.X);
        eixoX.setMin(min);
        eixoX.setMax(max);
    }

    public void setarPosicaoLegenda(String pos){
        grafico.setLegendPosition(pos);
    }

    public void mostrarRotuloNosPontos(boolean flag){
        grafico.setShowPointLabels(flag);
    }

    public void adicionarLinha(LinhaGrafico linha){
        linhas.add(linha);
    }

    public void carregarLinhas(){
        for(LinhaGrafico linhaGrafico : linhas){
            grafico.addSeries(linhaGrafico.linha);
        }
    }

    //GETTERS AND SETTERS

    public LineChartModel getGrafico() {
        return grafico;
    }

    public void setGrafico(LineChartModel grafico) {
        this.grafico = grafico;
    }

    public List<LinhaGrafico> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<LinhaGrafico> linhas) {
        this.linhas = linhas;
    }
}
