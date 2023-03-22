package com.example.ramadanchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ramadanchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var allDoaTexts: MutableList<String>
    private var currentDoaIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        allDoaTexts = resources.getStringArray(R.array.all_doas).toMutableList()
        addCallBacks()
    }

    private fun addCallBacks() {
        binding.apply {
            tvNext.setOnClickListener {
                tvQuran.text = getNextDoa()
            }
            tvBefore.setOnClickListener {
                tvQuran.text = getPreviousDoa()
            }
        }

    }

    private fun getPreviousDoa(): String {
        currentDoaIndex--
        if (currentDoaIndex < 0) currentDoaIndex = allDoaTexts.lastIndex
        return allDoaTexts[currentDoaIndex]
    }

    private fun getNextDoa(): String {
        currentDoaIndex++
        if (currentDoaIndex > allDoaTexts.lastIndex) currentDoaIndex = 0
        return allDoaTexts[currentDoaIndex]
    }
}


