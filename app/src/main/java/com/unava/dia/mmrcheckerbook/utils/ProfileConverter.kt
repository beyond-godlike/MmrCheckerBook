package com.unava.dia.mmrcheckerbook.utils

import androidx.room.TypeConverter
import com.fasterxml.jackson.databind.ObjectMapper
import com.unava.dia.mmrcheckerbook.data.Profile

object ProfileConverter {
    private val mapper = ObjectMapper()
    @TypeConverter
    @JvmStatic
    fun toObject(value: String?) : Profile?{
        val user: Profile = mapper.readValue(value, Profile::class.java)
        return user
    }

    @TypeConverter
    @JvmStatic
    fun toString(value: Profile) : String {
        val jsonInString = mapper.writeValueAsString(value)
        return jsonInString.toString()
    }
}