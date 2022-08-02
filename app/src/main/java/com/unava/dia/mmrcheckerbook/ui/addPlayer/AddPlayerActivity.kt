package com.unava.dia.mmrcheckerbook.ui.addPlayer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.unava.dia.mmrcheckerbook.R
import com.unava.dia.mmrcheckerbook.utils.AppConstants.Companion.PLAYER_ID
import com.unava.dia.mmrcheckerbook.utils.obtainViewModel
import com.unava.dia.mmrcheckerbook.utils.setImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_add_player.*
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class AddPlayerActivity : AppCompatActivity() {

    private val viewModel: AddPlayerViewModel by lazy {
        obtainViewModel(AddPlayerViewModel::class.java,)
    }

    private var playerId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_player)
        playerId = intent.getIntExtra(PLAYER_ID, 0)
        this.observeViewModel()

        if (playerId != 0) {
            viewModel.restorePlayerFromDatabase(playerId!!)
        }

        btFetchPlayer.setOnClickListener {
            viewModel.getPlayer(etPlayerId.text.toString())
        }
        btSubmit.setOnClickListener {
            if (playerId != 0) {
                viewModel.addPlayer()
            } else {
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


    private fun observeViewModel() {
        this.viewModel.requestError.observe(this) { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        }

        this.viewModel.accInfo.observe(this) { iter->
            playerId = iter.id


            playerIcon?.let { setImage(it, iter?.profile?.avatarfull!!) }
            tvEstimatedMmr.text = iter?.mmr_estimate?.estimate.toString()
            tvSoloMmr.text = iter?.solo_competitive_rank
            tvPartyMmr.text = iter?.competitive_rank
            etPlayerId.setText(iter?.profile?.account_id?.toString())
        }
    }
}
