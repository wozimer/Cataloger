package com.wozimer.cataloger.model;

import com.sun.istack.internal.NotNull;

import java.io.File;

/**
 * Начальная точка категоризации.
 * <p>
 * Простоеописание места с которого проводится каталогизация.
 */
public class StartPoint {

    // с какого каталога начинаем
    @NotNull
    private File start;
    // как показываем пользователю
    private String description;

    public StartPoint(File start, String description) {
        assert start != null;
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
