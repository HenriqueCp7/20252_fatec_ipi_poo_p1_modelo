package com.fatecpoop2.model;

import lombok.Getter;

public class Fuzil {
    @Getter
    private int dano = 3;

    public void atacar(Policial alvo) {
        alvo.setEnergia(alvo.getEnergia() - this.dano);
        System.out.printf ("O policial levou um tiro de fuzil e sofreu %d de dano.\n\n", this.dano);    
    }

    public void atacar(Terrorista alvo) {
        alvo.setEnergia(alvo.getEnergia() - this.dano);
        System.out.printf ("O terrorista levou um tiro de fuzil e sofreu %d de dano.\n\n", this.dano);      
    }   
}
        
            
    
        
    
