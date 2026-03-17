package App;

import Entidades.Item;
import Entidades.Personaje;
import Entidades.TIpoItem;
import Entidades.TipoEquipamiento;

import java.util.Map;

public class Main {

    static void main() {

        Personaje personaje = new Personaje("Rnadolf");
        personaje.agregarItemInventario(new Item("Espada", "Espada de Lord Capon", 10,
                TIpoItem.ARMA));

        personaje.agregarItemInventario(new Item("Capa Blanca", "Capa de mago", 7,
                TIpoItem.ARMADURA));

        personaje.agregarItemInventario(new Item("Vino de la comarca", "Borrachuzo", 1,
                TIpoItem.CONSUMIBLE));

        personaje.agregarItemInventario(new Item("Botas de Acero aleman", "Botas irrompibles", 3,
                TIpoItem.ARMADURA));

        personaje.agregarEquipo(TipoEquipamiento.MANO_PRINCIPAL, personaje.buscarItem("Espada"));
        personaje.agregarEquipo(TipoEquipamiento.PECHO, personaje.buscarItem("Capa Blanca"));
        personaje.agregarEquipo(TipoEquipamiento.PIERNAS, personaje.buscarItem("Botas de Acero aleman"));

        IO.println("---- EQUIPO ----");
        for(Map.Entry<TipoEquipamiento, Item> entry : personaje.getEquipo()) {
            IO.println(entry.getKey() + ": " + entry.getValue());
        }

        IO.println("---- INVENTARIO ----");
        for(Item item : personaje.getInventario()) {
            IO.println(item);
        }

    }
}
