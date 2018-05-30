package com.wozimer.cataloger.model;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * Классифицируемый элемент.
 * <p>
 * Класс отражает известные свойства некого объекта, который  подлежит классификации.
 * Имя и путь получаются из внешних источников.
 * Категории присваиваются пользователем.
 */
public class Element {

    // пока разбираем только файлы - это и индентификатор, и путь, и имя по умолчанию
    private final File file;
    // подгружаемые дети
    private List<Element> children;
    // признак конечности элемента
    private boolean leafIsSet;
    private boolean leaf;
    // признак незаконченной каталогизации
    private boolean isNew;
    private boolean isNewSet;
    // отображаемое имя элемента
    private String displayName;
    // присвоенные категории
    private Set<Category> categories;

    Element(File file) {
        assert file != null;
        this.file = file;
    }

    File getFile() {
        return file;
    }

    List<Element> getChildren() {
        return children;
    }

    void setChildren(List<Element> children) {
        this.children = children;
    }

    boolean isLeafSet() {
        return leafIsSet;
    }

    boolean getLeaf() {
        return leaf;
    }

    void setLeaf(boolean leaf) {
        this.leaf = leaf;
        leafIsSet = true;
    }

    String getDisplayName() {
        return displayName;
    }

    void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    boolean newIsSet() {
        return isNewSet;
    }

    boolean isNew() {
        return isNew;
    }

    public void setNew(boolean value) {
        this.isNew = value;
        isNewSet = true;
    }

    Set<Category> getCategories() {
        return categories;
    }

    void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

}
