package domain;

import java.util.List;

public class Bolsa {
    private List<Item> itens;

    public Bolsa(List<Item> itens) {
        this.itens = itens;
    }

    public void equipar(int idItem) {
        for (Item i : itens) {
            if (idItem == i.getIdItem()) {
                i.setEquipado(true);
            }
        }
    }

    public List<Item> getItens() {
        return itens;
    }
    

    public void desequipar(int idItem) {
        for (Item i : itens) {
            if (idItem == i.getIdItem()) {
                i.setEquipado(false);
            }
        }
    }
}
