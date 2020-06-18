package com.mobishop.toplixe.viewmodel.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobishop.toplixe.model.ItemSplashModel
import com.mobishop.toplixe.repositories.activity.SplashResitory


class SplashViewModel : ViewModel() {
    private var data: MutableLiveData<List<ItemSplashModel>> = MutableLiveData()
    private val splashRepository: SplashResitory =
        SplashResitory()


    fun getData(): MutableLiveData<List<ItemSplashModel>> {
        data = splashRepository.addData()
        return data
    }
}