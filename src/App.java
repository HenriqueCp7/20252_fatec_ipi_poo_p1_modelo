import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        String nomePolicial;
        String nomeTerrorista;
        String armamento = "Faca";
        int energia = 10;
        int quantidadeGranada = 5;
        int round = 1;

        do {nomePolicial = JOptionPane.showInputDialog ("Digite o nome do policial");}
        while (nomePolicial.length() < 4);

        do {nomeTerrorista = JOptionPane.showInputDialog ("Digite o nome do terrorista");}
        while (nomeTerrorista.length() < 4);

        Policial policial = new Policial(energia, nomePolicial, quantidadeGranada, armamento);
        Terrorista terrorista = new Terrorista(energia, nomeTerrorista, quantidadeGranada, armamento);

        while(true){
            policial.setEnergia(10);
            terrorista.setEnergia(10);
            
            System.out.println ("+++++++++++++++++++++++++++++++++++++++");
            System.out.printf ("Round %d:\n", round);

            if (round > 1) {
                int ArmamentoCtDaRodada = (int) (Math.random() * 3);
                    if (ArmamentoCtDaRodada == 1) {
                        policial.setArmamento ("Faca");
                    } else if (ArmamentoCtDaRodada == 2) {
                        policial.setArmamento ("Pistola");
                    } else if (ArmamentoCtDaRodada == 3) {
                        policial.setArmamento ("Fuzil");
                    }

                int ArmamentoTrDaRodada = (int) (Math.random() * 3);
                    if (ArmamentoTrDaRodada == 0) {
                        terrorista.setArmamento ("Faca");
                    } else if (ArmamentoTrDaRodada == 1) {
                        terrorista.setArmamento ("Pistola");
                    } else if (ArmamentoTrDaRodada == 2) {
                        terrorista.setArmamento ("Fuzil");
                    }
            }
            
            int AcaoTerrorista = (int) (Math.random() * 4);
           
            if (AcaoTerrorista == 0) {
                terrorista.PlantarBomba();
            } else if (AcaoTerrorista == 1) {
                terrorista.LançarGranada();
            } else if (AcaoTerrorista == 2) {
                terrorista.Atacar();
            } else if (AcaoTerrorista == 3) {
                terrorista.PassarVez();
            }

             int AcaoPolicial = (int) (Math.random() * 4);

            if (AcaoPolicial == 0) {
                policial.PlantarBomba();
            } else if (AcaoPolicial == 1) {
                policial.LançarGranada();
            } else if (AcaoPolicial == 2) {
                policial.Atacar();
            } else if (AcaoPolicial == 3) {
                policial.PassarVez();
            }

            round += 1;

            if (round >= 5) {
                System.out.println ("+++++++++++++++++++++++++++++++++++++++");
                break;
            }
        }
    }
}
