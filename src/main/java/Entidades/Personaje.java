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


    /**
     *
     * @param tipoEquipamiento
     * @param item
     */
    public void agregarEquipo(TipoEquipamiento tipoEquipamiento, Item item) {
        //No vamos a comprobar que el item esté en el inventario

        // 1.Verificar que el item no este ya en el equipo
        if(equipo.containsKey(tipoEquipamiento)) {
            //Mover el item al inventario
            Item antiguo = equipo.get(tipoEquipamiento);
            inventario.put(antiguo.getNombre(), antiguo);

        }
        //Poner el nuevo item
        equipo.put(tipoEquipamiento, item);
        //Eliminar el nuevo item del inventario
        inventario.remove(item.getNombre());
    }


    /**
     * Elimina un item del equipo del personaje, lo devolvemos al inventario
     * @param tipoEquipamiento
     */
    public void quitarEquipo(TipoEquipamiento tipoEquipamiento) {
        Item item = equipo.get(tipoEquipamiento);
        equipo.remove(tipoEquipamiento);
        inventario.put(item.getNombre(), item);
    }


    /**
     * Devuelve una lista con todos los item del equipo del personaje
     * @return Map.Entry<TipoEquipamiento, Item>
     */
    public List<Map.Entry<TipoEquipamiento, Item>> getEquipo() {
        return new ArrayList<>(equipo.entrySet());
    }

}



