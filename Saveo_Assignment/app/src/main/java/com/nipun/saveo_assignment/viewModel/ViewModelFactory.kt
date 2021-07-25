package com.nipun.saveo_assignment.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nipun.saveo_assignment.repository.ListRepository

class ViewModelFactory(private val listRepository: ListRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(listRepository) as T
    }
}