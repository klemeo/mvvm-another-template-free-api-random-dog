package ru.android.anothermvvmrandomdog.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import ru.android.anothermvvmrandomdog.R
import ru.android.anothermvvmrandomdog.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentHomeBinding>(
        inflater,
        R.layout.fragment_home,
        container,
        false
    )
        .apply {
            viewModel = this@HomeFragment.viewModel
            lifecycleOwner = viewLifecycleOwner

        }
        .root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModel.getDog()
    }

    private fun initView() {

        buttonNext.setOnClickListener { viewModel.getDog() }

    }

}