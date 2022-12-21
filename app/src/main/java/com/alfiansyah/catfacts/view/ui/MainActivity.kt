package com.alfiansyah.catfacts.view.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.alfiansyah.catfacts.databinding.ActivityMainBinding
import com.alfiansyah.catfacts.model.CatFact
import com.alfiansyah.catfacts.view.viewmodel.CatFactViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val catFactViewModel: CatFactViewModel by viewModels()
    private var _binding:ActivityMainBinding?=null
    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.btnCatFactLoadNew?.setOnClickListener {
            catFactViewModel.loadCatFact()
        }
        val catFactObserver = Observer<CatFact>{ newCatFact ->
            binding?.txtViewCatFact?.text = newCatFact.fact
        }
        catFactViewModel.catFact.observe(this, catFactObserver)
        catFactViewModel.loadCatFact()
    }
}