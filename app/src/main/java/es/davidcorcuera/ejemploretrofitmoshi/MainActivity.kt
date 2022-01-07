package es.davidcorcuera.ejemploretrofitmoshi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import es.davidcorcuera.ejemploretrofitmoshi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: ApiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Activity
        binding.lifecycleOwner = this

        // Giving the binding access to the WordViewModel
        binding.viewModel = viewModel

        // Inflate layout
        setContentView(binding.root)

        //ClickListener to get image random JSON formatted
        binding.btnImageRandom.setOnClickListener{viewModel.getImageRandom()}

        //ClickListener to get image random converted from JSON
        binding.btnImageRandomMoshi.setOnClickListener{viewModel.getImageRandomMoshi()}

        //ClickListener to list all breeds JSON formatted
        binding.btnListAllRaw.setOnClickListener{viewModel.getAll()}

    }
}