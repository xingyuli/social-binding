/*
 * This file is generated by jOOQ.
 */
package top.viclau.mn.social.binding.db.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import top.viclau.mn.social.binding.db.DefaultSchema;
import top.viclau.mn.social.binding.db.Indexes;
import top.viclau.mn.social.binding.db.Keys;
import top.viclau.mn.social.binding.db.enums.AccountStatus;
import top.viclau.mn.social.binding.db.enums.AccountType;
import top.viclau.mn.social.binding.db.tables.records.AccountRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Account extends TableImpl<AccountRecord> {

    private static final long serialVersionUID = -363976725;

    /**
     * The reference instance of <code>account</code>
     */
    public static final Account ACCOUNT = new Account();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AccountRecord> getRecordType() {
        return AccountRecord.class;
    }

    /**
     * The column <code>account.id</code>.
     */
    public final TableField<AccountRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>account.type</code>.
     */
    public final TableField<AccountRecord, AccountType> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR(6).nullable(false).asEnumDataType(top.viclau.mn.social.binding.db.enums.AccountType.class), this, "");

    /**
     * The column <code>account.ext_identifier</code>.
     */
    public final TableField<AccountRecord, String> EXT_IDENTIFIER = createField(DSL.name("ext_identifier"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>account.ext_name</code>.
     */
    public final TableField<AccountRecord, String> EXT_NAME = createField(DSL.name("ext_name"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>account.avatar</code>.
     */
    public final TableField<AccountRecord, String> AVATAR = createField(DSL.name("avatar"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>account.status</code>.
     */
    public final TableField<AccountRecord, AccountStatus> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR(12).nullable(false).asEnumDataType(top.viclau.mn.social.binding.db.enums.AccountStatus.class), this, "");

    /**
     * The column <code>account.created_at</code>.
     */
    public final TableField<AccountRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>account.updated_at</code>.
     */
    public final TableField<AccountRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * Create a <code>account</code> table reference
     */
    public Account() {
        this(DSL.name("account"), null);
    }

    /**
     * Create an aliased <code>account</code> table reference
     */
    public Account(String alias) {
        this(DSL.name(alias), ACCOUNT);
    }

    /**
     * Create an aliased <code>account</code> table reference
     */
    public Account(Name alias) {
        this(alias, ACCOUNT);
    }

    private Account(Name alias, Table<AccountRecord> aliased) {
        this(alias, aliased, null);
    }

    private Account(Name alias, Table<AccountRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Account(Table<O> child, ForeignKey<O, AccountRecord> key) {
        super(child, key, ACCOUNT);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ACCOUNT_PRIMARY, Indexes.ACCOUNT_UK_TYPE_EXT_ID);
    }

    @Override
    public Identity<AccountRecord, Long> getIdentity() {
        return Keys.IDENTITY_ACCOUNT;
    }

    @Override
    public UniqueKey<AccountRecord> getPrimaryKey() {
        return Keys.KEY_ACCOUNT_PRIMARY;
    }

    @Override
    public List<UniqueKey<AccountRecord>> getKeys() {
        return Arrays.<UniqueKey<AccountRecord>>asList(Keys.KEY_ACCOUNT_PRIMARY, Keys.KEY_ACCOUNT_UK_TYPE_EXT_ID);
    }

    @Override
    public Account as(String alias) {
        return new Account(DSL.name(alias), this);
    }

    @Override
    public Account as(Name alias) {
        return new Account(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Account rename(String name) {
        return new Account(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Account rename(Name name) {
        return new Account(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, AccountType, String, String, String, AccountStatus, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
