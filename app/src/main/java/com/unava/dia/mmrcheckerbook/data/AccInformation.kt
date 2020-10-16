package com.unava.dia.mmrcheckerbook.data

import android.provider.ContactsContract

data class AccInformation(
    var tracked_until: String? = null,
    var solo_competitive_rank: String? = null,
    var competitive_rank: String? = null,
    var rank_tier: Int? = null,
    var leaderboard_ank: Int? = null,
    var mmr_estimate: MmrEstimate? = null,
    var profile: ContactsContract.Profile? = null
) {
}