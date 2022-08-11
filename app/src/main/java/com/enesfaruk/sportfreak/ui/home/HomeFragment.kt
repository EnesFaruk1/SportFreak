package com.enesfaruk.sportfreak.ui.home

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.enesfaruk.sportfreak.base.BaseFragment
import com.enesfaruk.sportfreak.databinding.FragmentHomeBinding
import com.enesfaruk.sportfreak.model.transfer.Response
import com.enesfaruk.sportfreak.utils.Constants.API_KEY
import com.enesfaruk.sportfreak.utils.Constants.TEAM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
){
    override val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getTransferByTeam(API_KEY, TEAM)
    }

    override fun onCreateFinished() {
    }

    override fun initializeListeners() {
    }

    override fun observeEvents() {
        with(viewModel){
            transferTeamResponse.observe(viewLifecycleOwner, Observer {
                it?.let {
                    it.response?.let { it1 -> setupRecyclerView(it1) }
                }
            })
        }
    }

    private fun setupRecyclerView(response: List<Response>) {

    }

}