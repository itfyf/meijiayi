package com.fyf.meijiayi.service.impl;

import com.fyf.meijiayi.mapper.SmbmsProviderMapper;
import com.fyf.meijiayi.pojo.SmbmsProvider;
import com.fyf.meijiayi.pojo.SmbmsProviderExample;
import com.fyf.meijiayi.service.SmbmsProviderSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmbmsProviderSerivceImpl implements SmbmsProviderSerivce {

    @Autowired
    private SmbmsProviderMapper smbmsProviderMapper;

    @Override
    public List<SmbmsProvider> selectAll() {
        SmbmsProviderExample smbmsProviderExample = new SmbmsProviderExample();
        SmbmsProviderExample.Criteria criteria = smbmsProviderExample.createCriteria();
        criteria.andIdIsNotNull();
        List<SmbmsProvider> smbmsProviders = smbmsProviderMapper.selectByExample(smbmsProviderExample);
        return smbmsProviders;
    }

    @Override
    public List<SmbmsProvider> queryPro(String queryProCode, String queryProName) {
        List<SmbmsProvider> smbmsProviders = smbmsProviderMapper.queryPro(queryProCode, queryProName);
        return smbmsProviders;
    }

    @Override
    public SmbmsProvider selectById(int id) {
        SmbmsProvider smbmsProvider = smbmsProviderMapper.selectByPrimaryKey(id);
        return smbmsProvider;
    }

    @Override
    public void updata(SmbmsProvider smbmsProvider) {
        smbmsProviderMapper.updateByPrimaryKeySelective(smbmsProvider);
    }

    @Override
    public void delete(int id) {
        smbmsProviderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addPro(SmbmsProvider smbmsProvider) {
        smbmsProviderMapper.insertSelective(smbmsProvider);
    }

    @Override
    public List<SmbmsProvider> isProCode(String code) {
        SmbmsProviderExample smbmsProviderExample = new SmbmsProviderExample();
        SmbmsProviderExample.Criteria criteria = smbmsProviderExample.createCriteria();
        criteria.andProcodeEqualTo(code);
        List<SmbmsProvider> smbmsProviders = smbmsProviderMapper.selectByExample(smbmsProviderExample);
        return smbmsProviders;
    }

    @Override
    public List<SmbmsProvider> isProName(String name) {
        SmbmsProviderExample smbmsProviderExample = new SmbmsProviderExample();
        SmbmsProviderExample.Criteria criteria = smbmsProviderExample.createCriteria();
        criteria.andPronameEqualTo(name);
        List<SmbmsProvider> smbmsProviders = smbmsProviderMapper.selectByExample(smbmsProviderExample);
        return smbmsProviders;
    }
}
