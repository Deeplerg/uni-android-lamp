package com.example.somelesson.presenter

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.somelesson.R
import com.example.somelesson.databinding.FragmentMainBinding
import com.example.somelesson.di.DaggerAppComponent
import com.example.somelesson.di.viewModel.ViewModelFactory
import dev.androidbroadcast.vbpd.viewBinding
import javax.inject.Inject

class MainFragment: Fragment(R.layout.fragment_main) {

    val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.turnOffBtn.setOnClickListener {
            viewModel.turnOffLamp()
        }

        binding.turnOnBtn.setOnClickListener {
            viewModel.turnOnLamp()
        }

        binding.setColorBtn.setOnClickListener {
            val color = binding.editColor.text.toString().trim()
            this.viewModel.setColor(color)
        }

        binding.enablePoliceBlinkingBtn.setOnClickListener {
            viewModel.enablePoliceJob()
        }

        binding.enableSuppressorBtn.setOnClickListener {
            viewModel.enableSuppressorJob()
        }

        binding.stopBlinkingBtn.setOnClickListener {
            viewModel.stopRecurringJob()
        }
    }

    override fun onAttach(context: Context) {
        val component = DaggerAppComponent.create()

        component.inject(this)

        super.onAttach(context)
    }
}