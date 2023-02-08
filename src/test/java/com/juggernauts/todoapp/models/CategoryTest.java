package com.juggernauts.todoapp.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//

class CategoryTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Category#Category(String)}
     *   <li>{@link Category#toString()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals("Category{categoryId=0, categoryName='Category Name', user=null, tasks=null}",
                (new Category("Category Name")).toString());
    }
}

