/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.accounting;

import java.io.Serializable;
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
 * June 12, 2015: Sale of delicious beef jerky to customer
 * Credit, sales revenue, $1800 (money came from the customer)
 * Debit, bank account, $1800 (money went to the bank account)
 *
 * Payment of rent to the landlord: June 14, 2015
 * Credit, bank account, $1500 (money came from the bank account)
 * Debit, rent expense, $1500 (money went to the rent expense account)
 */
public class DoubleEntry implements Serializable {

    private Long sequential;
    private UUID uuid;
    private String description;
    private Account debited;
    private Account credited;
    private BigDecimal amount;
    private LocalDateTime transactionTime;

    public DoubleEntry() {
    }

    public DoubleEntry(Long sequential, UUID uuid, String description, Account debited, Account credited, BigDecimal amount, LocalDateTime transactionTime) {
        this.sequential = sequential;
        this.uuid = uuid;
        this.description = description;
        this.debited = debited;
        this.credited = credited;
        this.amount = amount;
        this.transactionTime = transactionTime;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getDebited() {
        return debited;
    }

    public void setDebited(Account debited) {
        this.debited = debited;
    }

    public Account getCredited() {
        return credited;
    }

    public void setCredited(Account credited) {
        this.credited = credited;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoubleEntry that = (DoubleEntry) o;

        if (!description.equals(that.description)) return false;
        if (!debited.equals(that.debited)) return false;
        if (!credited.equals(that.credited)) return false;
        if (!amount.equals(that.amount)) return false;
        return transactionTime.equals(that.transactionTime);
    }

    @Override
    public int hashCode() {
        int result = description.hashCode();
        result = 31 * result + debited.hashCode();
        result = 31 * result + credited.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + transactionTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DoubleEntry{" +
                "description='" + description + '\'' +
                ", debited=" + debited +
                ", credited=" + credited +
                ", amount=" + amount +
                ", transactionTime=" + transactionTime +
                '}';
    }
}
