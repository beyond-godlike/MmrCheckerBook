package com.unava.dia.mmrcheckerbook.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.unava.dia.mmrcheckerbook.R
import com.unava.dia.mmrcheckerbook.data.AccInformation
import com.unava.dia.mmrcheckerbook.utils.PlayerDiffUtil
import com.unava.dia.mmrcheckerbook.utils.RecyclerViewClickListener
import com.unava.dia.mmrcheckerbook.utils.setImage

class MainListAdapter (private val players: MutableList<AccInformation>, private val listener: RecyclerViewClickListener) :
    RecyclerView.Adapter<MainListAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.player_scores, parent, false)
        view.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
        return CustomViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val player = getItem(position)

        val url = player.profile?.avatarmedium.toString()
        setImage(holder.playerIcon, url)

        holder.name.text = nullToString(player.profile?.personaname)
        holder.estimated.text = nullToString(player.mmr_estimate?.estimate)
        holder.solo.text = nullToString(player.solo_competitive_rank)
        holder.party.text = nullToString(player.competitive_rank)
        holder.rank.text = nullToString(player.leaderboard_rank)
    }

    private fun nullToString(any: Any?) : String {
        return when {
            any != null -> any.toString()
            else -> "?"
        }
    }

    override fun getItemCount(): Int {
        return players.size
    }

    fun getItem(position: Int): AccInformation {
        return players[position]
    }

    fun addPlayers(newPlayers: List<AccInformation>) {
        val playerDiffUtil = PlayerDiffUtil(players, newPlayers)
        val diffResult = DiffUtil.calculateDiff(playerDiffUtil)
        players.clear()
        players.addAll(newPlayers)
        diffResult.dispatchUpdatesTo(this)
    }

    class CustomViewHolder(itemView: View, listener: RecyclerViewClickListener)
        : RecyclerView.ViewHolder(itemView), View.OnClickListener
    {
        private val mListener = listener
        var playerIcon: ImageButton = itemView.findViewById(R.id.ivPlayerIcon)
        var name: TextView = itemView.findViewById(R.id.tvName)
        var estimated: TextView = itemView.findViewById(R.id.tvEstimated)
        var solo: TextView = itemView.findViewById(R.id.tvSolo)
        var party: TextView = itemView.findViewById(R.id.tvParty)
        var rank: TextView = itemView.findViewById(R.id.tvRank)
        var edit: Button = itemView.findViewById(R.id.btEdit)

        init {
            edit.setOnClickListener(this)
            playerIcon.setOnClickListener(this)
        }


        override fun onClick(v: View?) {
            mListener.onClick(v, adapterPosition)
        }
    }
}
