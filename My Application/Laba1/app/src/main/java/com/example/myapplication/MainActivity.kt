package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = mutableListOf<AnimalData>()

        val imgPathCat: String = "app/src/main/res/images/jf.png"
        val imgPathDog: String = "app/src/main/res/images/drag.png"
        val imgPathMouse: String = "app/src/main/res/images/hedgehog.jpg"

        data.add(AnimalData("Jellyfish", "/", R.drawable.jf, Color.BLACK, this.resources.getString(R.string.jellyfish_description)))
        data.add(AnimalData("Dragon", "/", R.drawable.drag, Color.BLACK, this.resources.getString(R.string.dragon_description)))
        data.add(AnimalData("Hedgehog", "/", R.drawable.hedgehog, Color.BLACK, this.resources.getString(R.string.hedgehog_description)))

        recyclerView.adapter = AnimalsRecyclerAdapter(data, this)
    }

    public fun startActivity(longDesc: String)
    {
        startActivity(Intent(this, SecondActivity::class.java).apply
        {
            putExtra("text", longDesc)
        })
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
    }
}