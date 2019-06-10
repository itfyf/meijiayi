package com.fyf.meijiayi.service;

import com.fyf.meijiayi.pojo.Bill;

import java.util.List;

public interface BillService {

    List<Bill> selectAllBill();

    void saveBill(Bill bill);

    List<Bill> selectNameOrUnitOrPayment(String name, String unit, String payment);

    Bill selectById(int id);

    void delectById(int id);
}
