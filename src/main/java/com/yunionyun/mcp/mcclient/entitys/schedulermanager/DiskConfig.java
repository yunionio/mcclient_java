package com.yunionyun.mcp.mcclient.entitys.schedulermanager;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * @author zxc
 * @date 2020/02/05
 */
public class DiskConfig {
    @JSONField(name = "index")
    private int index;

    @JSONField(name = "image_id")
    private String imageId;

    @JSONField(name = "snapshot_id")
    private String snapshotId;

    @JSONField(name = "disk_type")
    private String diskType;

    @JSONField(name = "schedtags")
    private SchedtagConfig[] schedtags;

    @JSONField(name = "size")
    private int sizeMb;

    @JSONField(name = "fs")
    private String fs;

    @JSONField(name = "format")
    private String format;

    @JSONField(name = "driver")
    private String driver;

    @JSONField(name = "cache")
    private String cache;

    @JSONField(name = "mountpoint")
    private String mountpoint;

    @JSONField(name = "backend")
    private String backend;

    @JSONField(name = "medium")
    private String medium;

    @JSONField(name = "image_properties")
    private Map<String,String> imageProperties;

    @JSONField(name = "storage_id")
    private String storage;

    @JSONField(name = "disk_id")
    private String diskId;


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public String getDiskType() {
        return diskType;
    }

    public void setDiskType(String diskType) {
        this.diskType = diskType;
    }

    public SchedtagConfig[] getSchedtags() {
        return schedtags;
    }

    public void setSchedtags(SchedtagConfig[] schedtags) {
        this.schedtags = schedtags;
    }

    public int getSizeMb() {
        return sizeMb;
    }

    public void setSizeMb(int sizeMb) {
        this.sizeMb = sizeMb;
    }

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    public String getMountpoint() {
        return mountpoint;
    }

    public void setMountpoint(String mountpoint) {
        this.mountpoint = mountpoint;
    }

    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public Map<String, String> getImageProperties() {
        return imageProperties;
    }

    public void setImageProperties(Map<String, String> imageProperties) {
        this.imageProperties = imageProperties;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getDiskId() {
        return diskId;
    }

    public void setDiskId(String diskId) {
        this.diskId = diskId;
    }
}
