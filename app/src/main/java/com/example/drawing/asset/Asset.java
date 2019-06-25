package com.example.drawing.asset;


import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Implementation.AndroidSound;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Asset  {
    public static Image bg;
    public static Image green_clair_sprite;
    public static Image blue_clair_sprite;
    public static Image red_sprite;
    public static Image rose_sprite;
    public static Image yellow_sprite;
    public static Image reset;
    public static Image valider;
    public static Image happy_face;
    public static Image sad_face;
    public static Image wink_face;
    public static Image blank;
    public static Image cercle_noir;
    public static String LANG="fr";
    public static int LEVEL;
    public static int[] marge;
    public static int[] fillPercentage = {200,400,150};

    //statistiques
    public static int succes = 0;
    public static int fail = 0;
    public static long min_time = 0;
    public static long avg_time = 0;

    public static Date date_debut;
    public static Date date_fin;

    public static List<Long> scores_time;


}
