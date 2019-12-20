package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Задание №5
 *
 * <p>
 * Тема: "Потоковый ввод-вывод. Чтение локализованных ресурсов".
 */
public class Task5 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {

        String path = "resources/strings/titles";
        Locale locale = new Locale("en");

        ResourceBundle def_bundle = read(path);

        ResourceBundle en_bundle = read(path, locale);

        /**
         * Блок проверки правильности работы задания
         */
        System.out.println("Проверка значения ключа\"menu.edit\""
                + "в локализации по умолчанию: ");

        getKey(def_bundle, "menu.edit");

        System.out.println("Проверка значения ключа\"menu.edit\""
                + "в локализации языка EN: ");

        getKey(en_bundle, "menu.edit");

        /*
         * TODO(Студент): Выполнить задание №5
         *
         * 1. Реализовать метод read.
         *
         * 2. Прочитать ресурсы с использованием локализации по умолчанию.
         *
         * 3. Прочитать ресурсы с использованием локализации, отличной от той,
         *    которая задана по умолчанию.
         *
         * 4. С использованием отладчика сравнить полученные ресурсы и
         *    проверить корректность работы программы.
         */
    }

    /**
     * Выполняет чтение локализованных ресурсов с использованием локализации по
     * умолчанию.
     *
     * @param path путь к файлу ресурсов
     * @return новый экземпляр типа {@link ResourceBundle}
     */
    private ResourceBundle read(String path) {

        return ResourceBundle.getBundle(path);

    }

    /**
     * Выполняет чтение локализованных ресурсов.
     *
     * @param path путь к файлу ресурсов
     * @return новый экземпляр типа {@link ResourceBundle}
     */
    private ResourceBundle read(String path, Locale locale) {
        return ResourceBundle.getBundle(path, locale);
    }

    /**
     * Проверка ключа свойств локализации
     *
     * @param r_bundle свойства локализации
     * @param Key ключ параметра
     */
    private void getKey(ResourceBundle bundle, String Key) {

        String st = bundle.getString(Key);
        String s = "";
        try {
            s = new String(st.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.err.println("Problems with code");
        }

        System.out.println(s);
    }
}
