public class Terrorista{
  private int energia;
  private String nome;
  private int quantidadeGranadas;
  private String armamento;
  private String mapa;


    public Terrorista (int energia, String nome, int quantidadeGranadas, String armamento, int escolhaMapa) {
        this.setEnergia(energia);
        this.setNome(nome);
        this.setQntGranadas(quantidadeGranadas);
        this.setArmamento(armamento);
        setMapa(escolhaMapa);
    };

    public void PlantarBomba () {
        System.out.println("O terrorista " + this.nome + " esta plantando a bomba em " + this.mapa + " ...\n");
    };

    public void LançarGranada (Policial policial) {
        if (this.quantidadeGranadas <= 0) {
            System.out.println("\nO terrorista tentou lançar uma granada mas ele esta sem granadas.\n");
            return; 
        }

        System.out.println("O terrorista " + this.nome + " esta lancando uma granada em " + this.mapa + " ...");
        policial.setEnergia(policial.getEnergia() - 4);
            System.out.println ("O policial foi atingido por uma granada e sofreu 4 de dano.\n");
        this.quantidadeGranadas -= 1;
    };

    public void Atacar (Policial policial) {
        System.out.println("O terrorista " + this.nome + " esta atacando em " + this.mapa + " ...");
        if (this.armamento == "Faca") {
            policial.setEnergia(policial.getEnergia() - 1);
            System.out.println ("O policial foi atacado por uma faca e sofreu 1 de dano.\n");
        } else if (this.armamento == "Pistola") {
            policial.setEnergia(policial.getEnergia() - 2);
            System.out.println ("O policial levou um tiro de pistola e sofreu 2 de dano.\n");
        } else if (this.armamento == "Fuzil") {
            policial.setEnergia(policial.getEnergia() - 3);
            System.out.println ("O policial levou um tiro de fuzil e sofreu 3 de dano.\n");
        }
    };

    public void PassarVez (Policial policial) {
        System.out.println("O terrorista " + this.nome + " passou a vez em " + this.mapa + " ...");

        int BonusEnergia = (int) (Math.random() * 2);
        if (BonusEnergia == 0){
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
        if (quantidadeGranadas >= 0 && quantidadeGranadas <= 5) {
            this.quantidadeGranadas = quantidadeGranadas;
        } else if (quantidadeGranadas < 0) {
            System.out.println ("\nO terrorista " + nome + " esta sem granadas.\n");
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