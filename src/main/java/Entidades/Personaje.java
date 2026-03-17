package Entidades;

import lombok.Getter;

import java.util.*;

@Getter
public class Personaje {

    private String nombre;
    private Map<String, Item> inventario;
    private Map<TipoEquipamiento, Item> equipo;

    //Constructor
    public Personaje(String nombre) {
        this.nombre = nombre;
        this.inventario = new HashMap<>();
        this.equipo = new TreeMap<>();
    }


    //Metodos
    /**
     * Agrega un item al inventario del personaje
     * Usamos como clave el nombre del item
     * @param item
     */
    public void agregarItemInventario(Item item) {
        this.inventario.put(item.getNombre(), item);
    }


    /**
     * Elimina un item al inventario del personaje
     * Usamos como clave el nombre del item
     * @param nombreItem
     */
    public void eliminarItemInventario(String nombreItem) {
        this.inventario.remove(nombreItem);
    }


    /**
     * Devuelve una lista con todos los item del inventrio del personaje
     * @return
     */
    public List<Item> getInventario() {
        return new ArrayList<>(this.inventario.values());
    }


    /**
     * Busca un item en el inventario del personaje por su nombre
     * @param nombreItem
     * @return item o null si no lo encuentra
     */
    public Item buscarItem(String nombreItem) {
        return this.inventario.get(nombreItem);
    }


}
