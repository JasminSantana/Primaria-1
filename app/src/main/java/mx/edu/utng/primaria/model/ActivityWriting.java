package mx.edu.utng.primaria.model;

/**
 * Created by Husky Siberiano on 24/02/2017.
 */

public class ActivityWriting {
    private int imageId;
    private String title;
    private String color;
    private String writingColor;
    private int cardColor;

    public ActivityWriting(int imageId,String title, String color, String writingColor, int cardColor) {
        this.imageId = imageId;
        this.title = title;
        this.color = color;
        this.writingColor = writingColor;
        this.cardColor = cardColor;
    }

    public ActivityWriting() {
        this(0, "","" , "", 0);
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWritingColor() {
        return writingColor;
    }

    public void setWritingColor(String writingColor) {
        this.writingColor = writingColor;
    }

    public int getCardColor() {
        return cardColor;
    }

    public void setCardColor(int cardColor) {
        this.cardColor = cardColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ActivityWriting{" +
                "imageId=" + imageId +
                ", title='" + title + '\'' +
                ", color='" + color + '\'' +
                ", writingColor='" + writingColor + '\'' +
                ", cardColor=" + cardColor +
                '}';
    }
}
