package mx.edu.utng.primaria.model;

/**
 * Created by Husky Siberiano on 03/02/2017.
 */
public class Activities {
    private int imageId;
    private String nombre;
    private String descripcion;
    private int cardColor;

    public Activities(int imageId, String nombre, String descripcion, int cardColor) {
        this.imageId = imageId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cardColor = cardColor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getCardColor() {
        return cardColor;
    }

    public void setCardColor(int cardColor) {
        this.cardColor = cardColor;
    }
}
