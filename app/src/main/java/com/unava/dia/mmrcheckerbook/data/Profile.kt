package com.unava.dia.mmrcheckerbook.data

import androidx.room.Entity
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
data class Profile(
    @JsonProperty("account_id")
    var account_id: Int? = null,

    @JsonProperty("personaname")
    var personaname: String? = null,

    @JsonProperty("name")
    var name: String? = null,

    @JsonProperty("plus")
    var plus: Boolean? = false,

    @JsonProperty("cheese")
    var cheese: Int? = null,

    @JsonProperty("steamid")
    var steamid: String? = null,

    @JsonProperty("avatar")
    var avatar: String? = null,

    @JsonProperty("avatarmedium")
    var avatarmedium: String? = null,

    @JsonProperty("avatarfull")
    var avatarfull: String? = null,

    @JsonProperty("profileurl")
    var profileurl: String? = null,

    @JsonProperty("last_login")
    var last_login: String? = null,

    @JsonProperty("loccountrycode")
    var loccountrycode: String? = null,

    @JsonProperty("is_contributor")
    var is_contributor: Boolean? = false
)