package com.damoproductionsandroid.freefall;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class PassivePerkManager extends Activity {

    public static String PERKS = "perkSaveFile";
    public int perk_1_lvl;
    public double perk_1_stack;
    public int perk_1_cost;

    public int perk_2_lvl;
    public int perk_2_stack;
    public int perk_2_cost;

    public int perk_3_lvl;
    public int perk_4_lvl;
    public int perk_5_lvl;
    public int perk_6_lvl;



    public int getPerk_1_lvl(Context context, int perk_1_lvl) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_1_lvl", Constants.PERK_1_LVL);
        editor.apply();
        return perk_1_lvl;
    }

    public int setPerk_1_lvl(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_1_lvl = pref.getInt("perk_1_lvl", 0);

       return perk_1_lvl;
    }

    public double getPerk_1_stack(Context context, double perk_1_stack) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putFloat("perk_1_stack", (float) Constants.PERK_1_STACK);
        editor.apply();
        return perk_1_stack;
    }

    public double setPerk_1_stack(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_1_stack = pref.getFloat("perk_1_stack", 0);

        return perk_1_stack;
    }

    public int getPerk_1_cost(Context context, int perk_1_cost) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_1_cost", Constants.PERK_1_COST);
        editor.apply();
        return perk_1_cost;
    }

    public int setPerk_1_cost(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_1_cost = pref.getInt("perk_1_cost", 0);

        return perk_1_cost;
    }


    public int getPerk_2_lvl(Context context, int perk_2_lvl) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_2_lvl", Constants.PERK_2_LVL);
        editor.apply();
        return perk_2_lvl;
    }

    public int setPerk_2_lvl(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_2_lvl = pref.getInt("perk_2_lvl", 0);

        return perk_2_lvl;
    }

    public int getPerk_2_stack(Context context, int perk_2_stack) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_2_stack", Constants.PERK_2_STACK);
        editor.apply();
        return perk_2_stack;
    }

    public int setPerk_2_stack(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_2_stack = pref.getInt("perk_2_stack", 0);

        return perk_2_stack;
    }

    public int getPerk_2_cost(Context context, int perk_2_cost) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_2_cost", Constants.PERK_2_COST);
        editor.apply();
        return perk_2_cost;
    }

    public int setPerk_2_cost(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_2_cost = pref.getInt("perk_2_cost", 0);

        return perk_2_cost;
    }

    public int getPerk_3_lvl() {
        return perk_3_lvl;
    }

    public void setPerk_3_lvl(int perk_3_lvl) {
        this.perk_3_lvl = perk_3_lvl;
    }

    public int getPerk_4_lvl() {
        return perk_4_lvl;
    }

    public void setPerk_4_lvl(int perk_4_lvl) {
        this.perk_4_lvl = perk_4_lvl;
    }

    public int getPerk_5_lvl() {
        return perk_5_lvl;
    }

    public void setPerk_5_lvl(int perk_5_lvl) {
        this.perk_5_lvl = perk_5_lvl;
    }

    public int getPerk_6_lvl() {
        return perk_6_lvl;
    }

    public void setPerk_6_lvl(int perk_6_lvl) {
        this.perk_6_lvl = perk_6_lvl;
    }

}
