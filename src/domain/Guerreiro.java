package domain;

import java.util.Random;

public class Guerreiro {
    private String nome;
    private int qtdVida;
    private Bolsa myBolsa;
    private int danoWarrior;


    public Guerreiro(){}
    public Guerreiro(String nome, int qtdVida, Bolsa myBolsa) {
        this.nome = nome;
        this.qtdVida = qtdVida;
        this.myBolsa = myBolsa;
    }

    public int getDanoWarrior(){
        return this.danoWarrior;
    }
    
    public void ganharItem(){
        Random random = new Random();
        Item item = new Item();
        item.criarItem();
        int itemAdquirido = random.nextInt(20)+1;
        for(Item i : item.getItensTotal()){
            if(i.getIdItem()==itemAdquirido){
                myBolsa.getItens().add(i);
                i.imprimirDados();
                char escolha = InOut.leChar("Deseja equipar o item? (S/N)");
                if (Character.toUpperCase(escolha) == 'S'){
                    myBolsa.equipar(itemAdquirido);
                    if (i.getTipoitem().equals("Armadura")){
                        this.qtdVida += i.getAtributovida();
                    }
                    if (i.getTipoitem().equals("Arma")){
                        this.danoWarrior += i.getAtributodano();
                    }
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
        InOut.MsgDeInformacao("Implore pela sua vida", "O oraculo pode te conceder mais uma vida ");
        String misericordia = InOut.leString("IMPLORE POR MAIS UMA CHANCE");
        return misericordia;
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
