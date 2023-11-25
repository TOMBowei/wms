package com.wms.sbwms.entity;

import lombok.Data;

@Data
public class RecordResult extends Record{
    private String username;
    private String adminname;
    private String goodsname;
    private String storagename;
    private String goodstypename;
}
