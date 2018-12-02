package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

public class Chapter implements Serializable {
    private Integer id;

    private String title;

    private String size;

    private String duration;

    private String duwnPath;

    private Date uploadDate;

    private Integer viwdpagerId;

    public Chapter() {
    }

    public Chapter(Integer id, String title, String size, String duration, String duwnPath, Date uploadDate, Integer viwdpagerId) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.duration = duration;
        this.duwnPath = duwnPath;
        this.uploadDate = uploadDate;
        this.viwdpagerId = viwdpagerId;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getDuwnPath() {
        return duwnPath;
    }

    public void setDuwnPath(String duwnPath) {
        this.duwnPath = duwnPath == null ? null : duwnPath.trim();
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getViwdpagerId() {
        return viwdpagerId;
    }

    public void setViwdpagerId(Integer viwdpagerId) {
        this.viwdpagerId = viwdpagerId;
    }

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
        Chapter other = (Chapter) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getDuration() == null ? other.getDuration() == null : this.getDuration().equals(other.getDuration()))
            && (this.getDuwnPath() == null ? other.getDuwnPath() == null : this.getDuwnPath().equals(other.getDuwnPath()))
            && (this.getUploadDate() == null ? other.getUploadDate() == null : this.getUploadDate().equals(other.getUploadDate()))
            && (this.getViwdpagerId() == null ? other.getViwdpagerId() == null : this.getViwdpagerId().equals(other.getViwdpagerId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getDuration() == null) ? 0 : getDuration().hashCode());
        result = prime * result + ((getDuwnPath() == null) ? 0 : getDuwnPath().hashCode());
        result = prime * result + ((getUploadDate() == null) ? 0 : getUploadDate().hashCode());
        result = prime * result + ((getViwdpagerId() == null) ? 0 : getViwdpagerId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", size=").append(size);
        sb.append(", duration=").append(duration);
        sb.append(", duwnPath=").append(duwnPath);
        sb.append(", uploadDate=").append(uploadDate);
        sb.append(", viwdpagerId=").append(viwdpagerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}