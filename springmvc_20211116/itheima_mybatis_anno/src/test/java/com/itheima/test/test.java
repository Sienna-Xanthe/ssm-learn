package com.itheima.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class test {

    /**
     * 力扣
     * 1002. 查找共用字符
     */
    @Test
    public List<String> qwewer(String[] words){
        int[] ans = new int[26];
        int len = words.length;
        if(len <= 0){
            return null;
        }
        for(int i = 0; i < words[0].length();i++){
            ans[words[0].charAt(i) - 'a']++;
        }
        for(int i = 1;i < words.length;i++){
            int[] temp = new int[26];
            for(int j = 0;j < words[i].length();j++){
                temp[words[i].charAt(j) - 'a']++;
            }
            for(int k = 0;k < 26;k++){
                if(ans[k] < temp[k])
                    ans[k] = ans[k];
                else
                    ans[k] = temp[k];
            }
        }
        List<String> anslist = new ArrayList<>();
        for(int i = 0;i < 26;i ++){
            if(ans[i] > 0){
                for(int j = 0;j < ans[i];j ++)
                    anslist.add(String.valueOf((char)(i + 'a')));
            }
        }
        return anslist;
    }
}
