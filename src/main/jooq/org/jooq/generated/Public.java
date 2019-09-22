/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.generated.tables.CatalogItem;
import org.jooq.generated.tables.FlywaySchemaHistory;
import org.jooq.generated.tables.Movie;
import org.jooq.generated.tables.Rating;
import org.jooq.generated.tables.TestData;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 193850754;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.catalog_item</code>.
     */
    public final CatalogItem CATALOG_ITEM = org.jooq.generated.tables.CatalogItem.CATALOG_ITEM;

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    public final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = org.jooq.generated.tables.FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>public.movie</code>.
     */
    public final Movie MOVIE = org.jooq.generated.tables.Movie.MOVIE;

    /**
     * The table <code>public.rating</code>.
     */
    public final Rating RATING = org.jooq.generated.tables.Rating.RATING;

    /**
     * The table <code>public.test_data</code>.
     */
    public final TestData TEST_DATA = org.jooq.generated.tables.TestData.TEST_DATA;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            CatalogItem.CATALOG_ITEM,
            FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY,
            Movie.MOVIE,
            Rating.RATING,
            TestData.TEST_DATA);
    }
}