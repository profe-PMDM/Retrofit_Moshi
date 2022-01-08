package es.davidcorcuera.ejemploretrofitmoshi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        binding.btnImageRandom.setOnClickListener{
            binding.scrollText.visibility = View.VISIBLE
            binding.scrollImage.visibility = View.GONE
            viewModel.getImageRandom()}

        //ClickListener to get image random converted from JSON
        binding.btnImageRandomMoshi.setOnClickListener{
            binding.scrollText.visibility = View.GONE
            binding.scrollImage.visibility = View.VISIBLE
            viewModel.getImageRandomMoshi()}

        //ClickListener to list all breeds JSON formatted
        binding.btnListAllRaw.setOnClickListener{
            binding.scrollText.visibility = View.VISIBLE
            binding.scrollImage.visibility = View.GONE
            viewModel.getAll()}

    }
}