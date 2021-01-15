/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.accounting;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <b>Double-entry bookkeeping</b>
 *
 * Simply put, a credit is money that has come from somewhere,
 * whereas a debit is money that has gone somewhere.
 * When transactions are described in "bookkeeper speak" they're
 * often being "credited" to or "debited" from an account of some kind.
 *
 * These examples illustrate how transactions are recorded in
 * bookkeeping as either a credit or debit:
 * Example 1: Money has come from a sale = Credit sales revenue
 * Example 2: Money has gone to a bank account = Debit bank account
 * Example 3: Money has come from a bank account = Credit bank account
 * Example 4: Money has gone to pay the landlord = Debit rent expense
 *
 * To help clarify this, take a look at the following two example transactions.
 * In the month of June, a small seller of beef jerky made a sale of $1800
 * and also had to pay their rent of $1500.
 * The transactions for the month of June would be recorded
 * with the following journal entries:
 *
 * June 12, 2015: Order of delicious beef jerky to customer
 * Credit, sales revenue, $1800 (money came from the customer)
 * Debit, bank account, $1800 (money went to the bank account)
 *
 * Payment of rent to the landlord: June 14, 2015
 * Credit, bank account, $1500 (money came from the bank account)
 * Debit, rent expense, $1500 (money went to the rent expense account)
 */
@Builder
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DoubleEntry {
    private UUID uuid;
    private String description;
    private Account debited;
    private Account credited;
    private BigDecimal amount;
    private LocalDateTime transactionTime;

}
