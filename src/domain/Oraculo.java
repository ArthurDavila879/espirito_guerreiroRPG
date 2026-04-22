package domain;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Oraculo {
    private String nome;
    private Guerreiro warrior;
    private int vidasIniciais;
    private int vidasPerdidas;
    private List<Integer> palpitesLevel01 = new ArrayList<>();
    private int numeroSecretoLevel01;
    private List<String> respostasLevel02 = new ArrayList<>();
    private List<String> respostasCorretasLevel02 = new ArrayList<>();


    public void game(){
        String nome = InOut.leString("INSIRA SEU NOME");
        this.warrior = new Guerreiro();
        Bolsa bolsa = new Bolsa();
        warrior.setNome(nome);
        this.nome = "Aethryon";
        warrior.setMyBolsa(bolsa);
        this.prologoIntroducao();
        
        // Level 01
        boolean continuarJogo = false;
        do {
            if(this.loadLevel01()){
                InOut.MsgDeAviso("Item","Item desbloqueado");
                warrior.ganharItem();
                continuarJogo = true;
                break;
            }
            else if (warrior.getQtdVida()==0){
                this.prologoPerdedor();
                // Se recebeu vidas extras, continua do Level 01, senão encerra
                if (warrior.getQtdVida() == 0) {
                    this.relatorioFimGame();
                    InOut.MsgDeInformacao("FIM DE JOGO", "Você não conseguiu se salvar...");
                    return;
                }
            }
        } while (warrior.getQtdVida() > 0 && !continuarJogo);
        
        // Level 02
        if (warrior.getQtdVida()!=0) {
            this.loadLevel02();
            InOut.MsgDeAviso("Item","Item desbloqueado");
            warrior.ganharItem();
        }

        // Level 03
        if ( warrior.getQtdVida()!=0){
            this.loadLevel03();
        }
        
        // Resultado Final
        if (warrior.getQtdVida()==0){
            this.relatorioFimGame();
            InOut.MsgDeInformacao("DERROTA", warrior.getNome() + " foi derrotado pelo verdadeiro Oráculo Master");
        }
        else {
            this.relatorioFimGame();
            this.prologoVencedor();
        }
    }
    public void definirNome(String nome) {
        this.nome = nome;
    }

    public void prologoIntroducao() {
        String mensagem = "Ola guerreiro " + warrior.getNome();
        InOut.MsgDeInformacao("Introdução", mensagem);
        InOut.MsgDeInformacao("Introdução", "Sou o oraculo " + this.nome);
        warrior.sortearVidas();
        this.vidasIniciais = warrior.getQtdVida();
        this.vidasPerdidas = 0;
        InOut.MsgDeInformacao("Introdução", "Sua vida atual é " + warrior.getQtdVida());

    }

    public void prologoPerdedor() {
        InOut.MsgDeInformacao("DERROTA", warrior.getNome() + " Você foi derrotado no duelo!");
        this.warrior.setQtdVida(this.decidirVidaExtra());
        if (this.warrior.getQtdVida() != 0) {
            InOut.MsgDeAviso("SEGUNDA CHANCE", "O Oráculo se compadeceu de você! Você recebe uma segunda chance.");
            palpitesLevel01.clear();
            vidasPerdidas = 0;
        }
    }

    public void prologoVencedor() {
        InOut.MsgDeInformacao("PÁRABENS ", warrior.getNome() + " Ao derrotar o Oráculo, provaste teu valor e és digno de tomar meu lugar como o novo Oráculo Master");
    }

    public boolean loadLevel01() {
        Random random = new Random();
        int segredo = random.nextInt(101);
        this.numeroSecretoLevel01 = segredo;
        boolean acertou = false;
        int vidasAntesLevel = warrior.getQtdVida();
        InOut.MsgDeInformacao("Oráculo", "Um número secreto foi definido (1 a 100), acerte ou perca vida");
        do {
            int palpite = InOut.leInt("Insira seu palpite");
            palpitesLevel01.add(palpite);
            if (palpite > segredo) {
                InOut.MsgDeAviso("Aviso", "Seu palpite é maior que o numero secreto");
                warrior.setQtdVida(warrior.getQtdVida() - 1);
            } else if (palpite < segredo) {
                InOut.MsgDeAviso("Aviso", "Seu palpite é menor que o numero secreto");
                warrior.setQtdVida(warrior.getQtdVida() - 1);
            }
            if (palpite == segredo) {
                acertou = true;
                InOut.MsgDeAviso("Aviso","Você acertou o numero secreto");
                return true;


            }
            if (warrior.getQtdVida() == 0) {
                InOut.MsgDeAviso("Morte", "Morte precoce");
                break;


            }
        } while (!acertou);

        this.vidasPerdidas += (vidasAntesLevel - warrior.getQtdVida());
        return false;
    }

    public boolean loadLevel02() {
        String charada1 = "nuvem";
        String charada2 = "buraco";
        String charada3 = "pente";
        InOut.MsgDeInformacao("Charada", warrior.getNome() + " Agora você ira tentar advinhar uma charada");
        String resposta1 = "";
        String resposta2 = "";
        String resposta3 = "";
        int vidasAntesLevel = warrior.getQtdVida();

        while (!(charada1.equals(resposta1))) {
            resposta1 = InOut.leString("O que é o que é, anda sem pernas e chora sem olhos?");
            if (charada1.equals(resposta1)) {
                InOut.MsgDeInformacao("Charada", "Parabens você acertou a primeira charada");
            } else {
                InOut.MsgDeAviso("Charada", "Errou");
                warrior.setQtdVida(warrior.getQtdVida() - 1);
            }
        }
        respostasLevel02.add(resposta1);
        respostasCorretasLevel02.add(charada1);

        while (!(charada2.equals(resposta2))) {
            resposta2 = InOut.leString("O que é, o que é: quanto mais você tira, maior ele fica?");
            if (charada2.equals(resposta2)) {
                InOut.MsgDeInformacao("Charada", "Parabens você acertou a segunda charada");
            } else {
                InOut.MsgDeAviso("Charada", "Errou");
                warrior.setQtdVida(warrior.getQtdVida() - 1);
            }
        }
        respostasLevel02.add(resposta2);
        respostasCorretasLevel02.add(charada2);

        while (!(charada3.equals(resposta3))) {
            resposta3 = InOut.leString("O que é, o que é: tem dentes, mas não morde?");
            if (charada3.equals(resposta3)) {
                InOut.MsgDeInformacao("Charada", "Parabens você acertou a terceira charada");
            } else {
                InOut.MsgDeAviso("Charada", "Errou");
                warrior.setQtdVida(warrior.getQtdVida() - 1);
            }
        }
        respostasLevel02.add(resposta3);
        respostasCorretasLevel02.add(charada3);

        this.vidasPerdidas += (vidasAntesLevel - warrior.getQtdVida());
        return true;
    }

    public int decidirVidaExtra() {
        try {
            Thread.sleep(200); // Pequeno delay para garantir que a entrada anterior foi processada
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        InOut.MsgDeInformacao("Misericórdia do Oráculo", "Implore pela sua vida com humildade...");
        String misericordia = InOut.leString("IMPLORE POR MAIS UMA CHANCE");
        
        if (misericordia != null && misericordia.length() >= 5) {
            InOut.MsgDeAviso("Aviso", "40 vidas concedidas pelo Oráculo!");
            return 40;
        } else {
            InOut.MsgDeAviso("Aviso", "Sua súplica não foi ouvida...");
            return 0;
        }
    }

    public boolean loadLevel03() {
        String nomeBoss;
        int vidaBoss;
        int danoBoss;
        danoBoss = 37;
        vidaBoss = 30;
        nomeBoss = "Cryptoros, o Oráculo das Respostas Impossíveis";

        InOut.MsgDeAviso("Aviso","Level 03, Boss Fight");

        warrior.imprimirGuerreiro();

        InOut.MsgDeInformacao("BOSS FIGHT", "O boss: Cryptoros, o Oráculo das Respostas Impossíveis ressurgiu\n" + danoBoss + " De dano\n" + vidaBoss + " De vida");
        if (warrior.getQtdVida() < danoBoss) {
            InOut.MsgDeAviso("DERROTA", "Você perdeu para o verdadeiro Oráculo");
            warrior.setQtdVida(0);
            return false;
        } else if (warrior.getQtdVida() == danoBoss && warrior.getDanoWarrior() == vidaBoss) {
            InOut.MsgDeAviso("EMPATE", "Os dois oráculos previram o mesmo fim — e, ao fazê-lo, anularam seus destinos em um empate inevitável.");
            return true;
        } else {
            InOut.MsgDeAviso("VITÓRIA", "Ao transcender todas as previsões, você supera o impossível e ascende como o Oráculo Master, soberano absoluto do destino.");
            return true;
        }
    }

    public String relatorioFimGame() {
        StringBuilder relatorio = new StringBuilder();
        
        relatorio.append("========== RELATÓRIO FINAL DO JOGO ==========\n\n");
        relatorio.append("GUERREIRO: ").append(warrior.getNome()).append("\n");
        relatorio.append("ORÁCULO: ").append(this.nome).append("\n\n");
        
        relatorio.append("--- ESTATÍSTICAS GERAIS ---\n");
        relatorio.append("Vidas Iniciais: ").append(this.vidasIniciais).append("\n");
        relatorio.append("Vidas Finais: ").append(warrior.getQtdVida()).append("\n");
        relatorio.append("Vidas Perdidas: ").append(this.vidasPerdidas).append("\n");
        relatorio.append("Dano Total: ").append(warrior.getDanoWarrior()).append("\n\n");
        
        relatorio.append("--- LEVEL 01: ADIVINHAÇÃO ---\n");
        if (!palpitesLevel01.isEmpty()) {
            relatorio.append("Número Secreto: ").append(this.numeroSecretoLevel01).append("\n");
            relatorio.append("Palpites Dados: ");
            for (int i = 0; i < palpitesLevel01.size(); i++) {
                if (i > 0) relatorio.append(", ");
                relatorio.append(palpitesLevel01.get(i));
            }
            relatorio.append("\n");
            relatorio.append("Total de Tentativas: ").append(palpitesLevel01.size()).append("\n\n");
        } else {
            relatorio.append("Não foi realizado\n\n");
        }
        
        relatorio.append("--- LEVEL 02: CHARADAS ---\n");
        if (!respostasLevel02.isEmpty()) {
            relatorio.append("Charada 1:\n");
            relatorio.append("  Resposta Dada: ").append(respostasLevel02.size() > 0 ? respostasLevel02.get(0) : "N/A").append("\n");
            relatorio.append("  Resposta Correta: ").append(respostasCorretasLevel02.size() > 0 ? respostasCorretasLevel02.get(0) : "N/A").append("\n\n");
            
            relatorio.append("Charada 2:\n");
            relatorio.append("  Resposta Dada: ").append(respostasLevel02.size() > 1 ? respostasLevel02.get(1) : "N/A").append("\n");
            relatorio.append("  Resposta Correta: ").append(respostasCorretasLevel02.size() > 1 ? respostasCorretasLevel02.get(1) : "N/A").append("\n\n");
            
            relatorio.append("Charada 3:\n");
            relatorio.append("  Resposta Dada: ").append(respostasLevel02.size() > 2 ? respostasLevel02.get(2) : "N/A").append("\n");
            relatorio.append("  Resposta Correta: ").append(respostasCorretasLevel02.size() > 2 ? respostasCorretasLevel02.get(2) : "N/A").append("\n\n");
        } else {
            relatorio.append("Não foi realizado\n\n");
        }
        
        relatorio.append("==========================================\n");
        
        String relatorioString = relatorio.toString();
        InOut.MsgDeInformacao("RELATÓRIO FINAL", relatorioString);
        return relatorioString;
    }

    public void setwarrior(Guerreiro warrior) {
        this.warrior = warrior;
    }
}

