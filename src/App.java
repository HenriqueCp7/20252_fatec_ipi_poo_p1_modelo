import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        String nomePolicial;
        String nomeTerrorista;
        String armamento = "Pistola";
        int energia = 10;
        int quantidadeGranada = 5;
        int movimento = 1;

        do {nomePolicial = JOptionPane.showInputDialog ("Digite o nome do policial");}
        while (nomePolicial.length() < 4);

        do {nomeTerrorista = JOptionPane.showInputDialog ("Digite o nome do terrorista");}
        while (nomeTerrorista.length() < 4);

        Policial policial = new Policial(energia, nomePolicial, quantidadeGranada, armamento);
        Terrorista terrorista = new Terrorista(energia, nomeTerrorista, quantidadeGranada, armamento);

        while(terrorista.getEnergia() > 0 && policial.getEnergia() > 0){
            
            System.out.println ("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.printf ("%do movimento:\n\n", movimento);

            if (movimento > 1) {
                int ArmamentoCtDaRodada = (int) (Math.random() * 3);
                    if (ArmamentoCtDaRodada == 0) {
                        policial.setArmamento ("Faca");
                    } else if (ArmamentoCtDaRodada == 1) {
                        policial.setArmamento ("Pistola");
                    } else if (ArmamentoCtDaRodada == 2) {
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
                int AcaoPolicial = (int) (Math.random() * 4);   
                int MovimentaPrimeiro = (int) (Math.random() * 2);
            
                if (MovimentaPrimeiro == 0){
                        if (AcaoTerrorista == 0) {
                            terrorista.PlantarBomba();
                        } else if (AcaoTerrorista == 1) {
                            terrorista.LançarGranada(policial);
                        } else if (AcaoTerrorista == 2) {
                            terrorista.Atacar(policial);
                        } else if (AcaoTerrorista == 3) {
                            terrorista.PassarVez(policial);
                        }
                if (policial.getEnergia() < 0) {       
                    System.out.println ("Vida atual do policial: 0");
                    break;
                } else {
                    System.out.printf ("Vida atual do policial: %d", policial.getEnergia());
                }
                System.out.println ("\n------------------------------------------------------------------------------\n");

                    if (policial.getEnergia() > 0) {
                        if (AcaoPolicial == 0) {
                            policial.PlantarBomba();
                        } else if (AcaoPolicial == 1) {
                            policial.LançarGranada(terrorista);
                        } else if (AcaoPolicial == 2) {
                            policial.Atacar(terrorista);
                        } else {
                            policial.PassarVez(terrorista);
                        }
                    }
                if (terrorista.getEnergia() < 0) {       
                    System.out.println ("Vida atual do terrorista: 0");
                    break;
                    System.out.println ("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                } else {
                    System.out.printf ("Vida atual do terrorista: %d", terrorista.getEnergia());
                }

                } else {
                        if (AcaoPolicial == 0) {
                            policial.PlantarBomba();
                        } else if (AcaoPolicial == 1) {
                            policial.LançarGranada(terrorista);
                        } else if (AcaoPolicial == 2) {
                            policial.Atacar(terrorista);
                        } else if (AcaoPolicial == 3) {
                            policial.PassarVez(terrorista);
                        }
                if (terrorista.getEnergia() < 0) {       
                    System.out.println ("Vida atual do terrorista: 0");
                    break;
                    System.out.println ("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                } else {
                    System.out.printf ("Vida atual do terrorista: %d", terrorista.getEnergia());
                }
                    System.out.println ("\n------------------------------------------------------------------------------\n");

                    if (terrorista.getEnergia() > 0) {
                        if (AcaoTerrorista == 0) {
                            terrorista.PlantarBomba();
                        } else if (AcaoTerrorista == 1) {
                            terrorista.LançarGranada(policial);
                        } else if (AcaoTerrorista == 2) {
                            terrorista.Atacar(policial);
                        } else {
                            terrorista.PassarVez(policial);
                        }
                    }
                if (policial.getEnergia() < 0) {       
                    System.out.println ("Vida atual do policial: 0");
                    break;
                } else {
                    System.out.printf ("Vida atual do policial: %d", policial.getEnergia());
                }
            }
            movimento += 1;
        }

    if (terrorista.getEnergia() <= 0) {
            System.out.println ("\nO policial venceu!!!\n");
        } else if (policial.getEnergia() <= 0){
            System.out.println ("\nO terrorista venceu!!!\n");
        }
    }
}
