package com.federal.drisyaHome.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity(name = "CircularFiles")
@Table(name = "Circular_Files")
public class CircularFiles {
    @Id
    @Column(name = "CIRCULAR_HEADLINE")
    private String circularHeadline;
    @Column(name = "DOC_TYPE")
    private String doc_type;
    @Column(name = "DOC_NAME")
    private String doc_name;
    @Column(name = "PDF")
    @Lob
    private byte[] pdf;


    public String getCircularHeadline() {
        return circularHeadline;
    }

    public void setCircularHeadline(String circularHeadline) {
        this.circularHeadline = circularHeadline;
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
                "\"circularHeadline\":" +"\""+ circularHeadline + "\"" +
                ",\"doc_type\":" +"\""+ doc_type + "\"" +
                ",\"doc_name\":" +"\""+ doc_name + "\"" +
                ",\"pdf\":" + Arrays.toString(pdf) +
                '}';
    }
}

