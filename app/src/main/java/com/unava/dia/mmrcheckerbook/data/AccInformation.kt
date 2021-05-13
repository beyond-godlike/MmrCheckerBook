package com.unava.dia.mmrcheckerbook.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonProperty

@Entity
data class AccInformation(
    @JsonProperty("tracked_until")
    var tracked_until: String? = null,

    @JsonProperty("solo_competitive_rank")
    var solo_competitive_rank: String? = null,

    @JsonProperty("competitive_rank")
    var competitive_rank: String? = null,

    @JsonProperty("rank_tier")
    var rank_tier: Int? = null,

    @JsonProperty("leaderboard_rank")
    var leaderboard_rank: Int? = null,

    @JsonProperty("mmr_estimate")
    var mmr_estimate: MmrEstimate? = null,

    @JsonProperty("profile")
    var profile: Profile? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}