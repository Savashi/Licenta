package ro.cristin.dto;

public interface EdgeDTO {

    String getFrom();
    String getTo();
    Color getColor();
    String getLabel();

    default Font getFont() {
        return new Font();
    }



}
