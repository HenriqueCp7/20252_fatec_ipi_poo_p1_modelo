package com.fatecpoop2.model;


import lombok.Getter;

public class Pistola {

    @Getter
    private int dano = 2;

    public void atacar(Policial alvo) {
        alvo.setEnergia(alvo.getEnergia() - this.dano);
        System.out.printf ("O policial levou um tiro de pistola e sofreu %d de dano.\n\n", this.dano);    
    }

    public void atacar(Terrorista alvo) {
        alvo.setEnergia(alvo.getEnergia() - this.dano);
        System.out.printf ("O terrorista levou um tiro de pistola e sofreu %d de dano.\n\n", this.dano);      
    }      
}