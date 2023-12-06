package org.example;

import lombok.Data;

@Data
public class Birgha {
    private String proff;
    private String edication;
    private String placeJob;
    private String doljnost;
    private String reason;
    private String semPog;
    private String uslovie;
    private String coordinat;
    private String treb;

    @Override
    public String toString() {
        return "Безработный:  " +
                " Профессия = " + proff + ';' + '\n' +
                " Образование= " + edication  + ';' + '\n' +
                " Место работы (последнее) = " + placeJob + ';' + '\n' +
                " Должность= " + doljnost + ';' + '\n' +
                " Причина уволнения = " + reason  + ';' + '\n' +
                " Семейное положение = " + semPog  + ';' + '\n' +
                " Жил.условия = " + uslovie  + ';' + '\n' +
                " Контактные координаты = " + coordinat  + ';' + '\n' +
                " Требования к будущей работе= " + treb + '\n';
    }
}
