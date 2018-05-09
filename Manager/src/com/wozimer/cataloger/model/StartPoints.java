package com.wozimer.cataloger.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Модель данных набора начальных точек для анализа.
 * <p>
 * Начальная точка - это каталог, содержимое которого мы рекурсивно разбираем.
 * Пока анализ ведется только в локальной файловой системе, поэтому начальная точка задается указанием каталога.
 */
public class StartPoints {

    // список начальных точек
    private final List<StartPoint> list = new ArrayList<>();

    /**
     * Колчество начальных точек
     *
     * @return количество
     */
    public int count() {
        return list.size();
    }

    /**
     * Опичание начальной точки по индексу
     *
     * @param index индекс
     * @return описанме начальной точки
     */
    public StartPoint get(int index) {
        return list.get(index);
    }

    public void add(File start, String description) {
        list.add(new StartPoint(start, description));
    }

}
