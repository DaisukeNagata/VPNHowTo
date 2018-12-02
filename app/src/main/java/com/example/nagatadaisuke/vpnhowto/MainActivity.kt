package com.example.nagatadaisuke.vpnhowto

import android.util.Log
import android.os.Bundle
import android.content.Context
import android.annotation.SuppressLint
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var check: Int = 0
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            vpn()
        }
    }

    fun vpn(){
        var cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networks = cm.allNetworks

        for (i in networks.indices) {
            check += i
            val caps = cm.getNetworkCapabilities(networks[i])
            if (caps.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
                Log.i("VPN", "VPN" )
            } else {
                Log.i("NOTVPN", "NOTVPN" )
            }
        }
        if (check == 1) {
            Log.i("VPN", "VPN" )
            Toast.makeText(this, "VPN", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "NOT_VPN", Toast.LENGTH_LONG).show()
        }
    }
}
