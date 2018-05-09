package com.wozimer.cataloger.model;

import java.util.Set;

public interface CatalogDatabase {
    String loadName(Element element);

    boolean loadIsNew(Element element);

    Set<Category> loadCategories(Element element);

    Set<Category> loadAvailableCategories(Element element);
}
