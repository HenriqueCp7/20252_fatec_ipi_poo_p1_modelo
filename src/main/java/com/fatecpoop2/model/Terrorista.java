package com.fatecpoop2.model;
import java.util.Random;

public class Terrorista{
  private int energia;
  private String nome;
  private int quantidadeGranadas;
  private String armamento;
  private String mapa;
  private Faca faca = new Faca();
  private Pistola pistola = new Pistola();
  private Fuzil fuzil = new Fuzil();
 


    public Terrorista (int energia, String nome, int quantidadeGranadas, int escolhaMapa) {
        this.setEnergia(energia);
        this.setNome(nome);
        this.setQntGranadas(quantidadeGranadas);
        setMapa(escolhaMapa);
    };

    public void plantarBomba (Bomba bomba, int movimento) {
        System.out.println("O terrorista " + this.nome + " esta plantando a bomba em " + this.mapa + " ...\n");
        bomba.setPlantarBomba(movimento);
    };

    public void lancarGranada (Policial policial) {
        if (this.quantidadeGranadas <= 0) {
            System.out.println("\nO terrorista tentou lançar uma granada mas ele esta sem granadas.\n");
            return; 
        }

        System.out.println("O terrorista " + this.nome + " esta lancando uma granada em " + this.mapa + " ...");
        policial.setEnergia(policial.getEnergia() - 4);
            System.out.println ("O policial foi atingido por uma granada e sofreu 4 de dano.\n");
        this.quantidadeGranadas -= 1;
    };

    public void atacar (Policial policial) {
        int armamentoTrProxRodada = new Random().nextInt(3);

        System.out.println("O terrorista " + this.nome + " esta atacando em " + this.mapa + " ...");

        switch(armamentoTrProxRodada) {
            case 0: {
                setArmamento ("Faca");
                faca.atacar(policial);
                break;
            }
            case 1: {
                setArmamento ("Fuzil");
                fuzil.atacar(policial);
                break;
            }
            case 2: {
                setArmamento ("Pistola");
                pistola.atacar(policial);
                break;
            }
        }
    };

    public void passarVez (Policial policial) {
        System.out.println("O terrorista " + this.nome + " passou a vez em " + this.mapa + " ...");

        int bonusEnergia = (int) (Math.random() * 2);
        if (bonusEnergia == 0){
            policial.setEnergia(policial.getEnergia() + 1);
            System.out.println ("O policial ganhou 1 ponto de vida.\n");
        } else {
            policial.setEnergia(policial.getEnergia() + 2);
            System.out.println ("O policial ganhou 2 pontos de vida.\n");
        }
    };

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        if (energia < 0) {
            this.energia = 0;
        } else if (energia > 10) {
            this.energia = 10;
        } else {
            this.energia = energia;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() >= 4) {
            this.nome = nome;
        } 
    }

    public int getQntGranadas() {
        return quantidadeGranadas;
    }

    public void setQntGranadas(int quantidadeGranadas) {
        if (quantidadeGranadas < 0) {
            this.quantidadeGranadas = 0;
            System.out.println ("\nO terrorista " + nome + " esta sem granadas.\n");
        } else if (quantidadeGranadas > 5) {
            this.quantidadeGranadas = 5;
        } else {
            this.quantidadeGranadas = quantidadeGranadas;
        }
    }

    public String getArmamento() {
        return armamento;
    }

    public void setArmamento(String armamento) {
        if (armamento == "Faca" || armamento == "Pistola" || armamento == "Fuzil"){
        this.armamento = armamento;
        }
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(int escolhaMapa) {
        if (escolhaMapa == 1 ) {
            this.mapa = "Roma";
        } else if (escolhaMapa == 2) {
            this.mapa = "FatecIpiranga";
        } else {
            System.out.println("Mapa inexistente.");
        }

    }
}