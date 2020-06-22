package omikhieiev.app.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import omikhieiev.app.R
import omikhieiev.app.domain.data.Transaction
import kotlin.properties.Delegates

class TransactionsRecyclerViewAdapter: RecyclerView.Adapter<TransactionsRecyclerViewAdapter.ViewHolder>(), AutoUpdatableAdapter {

    var transactions: List<Transaction> by Delegates.observable(emptyList()) {
            _, old, new ->
        autoNotify(old, new) { o, n -> o.reference == n.reference }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.transaction_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = transactions.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.mItem = transaction
        holder.referenceView.text = transaction.reference
        holder.amountView.text = transaction.sourceAmount.toString()
        holder.statusView.text = transaction.status
    }

    class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val referenceView: TextView = mView.findViewById(R.id.reference)
        val statusView: TextView = mView.findViewById(R.id.status)
        val amountView: TextView = mView.findViewById(R.id.amount)
        var mItem: Transaction? = null

        override fun toString(): String {
            return super.toString() + " '" + referenceView.text + "'"
        }

    }

}