package com.wozimer.cataloger.model;

import com.sun.istack.internal.NotNull;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.io.File;
import java.util.*;

/**
 * Модель элементов в файловой системе.
 */
public class FileTreeElements implements TreeModel, Elements {

    // каталог, от которого идет категоризация
    @NotNull
    private final File rootDir;
    // база для хранения сведений о категорий
    @NotNull
    private final CatalogDatabase database;

    // кэш элементов
    private final Map<File, Element> elements = new HashMap<>();

    public FileTreeElements(@NotNull File rootDir, @NotNull CatalogDatabase database) {
        assert rootDir != null;
        assert database != null;
        this.rootDir = rootDir;
        this.database = database;
    }

    @Override
    public Object getRoot() {
        return getElement(rootDir);
    }

    @Override
    public int getChildCount(Object parent) {
        Element element = (Element) parent;
        List<Element> children = element.getChildren();
        if (children == null) {
            children = loadChildren(element);
        }
        return children.size();
    }

    @Override
    public Object getChild(Object parent, int index) {
        Element element = (Element) parent;
        List<Element> children = element.getChildren();
        if (children == null) {
            children = loadChildren(element);
        }
        return children.get(index);
    }

    @Override
    public boolean isLeaf(Object node) {
        Element element = (Element) node;
        if (!element.isLeafSet()) {
            loadChildren(element);
        }
        return element.getLeaf();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        Element element = (Element) parent;
        List<Element> children = element.getChildren();
        if (children == null) {
            children = loadChildren(element);
        }
        return children.indexOf(child);
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {

    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {

    }

    @Override
    public String displayName(Element element) {
        String displayName = element.getDisplayName();
        if (displayName == null) {
            displayName = database.loadName(element);
            if (displayName == null)
                displayName = element.getFile().getName();
        }
        return displayName;
    }

    @Override
    public boolean isNew(Element element) {
        if (!element.newIsSet()) {
            database.loadIsNew(element);
        }
        return element.isNew();
    }

    @Override
    public Set<Category> getCategories(Element element) {
        Set<Category> categories = element.getCategories();
        if (categories == null) {
            categories = database.loadCategories(element);
        }
        return categories;
    }

    @Override
    public Set<Category> getAvailableCategories(Element element) {
        return database.loadAvailableCategories(element);
    }

    @Override
    public boolean addCategory(Element element, Category category) {
        Set<Category> categories = element.getCategories();
        if (categories == null) {
            categories = database.loadCategories(element);
        }
        return categories.add(category);
    }

    @Override
    public boolean removeCategory(Element element, Category category) {
        Set<Category> categories = element.getCategories();
        if (categories == null) {
            categories = database.loadCategories(element);
        }
        return categories.remove(category);
    }

    /**
     * Возвращает элемент для файла или каталога.
     *
     * Созданные элементы кешируются.
     * Гарантируется возврат того же элемента из нескольких вызовов для одного файла.
     *
     * @param file файл/каталог
     * @return элемент
     */
    @NotNull
    private Element getElement(@NotNull File file) {
        assert file != null;
        assert file.getAbsolutePath().startsWith(rootDir.getAbsolutePath());
        Element element = elements.get(file);
        if (element == null) {
            element = new Element(file);
            elements.put(file, element);
        }
        return element;
    }

    /**
     * Подгружает список детей для элемента.
     *
     * @param element заполняемый элемент
     * @return список детей элемента
     */
    @NotNull
    private List<Element> loadChildren(@NotNull Element element) {
        assert element != null;
        List<Element> children;
        children = new ArrayList<>();
        File[] files = element.getFile().listFiles();
        if (files == null) {
            element.setLeaf(true);
        } else {
            element.setLeaf(false);
            for (File file : files) {
                children.add(getElement(file));
            }
        }
        element.setChildren(children);
        return children;
    }
}
