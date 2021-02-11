/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.accounting;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
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

@Entity
@Builder
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    private UUID uuid;
    private String name;
    private FinancialStatement financialStatement;
    private AccountGroup group;
    private String code;

}
