package com.ivoxavier.kaltracker.viewmodel

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ivoxavier.kaltracker.service.repository.utils.mifflinStJeorEquation
import com.ivoxavier.kaltracker.service.repository.utils.periodFour
import com.ivoxavier.kaltracker.service.repository.utils.periodOne
import com.ivoxavier.kaltracker.service.repository.utils.periodThree
import com.ivoxavier.kaltracker.service.repository.utils.periodTwo

class UserProfileConfigViewModel(application: Application) : AndroidViewModel(application) {

    //use to hide OR show the periodObjetive dialog
    private val _periodDialog = MutableLiveData<Boolean>()
    val periodDialog: LiveData<Boolean> = _periodDialog

    private val _age = MutableLiveData<Int>()
    val age : LiveData<Int> = _age

    private val _plan = MutableLiveData<Int>()
    val plan : LiveData<Int> = _plan

    private val _activity = MutableLiveData<Int>()
    val activity : LiveData<Int> = _activity

    private val _height = MutableLiveData<Int>()
    val height : LiveData<Int> = _height

    private val _weight = MutableLiveData<Int>()
    val weight : LiveData<Int> = _weight


    private val _sex_at_birth = MutableLiveData<Int>()
    val sex_at_birth : LiveData<Int> = _sex_at_birth


    private val _period_plan = MutableLiveData<Int>()
    val period_plan : LiveData<Int> = _period_plan

    //to validate if all the fields are filled before calculating the calories
    val _allSet = mutableStateMapOf(
        "age" to false,
        "sex" to false,
        "activity" to false,
        "height" to false,
        "weight" to false,
        "plan" to false
    )


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


    fun allFieldsFilled(map: Map<String, Boolean>): Boolean {
        return map.values.all { it}
    }

    fun showDialog(){
        _periodDialog.value = true
    }

    fun hideDialog(){
        _periodDialog.value = false
    }

    fun dialogState() : Boolean? {
        return _periodDialog.value
    }

    fun ageIncrement() {
        val newAge = _age.value?.plus(1) ?: 0
        _age.value = newAge
        _allSet["age"] = true
    }

    fun ageDecrement() {
        val newAge = _age.value?.minus(1) ?: 0
        _age.value = newAge
        _allSet["age"] = true
    }

    fun setPlan(selectedPlan: Int){
        _plan.value = selectedPlan
        _allSet["plan"] = true
    }

    fun setActivity(selectedActivity: Int){
        _activity.value = selectedActivity
        _allSet["activity"] = true
    }

    fun setSexAtBirth(selectedSex: Int){
        _sex_at_birth.value = selectedSex
        _allSet["sex"] = true
    }

    fun setHeight(selectedHeight: Int){
        _height.value = selectedHeight
        _allSet["height"] = true
    }

    fun setWeight(selectedWeight: Int){
        _weight.value = selectedWeight
        _allSet["weight"] = true
    }

    fun setPeriodPlan(selectedPeriod: Int){
        when(selectedPeriod){
            0 -> _period_plan.value = 0
            1 -> _period_plan.value = periodOne()
            2 -> _period_plan.value = periodTwo()
            3 -> _period_plan.value = periodThree()
            4 -> _period_plan.value = periodFour()
        }
    }

    fun recommendedCalories(): Int {
        //This uses the !! bang operator that forces the wrapping object, but if a given moment some value is null we get NullPointerExecption error
        //return mifflinStJeorEquation(_age.value!!, _weight.value!!.toDouble(), _height.value!!.toDouble(), _sex_at_birth.value!!, _activity.value!!) ?: 0

        val age = _age.value ?: 0
        val weight = _weight.value ?: 0
        val height = _height.value ?: 0
        val sex = _sex_at_birth.value ?: 0
        val activity = _activity.value ?: 0
        val period = _period_plan.value ?: 0
        val plan = _plan.value
        var calories: Int = 0

        //0 - maitain weight
        //1 - loose weight
        //2 - gain weight
        when(plan){
            0 -> calories =  mifflinStJeorEquation(age, weight.toDouble(), height.toDouble(), sex, activity)
            1 -> calories =  mifflinStJeorEquation(age, weight.toDouble(), height.toDouble(), sex, activity) - period
            2 -> calories =  mifflinStJeorEquation(age, weight.toDouble(), height.toDouble(), sex, activity) + period
        }

        return calories
    }

}