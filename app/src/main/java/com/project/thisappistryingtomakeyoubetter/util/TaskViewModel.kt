package com.project.thisappistryingtomakeyoubetter.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.thisappistryingtomakeyoubetter.model.Task
import java.util.*
import javax.inject.Inject

class TaskViewModel @Inject constructor(
        private val taskRepository: TaskRepository
) : ViewModel() {
    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> = _tasks

    init {
        get(null, null)
    }

    fun insert(task: Task?) {
        taskRepository.insert(task)
    }

    fun update(task: Task?) {
        taskRepository.update(task)
    }

    fun delete(task: Task?) {
        taskRepository.delete(task)
    }

    @Suppress("UNUSED_PARAMETER")
    fun get(from: Date?, to:Date?){
        val result = taskRepository.get(from, to)
        _tasks.postValue(result)
    }
}