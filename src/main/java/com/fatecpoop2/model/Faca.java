package com.fatecpoop2.model;

import lombok.Getter;

public class Faca {

    @Getter
    private int dano = 1;

    public void atacar(Policial alvo) {
        alvo.setEnergia(alvo.getEnergia() - this.dano);
        System.out.printf ("O policial levou uma facada e sofreu %d de dano.\n\n", this.dano);    
    }

    public void atacar(Terrorista alvo) {
        alvo.setEnergia(alvo.getEnergia() - this.dano);
        System.out.printf ("O terrorista levou uma facada e sofreu %d de dano.\n\n", this.dano);      
    }   
}
