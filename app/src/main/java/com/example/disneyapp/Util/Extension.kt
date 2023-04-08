package com.example.disneyapp.Util

import android.content.Context
import android.widget.Toast

class Extension {
    companion object{
        fun Context.toast(message : String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}