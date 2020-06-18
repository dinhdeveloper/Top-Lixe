package com.mobishop.toplixe.repositories.activity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mobishop.toplixe.R
import com.mobishop.toplixe.model.ItemSplashModel
import java.util.ArrayList

class SplashResitory {

    var itemList: MutableList<ItemSplashModel> = ArrayList<ItemSplashModel>()
    var itemPay: ItemSplashModel = ItemSplashModel()
    var itemOnTheWay: ItemSplashModel = ItemSplashModel()
    var itemTogether: ItemSplashModel = ItemSplashModel()

    fun addData(): MutableLiveData<List<ItemSplashModel>> {
        var data: MutableLiveData<List<ItemSplashModel>> = MutableLiveData<List<ItemSplashModel>>()

        itemPay.setTitle("Pay Your Bill Online")
        itemPay.setImage(R.drawable.business)
        itemPay.setDescription("Electric bill payment is a feature of online,mobile and telephone banking")

        itemOnTheWay.setTitle("Pay Your Bill Online")
        itemOnTheWay.setImage(R.drawable.desk)
        itemOnTheWay.setDescription("Electric bill payment is a feature of online,mobile and telephone banking")

        itemTogether.setTitle("Pay Your Bill Online")
        itemTogether.setImage(R.drawable.smartphone)
        itemTogether.setDescription("Electric bill payment is a feature of online,mobile and telephone banking")

        itemList.add(itemPay)
        itemList.add(itemOnTheWay)
        itemList.add(itemTogether)


        data.value = itemList

        return data
    }
}