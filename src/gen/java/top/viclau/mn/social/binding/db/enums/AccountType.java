/*
 * This file is generated by jOOQ.
 */
package top.viclau.mn.social.binding.db.enums;


import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum AccountType implements EnumType {

    WECHAT("WECHAT");

    private final String literal;

    private AccountType(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return null;
    }

    @Override
    public Schema getSchema() {
        return null;
    }

    @Override
    public String getName() {
        return "account_type";
    }

    @Override
    public String getLiteral() {
        return literal;
    }
}
