package com.example.midtermlistview;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
    private String id;

    public Data(String id, String nodeId, String fullName, String languageUrl, String eventsUrl) {
        this.id = id;
        this.nodeId = nodeId;
        this.fullName = fullName;
        this.languageUrl = languageUrl;
        this.eventsUrl = eventsUrl;
    }

    private String nodeId;
    private String fullName;
    private String languageUrl;
    private String eventsUrl;

    protected Data(Parcel in) {
        id = in.readString();
        nodeId = in.readString();
        fullName = in.readString();
        languageUrl = in.readString();
        eventsUrl = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLanguageUrl() {
        return languageUrl;
    }

    public void setLanguageUrl(String languageUrl) {
        this.languageUrl = languageUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nodeId);
        dest.writeString(fullName);
        dest.writeString(languageUrl);
        dest.writeString(eventsUrl);
    }
}
