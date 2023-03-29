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
 * @TableName VisitRecord
 */
@TableName(value ="VisitRecord")
@Data
public class Visitrecord implements Serializable {
    /**
     * 
     */
    @TableId(value = "RecordID")
    private Integer recordid;

    /**
     * 
     */
    @TableField(value = "EmployeeID")
    private Integer employeeid;

    /**
     * 
     */
    @TableField(value = "VisitorID")
    private Integer visitorid;

    /**
     * 
     */
    @TableField(value = "VehicleID")
    private Integer vehicleid;

    /**
     * 
     */
    @TableField(value = "RecordTime")
    private Date recordtime;

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
        Visitrecord other = (Visitrecord) that;
        return (this.getRecordid() == null ? other.getRecordid() == null : this.getRecordid().equals(other.getRecordid()))
            && (this.getEmployeeid() == null ? other.getEmployeeid() == null : this.getEmployeeid().equals(other.getEmployeeid()))
            && (this.getVisitorid() == null ? other.getVisitorid() == null : this.getVisitorid().equals(other.getVisitorid()))
            && (this.getVehicleid() == null ? other.getVehicleid() == null : this.getVehicleid().equals(other.getVehicleid()))
            && (this.getRecordtime() == null ? other.getRecordtime() == null : this.getRecordtime().equals(other.getRecordtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecordid() == null) ? 0 : getRecordid().hashCode());
        result = prime * result + ((getEmployeeid() == null) ? 0 : getEmployeeid().hashCode());
        result = prime * result + ((getVisitorid() == null) ? 0 : getVisitorid().hashCode());
        result = prime * result + ((getVehicleid() == null) ? 0 : getVehicleid().hashCode());
        result = prime * result + ((getRecordtime() == null) ? 0 : getRecordtime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recordid=").append(recordid);
        sb.append(", employeeid=").append(employeeid);
        sb.append(", visitorid=").append(visitorid);
        sb.append(", vehicleid=").append(vehicleid);
        sb.append(", recordtime=").append(recordtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}