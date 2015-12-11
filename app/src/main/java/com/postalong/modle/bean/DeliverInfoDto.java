package com.postalong.modle.bean;


import java.io.Serializable;

/**
 * Created by heqiang on 2015/8/13.
 */
public class DeliverInfoDto{

    private DeliverInfo res;

    public DeliverInfo getRes() {
        return res;
    }

    public void setRes(DeliverInfo res) {
        this.res = res;
    }


    private Integer ret;//状态码

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public static class DeliverInfo implements Serializable {
//        picFid：半身照 文件 id
//        realName：真实名
        String nation; // 国籍
        String address; // 所在地区
        String firstName; //
        String familyName; //
        String creditCard; // 信用卡号
        String identity; // 身份证号
        String armUser; // 紧急联系人
        String armPhone; // 紧急联系人电话

        String sex; // 性别
        String idType; // 证件类型


        public String getCreditCard() {
            return creditCard;
        }

        public void setCreditCard(String creditCard) {
            this.creditCard = creditCard;
        }

        public String getIdType() {
            return idType;
        }

        public void setIdType(String idType) {
            this.idType = idType;
        }



        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }


        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getFamilyName() {
            return familyName;
        }

        public void setFamilyName(String familyName) {
            this.familyName = familyName;
        }

        public String getIdentity() {
            return identity;
        }

        public void setIdentity(String identity) {
            this.identity = identity;
        }

        public String getArmUser() {
            return armUser;
        }

        public void setArmUser(String armUser) {
            this.armUser = armUser;
        }

        public String getArmPhone() {
            return armPhone;
        }

        public void setArmPhone(String armPhone) {
            this.armPhone = armPhone;
        }

        }
}
