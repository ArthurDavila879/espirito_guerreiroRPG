package domain;

import java.util.Random;

public class Guerreiro {
    private String nome;
    private int qtdVida;
    private Bolsa myBolsa;


    public Guerreiro(){}
    public Guerreiro(String nome, int qtdVida, Bolsa myBolsa) {
        this.nome = nome;
        this.qtdVida = qtdVida;
        this.myBolsa = myBolsa;
    }
    
    public void ganharItem(boolean levelUp){
        Random random = new Random();
        Item item = new Item();
        item.criarItem();
        int itemAdquirido = random.nextInt(21)+1;
        for(Item i : item.getItensTotal()){
            if(i.getIdItem()==itemAdquirido){
                myBolsa.getItens().add(i);
                i.imprimirDados();
                char escolha = InOut.leChar("Deseja equipar o item? (S/N)");
                if (escolha == 'S'){
                    myBolsa.equipar(itemAdquirido);
                }
            }

        }
    
    }

    public int sortearVidas(){
        Random random = new Random();
        this.qtdVida = random.nextInt(4) + 9;
        return this.qtdVida;
    }

    public String vidaExtra() {
        InOut.MsgDeInformacao("Implore pela sua vida","O oraculo pode te conceder mais uma vida ");
        Random random = new Random();
        int escolha = random.nextInt(2);
        if (escolha == 0)return "Sem vida extra";
        if (escolha == 1)return "Vida extra";

        return "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdVida() {
        return qtdVida;
    }

    public void setQtdVida(int qtdVida) {
        this.qtdVida = qtdVida;
    }

    public Bolsa getMyBolsa() {
        return myBolsa;
    }

    public void setMyBolsa(Bolsa myBolsa) {
        this.myBolsa = myBolsa;
    }
}
