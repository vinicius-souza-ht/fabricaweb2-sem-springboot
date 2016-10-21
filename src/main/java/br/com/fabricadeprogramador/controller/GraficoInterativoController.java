package br.com.fabricadeprogramador.controller;

import br.com.fabricadeprogramador.entidade.GraficoLinha;
import br.com.fabricadeprogramador.entidade.LinhaGrafico;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@Controller(value="graficoInterativoController")
public class GraficoInterativoController {

    GraficoLinha graficoLinha = new GraficoLinha();
    GraficoLinha graficoLinha2 = new GraficoLinha();

    //So existem aqui pois nao tenho a lista de linhas do meu grafico carregadas. Vc devera carregar essas linhas dinamicamente
    //ou seja, setar todas as linhas(meses do ano) antes de iniciar.
    LinhaGrafico series1 = new LinhaGrafico();
    LinhaGrafico series2 = new LinhaGrafico();

    List<LinhaGrafico> linhasList = new ArrayList<>();
    private List<LinhaGrafico> linhasSelecionadasList = new ArrayList<>();

    @PostConstruct
    public void init() {
        //Inicializar a lista(linhasList) com todas as linhas do grafico para carregar no DataTable
        graficoLinha.setGrafico(new LineChartModel());
        linhasList = new ArrayList<>();
        criarModeloDeLinha();
        inicializarModeloLinear();
    }

    //Getters e Setters
    public List<LinhaGrafico> getLinhasList() {
        return linhasList;
    }

    public void setLinhasList(List<LinhaGrafico> linhasList) {
        this.linhasList = linhasList;
    }

    public List<LinhaGrafico> getLinhasSelecionadasList() {
        return linhasSelecionadasList;
    }

    public void setLinhasSelecionadasList(List<LinhaGrafico> linhasSelecionadasList) {
        this.linhasSelecionadasList = linhasSelecionadasList;
    }

    public GraficoLinha getGraficoLinha() {
        return graficoLinha;
    }

    public void setGraficoLinha(GraficoLinha graficoLinha) {
        this.graficoLinha = graficoLinha;
    }

    public GraficoLinha getGraficoLinha2() {
        return graficoLinha2;
    }

    public void setGraficoLinha2(GraficoLinha graficoLinha2) {
        this.graficoLinha2 = graficoLinha2;
    }


    //Metodos

    private void criarModeloDeLinha(){

//        graficoLinha.setGrafico(inicializarModeloLinear());
        graficoLinha.setTitulo("Linear Chart");
        graficoLinha.setarPosicaoLegenda("e");
        Axis yAxis = graficoLinha.getGrafico().getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

//        graficoLinha2.setGrafico(inicializarModeloCategoria());
//        graficoLinha2.setTitulo("Category Chart");
//        graficoLinha2.setarPosicaoLegenda("e");
//        graficoLinha2.mostrarRotuloNosPontos(true);
//        graficoLinha2.getGrafico().getAxes().put(AxisType.X, new CategoryAxis("Years"));
//        yAxis = graficoLinha2.getGrafico().getAxis(AxisType.Y);
//        yAxis.setLabel("Births");
//        yAxis.setMin(0);
//        yAxis.setMax(200);
    }

    private void inicializarModeloLinear(){
        //Inicializa todos os pontos de todas as linhas do grafico PS.: Estou setando aqui por nao ter todos os valores
        //do seu grafico, mas vc tera que fazer um laço pra setar todos os valores dos pontos das linhas.
        //Estou criando as linhas do meu grafico manualmente aqui. Series 1 e Series 2 sao linhas

        series1.adicionarLabel("Series 1");
        series1.setId(0);

        series1.adicionarValor(1, 2);
        series1.adicionarValor(2, 1);
        series1.adicionarValor(3, 3);
        series1.adicionarValor(4, 6);
        series1.adicionarValor(5, 8);


        series2.adicionarLabel("Series 2");
        series2.setId(1);

        series2.adicionarValor(1, 6);
        series2.adicionarValor(2, 3);
        series2.adicionarValor(3, 2);
        series2.adicionarValor(4, 7);
        series2.adicionarValor(5, 9);

        linhasList.add(series1);
        linhasList.add(series2);

//        graficoLinha.getGrafico().addSeries(series1.getLinha());
//        graficoLinha.getGrafico().addSeries(series2.getLinha());

//        return graficoLinha.getGrafico();
    }

//    private LineChartModel inicializarModeloCategoria() {
//
//        graficoLinha.setGrafico(new LineChartModel());
//
//        LinhaGrafico boys = new LinhaGrafico();
//
//        boys.adicionarLabel("Boys");
//        boys.adicionarValor("2004", 120);
//        boys.adicionarValor("2005", 100);
//        boys.adicionarValor("2006", 44);
//        boys.adicionarValor("2007", 150);
//        boys.adicionarValor("2008", 25);
//
//        LinhaGrafico girls = new LinhaGrafico();
//        girls.adicionarLabel("Girls");
//        girls.adicionarValor("2004", 52);
//        girls.adicionarValor("2005", 60);
//        girls.adicionarValor("2006", 110);
//        girls.adicionarValor("2007", 90);
//        girls.adicionarValor("2008", 120);
//
//        graficoLinha.getGrafico().addSeries(boys.getLinha());
//        graficoLinha.getGrafico().addSeries(girls.getLinha());
//
//        //Adiciona na lista as linhas
//        linhasList.add(boys);
//        linhasList.add(girls);
//
//        return graficoLinha.getGrafico();
//    }

    public void carregarGrafico(){
        //Estou adicionando as linhas selecionadas no grafico
        init();

        for(LinhaGrafico linhaGrafico : linhasSelecionadasList){
            graficoLinha.getGrafico().addSeries(linhaGrafico.getLinha());
        }
    }
}
