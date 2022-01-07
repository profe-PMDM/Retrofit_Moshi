package es.davidcorcuera.ejemploretrofitmoshi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch

class ApiViewModel: ViewModel() {
    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response

    fun getImageRandom(){
        viewModelScope.launch {
            try {
                // Call API to get random image
                _response.value = Api.retrofitService.getImageRandom()
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
                Log.d("Retrofit",e.message!!)
            }
        }
    }

    fun getImageRandomMoshi(){
        viewModelScope.launch {
            try {
                // Call API to get random image
                _response.value = ApiMoshi.retrofitMoshiService.getImageRandom().message
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
                Log.d("Retrofit",e.message!!)
            }
        }
    }

    fun getAll(){
        viewModelScope.launch {
            try {
                // Call API to get random image
                _response.value = Api.retrofitService.getAll()
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
                Log.d("Retrofit",e.message!!)
            }
        }
    }

}