package com.abdhilabs.movieapp.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdhilabs.movieapp.R
import com.abdhilabs.movieapp.adapter.GroupAdapter
import com.abdhilabs.movieapp.data.GroupItem
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    private lateinit var adapterGroup: GroupAdapter
    private lateinit var viewModel: MovieViewModel

    private var groupItem = GroupItem.list as ArrayList

    companion object {
        fun newInstance(): MovieFragment {
            val fragment = MovieFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this)[MovieViewModel::class.java]

        setupRecyclerView()
        observeLiveData()

        viewModel.getList()
    }

    private fun setupRecyclerView() {
        adapterGroup = GroupAdapter(groupItem)
        rv_movie.apply {
            adapter = adapterGroup
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun observeLiveData() {
        viewModel.dataList.observe(this, Observer {
            adapterGroup.setShowing(it?.data!!)
            adapterGroup.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer {
            Toast.makeText(context, "You got some error : ${it.message}", Toast.LENGTH_LONG).show()
        })
    }
}
