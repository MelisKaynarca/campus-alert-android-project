package com.example.campushere

import com.google.type.Date

data class Incident(val type: String,val title : String,val description: String, val date : Long=System.currentTimeMillis(),val status : String="open"){

}
