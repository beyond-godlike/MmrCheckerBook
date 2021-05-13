package com.unava.dia.mmrcheckerbook.utils

import androidx.room.TypeConverter
import com.fasterxml.jackson.databind.ObjectMapper
import com.unava.dia.mmrcheckerbook.data.MmrEstimate


object MmrEstimateConverter {
    private val mapper = ObjectMapper()
    @TypeConverter
    @JvmStatic
    fun toObject(value: String?) : MmrEstimate?{
        val user: MmrEstimate = mapper.readValue(value, MmrEstimate::class.java)
        return user
    }

    @TypeConverter
    @JvmStatic
    fun toString(value: MmrEstimate) : String {
        val jsonInString = mapper.writeValueAsString(value)
        return jsonInString.toString()
    }
}