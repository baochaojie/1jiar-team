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
    private  String name;       //房主名字
    private  String phoneNum;   //房主的联系方式

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    private  String houseManName;//用户姓名
    private  Integer houseJianzhuMianji;//建筑面积
    private  String houseTaoneiMianji;//套内面积
    private  String houseTypeId;//房型id 关联一张房屋类型表
    private  String  houseTypeName;//房型名
    private  Integer houseUseId;//用途id 关联一张房屋用途表
    private  String  houseUseName;//房型名
    private  Integer houseFloorTypeId;//楼层类型表id 关联一张楼层类型表
    private  String  houseFloorTypeName;//楼层类型名
    private  String houseDirectionId;//房屋朝向表id 关联一张房屋朝向表
    private  String  houseDirectionName;//房屋朝向名
    private  Integer houseAgeId;//楼龄id 关联一张楼龄表
    private  String  houseAgeName;//楼龄名
    private  Integer ZuTypeid;//租房方式id 关联一张租房表
    private  String  houseZuTypeName;//租房方式 1整租 2合租
    private  String  houseTeSeId;//房屋特色id 关联一张房屋特色表
    private  String  TeSeName;//房屋特色名
    private  String  agentId;//经纪人关联表id 关联一张经纪人表
    private  String  agentName;//经纪人名
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
    private  String houseImg;//图片
    //临时
    private Integer	startPrice;//开始价格
    private Integer	endPrice;//结束价格
    private Integer	houseQuYuFuId;//地区临时字段
    private Integer	houseDiTieFuId;//地铁线路临时字段
    private Integer	intid;//排序类型临时字段


    public String getHouseImg() {
        return houseImg;
    }

    public void setHouseImg(String houseImg) {
        this.houseImg = houseImg;
    }

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

    public Integer getHouseJianzhuMianji() {
        return houseJianzhuMianji;
    }

    public void setHouseJianzhuMianji(Integer houseJianzhuMianji) {
        this.houseJianzhuMianji = houseJianzhuMianji;
    }

    public String getHouseTaoneiMianji() {
        return houseTaoneiMianji;
    }

    public void setHouseTaoneiMianji(String houseTaoneiMianji) {
        this.houseTaoneiMianji = houseTaoneiMianji;
    }

    public String getHouseTypeId() {
        return houseTypeId;
    }

    public void setHouseTypeId(String houseTypeId) {
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

    public String getHouseDirectionId() {
        return houseDirectionId;
    }

    public void setHouseDirectionId(String houseDirectionId) {
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

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Integer endPrice) {
        this.endPrice = endPrice;
    }

    public String getHouseAgeName() {
        return houseAgeName;
    }

    public void setHouseAgeName(String houseAgeName) {
        this.houseAgeName = houseAgeName;
    }

    public String getHouseDirectionName() {
        return houseDirectionName;
    }

    public void setHouseDirectionName(String houseDirectionName) {
        this.houseDirectionName = houseDirectionName;
    }

    public String getHouseFloorTypeName() {
        return houseFloorTypeName;
    }

    public void setHouseFloorTypeName(String houseFloorTypeName) {
        this.houseFloorTypeName = houseFloorTypeName;
    }

    public String getHouseTypeName() {
        return houseTypeName;
    }

    public void setHouseTypeName(String houseTypeName) {
        this.houseTypeName = houseTypeName;
    }

    public String getHouseUseName() {
        return houseUseName;
    }

    public void setHouseUseName(String houseUseName) {
        this.houseUseName = houseUseName;
    }

    public Integer getHouseQuYuFuId() {
        return houseQuYuFuId;
    }

    public void setHouseQuYuFuId(Integer houseQuYuFuId) {
        this.houseQuYuFuId = houseQuYuFuId;
    }

    public Integer getHouseDiTieFuId() {
        return houseDiTieFuId;
    }

    public void setHouseDiTieFuId(Integer houseDiTieFuId) {
        this.houseDiTieFuId = houseDiTieFuId;
    }

    public Integer getZuTypeid() {
        return ZuTypeid;
    }

    public void setZuTypeid(Integer zuTypeid) {
        ZuTypeid = zuTypeid;
    }

    public String getHouseZuTypeName() {
        return houseZuTypeName;
    }

    public void setHouseZuTypeName(String houseZuTypeName) {
        this.houseZuTypeName = houseZuTypeName;
    }

    public String getHouseTeSeId() {
        return houseTeSeId;
    }

    public void setHouseTeSeId(String houseTeSeId) {
        this.houseTeSeId = houseTeSeId;
    }

    public String getTeSeName() {
        return TeSeName;
    }

    public void setTeSeName(String teSeName) {
        TeSeName = teSeName;
    }

    public Integer getIntid() {
        return intid;
    }

    public void setIntid(Integer intid) {
        this.intid = intid;
    }

    public String getHouseManName() {
        return houseManName;
    }

    public void setHouseManName(String houseManName) {
        this.houseManName = houseManName;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }
}
