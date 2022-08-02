package com.unava.dia.mmrcheckerbook.data

import androidx.room.Entity
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
data class MmrEstimate(
    @JsonProperty("estimate")
    var estimate: Int? = null,

    @JsonProperty("std_dev")
    var std_dev: Int? = null,

    @JsonProperty("n")
    var n: Int? = null
)