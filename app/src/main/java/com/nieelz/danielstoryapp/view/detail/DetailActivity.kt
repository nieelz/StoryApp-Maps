package com.nieelz.danielstoryapp.view.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.nieelz.danielstoryapp.database.remote.response.ListStoryItem
import com.nieelz.danielstoryapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.title = "Detail Story"
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.getParcelable<ListStoryItem>(EXTRA_STORY)?.let {
            with(binding) {
                ivPhotos.load(it.photoUrl)
                tvUserName.text = it.name
                tvDesc.text = it.description
            }
        }
    }

    companion object {
        const val EXTRA_STORY = "extra_story"
    }

}