package com.hand.dao;

import com.hand.pojo.CustomerDTO;

public interface LoginDAO {

    CustomerDTO checkLoginByName(int customerId);

}
