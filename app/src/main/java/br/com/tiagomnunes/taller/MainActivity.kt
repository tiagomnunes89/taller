package br.com.tiagomnunes.taller

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : Activity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val adapter = Adapter(list)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.listener = object : Adapter.OnItemClickListener {
            override fun onItemClickListener(v: View, pos: Int, item: Item) {
                Toast.makeText(this@MainActivity, "Item clicked: ${item.title}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
