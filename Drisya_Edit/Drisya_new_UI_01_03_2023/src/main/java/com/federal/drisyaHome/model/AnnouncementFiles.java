package com.federal.drisyaHome.model;


import javax.persistence.*;
import java.util.Arrays;


@Entity(name = "AnnouncementFiles")
@Table(name = "ANNOUNCEMENT_FILES")
public class AnnouncementFiles {
    @Id
    @Column(name = "ANNOUNCEMENT_HEADLINE")
    private String announcementHeadline;
    @Column(name = "DOC_TYPE")
    private String doc_type;
    @Column(name = "DOC_NAME")
    private String doc_name;
    @Column(name = "PDF")
    @Lob
    private byte[] pdf;


    public String getAnnouncementHeadline() {
        return announcementHeadline;
    }

    public void setAnnouncementHeadline(String announcementHeadline) {
        this.announcementHeadline = announcementHeadline;
    }

    public String getDoc_type() {
        return doc_type;
    }

    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }


    @Override
    public String toString() {
        return "{" +
                "\"announcementHeadline\":" +"\""+ announcementHeadline + "\"" +
                ",\"doc_type\":" +"\""+ doc_type + "\"" +
                ",\"doc_name\":" +"\""+ doc_name + "\"" +
                ",\"pdf\":" + Arrays.toString(pdf) +
                '}';
    }

}
