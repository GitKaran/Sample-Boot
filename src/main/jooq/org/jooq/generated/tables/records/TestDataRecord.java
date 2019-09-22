/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row1;
import org.jooq.generated.tables.TestData;
import org.jooq.impl.UpdatableRecordImpl;


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
public class TestDataRecord extends UpdatableRecordImpl<TestDataRecord> implements Record1<String> {

    private static final long serialVersionUID = -742233564;

    /**
     * Setter for <code>public.test_data.value</code>.
     */
    public void setValue(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.test_data.value</code>.
     */
    public String getValue() {
        return (String) get(0);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record1 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row1<String> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    @Override
    public Row1<String> valuesRow() {
        return (Row1) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return TestData.TEST_DATA.VALUE;
    }

    @Override
    public String component1() {
        return getValue();
    }

    @Override
    public String value1() {
        return getValue();
    }

    @Override
    public TestDataRecord value1(String value) {
        setValue(value);
        return this;
    }

    @Override
    public TestDataRecord values(String value1) {
        value1(value1);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TestDataRecord
     */
    public TestDataRecord() {
        super(TestData.TEST_DATA);
    }

    /**
     * Create a detached, initialised TestDataRecord
     */
    public TestDataRecord(String value) {
        super(TestData.TEST_DATA);

        set(0, value);
    }
}