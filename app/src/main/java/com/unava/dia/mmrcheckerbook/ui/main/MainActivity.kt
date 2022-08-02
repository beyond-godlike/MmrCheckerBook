package com.unava.dia.mmrcheckerbook.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.unava.dia.mmrcheckerbook.R
import com.unava.dia.mmrcheckerbook.data.AccInformation
import com.unava.dia.mmrcheckerbook.ui.addPlayer.AddPlayerActivity
import com.unava.dia.mmrcheckerbook.utils.AppConstants.Companion.ACTIVITY_REQUEST_CODE
import com.unava.dia.mmrcheckerbook.utils.AppConstants.Companion.PLAYER_ID
import com.unava.dia.mmrcheckerbook.utils.RecyclerViewClickListener
import com.unava.dia.mmrcheckerbook.utils.obtainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), RecyclerViewClickListener {

    private val viewModel: MainViewModel by lazy {
        obtainViewModel(MainViewModel::class.java)
    }

    private var adapter: MainListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        this.observeViewModel()

        btNew.setOnClickListener {
            val intent = Intent(this, AddPlayerActivity::class.java)
            startActivityForResult(intent, ACTIVITY_REQUEST_CODE)
        }
    }

    // LiveData takes in an observer and notifies it about data changes only when it is in STARTED or RESUMED state.
    private fun observeViewModel() {
        viewModel.getPlayersList()?.observe(this) {
            updatePlayersList(it)
        }
        viewModel.updatingStatus.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
        this.viewModel.requestError.observe(this) { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        }
    }

    private fun setupRecyclerView() {
        rvPlayers.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun updatePlayersList(list: List<AccInformation>) {
        if (list.isNotEmpty()) {
            if (adapter == null) {
                adapter =
                    MainListAdapter(list.toMutableList(), this)
                rvPlayers.adapter = adapter
                adapter?.addPlayers(list)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // LiveData takes in an observer and notifies it about data changes only when it is in STARTED or RESUMED state
            this.recreate()
        }
    }

    override fun onClick(view: View?, position: Int) {
        // here we create an instance & use more memory(
        val player = adapter!!.getItem(position)

        if (view?.id == R.id.ivPlayerIcon) {
            if (player.id != null) {
                viewModel.updatePlayer(player.id!!)
                // LiveData takes in an observer and notifies it about data changes only when it is in STARTED or RESUMED state
                this.recreate()
            }
        }
        if (view?.id == R.id.btEdit) {
            val intent = Intent(this, AddPlayerActivity::class.java)
            intent.putExtra(PLAYER_ID, player.id)
            startActivityForResult(intent, ACTIVITY_REQUEST_CODE)
        }
    }
}
