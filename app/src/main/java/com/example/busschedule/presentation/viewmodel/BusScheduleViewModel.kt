package com.example.busschedule.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.busschedule.data.dao.ScheduleDao
import com.example.busschedule.data.model.Schedule

class BusScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel(){
    fun fullSchedule(): List<Schedule> = scheduleDao.getAll()
    fun scheduleForStopName(name: String): List<Schedule> = scheduleDao.getByStopName(name)
}

class BusScheduleViewModelFactory(private val scheduleDao: ScheduleDao): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(BusScheduleViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return BusScheduleViewModel(scheduleDao) as T
        }
        throw IllegalAccessException("Unknown ViewModel Class")
    }
}