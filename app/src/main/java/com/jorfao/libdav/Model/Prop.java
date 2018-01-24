package com.jorfao.libdav.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;


@Root(name = "response", strict = false)
public class Prop {

    @Path("propstat/prop")
    @Element(name = "displayname", required = false)
    private String mName;

    @Element(name = "href", required = false)
    private String mPath;

    @Path("propstat")
    @Element(name = "status", required = false)
    private String mStatus;

    @Path("propstat/prop")
    @Element(name = "getcontentlength", required = false)
    private String mContentLength;

    @Path("propstat/prop")
    @Element(name = "getetag", required = false)
    private String mTag;

    @Path("propstat/prop")
    @Element(name = "getcontenttype", required = false)
    private String mContentType;

    @Path("propstat/prop")
    @Element(name = "creationdate", required = false)
    private String mCreationDate;

    @Path("propstat/prop")
    @Element(name = "getlastmodified", required = false)
    private String mLastModified;

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        this.mStatus = status;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String mTag) {
        this.mTag = mTag;
    }

    public String getCreationDate() {
        return mCreationDate;
    }

    public void setCreationDate(String creationDate) {
        this.mCreationDate = mCreationDate;
    }

    public String getLastModified() {
        return mLastModified;
    }

    public void setLastModified(String lastModified) {
        this.mLastModified = mLastModified;
    }

    public String getContentLength() {
        return mContentLength;
    }

    public void setContentLength(String contentLength) {
        this.mContentLength = contentLength;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        this.mPath = path;
    }

    public String getContentType() {
        return mContentType;
    }

    public void setContentType(String contentType) {
        this.mContentType = contentType;
    }

    public Prop() {
    }

    public Prop(String name, String path, String status, String tag, String contentType, String creationDate, String lastModified) {
        mName = name;
        mPath = path;
        mStatus = status;
        mTag = tag;
        mContentType = contentType;
        mCreationDate = creationDate;
        mLastModified = lastModified;
    }
}
