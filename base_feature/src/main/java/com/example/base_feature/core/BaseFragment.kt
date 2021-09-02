package com.example.base_feature.core

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.example.base_feature.utils.extensions.hideKeyboard
import org.koin.core.component.KoinComponent

abstract class BaseFragment: Fragment(), KoinComponent {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        addObservers(viewLifecycleOwner)
    }

    override fun onStop() {
        super.onStop()
        hideKeyboard()
    }

    open fun addObservers(owner: LifecycleOwner) = Unit

    open fun setupView() = Unit

}