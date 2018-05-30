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
     * Является ли элемент "новым", не прошедшим каталогизацию.
     *
     * @param element проверяемый элемент
     * @return {@code true} если ещё не каталогизировался.
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

    /**
     * Добавляет элемент в категорию
     *
     * @param element элемент
     * @param category категория
     * @return {@code false} если список категорий элемента не был изменен
     */
    boolean addCategory(Element element, Category category);

    /**
     * Убирает элемент из категории.
     *
     * @param element элемент
     * @param category категория
     * @return {@code false} если список категорий элемента не был изменен
     */
    boolean removeCategory(Element element, Category category);
}
