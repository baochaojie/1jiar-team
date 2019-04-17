package com.jk.model;

//import lombok.Data;

import java.io.Serializable;

//房屋主表
public class House implements Serializable {
    private static final long serialVersionUID = -3999842267868731167L;
    private  Integer houseId;//id
    private  String houseaheName;//名字
    private  Integer housePrice;//售价
    private  Integer houseManId;//用户id 房屋拥有者 关联一张用户表
    private  String houseJianzhuMianji;//建筑面积
    private  String houseTaoneiMianji;//套内面积
    private  Integer houseTypeId;//房型id 关联一张房屋类型表
    private  Integer houseUseId;//用途id 关联一张房屋用途表
    private  Integer houseFloorTypeId;//楼层类型表id 关联一张楼层类型表
    private  Integer houseDirectionId;//房屋朝向表id 关联一张房屋朝向表
    private  Integer houseAgeId;//楼龄id 关联一张楼龄表
    private  Integer houseElevator;//有无电梯 1是有电梯，2是没有电梯
    private  Integer houseFinish;//是否装修 1是已装修，2是未装修
    private  Integer houseHeating;//是否供暖 1是供暖，2是不供暖
    private  String ridgepoleName;//楼栋
    private  String elementName;//单元
    private  String doorplateName;//门牌号
    private  Integer houseQuYuId;//区域关联表id
    private  String houseQuYuName;//区域名
    private  Integer houseDiTieId;//地铁关联表id
    private  String houseDiTieName;//地铁名
    private  Integer houseZuQi;//租期 1月租 2年租

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getHouseaheName() {
        return houseaheName;
    }

    public void setHouseaheName(String houseaheName) {
        this.houseaheName = houseaheName;
    }

    public Integer getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(Integer housePrice) {
        this.housePrice = housePrice;
    }

    public Integer getHouseManId() {
        return houseManId;
    }

    public void setHouseManId(Integer houseManId) {
        this.houseManId = houseManId;
    }

    public String getHouseJianzhuMianji() {
        return houseJianzhuMianji;
    }

    public void setHouseJianzhuMianji(String houseJianzhuMianji) {
        this.houseJianzhuMianji = houseJianzhuMianji;
    }

    public String getHouseTaoneiMianji() {
        return houseTaoneiMianji;
    }

    public void setHouseTaoneiMianji(String houseTaoneiMianji) {
        this.houseTaoneiMianji = houseTaoneiMianji;
    }

    public Integer getHouseTypeId() {
        return houseTypeId;
    }

    public void setHouseTypeId(Integer houseTypeId) {
        this.houseTypeId = houseTypeId;
    }

    public Integer getHouseUseId() {
        return houseUseId;
    }

    public void setHouseUseId(Integer houseUseId) {
        this.houseUseId = houseUseId;
    }

    public Integer getHouseFloorTypeId() {
        return houseFloorTypeId;
    }

    public void setHouseFloorTypeId(Integer houseFloorTypeId) {
        this.houseFloorTypeId = houseFloorTypeId;
    }

    public Integer getHouseDirectionId() {
        return houseDirectionId;
    }

    public void setHouseDirectionId(Integer houseDirectionId) {
        this.houseDirectionId = houseDirectionId;
    }

    public Integer getHouseAgeId() {
        return houseAgeId;
    }

    public void setHouseAgeId(Integer houseAgeId) {
        this.houseAgeId = houseAgeId;
    }

    public Integer getHouseElevator() {
        return houseElevator;
    }

    public void setHouseElevator(Integer houseElevator) {
        this.houseElevator = houseElevator;
    }

    public Integer getHouseFinish() {
        return houseFinish;
    }

    public void setHouseFinish(Integer houseFinish) {
        this.houseFinish = houseFinish;
    }

    public Integer getHouseHeating() {
        return houseHeating;
    }

    public void setHouseHeating(Integer houseHeating) {
        this.houseHeating = houseHeating;
    }

    public String getRidgepoleName() {
        return ridgepoleName;
    }

    public void setRidgepoleName(String ridgepoleName) {
        this.ridgepoleName = ridgepoleName;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getDoorplateName() {
        return doorplateName;
    }

    public void setDoorplateName(String doorplateName) {
        this.doorplateName = doorplateName;
    }

    public Integer getHouseQuYuId() {
        return houseQuYuId;
    }

    public void setHouseQuYuId(Integer houseQuYuId) {
        this.houseQuYuId = houseQuYuId;
    }

    public Integer getHouseDiTieId() {
        return houseDiTieId;
    }

    public void setHouseDiTieId(Integer houseDiTieId) {
        this.houseDiTieId = houseDiTieId;
    }

    public String getHouseQuYuName() {
        return houseQuYuName;
    }

    public void setHouseQuYuName(String houseQuYuName) {
        this.houseQuYuName = houseQuYuName;
    }

    public String getHouseDiTieName() {
        return houseDiTieName;
    }

    public void setHouseDiTieName(String houseDiTieName) {
        this.houseDiTieName = houseDiTieName;
    }

    public Integer getHouseZuQi() {
        return houseZuQi;
    }

    public void setHouseZuQi(Integer houseZuQi) {
        this.houseZuQi = houseZuQi;
    }
}
