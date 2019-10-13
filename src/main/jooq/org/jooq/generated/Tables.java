/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated;


import javax.annotation.Generated;

import org.jooq.generated.tables.CatalogItem;
import org.jooq.generated.tables.FlywaySchemaHistory;
import org.jooq.generated.tables.Movie;
import org.jooq.generated.tables.Rating;
import org.jooq.generated.tables.TestData;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.catalog_item</code>.
     */
    public static final CatalogItem CATALOG_ITEM = CatalogItem.CATALOG_ITEM;

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    public static final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>public.movie</code>.
     */
    public static final Movie MOVIE = Movie.MOVIE;

    /**
     * The table <code>public.rating</code>.
     */
    public static final Rating RATING = Rating.RATING;

    /**
     * The table <code>public.test_data</code>.
     */
    public static final TestData TEST_DATA = TestData.TEST_DATA;
}
