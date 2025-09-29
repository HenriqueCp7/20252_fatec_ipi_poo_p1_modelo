public class Terrorista{
  private int energia;
  private String nome;
  private int quantidadeGranadas;
  private String armamento;

    public Terrorista (int energia, String nome, int quantidadeGranadas, String armamento) {
        this.setEnergia(energia);
        this.setNome(nome);
        this.setQntGranadas(quantidadeGranadas);
        this.setArmamento(armamento);
    };

    public void PlantarBomba () {
        System.out.println("\nO terrorista " + this.nome + " esta plantando a bomba...\n");
    };

    public void LançarGranada () {
        System.out.println("\nO terrorista " + this.nome + " esta lancando uma granada...\n");
        this.quantidadeGranadas -= 1;
    };

    public void Atacar () {
        System.out.println("\nO terrorista " + this.nome + " esta atacando...\n");
    };

    public void PassarVez () {
        System.out.println("\nO terrorista " + this.nome + " passou...\n");
    };

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        if (energia >= 0 && energia <= 10) {
        this.energia = energia;
        } else if (energia < 0) {
            System.out.println ("O terrorista morreu\n");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() < 4) {
            System.out.println ("O nome do terrorista deve ter no minimo 4 letras\n");
        } else {
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
            System.out.println ("O terrorista " + nome + " esta sem granadas.\n");
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
}