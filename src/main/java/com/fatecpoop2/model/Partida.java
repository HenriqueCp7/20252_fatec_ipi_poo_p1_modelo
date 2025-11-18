package com.fatecpoop2.model;

import java.util.Random;

public class Partida {
    
    private int acaoDoTerrorista;
    private int acaoDoPolicial;
    private int jogaPrimeiro;
    private Random aux = new Random();
    private int rodadaAtual = 1;
    private int qntRodadasPartida;
    private int movimento = 1;
    private int pontuacaoPolicial = 0;
    private int pontuacaoTerrorista = 0;
    private boolean haUmVencedor = false;
    private String trResultado;
    private String ctResultado;

    public Partida(int qntRodadasPartida){
        this.setQntRodadasPartida(qntRodadasPartida);
    }

    public void sorteiaAcao(){
        this.acaoDoPolicial = aux.nextInt(4);
        this.acaoDoTerrorista = aux.nextInt(4);
        this.jogaPrimeiro = aux.nextInt(2);
    }

    public void vencedorDaRodada(Bomba bomba, Terrorista terrorista, Policial policial){

        if (bomba.getBombaDesarmada()){
            System.out.println ("\n++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println ("\nA bomba foi desarmada com sucesso!");
            System.out.println ("O policial venceu a rodada!!!");
            setPontuacaoPolicial(getPontuacaoPolicial() + 1);

            this.ctResultado = "Vencedor";
            this.trResultado = "Perdedor";
        } else {
            System.out.println ("\n++++++++++++++++++++++++++++++++++++++++++++++");

            if (bomba.getBombaPlantada() && bomba.vaiExplodir(this.movimento)) {
                System.out.println ("\nA bomba plantada explodiu.");
                System.out.println ("O terrorista venceu a rodada!!!");
                setPontuacaoTerrorista(getPontuacaoTerrorista() + 1);

                this.ctResultado = "Perdedor";
                this.trResultado = "Vencedor";
            } else {
                
                if (terrorista.getEnergia() <= 0) {
                    System.out.println ("\nO policial venceu a rodada!!!\n");
                    setPontuacaoPolicial(getPontuacaoPolicial() + 1);

                    this.ctResultado = "Vencedor";
                    this.trResultado = "Perdedor";
                } 
                else if (policial.getEnergia() <= 0){
                    System.out.println ("\nO terrorista venceu a rodada!!!\n");
                    setPontuacaoTerrorista(getPontuacaoTerrorista() + 1);

                    this.ctResultado = "Perdedor";
                    this.trResultado = "Vencedor";
                }
            }
        }
    }

    public void vencedorDaPartida(){
        if (getPontuacaoTerrorista() > (getQntRodadasPartida() / 2)) {
                System.out.println ("\n++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println ("\n\n!!!O TERRORISTA VENCEU O JOGO!!!\n");
                System.out.printf ("O terrorista venceu: %d rodadas e perdeu %d rodadas\n", getPontuacaoTerrorista(), getPontuacaoPolicial());
                System.out.printf ("O policial venceu: %d rodadas e perdeu %d rodadas\n", getPontuacaoPolicial(), getPontuacaoTerrorista());
                this.haUmVencedor = true;
            } else if (getPontuacaoPolicial() > (getQntRodadasPartida() / 2)) {
                System.out.println ("\n++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println ("\n\n!!!O POLICIAL VENCEU O JOGO!!!\n");
                System.out.printf ("O policial venceu: %d rodadas e perdeu %d rodadas\n", getPontuacaoPolicial(), getPontuacaoTerrorista());
                System.out.printf ("O terrorista venceu: %d rodadas e perdeu %d rodadas\n", getPontuacaoTerrorista(), getPontuacaoPolicial());
                this.haUmVencedor = true;
        } 
    }

    public void setRodadaAtual(int rodadaAtual){
        this.rodadaAtual = rodadaAtual;
    }

    public void setQntRodadasPartida(int qntRodadasPartida){
        this.qntRodadasPartida = qntRodadasPartida;
    }

    public void setMovimento(int movimento){
        this.movimento = movimento;
    }

    public void setPontuacaoPolicial(int pontuacaoPolicial){
        this.pontuacaoPolicial = pontuacaoPolicial;
    }

    public void setPontuacaoTerrorista(int pontuacaoTerrorista){
        this.pontuacaoTerrorista = pontuacaoTerrorista;
    }

    public void setResetaResultado(){
        this.ctResultado = null;
        this.trResultado = null;
    }

    public int getAcaoTerrorista(){
        return this.acaoDoTerrorista;
    }

    public int getAcaoPolicial(){
        return this.acaoDoPolicial;
    }

    public int getJogaPrimeiro(){
        return this.jogaPrimeiro;
    }

    public int getRodadaAtual(){
        return this.rodadaAtual;
    }

    public int getQntRodadasPartida(){
        return this.qntRodadasPartida;
    }

    public int getMovimento(){
        return this.movimento;
    }

    public int getPontuacaoPolicial(){
        return this.pontuacaoPolicial;
    }

    public int getPontuacaoTerrorista(){
        return this.pontuacaoTerrorista;
    }

    public boolean getHaUmVencedor(){
        return this.haUmVencedor;
    }

    public String getResultadoCT(){
        return this.ctResultado;
    }

    public String getResultadoTR(){
        return this.trResultado;
    }

}