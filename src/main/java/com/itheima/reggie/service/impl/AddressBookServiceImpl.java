package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.CustomException;
import com.itheima.reggie.entity.AddressBook;
import com.itheima.reggie.mapper.AddressBookMapper;
import com.itheima.reggie.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

    @Autowired
    private AddressBookService addressBookService;

    @Override
    public void remove(Long id) {
        AddressBook addressBook = addressBookService.getById(id);
        //如果为默认地址不能删除
        if (addressBook.getIsDefault() == 1) {
            //抛出一个业务异常
            throw new CustomException("地址为默认地址，不能删除");
        }
        //正常删除
        super.removeById(id);
    }
}
