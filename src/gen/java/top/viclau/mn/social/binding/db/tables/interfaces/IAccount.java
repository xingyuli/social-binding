/*
 * This file is generated by jOOQ.
 */
package top.viclau.mn.social.binding.db.tables.interfaces;


import java.io.Serializable;
import java.time.LocalDateTime;

import top.viclau.mn.social.binding.db.enums.AccountStatus;
import top.viclau.mn.social.binding.db.enums.AccountType;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IAccount extends Serializable {

    /**
     * Setter for <code>account.id</code>.
     */
    public void setId(Long value);

    /**
     * Getter for <code>account.id</code>.
     */
    public Long getId();

    /**
     * Setter for <code>account.type</code>.
     */
    public void setType(AccountType value);

    /**
     * Getter for <code>account.type</code>.
     */
    public AccountType getType();

    /**
     * Setter for <code>account.ext_identifier</code>.
     */
    public void setExtIdentifier(String value);

    /**
     * Getter for <code>account.ext_identifier</code>.
     */
    public String getExtIdentifier();

    /**
     * Setter for <code>account.ext_name</code>.
     */
    public void setExtName(String value);

    /**
     * Getter for <code>account.ext_name</code>.
     */
    public String getExtName();

    /**
     * Setter for <code>account.avatar</code>.
     */
    public void setAvatar(String value);

    /**
     * Getter for <code>account.avatar</code>.
     */
    public String getAvatar();

    /**
     * Setter for <code>account.status</code>.
     */
    public void setStatus(AccountStatus value);

    /**
     * Getter for <code>account.status</code>.
     */
    public AccountStatus getStatus();

    /**
     * Setter for <code>account.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value);

    /**
     * Getter for <code>account.created_at</code>.
     */
    public LocalDateTime getCreatedAt();

    /**
     * Setter for <code>account.updated_at</code>.
     */
    public void setUpdatedAt(LocalDateTime value);

    /**
     * Getter for <code>account.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IAccount
     */
    public void from(top.viclau.mn.social.binding.db.tables.interfaces.IAccount from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IAccount
     */
    public <E extends top.viclau.mn.social.binding.db.tables.interfaces.IAccount> E into(E into);
}
