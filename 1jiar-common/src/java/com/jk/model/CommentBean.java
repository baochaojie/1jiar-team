package com.jk.model;

public class CommentBean {
    private Integer id;//评论id
    private String content;//评论内容
    private String agentId;//关联经济人id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    @Override
    public String toString() {
        return "CommentBean{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", agentId='" + agentId + '\'' +
                '}';
    }
}
