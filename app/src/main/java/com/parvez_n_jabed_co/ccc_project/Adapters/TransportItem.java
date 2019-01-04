package com.parvez_n_jabed_co.ccc_project.Adapters;

/**
 * Created by PARVEZ on 07-Feb-17.
 */

public class TransportItem {

    private String trans_type;
    private int trans_pic_id;

    public String getTrans_type() {
        return trans_type;
    }

    public void setTrans_type(String trans_type) {
        this.trans_type = trans_type;
    }

    public int getTrans_pic_id() {
        return trans_pic_id;
    }

    public void setTrans_pic_id(int trans_pic_id) {
        this.trans_pic_id = trans_pic_id;
    }

    public TransportItem(String trans_type, int trans_pic_id) {

        this.trans_type = trans_type;
        this.trans_pic_id = trans_pic_id;

//        this.trans_grt_sign = trans_gater;
    }
/*
    public String getTrans_grt_sign() {
        return trans_grt_sign;
    }

    public void setTrans_grt_sign(String trans_grt_sign) {
        this.trans_grt_sign = trans_grt_sign;
    }*/
}
