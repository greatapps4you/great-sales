package us.greatapps4you.greatsales.entities.accounting;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
 * June 12, 2015: Sale of delicious beef jerky to customer
 * Credit, sales revenue, $1800 (money came from the customer)
 * Debit, bank account, $1800 (money went to the bank account)
 *
 * Payment of rent to the landlord: June 14, 2015
 * Credit, bank account, $1500 (money came from the bank account)
 * Debit, rent expense, $1500 (money went to the rent expense account)
 */
public class DoubleEntry {
    private String description;
    private Account debited;
    private Account credited;
    private BigDecimal amount;
    private LocalDateTime transactionTime;


}
