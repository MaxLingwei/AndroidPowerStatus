package com.example.rudy.batterinfofinal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.Class;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Class<?> powerProfileClazz = null;
        try{
            powerProfileClazz = Class.forName("com.android.internal.os.PowerProfile");
            Class[] argTypes = {Context.class};
            Constructor constructor = powerProfileClazz.getDeclaredConstructor(argTypes);
            Object[] arguments = {this};
            Object powerProInstance = constructor.newInstance(arguments);
            Method batteryCap = powerProfileClazz.getMethod("getBatteryCapacity", null);

            Log.i("mainbattery", batteryCap.invoke(powerProInstance, null).toString());
        }catch (ClassNotFoundException e){
            Log.i("print", "1");
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            Log.i("print", "2");
            e.printStackTrace();
        }catch (InstantiationException e){
            Log.i("print", "3");
            e.printStackTrace();
        }catch (IllegalAccessException e){
            Log.i("print", "4");
            e.printStackTrace();
        }catch (InvocationTargetException e){
            Log.i("print", "5");
            e.printStackTrace();
        }
        Log.i("MAIN", "1");
        setContentView(R.layout.activity_main);
        Log.i("MAIN", "2");
    }
}
