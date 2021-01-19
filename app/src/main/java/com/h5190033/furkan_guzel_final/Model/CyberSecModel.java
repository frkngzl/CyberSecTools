package com.h5190033.furkan_guzel_final.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//İnternetten json to java çevirici kullanarak hazırlanmış CyberSecModel dosyası.
public class CyberSecModel {

    @SerializedName("ToolName")
    @Expose
    private String toolName;
    @SerializedName("Creator")
    @Expose
    private String creator;
    @SerializedName("ImageURL")
    @Expose
    private String imageURL;
    @SerializedName("HeaderImageURL")
    @Expose
    private String headerImageURL;
    @SerializedName("Website")
    @Expose
    private String website;
    @SerializedName("Stable Release")
    @Expose
    private String stableRelease;
    @SerializedName("Description")
    @Expose
    private String description;

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getHeaderImageURL() {
        return headerImageURL;
    }

    public void setHeaderImageURL(String headerImageURL) {
        this.headerImageURL = headerImageURL;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getStableRelease() {
        return stableRelease;
    }

    public void setStableRelease(String stableRelease) {
        this.stableRelease = stableRelease;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
