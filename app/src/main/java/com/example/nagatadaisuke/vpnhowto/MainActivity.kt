package com.example.nagatadaisuke.vpnhowto

import android.util.Log
import android.os.Bundle
import android.content.Context
import android.annotation.SuppressLint
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.support.v7.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networks = cm.allNetworks

        for (i in networks.indices) {
            val caps = cm.getNetworkCapabilities(networks[i])
            if (caps.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
                Log.i("VPN", "VPN" )
            } else {
                Log.i("NOTVPN", "NOTVPN" )
            }
        }
    }
}
