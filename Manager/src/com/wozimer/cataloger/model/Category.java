package com.wozimer.cataloger.model;

/**
 * Категория элемента.
 * <p>
 * Категория - это именованный ярлык каталогизируемых элементов.
 * В дальнейшем с категориями могут быть ассоциированы дополнительные атрибуты, возможно специфичные для начальных точек.
 */
public class Category {

    private String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
