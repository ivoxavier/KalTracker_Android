package com.ivoxavier.kaltracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ivoxavier.kaltracker.service.repository.utils.mifflinStJeorEquation

class UserProfileConfigViewModel(application: Application) : AndroidViewModel(application) {


    private val _age = MutableLiveData<Int>(15)//15
    val age : LiveData<Int> = _age

    private val _plan = MutableLiveData<Int>(0)//0
    val plan : LiveData<Int> = _plan

    private val _activity = MutableLiveData<Int>(0)//0
    val activity : LiveData<Int> = _activity

    private val _height = MutableLiveData<Int>(150)//150
    val height : LiveData<Int> = _height

    private val _weight = MutableLiveData<Int>(50)//50
    val weight : LiveData<Int> = _weight


    private val _sex_at_birth = MutableLiveData<Int>(0)//0
    val sex_at_birth : LiveData<Int> = _sex_at_birth


    //UserProfileCard types: Plan, Activity, Height, Weight, Sex. This helps in composable function
    val userProfileCardTypes = listOf(
        "LOOSE_WEIGHT",//0
        "MAINTAIN_WEIGHT",//1
        "GAIN_WEIGHT",//2
        "VERY_LIGHT_ACTIVITY",//3
        "LIGHT_ACTIVITY",//4
        "MODERATE_ACTIVITY",//5
        "HEAVY_ACTIVITY",//6
        "MALE_SEX",//7
        "FEMALE_SEX"//8
    )

    fun ageIncrement() {
        val newAge = _age.value?.plus(1) ?: 0
        _age.value = newAge
    }

    fun ageDecrement() {
        val newAge = _age.value?.minus(1) ?: 0
        _age.value = newAge
    }

    fun setPlan(selectedPlan: Int){
        _plan.value = selectedPlan
    }

    fun setActivity(selectedActivity: Int){
        _activity.value = selectedActivity
    }

    fun setSexAtBirth(selectedSex: Int){
        _sex_at_birth.value = selectedSex
    }

    fun setHeight(selectedHeight: Int){
        _height.value = selectedHeight
    }

    fun setWeight(selectedWeight: Int){
        _weight.value = selectedWeight
    }


    fun recommendedCalories(): Int {
        return mifflinStJeorEquation(_age.value!!, _weight.value!!.toDouble(), _height.value!!.toDouble(), _sex_at_birth.value!!, _activity.value!!) ?: 0
    }





}