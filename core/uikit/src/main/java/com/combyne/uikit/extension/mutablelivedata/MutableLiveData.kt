package com.combyne.uikit.extension.mutablelivedata

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.postNotifyObserver() {
    this.postValue(this.value)
}

fun <T> MutableLiveData<T>.notifyObserver() {
    this.value = this.value
}
