package com.example.drawing;

import android.content.Context;
import android.util.Log;

import com.example.ensias_auth_library.FoxyAuth;
import com.example.ensias_auth_library.models.GameStat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Statistics {

    private static GameStat gameStat;
    final String app_id = "2019_2_4_2";
    final String ex_id = "T_5_27";

    private Statistics() {
        gameStat = new GameStat();
        gameStat.setApp_id(app_id);
        gameStat.setExercise_id(ex_id);
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String created_at = dateFormat.format(date);
        gameStat.setCreated_at(created_at);
        gameStat.setUpdated_at(created_at);
        Log.i("dataa", " db " + created_at);
    }
    synchronized public static GameStat getGameStat() {
        if (gameStat == null) {
            new Statistics();
        }
        return gameStat;
    }
    public static void setLevel(int level) {
        gameStat.setLevel_id("" + level);
    }
    public static void setsetUpdatedAt(String updated_at) {
        gameStat.setUpdated_at(updated_at);
    }
    public static void setSuccessAttempts(int successAttempts) {
        gameStat.setSuccessful_attempts("" + successAttempts);
    }
    public static void setFailedAttempts(int failedAttempts) {
        gameStat.setFailed_attempts("" + failedAttempts);
    }
    public static void setMinTimeSucceed(long time) {
        gameStat.setMin_time_succeed_sec("" + time);
    }
    public static void setAvgTimeSucceedSec(long Avg_time) {
        gameStat.setAvg_time_succeed_sec("" + Avg_time);
    }
    public static void setGeoloc(double longitude, double latitude) {
        gameStat.setLongitude("" + longitude);
        gameStat.setLatitude("" + latitude);
    }
    public static void saveGame(Context context) {
        FoxyAuth.storeGameStat(context, gameStat);
    }
    public static void main(String[] args) throws ParseException, InterruptedException {
        Date date3 = Calendar.getInstance().getTime();
        TimeUnit.SECONDS.sleep(5);
        Date date4 = Calendar.getInstance().getTime();

        long difference = (date4.getTime() - date3.getTime()) / 1000; //sec
        int days = (int) (difference / (1000 * 60 * 60 * 24));
        int hours = (int) ((difference - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
        int min = (int) (difference - (1000 * 60 * 60 * 24 * days) - (1000 * 60 * 60 * hours)) / (1000 * 60);
        hours = (hours < 0 ? -hours : hours);
        System.out.println("======= Hours :: " + difference);
    }
}
