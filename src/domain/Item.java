package domain;

public class Item {
    private int idItem;
    private String tipoitem;
    private boolean equipado;

    public Item(){}

    public Item(int idItem, String tipoitem, boolean equipado) {
        this.idItem = idItem;
        this.tipoitem = tipoitem;
        this.equipado = equipado;
    }
    public void imprimirDados(){
        System.out.println("ID item: "+this.idItem);
        System.out.println("Tipo de item: "+this.tipoitem);
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
}
