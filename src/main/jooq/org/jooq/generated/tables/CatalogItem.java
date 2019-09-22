/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.generated.Keys;
import org.jooq.generated.Public;
import org.jooq.generated.tables.records.CatalogItemRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class CatalogItem extends TableImpl<CatalogItemRecord> {

    private static final long serialVersionUID = -1474945518;

    /**
     * The reference instance of <code>public.catalog_item</code>
     */
    public static final CatalogItem CATALOG_ITEM = new CatalogItem();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CatalogItemRecord> getRecordType() {
        return CatalogItemRecord.class;
    }

    /**
     * The column <code>public.catalog_item.movie_id</code>.
     */
    public final TableField<CatalogItemRecord, Integer> MOVIE_ID = createField(DSL.name("movie_id"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.catalog_item.name</code>.
     */
    public final TableField<CatalogItemRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(25), this, "");

    /**
     * The column <code>public.catalog_item.description</code>.
     */
    public final TableField<CatalogItemRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.VARCHAR(25), this, "");

    /**
     * The column <code>public.catalog_item.rating</code>.
     */
    public final TableField<CatalogItemRecord, Integer> RATING = createField(DSL.name("rating"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>public.catalog_item</code> table reference
     */
    public CatalogItem() {
        this(DSL.name("catalog_item"), null);
    }

    /**
     * Create an aliased <code>public.catalog_item</code> table reference
     */
    public CatalogItem(String alias) {
        this(DSL.name(alias), CATALOG_ITEM);
    }

    /**
     * Create an aliased <code>public.catalog_item</code> table reference
     */
    public CatalogItem(Name alias) {
        this(alias, CATALOG_ITEM);
    }

    private CatalogItem(Name alias, Table<CatalogItemRecord> aliased) {
        this(alias, aliased, null);
    }

    private CatalogItem(Name alias, Table<CatalogItemRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> CatalogItem(Table<O> child, ForeignKey<O, CatalogItemRecord> key) {
        super(child, key, CATALOG_ITEM);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<ForeignKey<CatalogItemRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CatalogItemRecord, ?>>asList(Keys.CATALOG_ITEM__CATALOG_ITEM_MOVIE_ID_FKEY);
    }

    public Movie movie() {
        return new Movie(this, Keys.CATALOG_ITEM__CATALOG_ITEM_MOVIE_ID_FKEY);
    }

    @Override
    public CatalogItem as(String alias) {
        return new CatalogItem(DSL.name(alias), this);
    }

    @Override
    public CatalogItem as(Name alias) {
        return new CatalogItem(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CatalogItem rename(String name) {
        return new CatalogItem(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CatalogItem rename(Name name) {
        return new CatalogItem(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
