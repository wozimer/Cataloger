package com.wozimer.cataloger.model;

import java.util.Set;

/**
 * Работа с каталогизируемыми элементами.
 */
public interface Elements {

    /**
     * Отображаемое имя элемента
     *
     * @param element проверяемый элемент
     * @return строка для вывода
     */
    String displayName(Element element);

    /**
     * Является ли элемент "новысм", не прошедшим каталогизацию.
     *
     * @param element проверяемый элемент
     * @return {@code true} если ещё некаталогизировался.
     */
    boolean isNew(Element element);

    /**
     * Список присвоенных элементу категорий.
     *
     * @param element проверяемый элемент
     * @return неизменяемый список
     */
    Set<Category> getCategories(Element element);

    /**
     * Список допустимых категорий для элемента.
     *
     * @param element проверяемый элемент
     * @return неизменяемый список
     */
    Set<Category> getAvailableCategories(Element element);

    boolean addCategory(Element element, Category category);

    boolean removeCategory(Element element, Category category);
}
