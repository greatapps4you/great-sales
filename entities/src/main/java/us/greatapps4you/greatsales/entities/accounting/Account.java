package us.greatapps4you.greatsales.entities.accounting;

import java.io.Serializable;
import java.util.UUID;

/**
 * The Chart of Accounts
 * A Chart of Accounts is a list of all the names of the accounts found
 * in the General Ledger with an account code allocated to it.
 * Chart of Accounts is sometimes abbreviated to COA.
 * The Chart of Accounts simply sets out the structure
 * of your accounts so that all similar accounts are grouped together.
 * For example, balance sheet fixed asset accounts
 * might have codes from 10-50, income accounts might have codes from 4000-4999.
 * The Chart of Accounts should be split into balance sheet
 * and income statement sections, each of which is then
 * subdivided into groups (e.g. fixed assets, accounts receivable, sales etc).
 * Generally the most used accounts should be kept near the top of each group.
 */

public class Account implements Serializable {

    private Long sequential;
    private UUID uuid;
    private String name;
    private FinancialStatement financialStatement;
    private AccountGroup group;
    private String code;

    public Account() {
    }

    public Account(Long sequential, UUID uuid, String name, FinancialStatement financialStatement, AccountGroup group, String code) {
        this.sequential = sequential;
        this.uuid = uuid;
        this.name = name;
        this.financialStatement = financialStatement;
        this.group = group;
        this.code = code;
    }

    public Long getSequential() {
        return sequential;
    }

    public void setSequential(Long sequential) {
        this.sequential = sequential;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FinancialStatement getFinancialStatement() {
        return financialStatement;
    }

    public void setFinancialStatement(FinancialStatement financialStatement) {
        this.financialStatement = financialStatement;
    }

    public AccountGroup getGroup() {
        return group;
    }

    public void setGroup(AccountGroup group) {
        this.group = group;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (!name.equals(account.name)) return false;
        return code.equals(account.code);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + code.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
