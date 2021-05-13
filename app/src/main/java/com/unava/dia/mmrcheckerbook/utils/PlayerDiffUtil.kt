package com.unava.dia.mmrcheckerbook.utils

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.unava.dia.mmrcheckerbook.data.AccInformation

class PlayerDiffUtil (private var oldList: List<AccInformation>, private var newList: List<AccInformation>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id === newList[newItemPosition].id &&
                oldList.size == newList.size &&
                oldList[oldItemPosition].profile?.account_id === newList[newItemPosition].profile?.account_id

    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return  oldList[oldItemPosition].id === newList[newItemPosition].id &&
                oldList[oldItemPosition].tracked_until === newList[newItemPosition].tracked_until &&
                oldList[oldItemPosition].solo_competitive_rank === newList[newItemPosition].solo_competitive_rank &&
                oldList[oldItemPosition].competitive_rank === newList[newItemPosition].competitive_rank &&
                oldList[oldItemPosition].rank_tier === newList[newItemPosition].rank_tier &&
                oldList[oldItemPosition].leaderboard_rank === newList[newItemPosition].leaderboard_rank &&

                oldList[oldItemPosition].mmr_estimate?.estimate === newList[newItemPosition].mmr_estimate?.estimate &&

                oldList[oldItemPosition].equals(newList[newItemPosition])
        //    return oldList[oldItemPosition].equals(newList[newItemPosition])
    }

    @Nullable
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        //you can return particular field for changed item.
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}