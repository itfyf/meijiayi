package com.fyf.meijiayi.service;

import com.fyf.meijiayi.pojo.SmbmsProvider;

import java.util.List;

public interface SmbmsProviderSerivce {
    List<SmbmsProvider> selectAll();

    List<SmbmsProvider> queryPro(String queryProCode, String queryProName);

    SmbmsProvider selectById(int id);

    void updata(SmbmsProvider smbmsProvider);

    void delete(int id);

    void addPro(SmbmsProvider smbmsProvider);

    List<SmbmsProvider> isProCode(String code);

    List<SmbmsProvider> isProName(String name);
}
