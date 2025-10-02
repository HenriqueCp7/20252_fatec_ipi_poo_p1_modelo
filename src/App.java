import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        String nomePolicial;
        String nomeTerrorista;
        String armamento = "Pistola";
        int escolhaMapa;
        int energia = 10;
        int quantidadeGranada = 5;
        int movimento = 1;
        int rodadas; int rodadaAtual = 1;
        int bombaPlantada = 0; int vaiExplodir = 0;
        int pontosTerrorista = 0; int pontosPolicial = 0; int vencedor = 0;


            do {escolhaMapa = Integer.parseInt(JOptionPane.showInputDialog ("Digite 1 para escolher o mapa Roma e 2 para escolher o mapa Fatec Ipiranga"));}
            while (escolhaMapa !=1 && escolhaMapa != 2);

            do {nomePolicial = JOptionPane.showInputDialog ("Digite o nome do policial");}
            while (nomePolicial.length() < 4);

            do {nomeTerrorista = JOptionPane.showInputDialog ("Digite o nome do terrorista");}
            while (nomeTerrorista.length() < 4);

            do {rodadas = Integer.parseInt(JOptionPane.showInputDialog ("Digite um numero impar de rodadas que voce quer pro jogo 'pelo menos 1 rodada e no maximo 20'"));}
            while (rodadas <= 0 || rodadas > 20 || rodadas % 2 == 0);

            Policial policial = new Policial(energia, nomePolicial, quantidadeGranada, armamento, escolhaMapa);
            Terrorista terrorista = new Terrorista(energia, nomeTerrorista, quantidadeGranada, armamento, escolhaMapa);

        while (rodadaAtual <= rodadas && vencedor != 1) {
            while(terrorista.getEnergia() > 0 && policial.getEnergia() > 0){
                
                System.out.println ("\n++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.printf ("\n%do RODADA\n", rodadaAtual);
                System.out.printf ("%do movimento:\n", movimento);
                System.out.printf ("Mapa atual: de_%s\n\n", terrorista.getMapa());

                if (movimento >= 2) {
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
                            bombaPlantada = 1;
                            if (vaiExplodir == 0) {
                            vaiExplodir = movimento + 4;
                            }
                        } else if (AcaoTerrorista == 1) {
                            terrorista.LançarGranada(policial);
                        } else if (AcaoTerrorista == 2) {
                            terrorista.Atacar(policial);
                        } else if (AcaoTerrorista == 3) {
                            terrorista.PassarVez(policial);
                        }

                        if (policial.getEnergia() <= 0) {       
                            System.out.println ("Vida atual do policial: 0\n");
                            System.out.printf ("Vida atual do terrorista: %d", terrorista.getEnergia());
                            break;
                        } else {
                            System.out.printf ("Vida atual do policial: %d\n", policial.getEnergia());
                            System.out.printf ("Vida atual do terrorista: %d", terrorista.getEnergia());
                        }

                        System.out.println ("\n----------------------------------------------\n");
                        System.out.printf ("Mapa atual: de_%s\n\n", terrorista.getMapa());
                        if (policial.getEnergia() > 0) {
                            if (AcaoPolicial == 0) {
                                policial.PlantarBomba();
                                if (bombaPlantada == 1){
                                    System.out.println ("++++++++++++++++++++++++++++++++++++++++++++++\n");
                                    System.out.println ("\nO policial venceu a rodada!!!\n");
                                    bombaPlantada = 2;
                                    break;
                                }
                            } else if (AcaoPolicial == 1) {
                                policial.LançarGranada(terrorista);
                            } else if (AcaoPolicial == 2) {
                                policial.Atacar(terrorista);
                            } else {
                                policial.PassarVez(terrorista);
                            }
                        }

                        if (terrorista.getEnergia() <= 0) { 
                            System.out.printf ("Vida atual do policial: %d\n", policial.getEnergia());      
                            System.out.println ("Vida atual do terrorista: 0");
                            break;
                        } else {
                            System.out.printf ("Vida atual do policial: %d\n", policial.getEnergia());
                            System.out.printf ("Vida atual do terrorista: %d", terrorista.getEnergia());
                        }

                } else if (MovimentaPrimeiro == 1 && bombaPlantada !=2) {

                        if (AcaoPolicial == 0) {

                            policial.PlantarBomba();
                            if (bombaPlantada == 1){
                                System.out.println ("++++++++++++++++++++++++++++++++++++++++++++++\n");
                                System.out.println ("O policial venceu a rodada!!!\n");
                                bombaPlantada = 2;
                                break;
                            }
                        } else if (AcaoPolicial == 1) {
                            policial.LançarGranada(terrorista);
                        } else if (AcaoPolicial == 2) {
                            policial.Atacar(terrorista);
                        } else if (AcaoPolicial == 3) {
                            policial.PassarVez(terrorista);
                        }

                        if (terrorista.getEnergia() <= 0) {
                            System.out.printf ("Vida atual do policial: %d\n", policial.getEnergia());
                            System.out.println ("Vida atual do terrorista: 0");
                            break;
                        } else {
                            System.out.printf ("Vida atual do policial: %d\n", policial.getEnergia());
                            System.out.printf ("Vida atual do terrorista: %d", terrorista.getEnergia());    
                        }

                        System.out.println ("\n----------------------------------------------\n");
                        System.out.printf ("Mapa atual: de_%s\n\n", terrorista.getMapa());
                        if (terrorista.getEnergia() > 0) {
                            if (AcaoTerrorista == 0) {
                                terrorista.PlantarBomba();
                                bombaPlantada = 1;
                                if (vaiExplodir == 0) {
                                vaiExplodir = movimento + 4;
                                }
                            } else if (AcaoTerrorista == 1) {
                                terrorista.LançarGranada(policial);
                            } else if (AcaoTerrorista == 2) {
                                terrorista.Atacar(policial);
                            } else {
                                terrorista.PassarVez(policial);
                            }
                        }
                    if (policial.getEnergia() <= 0) {       
                        System.out.println ("Vida atual do policial: 0\n");
                        System.out.printf ("Vida atual do terrorista: %d", terrorista.getEnergia());
                        break;
                    } else {
                        System.out.printf ("Vida atual do policial: %d\n", policial.getEnergia());
                        System.out.printf ("Vida atual do terrorista: %d", terrorista.getEnergia());
                    }
                }
                movimento += 1;
                if (vaiExplodir == movimento && bombaPlantada == 1) {
                    bombaPlantada = 3;
                    break;
                }
            }

            if (bombaPlantada == 2){
                pontosPolicial += 1;
            }
            else {
                System.out.println ("\n++++++++++++++++++++++++++++++++++++++++++++++");

                if (bombaPlantada == 1 || bombaPlantada == 3) {
                    System.out.println ("\nA bomba plantada explodiu.");
                    System.out.println ("O terrorista venceu a rodada!!!");
                    pontosTerrorista += 1;
                } else {
                    if (terrorista.getEnergia() <= 0) {
                        System.out.println ("\nO policial venceu a rodada!!!\n");
                        pontosPolicial += 1;
                    } else if (policial.getEnergia() <= 0){
                        System.out.println ("\nO terrorista venceu a rodada!!!\n");
                        pontosTerrorista += 1;
                    }
                }
            }

            if (pontosTerrorista > (rodadas / 2)) {
                System.out.println ("\n++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println ("\n\n!!!O TERRORISTA VENCEU O JOGO!!!\n");
                System.out.printf ("O terrorista venceu: %d rodadas e perdeu %d rodadas\n", pontosTerrorista, pontosPolicial);
                System.out.printf ("O policial venceu: %d rodadas e perdeu %d rodadas\n", pontosPolicial, pontosTerrorista);
                vencedor = 1;
            } else if (pontosPolicial > (rodadas / 2)) {
                System.out.println ("\n++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println ("\n\n!!!O POLICIAL VENCEU O JOGO!!!\n");
                System.out.printf ("O policial venceu: %d rodadas e perdeu %d rodadas\n", pontosPolicial, pontosTerrorista);
                System.out.printf ("O terrorista venceu: %d rodadas e perdeu %d rodadas\n", pontosTerrorista, pontosPolicial);
                vencedor = 1;
            }   
            rodadaAtual += 1;
            bombaPlantada = 0;
            movimento = 1;
            quantidadeGranada = 5;
            policial.setEnergia(energia);
            terrorista.setEnergia(energia);
        }
    }
        
}
