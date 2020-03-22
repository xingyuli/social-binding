/*
 * This file is generated by jOOQ.
 */
package top.viclau.mn.social.binding.db;


import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;

import top.viclau.mn.social.binding.db.tables.Account;


/**
 * A class modelling indexes of tables of the <code></code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index ACCOUNT_PRIMARY = Indexes0.ACCOUNT_PRIMARY;
    public static final Index ACCOUNT_UK_TYPE_EXT_ID = Indexes0.ACCOUNT_UK_TYPE_EXT_ID;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index ACCOUNT_PRIMARY = Internal.createIndex("PRIMARY", Account.ACCOUNT, new OrderField[] { Account.ACCOUNT.ID }, true);
        public static Index ACCOUNT_UK_TYPE_EXT_ID = Internal.createIndex("uk_type_ext_id", Account.ACCOUNT, new OrderField[] { Account.ACCOUNT.TYPE, Account.ACCOUNT.EXT_IDENTIFIER }, true);
    }
}