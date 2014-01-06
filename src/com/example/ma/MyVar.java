package com.example.ma;

import java.util.Locale;

import android.app.Application;

public class MyVar extends Application {
	public Locale locale;
	public String question;
	public int main_var_num = 0;
	public static final int main_var_num_limit = 10;
	public static final int sub_var_num_limit = 10;
	public int[] sub_var_num = new int[main_var_num_limit];
	public String[] main_var = new String[main_var_num_limit];
	public String[] sub_var = new String[main_var_num_limit*sub_var_num_limit];
	
	public int current_sub_var_index;
	
	public boolean[] probable_solution_set = new boolean[main_var_num_limit*sub_var_num_limit];
	public int[] possible_solution_index_num = new int[main_var_num_limit];
	public int[] possible_solution_index = new int[main_var_num_limit*sub_var_num_limit];
	public String solution;
	
	public MyVar(){
		reset();
		locale = Locale.getDefault();
	}
	public void reset(){
		for(int i=0;i<main_var_num_limit;i++){
			sub_var_num[i] = 0;
			possible_solution_index_num[i] = 0;
			for(int j=0;j<sub_var_num_limit;j++){
				probable_solution_set[i*sub_var_num_limit+j] = false;
			}
		}
	}
}
