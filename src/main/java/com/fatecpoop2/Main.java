package com.fatecpoop2;

import javax.swing.JOptionPane;
import com.fatecpoop2.model.Policial;
import com.fatecpoop2.model.Terrorista;
import com.fatecpoop2.model.Partida;
import com.fatecpoop2.db.ArmazemDeResultadosDAO;
import com.fatecpoop2.db.HistoricoAtaquesDAO;
import com.fatecpoop2.model.Bomba;

public class Main {
    public static void main(String[] args) throws Exception {

        String nomePolicial;
        String nomeTerrorista;
        int escolhaMapa;
        int energia = 10;
        int quantidadeGranada = 2;
        int qntRodadasPartida;


            do {escolhaMapa = Integer.parseInt(JOptionPane.showInputDialog ("Digite 1 para escolher o mapa Roma e 2 para escolher o mapa Fatec Ipiranga"));}
            while (escolhaMapa !=1 && escolhaMapa != 2);

            do {nomePolicial = JOptionPane.showInputDialog ("Digite o nome do policial");}
            while (nomePolicial.length() < 4);

            do {nomeTerrorista = JOptionPane.showInputDialog ("Digite o nome do terrorista");}
            while (nomeTerrorista.length() < 4);

            do {qntRodadasPartida = Integer.parseInt(JOptionPane.showInputDialog ("Digite um numero impar de rodadas que voce quer pro jogo 'pelo menos 1 rodada e no maximo 20'"));}
            while (qntRodadasPartida <= 0 || qntRodadasPartida > 20 || qntRodadasPartida % 2 == 0);

            Policial policial = new Policial(energia, nomePolicial, quantidadeGranada, escolhaMapa);
            Terrorista terrorista = new Terrorista(energia, nomeTerrorista, quantidadeGranada, escolhaMapa);
            Partida partida = new Partida(qntRodadasPartida);
            Bomba bomba = new Bomba();
            HistoricoAtaquesDAO historicoAtaquesDAO = new HistoricoAtaquesDAO();
            ArmazemDeResultadosDAO armazemDeResultadosDAO = new ArmazemDeResultadosDAO();

        while (partida.getRodadaAtual() <= partida.getQntRodadasPartida() && partida.getHaUmVencedor() == false) {
            while(terrorista.getEnergia() > 0 && policial.getEnergia() > 0){
                
                System.out.println ("\n++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.printf ("\n%do RODADA\n", partida.getRodadaAtual());
                System.out.printf ("%do movimento:\n", partida.getMovimento());
                System.out.printf ("Mapa atual: de_%s\n\n", terrorista.getMapa());
                
                partida.sorteiaAcao();

                if (partida.getJogaPrimeiro() == 0){
                    switch (partida.getAcaoTerrorista()) {
                        case 0: {
                            terrorista.plantarBomba(bomba, partida.getMovimento());
                            break;
                        }
                        case 1: {
                            terrorista.lancarGranada(policial);
                            break;
                        }
                        case 2: {
                            terrorista.atacar(policial);
                            break;
                        }
                        case 3: {
                            terrorista.passarVez(policial);
                            break;
                        }
                    }
                    
                    if (policial.getEnergia() <= 0) {       
                        System.out.println ("Vida atual do policial: 0");
                        System.out.printf ("Vida atual do terrorista: %d", terrorista.getEnergia());
                        break;
                    } else {
                        System.out.printf ("Vida atual do policial: %d\n", policial.getEnergia());
                        System.out.printf ("Vida atual do terrorista: %d", terrorista.getEnergia());
                        
                        if (bomba.getBombaDesarmada()){
                                break;
                        } 

                        System.out.println ("\n----------------------------------------------\n");
                        System.out.printf ("Mapa atual: de_%s\n\n", terrorista.getMapa());
                    }

                    if (policial.getEnergia() > 0) {
                        switch (partida.getAcaoPolicial()) {
                            case 0: {
                                policial.desarmarBomba(bomba, partida);
                                break;
                                }
                            case 1: {
                                policial.lancarGranada(terrorista);
                                break;
                            }
                            case 2: {
                                policial.atacar(terrorista);
                                break;
                            }
                            case 3: {
                                policial.passarVez(terrorista);
                                break;
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

                        if (bomba.getBombaDesarmada()) {
                            break;
                        }
                    }   
                } else if (partida.getJogaPrimeiro() == 1) {
                        switch (partida.getAcaoPolicial()) {
                            case 0: {
                                policial.desarmarBomba(bomba, partida);
                                break;
                            }
                            case 1: {
                                policial.lancarGranada(terrorista);
                                break;
                            }
                            case 2: {
                                policial.atacar(terrorista);
                                break;
                            }
                            case 3: {
                                policial.passarVez(terrorista);
                                break;
                            }
                        }

                        if (terrorista.getEnergia() <= 0) {
                            System.out.printf ("Vida atual do policial: %d\n", policial.getEnergia());
                            System.out.println ("Vida atual do terrorista: 0");
                            break;
                        } else {
                            System.out.printf ("Vida atual do policial: %d\n", policial.getEnergia());
                            System.out.printf ("Vida atual do terrorista: %d", terrorista.getEnergia());

                            if (bomba.getBombaDesarmada()){
                                break;
                            } 

                            System.out.println ("\n----------------------------------------------\n");
                            System.out.printf ("Mapa atual: de_%s\n\n", terrorista.getMapa());   
                        }
                    
                        if (terrorista.getEnergia() > 0 && !bomba.getBombaDesarmada()) {
                            switch (partida.getAcaoTerrorista()) {
                                case 0: {
                                    terrorista.plantarBomba(bomba, partida.getMovimento());
                                    break;
                                }
                                case 1: {
                                    terrorista.lancarGranada(policial);
                                    break;
                                }
                                case 2: {
                                    terrorista.atacar(policial);
                                    break;
                                }
                                case 3: {
                                    terrorista.passarVez(policial);
                                    break;
                                }
                            }

                            if (policial.getEnergia() <= 0) {       
                                System.out.println ("Vida atual do policial: 0");
                                System.out.printf ("Vida atual do terrorista: %d", terrorista.getEnergia());
                                break;
                            } else {
                                System.out.printf ("Vida atual do policial: %d\n", policial.getEnergia());
                                System.out.printf ("Vida atual do terrorista: %d", terrorista.getEnergia());
                            }
                        }
                }
                    
                partida.setMovimento(partida.getMovimento() + 1);
                if(bomba.vaiExplodir(partida.getMovimento())){
                    break;
                }
            }

            partida.vencedorDaRodada(bomba, terrorista, policial);
            partida.vencedorDaPartida();
            armazemDeResultadosDAO.cadastrar(policial.getNome(), partida.getResultadoCT() , partida.getRodadaAtual());
            armazemDeResultadosDAO.cadastrar(terrorista.getNome(), partida.getResultadoTR() , partida.getRodadaAtual());
            partida.setRodadaAtual(partida.getRodadaAtual() + 1);
            historicoAtaquesDAO.cadastrar(policial.getNome(), policial.getHistoricoAtaques());
            historicoAtaquesDAO.cadastrar(terrorista.getNome(), terrorista.getHistoricoAtaques());
            partida.setMovimento(1);
            partida.setResetaResultado();
            bomba.setResetarBomba();
            policial.setQntGranadas(3);
            terrorista.setQntGranadas(3);
            policial.setEnergia(energia);
            terrorista.setEnergia(energia);
        }
    }
}