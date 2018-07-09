package com.example.karaens.goodplays;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonLyrics {
    @SerializedName("message")
    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public static class Message {
        @SerializedName("header")
        private Header header;
        @SerializedName("body")
        private Body body;

        public Header getHeader() {
            return header;
        }

        public void setHeader(Header header) {
            this.header = header;
        }

        public Body getBody() {
            return body;
        }

        public void setBody(Body body) {
            this.body = body;
        }

    }

    public static class Lyrics {
        @SerializedName("lyrics_id")
        private Integer lyrics_id;
        @SerializedName("can_edit")
        private Integer can_edit;
        @SerializedName("locked")
        private Integer locked;
        @SerializedName("published_status")
        private Integer published_status;
        @SerializedName("action_requested")
        private String action_requested;
        @SerializedName("verified")
        private Integer verified;
        @SerializedName("restricted")
        private Integer restricted;
        @SerializedName("instrumental")
        private Integer instrumental;
        @SerializedName("explicit")
        private Integer explicit;
        @SerializedName("lyrics_body")
        private String lyrics_body;
        @SerializedName("lyrics_language")
        private String lyrics_language;
        @SerializedName("lyrics_language_description")
        private String lyrics_language_description;
        @SerializedName("script_tracking_url")
        private String script_tracking_url;
        @SerializedName("pixel_tracking_url")
        private String pixel_tracking_url;
        @SerializedName("html_tracking_url")
        private String html_tracking_url;
        @SerializedName("lyrics_copyright")
        private String lyrics_copyright;
        @SerializedName("writer_list")
        private List<Object> writer_list = null;
        @SerializedName("publisher_list")
        private List<Object> publisher_list = null;
        @SerializedName("backlink_url")
        private String backlink_url;
        @SerializedName("updated_time")
        private String updated_time;

        public Integer getLyrics_id() {
            return lyrics_id;
        }

        public void setLyrics_id(Integer lyrics_id) {
            this.lyrics_id = lyrics_id;
        }

        public Integer getCan_edit() {
            return can_edit;
        }

        public void setCan_edit(Integer can_edit) {
            this.can_edit = can_edit;
        }

        public Integer getLocked() {
            return locked;
        }

        public void setLocked(Integer locked) {
            this.locked = locked;
        }

        public Integer getPublished_status() {
            return published_status;
        }

        public void setPublished_status(Integer published_status) {
            this.published_status = published_status;
        }

        public String getAction_requested() {
            return action_requested;
        }

        public void setAction_requested(String action_requested) {
            this.action_requested = action_requested;
        }

        public Integer getVerified() {
            return verified;
        }

        public void setVerified(Integer verified) {
            this.verified = verified;
        }

        public Integer getRestricted() {
            return restricted;
        }

        public void setRestricted(Integer restricted) {
            this.restricted = restricted;
        }

        public Integer getInstrumental() {
            return instrumental;
        }

        public void setInstrumental(Integer instrumental) {
            this.instrumental = instrumental;
        }

        public Integer getExplicit() {
            return explicit;
        }

        public void setExplicit(Integer explicit) {
            this.explicit = explicit;
        }

        public String getLyrics_body() {
            return lyrics_body;
        }

        public void setLyrics_body(String lyrics_body) {
            this.lyrics_body = lyrics_body;
        }

        public String getLyrics_language() {
            return lyrics_language;
        }

        public void setLyrics_language(String lyrics_language) {
            this.lyrics_language = lyrics_language;
        }

        public String getLyrics_language_description() {
            return lyrics_language_description;
        }

        public void setLyrics_language_description(String lyrics_language_description) {
            this.lyrics_language_description = lyrics_language_description;
        }

        public String getScript_tracking_url() {
            return script_tracking_url;
        }

        public void setScript_tracking_url(String script_tracking_url) {
            this.script_tracking_url = script_tracking_url;
        }

        public String getPixel_tracking_url() {
            return pixel_tracking_url;
        }

        public void setPixel_tracking_url(String pixel_tracking_url) {
            this.pixel_tracking_url = pixel_tracking_url;
        }

        public String getHtml_tracking_url() {
            return html_tracking_url;
        }

        public void setHtml_tracking_url(String html_tracking_url) {
            this.html_tracking_url = html_tracking_url;
        }

        public String getLyrics_copyright() {
            return lyrics_copyright;
        }

        public void setLyrics_copyright(String lyrics_copyright) {
            this.lyrics_copyright = lyrics_copyright;
        }

        public List<Object> getWriter_list() {
            return writer_list;
        }

        public void setWriter_list(List<Object> writer_list) {
            this.writer_list = writer_list;
        }

        public List<Object> getPublisher_list() {
            return publisher_list;
        }

        public void setPublisher_list(List<Object> publisher_list) {
            this.publisher_list = publisher_list;
        }

        public String getBacklink_url() {
            return backlink_url;
        }

        public void setBacklink_url(String backlink_url) {
            this.backlink_url = backlink_url;
        }

        public String getUpdated_time() {
            return updated_time;
        }

        public void setUpdated_time(String updated_time) {
            this.updated_time = updated_time;
        }
    }

    public static class Header {
        @SerializedName("status_code")
        private Integer status_code;
        @SerializedName("execute_time")
        private Double execute_time;

        public Integer getStatus_code() {
            return status_code;
        }

        public void setStatus_code(Integer status_code) {
            this.status_code = status_code;
        }

        public Double getExecute_time() {
            return execute_time;
        }

        public void setExecute_time(Double execute_time) {
            this.execute_time = execute_time;
        }
    }

    public static class Body {
        @SerializedName("lyrics")
        private Lyrics lyrics;

        public Lyrics getLyrics() {
            return lyrics;
        }

        public void setLyrics(Lyrics lyrics) {
            this.lyrics = lyrics;
        }
    }
}

