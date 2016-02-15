package com.xiaoxin.acp_client.Utils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/2/13.
 */
public class RI {

    public static ArrayList<Testdata> getdata(){
        ArrayList<Testdata> arrayList=new ArrayList<Testdata>();
        Testdata testdata=null;
        for (int i = 0; i < 20; i++) {
            testdata=new Testdata();
            testdata.num=i;
            arrayList.add(testdata);
        }
        return arrayList;
    }
}
