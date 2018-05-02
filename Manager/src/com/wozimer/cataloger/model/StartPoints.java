package com.wozimer.cataloger.model;

import com.sun.istack.internal.NotNull;

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

    /**
     * Описание начальной точки.
     */
    public class StartPoint {

        // с какого каталога начинаем
        @NotNull
        private File start;
        // как показываем пользователю
        private String description;

        public StartPoint(File start, String description) {
            if (start == null) throw new NullPointerException("No start point");
            this.start = start;
            this.description = description;
        }

        /**
         * Начальный каталог
         *
         * @return каталог
         */
        @NotNull
        public File getStart() {
            return start;
        }

        /**
         * Описание точки.
         *
         * @return описание
         */
        public String getDescription() {
            return description;
        }

        /**
         * Описание для отображения в интерфейсах.
         * <p>
         * Если описание не задано, то берется имя поседнего каталога в пути.
         *
         * @return строку
         */
        @NotNull
        public String getHumanDescription() {
            String desc = description;
            if (desc != null && !desc.isEmpty())
                return desc;

            return start.getName();
        }
    }
}
