package com.zkt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName Vehicle
 */
@TableName(value ="Vehicle")
@Data
public class Vehicle implements Serializable {
    /**
     * 
     */
    @TableId(value = "VehicleID")
    private Integer vehicleid;

    /**
     * 
     */
    @TableField(value = "LicensePlate")
    private String licenseplate;

    /**
     * 
     */
    @TableField(value = "VehicleType")
    private String vehicletype;

    /**
     * 
     */
    @TableField(value = "OwnerName")
    private String ownername;

    /**
     * 
     */
    @TableField(value = "OwnerPhoneNumber")
    private String ownerphonenumber;

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
        Vehicle other = (Vehicle) that;
        return (this.getVehicleid() == null ? other.getVehicleid() == null : this.getVehicleid().equals(other.getVehicleid()))
            && (this.getLicenseplate() == null ? other.getLicenseplate() == null : this.getLicenseplate().equals(other.getLicenseplate()))
            && (this.getVehicletype() == null ? other.getVehicletype() == null : this.getVehicletype().equals(other.getVehicletype()))
            && (this.getOwnername() == null ? other.getOwnername() == null : this.getOwnername().equals(other.getOwnername()))
            && (this.getOwnerphonenumber() == null ? other.getOwnerphonenumber() == null : this.getOwnerphonenumber().equals(other.getOwnerphonenumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVehicleid() == null) ? 0 : getVehicleid().hashCode());
        result = prime * result + ((getLicenseplate() == null) ? 0 : getLicenseplate().hashCode());
        result = prime * result + ((getVehicletype() == null) ? 0 : getVehicletype().hashCode());
        result = prime * result + ((getOwnername() == null) ? 0 : getOwnername().hashCode());
        result = prime * result + ((getOwnerphonenumber() == null) ? 0 : getOwnerphonenumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vehicleid=").append(vehicleid);
        sb.append(", licenseplate=").append(licenseplate);
        sb.append(", vehicletype=").append(vehicletype);
        sb.append(", ownername=").append(ownername);
        sb.append(", ownerphonenumber=").append(ownerphonenumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}