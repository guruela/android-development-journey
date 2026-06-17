package `in`.microkid.counterapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel: ViewModel() {
    private val _count = MutableStateFlow(0)

    val count: StateFlow<Int> = _count.asStateFlow()

    fun incrementCount()    {
        _count.value++
    }

    fun decrementCount() {
        if (_count.value > 0) {
            _count.value--
        }
    }
}