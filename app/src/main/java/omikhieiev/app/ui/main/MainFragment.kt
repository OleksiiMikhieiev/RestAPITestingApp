package omikhieiev.app.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.view.*
import omikhieiev.app.R

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val swipeContainer = view.swipeRefreshLayout
        swipeContainer.setOnRefreshListener {
            viewModel.getAllTransactions()
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.notesList)
        val adapter = TransactionsRecyclerViewAdapter()
        recyclerView.adapter = adapter

        viewModel.transactions.observe(this.viewLifecycleOwner, Observer {
            adapter.transactions = it
            swipeContainer.isRefreshing = false
        })

        viewModel.loadingError.observe(this.viewLifecycleOwner, Observer {
            Toast.makeText(this.context, "Error: $it", Toast.LENGTH_SHORT).show()
            swipeContainer.isRefreshing = false
        })

        viewModel.generalInfo.observe(this.viewLifecycleOwner, Observer {
            view.totalSum.text = it.sum.toString()
            view.averageSum.text = it.average.toString()
        })
    }
}