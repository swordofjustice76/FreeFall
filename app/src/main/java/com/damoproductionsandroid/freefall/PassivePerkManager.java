package com.damoproductionsandroid.freefall;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class PassivePerkManager extends FragmentActivity {

    public static String PERKS = "perkSaveFile";
    public int perk_1_lvl;
    public double perk_1_stack;
    public int perk_1_cost;
    public int perk_1_player_size;

    public int perk_2_lvl;
    public int perk_2_stack;
    public int perk_2_cost;
    public float perk_2_mps;

    public int perk_3_lvl;
    public int perk_3_stack;
    public int perk_3_cost;

    public int perk_4_lvl;
    public int perk_4_stack;
    public int perk_4_cost;

    public int perk_5_lvl;
    public float perk_5_stack;
    public int perk_5_cost;
    public float perk_5_player_gap;

    public int perk_6_lvl;
    public int perk_6_stack;
    public int perk_6_cost;
    public int perk_6_collect_amount;


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

    public int getPerk_1_player_size(Context context, int perk_1_player_size) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_1_player_size", Constants.PLAYER_SIZE);
        editor.apply();
        return perk_1_player_size;
    }

    public int setPerk_1_player_size(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_1_player_size = pref.getInt("perk_1_player_size", 150);

        return perk_1_player_size;
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

    public float getPerk_2_mps(Context context, float perk_2_mps) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putFloat("perk_2_mps", Constants.MPS_MULTIPLIER);
        editor.apply();
        return perk_2_mps;
    }

    public float setPerk_2_mps(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_2_mps = pref.getFloat("perk_2_mps", 1);

        return perk_2_mps;
    }

    public int getPerk_3_lvl(Context context, int perk_3_lvl) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_3_lvl", Constants.PERK_3_LVL);
        editor.apply();
        return perk_3_lvl;
    }

    public int setPerk_3_lvl(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_3_lvl = pref.getInt("perk_3_lvl", 0);

        return perk_3_lvl;
    }

    public int getPerk_3_stack(Context context, int perk_3_stack) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_3_stack", Constants.PERK_3_STACK);
        editor.apply();
        return perk_3_stack;
    }

    public int setPerk_3_stack(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_3_stack = pref.getInt("perk_3_stack", 0);

        return perk_3_stack;
    }

    public int getPerk_3_cost(Context context, int perk_3_cost) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_3_cost", Constants.PERK_3_COST);
        editor.apply();
        return perk_3_cost;
    }

    public int setPerk_3_cost(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_3_cost = pref.getInt("perk_3_cost", Constants.PERK_3_COST);

        return perk_3_cost;
    }

    public int getPerk_4_lvl(Context context, int perk_4_lvl) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_4_lvl", Constants.PERK_4_LVL);
        editor.apply();
        return perk_4_lvl;
    }

    public int setPerk_4_lvl(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_4_lvl = pref.getInt("perk_4_lvl", 0);

        return perk_4_lvl;
    }

    public int getPerk_4_stack(Context context, int perk_4_stack) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_4_stack", Constants.PERK_4_STACK);
        editor.apply();
        return perk_4_stack;
    }

    public int setPerk_4_stack(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_4_stack = pref.getInt("perk_4_stack", 0);

        return perk_4_stack;
    }

    public int getPerk_4_cost(Context context, int perk_4_cost) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_4_cost", Constants.PERK_4_COST);
        editor.apply();
        return perk_4_cost;
    }

    public int setPerk_4_cost(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_4_cost = pref.getInt("perk_4_cost", Constants.PERK_4_COST);

        return perk_4_cost;
    }

    public int getPerk_5_lvl(Context context, int perk_5_lvl) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_5_lvl", Constants.PERK_5_LVL);
        editor.apply();
        return perk_5_lvl;
    }

    public int setPerk_5_lvl(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_5_lvl = pref.getInt("perk_5_lvl", 0);

        return perk_5_lvl;
    }

    public float getPerk_5_stack(Context context, float perk_5_stack) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putFloat("perk_5_stack", Constants.PERK_5_STACK);
        editor.apply();
        return perk_5_stack;
    }

    public float setPerk_5_stack(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_5_stack = pref.getFloat("perk_5_stack", 0);

        return perk_5_stack;
    }

    public int getPerk_5_cost(Context context, int perk_5_cost) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_5_cost", Constants.PERK_5_COST);
        editor.apply();
        return perk_5_cost;
    }

    public int setPerk_5_cost(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_5_cost = pref.getInt("perk_5_cost", Constants.PERK_5_COST);

        return perk_5_cost;
    }

    public float getPerk_5_player_gap(Context context, float perk_5_player_gap) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putFloat("perk_5_player_gap", Constants.PLAYER_GAP);
        editor.apply();
        return perk_5_player_gap;
    }

    public float setPerk_5_player_gap(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_5_player_gap = pref.getFloat("perk_5_player_gap", Constants.PLAYER_GAP);

        return perk_5_player_gap;
    }

    public int getPerk_6_lvl(Context context, int perk_6_lvl) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_6_lvl", Constants.PERK_6_LVL);
        editor.apply();
        return perk_6_lvl;
    }

    public int setPerk_6_lvl(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_6_lvl = pref.getInt("perk_6_lvl", 0);

        return perk_6_lvl;
    }

    public int getPerk_6_stack(Context context, int perk_6_stack) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_6_stack", Constants.PERK_6_STACK);
        editor.apply();
        return perk_6_stack;
    }

    public int setPerk_6_stack(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_6_stack = pref.getInt("perk_6_stack", 0);

        return perk_6_stack;
    }

    public int getPerk_6_cost(Context context, int perk_6_cost) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_6_cost", Constants.PERK_6_COST);
        editor.apply();
        return perk_6_cost;
    }

    public int setPerk_6_cost(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_6_cost = pref.getInt("perk_6_cost", Constants.PERK_6_COST);

        return perk_6_cost;
    }

    public int getPerk_6_collect_amount(Context context, int perk_6_collect_amount) {
        SharedPreferences pref = Constants.CURRENT_CONTEXT.getSharedPreferences(PERKS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("perk_6_collect_amount", Constants.COLLECT_AMOUNT);
        editor.apply();
        return perk_6_collect_amount;
    }

    public int setPerk_6_collect_amount(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PERKS, MODE_PRIVATE);
        perk_6_collect_amount = pref.getInt("perk_6_collect_amount", Constants.COLLECT_AMOUNT);

        return perk_6_collect_amount;
    }

}
