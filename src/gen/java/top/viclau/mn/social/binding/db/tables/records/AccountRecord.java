/*
 * This file is generated by jOOQ.
 */
package top.viclau.mn.social.binding.db.tables.records;


import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;

import top.viclau.mn.social.binding.db.enums.AccountStatus;
import top.viclau.mn.social.binding.db.enums.AccountType;
import top.viclau.mn.social.binding.db.tables.Account;
import top.viclau.mn.social.binding.db.tables.interfaces.IAccount;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccountRecord extends UpdatableRecordImpl<AccountRecord> implements Record8<Long, AccountType, String, String, String, AccountStatus, LocalDateTime, LocalDateTime>, IAccount {

    private static final long serialVersionUID = -917856366;

    /**
     * Setter for <code>account.id</code>.
     */
    @Override
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>account.id</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>account.type</code>.
     */
    @Override
    public void setType(AccountType value) {
        set(1, value);
    }

    /**
     * Getter for <code>account.type</code>.
     */
    @Override
    public AccountType getType() {
        return (AccountType) get(1);
    }

    /**
     * Setter for <code>account.ext_identifier</code>.
     */
    @Override
    public void setExtIdentifier(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>account.ext_identifier</code>.
     */
    @Override
    public String getExtIdentifier() {
        return (String) get(2);
    }

    /**
     * Setter for <code>account.ext_name</code>.
     */
    @Override
    public void setExtName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>account.ext_name</code>.
     */
    @Override
    public String getExtName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>account.avatar</code>.
     */
    @Override
    public void setAvatar(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>account.avatar</code>.
     */
    @Override
    public String getAvatar() {
        return (String) get(4);
    }

    /**
     * Setter for <code>account.status</code>.
     */
    @Override
    public void setStatus(AccountStatus value) {
        set(5, value);
    }

    /**
     * Getter for <code>account.status</code>.
     */
    @Override
    public AccountStatus getStatus() {
        return (AccountStatus) get(5);
    }

    /**
     * Setter for <code>account.created_at</code>.
     */
    @Override
    public void setCreatedAt(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>account.created_at</code>.
     */
    @Override
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>account.updated_at</code>.
     */
    @Override
    public void setUpdatedAt(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>account.updated_at</code>.
     */
    @Override
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, AccountType, String, String, String, AccountStatus, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<Long, AccountType, String, String, String, AccountStatus, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Account.ACCOUNT.ID;
    }

    @Override
    public Field<AccountType> field2() {
        return Account.ACCOUNT.TYPE;
    }

    @Override
    public Field<String> field3() {
        return Account.ACCOUNT.EXT_IDENTIFIER;
    }

    @Override
    public Field<String> field4() {
        return Account.ACCOUNT.EXT_NAME;
    }

    @Override
    public Field<String> field5() {
        return Account.ACCOUNT.AVATAR;
    }

    @Override
    public Field<AccountStatus> field6() {
        return Account.ACCOUNT.STATUS;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return Account.ACCOUNT.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field8() {
        return Account.ACCOUNT.UPDATED_AT;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public AccountType component2() {
        return getType();
    }

    @Override
    public String component3() {
        return getExtIdentifier();
    }

    @Override
    public String component4() {
        return getExtName();
    }

    @Override
    public String component5() {
        return getAvatar();
    }

    @Override
    public AccountStatus component6() {
        return getStatus();
    }

    @Override
    public LocalDateTime component7() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component8() {
        return getUpdatedAt();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public AccountType value2() {
        return getType();
    }

    @Override
    public String value3() {
        return getExtIdentifier();
    }

    @Override
    public String value4() {
        return getExtName();
    }

    @Override
    public String value5() {
        return getAvatar();
    }

    @Override
    public AccountStatus value6() {
        return getStatus();
    }

    @Override
    public LocalDateTime value7() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value8() {
        return getUpdatedAt();
    }

    @Override
    public AccountRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public AccountRecord value2(AccountType value) {
        setType(value);
        return this;
    }

    @Override
    public AccountRecord value3(String value) {
        setExtIdentifier(value);
        return this;
    }

    @Override
    public AccountRecord value4(String value) {
        setExtName(value);
        return this;
    }

    @Override
    public AccountRecord value5(String value) {
        setAvatar(value);
        return this;
    }

    @Override
    public AccountRecord value6(AccountStatus value) {
        setStatus(value);
        return this;
    }

    @Override
    public AccountRecord value7(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public AccountRecord value8(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public AccountRecord values(Long value1, AccountType value2, String value3, String value4, String value5, AccountStatus value6, LocalDateTime value7, LocalDateTime value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IAccount from) {
        setId(from.getId());
        setType(from.getType());
        setExtIdentifier(from.getExtIdentifier());
        setExtName(from.getExtName());
        setAvatar(from.getAvatar());
        setStatus(from.getStatus());
        setCreatedAt(from.getCreatedAt());
        setUpdatedAt(from.getUpdatedAt());
    }

    @Override
    public <E extends IAccount> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AccountRecord
     */
    public AccountRecord() {
        super(Account.ACCOUNT);
    }

    /**
     * Create a detached, initialised AccountRecord
     */
    public AccountRecord(Long id, AccountType type, String extIdentifier, String extName, String avatar, AccountStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(Account.ACCOUNT);

        set(0, id);
        set(1, type);
        set(2, extIdentifier);
        set(3, extName);
        set(4, avatar);
        set(5, status);
        set(6, createdAt);
        set(7, updatedAt);
    }
}
