package com.malikirmizitas.movieapp.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel


abstract class BaseFragment<VM : ViewModel?, DB : ViewDataBinding> : Fragment(), IBaseFragment {

    abstract var viewModel: VM?
    protected lateinit var dataBinding: DB


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutID(), container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView()
        observeLiveData()

        //toastLong(shouldCheckInternetConnection().toString())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        prepareViewModel()
    }

    abstract fun getLayoutID(): Int
    abstract fun observeLiveData()
    abstract fun prepareView()
    abstract fun prepareViewModel()
    override fun shouldCheckInternetConnection() = true

}