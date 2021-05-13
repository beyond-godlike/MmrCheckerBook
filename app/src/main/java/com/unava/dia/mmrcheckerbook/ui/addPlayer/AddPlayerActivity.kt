package com.unava.dia.mmrcheckerbook.ui.addPlayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.mmrcheckerbook.R
import com.unava.dia.mmrcheckerbook.utils.AppConstants.Companion.PLAYER_ID
import com.unava.dia.mmrcheckerbook.utils.PicassoUtil
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_add_player.*
import javax.inject.Inject

class AddPlayerActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: AddPlayerViewModel

    private var playerId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_player)
        AndroidInjection.inject(this)
        playerId = intent.getIntExtra(PLAYER_ID, 0)
        this.bindViewModel()

        //Toast.makeText(this, playerId.toString(), Toast.LENGTH_LONG).show()
        if (playerId != 0) {
            viewModel.restorePlayerFromDatabase(playerId!!)
        }

        btFetchPlayer.setOnClickListener {
            viewModel.getPlayer(etPlayerId.text.toString())
        }
        btSubmit.setOnClickListener {
            if (playerId != 0) {
                viewModel.addPlayer()
            }
            else {
                viewModel.updatePlayer(playerId!!)
            }
            setResult(RESULT_OK, intent)
            finish()
        }
        btDelete.setOnClickListener {
            viewModel.deletePlayer(playerId!!)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(AddPlayerViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {
        this.viewModel.requestError.observe(this, Observer { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        })

        this.viewModel.accInfo.observe(this, Observer {
            playerId = it.id
            PicassoUtil.setPlayerIcon(playerIcon, it?.profile?.avatarfull.toString())
            tvEstimatedMmr.text = it?.mmr_estimate?.estimate.toString()
            tvSoloMmr.text = it?.solo_competitive_rank
            tvPartyMmr.text = it?.competitive_rank
            etPlayerId.setText(it?.profile?.account_id?.toString())
        })
    }
}
