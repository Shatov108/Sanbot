package com.shatov.super_sanbot

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sanbot.opensdk.base.BindBaseActivity

import com.sanbot.opensdk.beans.FuncConstant
import com.sanbot.opensdk.beans.FuncConstant.HARDWARE_MANAGER
import com.sanbot.opensdk.function.unit.HardWareManager


class MainActivity : AppCompatActivity() {
    //private HardWareManager hardWareManager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //HardWareManager hardWareManager = (HardWareManager)getUnitManager
               // (FuncConstant.HARDWARE_MANAGER);
        //HardWareManager hardWareManager = getUnitManager(HARDWARE_MANAGER) as HardWareManager
        //hardWareManager = (HardWareManager) getUnitManager(FuncConstant.HARDWARE_MANAGER);

        val hardWareManager = getUnitManager(HARDWARE_MANAGER) as HardWareManager

        hardWareManager.setOnHareWareListener(new GyroscopeListener() {
            @Override public void gyroscopeData(float driftAngle, float elevationAngle, float rollAngle) {
                //TODO Return Gyroscope Data
            }
        });
    }
}