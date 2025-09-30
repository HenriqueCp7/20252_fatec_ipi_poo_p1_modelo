public class Policial{
  private int energia;
  private String nome;
  private int quantidadeGranadas;
  private String armamento;

    public Policial (int energia, String nome, int quantidadeGranadas, String armamento) {
        this.setEnergia(energia);
        this.setNome(nome);
        this.setQntGranadas(quantidadeGranadas);
        this.setArmamento(armamento);
    };

    public void PlantarBomba () {
        System.out.println("O policial " + this.nome + " esta desarmando a bomba...\n");
    };

    public void LançarGranada (Terrorista terrorista) {
        System.out.println("O policial " + this.nome + " esta lançando uma granada...");
        terrorista.setEnergia(terrorista.getEnergia() - 4);
            System.out.println ("O terrorista foi atingido por uma granada e sofreu 4 de dano.\n");
        this.quantidadeGranadas -= 1;
    };

    public void Atacar (Terrorista terrorista) {
        System.out.println("O policial " + this.nome + " esta atacando...");
        if (this.armamento == "Faca") {
            terrorista.setEnergia(terrorista.getEnergia() - 1);
            System.out.println ("O terrorista foi atacado por uma faca e sofreu 1 de dano.\n");
        } else if (this.armamento == "Pistola") {
            terrorista.setEnergia(terrorista.getEnergia() - 2);
            System.out.println ("O terrorista levou um tiro de pistola e sofreu 2 de dano.\n");
        } else if (this.armamento == "Fuzil") {
            terrorista.setEnergia(terrorista.getEnergia() - 3);
            System.out.println ("O terrorista levou um tiro de fuzil e sofreu 3 de dano.\n");
        }
    };

    public void PassarVez (Terrorista terrorista) {
        System.out.println ("O policial " + this.nome + " passou a vez.");

        int BonusEnergia = (int) (Math.random() * 2);
        if (BonusEnergia == 0){
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
        if (energia >= -3 && energia <= 10) {
        this.energia = energia;
        } 
        if (energia < 0) {

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
}
