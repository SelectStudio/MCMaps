package com.select.mcmaps.classes;

public class CodeID {
    public static String incodeID(String codeString) {
        char[] codeList = codeString.toCharArray();
        String result = "";
        for (int i = 0; i < codeList.length; i++) {
            if(i==codeList.length-1){
                result+=String.valueOf((int)codeList[i]*719);
            }
            else{
                result+=String.valueOf((int)codeList[i]*719)+"\\";
            }
        }
        return result;
    }
    public static String decodeID(String codeString) {
        String[] charList=codeString.split("\\");
        String result="";
        for(int i=0;i<charList.length;i++){
            int data=Integer.parseInt(charList[i])/719;
            result+=String.valueOf((char)data);
        }
        return result;
    }

}
