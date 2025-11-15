package com.fatecpoop2.model;

public class Bomba {
    private boolean bombaPlantada = false;
    private boolean bombaDesarmada = false;
    private int QuandoVaiExplodir;

    public boolean vaiExplodir(int movimentoAtual){
        if((this.bombaPlantada == true) && (this.QuandoVaiExplodir == movimentoAtual)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void desarmarBomba(Partida partida){
        if((this.bombaPlantada == true)){
            this.bombaDesarmada = true;
        } else {
            System.out.println("\nA bomba não está plantada.\n");
        }
    }

    public void setPlantarBomba(int movimentoAtual){
        if(this.bombaPlantada == false){
            this.bombaPlantada = true;
            setQuandoVaiExplodir(movimentoAtual);
        }
    }

    public void setQuandoVaiExplodir(int movimentoAtual){
        this.QuandoVaiExplodir = (movimentoAtual + 4);
    }

    public void setResetarBomba(){
        this.bombaPlantada = false;
        this.bombaDesarmada = false;
    }

    public boolean getBombaPlantada(){
        return this.bombaPlantada;
    }

    public boolean getBombaDesarmada(){
        return this.bombaDesarmada;
    }
}
