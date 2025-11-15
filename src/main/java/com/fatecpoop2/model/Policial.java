package com.fatecpoop2.model;

import java.util.Random;

public class Policial{
  private int energia;
  private String nome;
  private int quantidadeGranadas;
  private String armamento;
  private String mapa;
  private Faca faca = new Faca();
  private Pistola pistola = new Pistola();
  private Fuzil fuzil = new Fuzil();

    public Policial (int energia, String nome, int quantidadeGranadas, int escolhaMapa) {
        this.setEnergia(energia);
        this.setNome(nome);
        this.setQntGranadas(quantidadeGranadas);

        setMapa(escolhaMapa);
    };

    public void desarmarBomba (Bomba bomba, Partida partida) {
        System.out.println("O policial " + this.nome + " esta desarmando a bomba em " + this.mapa + " ...\n");
        bomba.desarmarBomba(partida);
    };

    public void lancarGranada (Terrorista terrorista) {
        if (this.quantidadeGranadas <= 0) {
            System.out.println("\nO policial tentou lançar uma granada mas ele esta sem granadas.\n");
            return; 
        }

        System.out.println("O policial " + this.nome + " esta lançando uma granada em " + this.mapa + " ...");
        terrorista.setEnergia(terrorista.getEnergia() - 4);
            System.out.println ("O terrorista foi atingido por uma granada e sofreu 4 de dano.\n");
        this.quantidadeGranadas -= 1;
    };

    public void atacar (Terrorista terrorista) {
        int armamentoCtProxRodada = new Random().nextInt(3);

        System.out.println("O policial " + this.nome + " esta atacando em " + this.mapa + " ...");

        switch(armamentoCtProxRodada) {
            case 0: {
                setArmamento ("Faca");
                faca.atacar(terrorista);
                break;
            }
            case 1: {
                setArmamento ("Fuzil");
                fuzil.atacar(terrorista);
                break;
                
            }
            case 2: {
                setArmamento ("Pistola");
                pistola.atacar(terrorista);
                break;
            }
        }
    };

    public void passarVez (Terrorista terrorista) {
        System.out.println ("O policial " + this.nome + " passou a vez em " + this.mapa + " ...");

        int bonusEnergia = (int) (Math.random() * 2);
        if (bonusEnergia == 0){
            terrorista.setEnergia(terrorista.getEnergia() + 1);
            System.out.println ("O terrorista ganhou 1 ponto de vida.\n");
        } else {
            terrorista.setEnergia(terrorista.getEnergia() + 2);
            System.out.println ("O terrorista ganhou 2 pontos de vida.\n");
        }
    }

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
            System.out.println ("\nO policial " + nome + " esta sem granadas.\n");
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
