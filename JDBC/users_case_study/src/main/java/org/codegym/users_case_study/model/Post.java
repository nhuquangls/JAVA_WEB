package org.codegym.users_case_study.model;

import java.time.LocalDateTime;

public class Post {
    private int id;
    private String title;
    private String content;
    private User user;
    private LocalDateTime createDate;
    private String photo;
    private int view;


    public Post(String title, String content, User user, LocalDateTime createDate, String photo) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.createDate = createDate;
        this.photo = photo;
    }

    public Post(int id, String title, String content, User user, LocalDateTime createDate, String photo, int view) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.createDate = createDate;
        this.photo = photo;
        this.view = view;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
