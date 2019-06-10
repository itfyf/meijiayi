package com.fyf.meijiayi.service.impl;

import com.fyf.meijiayi.mapper.BillMapper;
import com.fyf.meijiayi.pojo.Bill;
import com.fyf.meijiayi.pojo.BillExample;
import com.fyf.meijiayi.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillMapper billMapper;

    @Override
    public List<Bill> selectAllBill() {
        BillExample billExample = new BillExample();
        BillExample.Criteria criteria = billExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Bill> bills = billMapper.selectByExample(billExample);
        return bills;
    }

    @Override
    public void saveBill(Bill bill) {
        billMapper.insert(bill);
    }

    @Override
    public void delectById(int id) {
        billMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Bill> selectNameOrUnitOrPayment(String name, String unit, String payment) {
        List<Bill> bills = billMapper.selectNameOrUnitOrPayment(name, unit, Integer.valueOf("未付款".equals(payment) ? 1 : 2));
        return bills;
    }

    @Override
    public Bill selectById(int id) {
        Bill bill = billMapper.selectByPrimaryKey(id);
        return bill;
    }

}
