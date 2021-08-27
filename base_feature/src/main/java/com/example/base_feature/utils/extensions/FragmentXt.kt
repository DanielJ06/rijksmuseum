package com.example.base_feature.utils.extensions

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.view.inputmethod.InputMethodManager.HIDE_NOT_ALWAYS
import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard() {
    val inputManager =
        requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            ?: return
    val currentFocusedView = requireActivity().currentFocus ?: return
    inputManager.hideSoftInputFromWindow(currentFocusedView.windowToken, HIDE_NOT_ALWAYS)
}