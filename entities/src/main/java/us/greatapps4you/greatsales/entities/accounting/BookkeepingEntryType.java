package us.greatapps4you.greatsales.entities.accounting;

/**
 * Double-entry bookkeeping,
 * is a method of bookkeeping that tracks where your money comes from and where it's going. Every financial transaction gets two entries, a "debit" and a "credit" to describe whether money is being transferred to or from an account, respectively. Each accounting entry affects two different accounts:
 * for example,
 * When you send an invoice to a client after finishing a project, you would "debit" accounts receivable and "credit" the sales account.
 * After the client pays you, you would then "debit" your cash account, and "credit" accounts receivable.
 *
 * Debits:
 * Increase an asset account, or decrease a liability account or equity account (such as owner's equity).
 * Increase an expense account.
 * Decrease revenue
 * Are always recorded on the left side
 *
 * Credits:
 * Increase a liability or equity account, or decrease an asset account.
 * Decrease an expense account.
 * Increase revenue
 * Are always recorded on the right side
 */
public enum BookkeepingEntryType {
    CREDIT, DEBIT
}
