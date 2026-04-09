package domain;

import java.util.List;

public class Item {
    private int idItem;
    private String tipoitem;
    private boolean equipado;
    private String nomeitem;
    private int atributodano;
    private int atributovida;
    
    private List<Item> listafds;    
    
    public Item(){}

    public Item(int idItem, String nomeitem, String tipoitem, boolean equipado, int atributodano, int atributovida) {
        this.idItem = idItem;
        this.nomeitem = nomeitem;
        this.tipoitem = tipoitem;
        this.equipado = equipado;
        this.atributodano = atributodano;
        this.atributovida = atributovida;
    }
    public void imprimirDados(){
        System.out.println("ID item: "+this.idItem);
        System.out.println("Nome do item: "+this.nomeitem);
        System.out.println("Tipo de item: "+this.tipoitem);
        System.out.println("Atributos de item: " + this.atributodano + " de dano, " + this.atributovida + " de vida");
       if (this.equipado){
           System.out.println("Item equipado");
       }
       else System.out.println("Item desequipado");
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getTipoitem() {
        return tipoitem;
    }
    
    public void setTipoitem(String tipoitem) {
        this.tipoitem = tipoitem;
    }

    public boolean isEquipado() {
        return equipado;
    }

    public void setEquipado(boolean equipado) {
        this.equipado = equipado;
    }
    
    public void criarItem(){
        Item item1 = new Item(1, "Lâmina do Eclipse", "Espada", false, 25, 0);
        Item item2 = new Item(2, "Arco da Aurora Silenciosa", "Arco", false, 30, 0);
        Item item3 = new Item(3, "Armadura do Titã Ancestral", "Armadura", false, 0, 65);
        Item item4 = new Item(4, "Adaga do Vento Cortante", "Adaga", false, 30, 0);
        Item item5 = new Item(5, "Martelo do Trovão Eterno", "Martelo", false, 35, 0);
        Item item6 = new Item(6, "Katana da Mente Clara", "Espada", false, 35, 0);
        Item item7 = new Item(7, "Botas do Passo Sombrio", "Armadura", false, 0, 30);
        Item item8 = new Item(8, "Cajado da Chama Viva", "Cajado", false, 37, 0);
        Item item9 = new Item(9, "Escudo do Guardião Imortal", "Armadura", false, 0, 55);
        Item item10 = new Item(10, "Anel da Fortuna Arcana", "Armadura", false, 0, 18);
        Item item11 = new Item(11, "Peitoral do Dragão Carmesim", "Armadura", false, 0, 50);
        Item item12 = new Item(12, "Lança da Tempestade Azul", "Lança", false, 30, 0);
        Item item13 = new Item(13, "Luvas do Punho de Ferro", "Armadura", false, 0, 20);
        Item item14 = new Item(14, "Colar da Alma Vital", "Armadura", false, 0, 30);
        Item item15 = new Item(15, "Capa do Andarilho Dimensional", "Armadura", false, 0, 35);
        Item item16 = new Item(16, "Foice do Ceifador Sombrio", "Foice", false, 30, 0);
        Item item17 = new Item(17, "Bracelete da Energia Pulsante", "Armadura", false, 0, 25);
        Item item18 = new Item(18, "Espada Curta do Guerreiro Solar", "Espada", false, 24, 0);
        Item item19 = new Item(19, "Calças do Caçador Ágil", "Armadura", false, 0, 28);
        Item item67 = new Item(20, "Katana da Aura 67", "ERROR505: AURA", false, 67, 67);
                                                                
                    
    }
}
