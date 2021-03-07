package com.example.catapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.catapp.R
import com.example.catapp.data.CatRepository
import kotlinx.android.synthetic.main.first_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstFragment : Fragment(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val repository = CatRepository()
        image.visibility = View.GONE
        click.setOnClickListener {
            image.visibility = View.VISIBLE
            launch {
                val cats = repository.getData().await()
                loader.visibility = View.GONE
                Glide.with(requireContext()).load(cats?.get(0)?.url).centerCrop().into(image)
            }

        }
    }

}