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
 * @TableName TemperatureRecord
 */
@TableName(value ="TemperatureRecord")
@Data
public class TemperatureRecord implements Serializable {
    /**
     * 
     */
    @TableId(value = "RecordID", type = IdType.AUTO)
    private Integer recordid;

    /**
     * 
     */
    @TableField(value = "VisitorID")
    private Integer visitorid;

    /**
     * 
     */
    @TableField(value = "MeasureTime")
    private Date measuretime;

    /**
     * 
     */
    @TableField(value = "Temperature")
    private Double temperature;

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
        TemperatureRecord other = (TemperatureRecord) that;
        return (this.getRecordid() == null ? other.getRecordid() == null : this.getRecordid().equals(other.getRecordid()))
            && (this.getVisitorid() == null ? other.getVisitorid() == null : this.getVisitorid().equals(other.getVisitorid()))
            && (this.getMeasuretime() == null ? other.getMeasuretime() == null : this.getMeasuretime().equals(other.getMeasuretime()))
            && (this.getTemperature() == null ? other.getTemperature() == null : this.getTemperature().equals(other.getTemperature()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecordid() == null) ? 0 : getRecordid().hashCode());
        result = prime * result + ((getVisitorid() == null) ? 0 : getVisitorid().hashCode());
        result = prime * result + ((getMeasuretime() == null) ? 0 : getMeasuretime().hashCode());
        result = prime * result + ((getTemperature() == null) ? 0 : getTemperature().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recordid=").append(recordid);
        sb.append(", visitorid=").append(visitorid);
        sb.append(", measuretime=").append(measuretime);
        sb.append(", temperature=").append(temperature);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}