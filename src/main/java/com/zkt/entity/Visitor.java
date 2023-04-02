package com.zkt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName Visitor
 */
@TableName(value ="Visitor")
@Data
public class Visitor implements Serializable {
    /**
     * 
     */
    @TableId(value = "VisitorID",type = IdType.AUTO)
    private Integer visitorid;

    /**
     * 
     */
    @TableField(value = "Name")
    private String name;

    /**
     * 
     */
    @TableField(value = "IDCard")
    private String idcard;

    /**
     * 
     */
    @TableField(value = "CompanyName")
    private String companyname;

    /**
     * 
     */
    @TableField(value = "Reason")
    private String reason;

    /**
     * 
     */
    @TableField(value = "VisitTime")
    private Date visittime;

    /**
     * 
     */
    @TableField(value = "LeaveTime")
    private Date leavetime;

    /**
     * 标识来访人员是否来自疫情重点地区（是/否）
     */
    @TableField(value = "IsEpidemicArea")
    private Integer isepidemicarea;

    /**
     * 
     */
    @TableField(value = "Temperature")
    private Double temperature;

    /**
     * 
     */
    @TableField(value = "VehicleId")
    private String vehicleid;

    /**
     * 
     */
    @TableField(value = "enter")
    private String enter;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Visitor other = (Visitor) that;
        return (this.getVisitorid() == null ? other.getVisitorid() == null : this.getVisitorid().equals(other.getVisitorid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIdcard() == null ? other.getIdcard() == null : this.getIdcard().equals(other.getIdcard()))
            && (this.getCompanyname() == null ? other.getCompanyname() == null : this.getCompanyname().equals(other.getCompanyname()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getVisittime() == null ? other.getVisittime() == null : this.getVisittime().equals(other.getVisittime()))
            && (this.getLeavetime() == null ? other.getLeavetime() == null : this.getLeavetime().equals(other.getLeavetime()))
            && (this.getIsepidemicarea() == null ? other.getIsepidemicarea() == null : this.getIsepidemicarea().equals(other.getIsepidemicarea()))
            && (this.getTemperature() == null ? other.getTemperature() == null : this.getTemperature().equals(other.getTemperature()))
            && (this.getVehicleid() == null ? other.getVehicleid() == null : this.getVehicleid().equals(other.getVehicleid()))
            && (this.getEnter() == null ? other.getEnter() == null : this.getEnter().equals(other.getEnter()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVisitorid() == null) ? 0 : getVisitorid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIdcard() == null) ? 0 : getIdcard().hashCode());
        result = prime * result + ((getCompanyname() == null) ? 0 : getCompanyname().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getVisittime() == null) ? 0 : getVisittime().hashCode());
        result = prime * result + ((getLeavetime() == null) ? 0 : getLeavetime().hashCode());
        result = prime * result + ((getIsepidemicarea() == null) ? 0 : getIsepidemicarea().hashCode());
        result = prime * result + ((getTemperature() == null) ? 0 : getTemperature().hashCode());
        result = prime * result + ((getVehicleid() == null) ? 0 : getVehicleid().hashCode());
        result = prime * result + ((getEnter() == null) ? 0 : getEnter().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", visitorid=").append(visitorid);
        sb.append(", name=").append(name);
        sb.append(", idcard=").append(idcard);
        sb.append(", companyname=").append(companyname);
        sb.append(", reason=").append(reason);
        sb.append(", visittime=").append(visittime);
        sb.append(", leavetime=").append(leavetime);
        sb.append(", isepidemicarea=").append(isepidemicarea);
        sb.append(", temperature=").append(temperature);
        sb.append(", vehicleid=").append(vehicleid);
        sb.append(", enter=").append(enter);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}