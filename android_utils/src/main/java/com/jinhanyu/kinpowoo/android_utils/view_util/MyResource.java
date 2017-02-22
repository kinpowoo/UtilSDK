package com.jinhanyu.kinpowoo.android_utils.view_util;

import android.content.Context;

/**
 * Created by Administrator on 2017/2/19 0019.
 */

public class MyResource {
    public static int getIdByName(Context context,String clsName,String resName){
        String packageName=context.getPackageName();
        int id=0;
        try {
            Class r=Class.forName(packageName+".R");
            Class []classes =r.getClasses();
            Class desireClass=null;

            for(Class cls:classes){
                if(cls.getName().split("\\$")[1].equals(clsName)){
                    desireClass=cls;
                    break;
                }
            }

            if(desireClass!=null){
                id=desireClass.getField(resName).getInt(clsName);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return id;
    }

}
