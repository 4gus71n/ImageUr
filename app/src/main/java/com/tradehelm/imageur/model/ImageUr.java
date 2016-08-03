package com.tradehelm.imageur.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Agustin Tomas Larghi on 02/08/2016.
 * Email: agustin.tomas.larghi@gmail.com
 * Note: I know that using Parcelable is better in performance but the difference in performance
 * about using Parcelable and Serializable is minimum, and using Serializable makes the things
 * really easy when sending data through Intent's bundles.
 */
public class ImageUr implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private Object description;
    @SerializedName("datetime")
    private Integer datetime;
    @SerializedName("type")
    private String type;
    @SerializedName("animated")
    private Boolean animated;
    @SerializedName("width")
    private Integer width;
    @SerializedName("height")
    private Integer height;
    @SerializedName("size")
    private Integer size;
    @SerializedName("views")
    private Integer views;
    @SerializedName("vote")
    private Integer vote;
    @SerializedName("favorite")
    private Boolean favorite;
    @SerializedName("nsfw")
    private Boolean nsfw;
    @SerializedName("section")
    private String section;
    @SerializedName("account_url")
    private Object accountUrl;
    @SerializedName("account_id")
    private Object accountId;
    @SerializedName("in_gallery")
    private Boolean inGallery;
    @SerializedName("link")
    private String link;
    @SerializedName("is_ad")
    private Boolean isAd;
    @SerializedName("comment_count")
    private Object commentCount;
    @SerializedName("ups")
    private Object ups;
    @SerializedName("downs")
    private Object downs;
    @SerializedName("points")
    private Object points;
    @SerializedName("score")
    private Integer score;
    @SerializedName("is_album")
    private Boolean isAlbum;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The description
     */
    public Object getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(Object description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The datetime
     */
    public Integer getDatetime() {
        return datetime;
    }

    /**
     *
     * @param datetime
     * The datetime
     */
    public void setDatetime(Integer datetime) {
        this.datetime = datetime;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The animated
     */
    public Boolean getAnimated() {
        return animated;
    }

    /**
     *
     * @param animated
     * The animated
     */
    public void setAnimated(Boolean animated) {
        this.animated = animated;
    }

    /**
     *
     * @return
     * The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     *
     * @return
     * The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     *
     * @return
     * The size
     */
    public Integer getSize() {
        return size;
    }

    /**
     *
     * @param size
     * The size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     *
     * @return
     * The views
     */
    public Integer getViews() {
        return views;
    }

    /**
     *
     * @param views
     * The views
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     *
     * @return
     * The vote
     */
    public Integer getVote() {
        return vote;
    }

    /**
     *
     * @param vote
     * The vote
     */
    public void setVote(Integer vote) {
        this.vote = vote;
    }

    /**
     *
     * @return
     * The favorite
     */
    public Boolean getFavorite() {
        return favorite;
    }

    /**
     *
     * @param favorite
     * The favorite
     */
    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    /**
     *
     * @return
     * The nsfw
     */
    public Boolean getNsfw() {
        return nsfw;
    }

    /**
     *
     * @param nsfw
     * The nsfw
     */
    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    /**
     *
     * @return
     * The section
     */
    public String getSection() {
        return section;
    }

    /**
     *
     * @param section
     * The section
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     *
     * @return
     * The accountUrl
     */
    public Object getAccountUrl() {
        return accountUrl;
    }

    /**
     *
     * @param accountUrl
     * The account_url
     */
    public void setAccountUrl(Object accountUrl) {
        this.accountUrl = accountUrl;
    }

    /**
     *
     * @return
     * The accountId
     */
    public Object getAccountId() {
        return accountId;
    }

    /**
     *
     * @param accountId
     * The account_id
     */
    public void setAccountId(Object accountId) {
        this.accountId = accountId;
    }

    /**
     *
     * @return
     * The inGallery
     */
    public Boolean getInGallery() {
        return inGallery;
    }

    /**
     *
     * @param inGallery
     * The in_gallery
     */
    public void setInGallery(Boolean inGallery) {
        this.inGallery = inGallery;
    }

    /**
     *
     * @return
     * The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @return
     * The isAd
     */
    public Boolean getIsAd() {
        return isAd;
    }

    /**
     *
     * @param isAd
     * The is_ad
     */
    public void setIsAd(Boolean isAd) {
        this.isAd = isAd;
    }

    /**
     *
     * @return
     * The commentCount
     */
    public Object getCommentCount() {
        return commentCount;
    }

    /**
     *
     * @param commentCount
     * The comment_count
     */
    public void setCommentCount(Object commentCount) {
        this.commentCount = commentCount;
    }

    /**
     *
     * @return
     * The ups
     */
    public Object getUps() {
        return ups;
    }

    /**
     *
     * @param ups
     * The ups
     */
    public void setUps(Object ups) {
        this.ups = ups;
    }

    /**
     *
     * @return
     * The downs
     */
    public Object getDowns() {
        return downs;
    }

    /**
     *
     * @param downs
     * The downs
     */
    public void setDowns(Object downs) {
        this.downs = downs;
    }

    /**
     *
     * @return
     * The points
     */
    public Object getPoints() {
        return points;
    }

    /**
     *
     * @param points
     * The points
     */
    public void setPoints(Object points) {
        this.points = points;
    }

    /**
     *
     * @return
     * The score
     */
    public Integer getScore() {
        return score;
    }

    /**
     *
     * @param score
     * The score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     *
     * @return
     * The isAlbum
     */
    public Boolean getIsAlbum() {
        return isAlbum;
    }

    /**
     *
     * @param isAlbum
     * The is_album
     */
    public void setIsAlbum(Boolean isAlbum) {
        this.isAlbum = isAlbum;
    }
}
