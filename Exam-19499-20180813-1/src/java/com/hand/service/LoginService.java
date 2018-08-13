package com.hand.service;

import com.hand.pojo.CustomerDTO;

public interface LoginService {

    CustomerDTO checkLoginByName(int customerId);
}
