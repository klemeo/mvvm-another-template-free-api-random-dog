package ru.android.anothermvvmrandomdog.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject
import ru.android.anothermvvmrandomdog.R
import ru.android.anothermvvmrandomdog.base.setImageFitPlaceholderWithGlide
//import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.android.anothermvvmrandomdog.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservers()
        viewModel.getDog()
    }

    private fun initView() {

        buttonNext.setOnClickListener { viewModel.getDog() }

    }

    private fun initObservers() {
        with(viewModel) {
            dogLiveData.observe(viewLifecycleOwner, Observer {
                imageView.setImageFitPlaceholderWithGlide(
                    imageUrl = it.message
                )
            }
            )
        }
    }

}