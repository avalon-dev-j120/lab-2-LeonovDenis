package ru.avalon.java.j20.labs.models;

import java.text.ParseException;
import java.util.Objects;

/**
 * Модель представления о стране.
 */
public class Country {

    /**
     * Код страны.
     */
    private final String code;
    /**
     * Название страны.
     */
    private final String name;

    /**
     * Основное конструктор класса.
     *
     * @param code код страны
     * @param name название страны
     */
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Возвращает код страны.
     *
     * @return строковый код страны
     */
    public String getCode() {
        return code;
    }

    /**
     * Возвращает название страны.
     *
     * @return название страны
     */
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.code);
        hash = 71 * hash + Objects.hashCode(this.name);
        return hash;
        /*
         * TODO(Студент): Реализовать метод valueOf класса Country
         */

    }

    /*
     * TODO(Студент): для класса Country переопределить методы equals и hashCode
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Country other = (Country) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    /**
     * Возвращает экземпляр страны созданный из переданного текста в формате
     * 'Код:Название'.
     *
     * @param text тектс в формате 'Код:Название'
     * @return новый экземпляр типа {@Link Country}.
     * @throws ParseException в случае, если переданная строка имеет неверный
     * формат.
     */
    public static Country valueOf(String text) throws ParseException {
        /*
         * TODO(Студент): Реализовать метод valueOf класса Country
         */
        if (text.indexOf(':') == -1) {
            throw new ParseException("There is no delimiter", 0);
        }
        String[] res = text.split(":");

        if (res[0] == null || res[1] == null) {
            throw new ParseException("Wrong format :" 
                    + res[0]+ ":" + res[1], 1);
        } else {
            return new Country(res[0], res[1]);
        }
    }
}
