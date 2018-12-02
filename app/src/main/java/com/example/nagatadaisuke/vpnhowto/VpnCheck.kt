package com.example.nagatadaisuke.vpnhowto

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.widget.Toast

class VpnCheck {

    fun vpn(con: Context){
        var cm = con.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networks = cm.allNetworks
        var check = 0
        for (i in networks.indices) {
            val caps = cm.getNetworkCapabilities(networks[i])
            if (caps.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
                Log.i("VPN", "VPN" )
                check += i
            } else {
                Log.i("NOTVPN", "NOTVPN" )
                check += i
            }
        }
        if (check == 0) {
            Log.i("VPN", "VPN" )
            Toast.makeText(con, "VPN", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(con, "NOT_VPN", Toast.LENGTH_LONG).show()
        }
    }
}