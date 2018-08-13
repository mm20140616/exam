package com.hand.pojo;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName CustomerDTO
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 10:36
 * @Version 1.0
 **/
public class CustomerDTO {
    private Integer customerId;
    private String firstName;

    public CustomerDTO(Integer customerId, String firstName) {
        this.customerId = customerId;
        this.firstName = firstName;
    }
    public CustomerDTO() {}

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
