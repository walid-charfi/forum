package org.formation.forum.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Message.
 */
@Entity
@Table(name = "message")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "content")
    private String content;

    @Column(name = "post_date")
    private LocalDate postDate;

    @OneToMany(mappedBy = "message")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "reponses", "topic", "user", "message" }, allowSetters = true)
    private Set<Message> reponses = new HashSet<>();

    @ManyToOne
    private Topic topic;

    @ManyToOne
    private User user;

    @ManyToOne
    @JsonIgnoreProperties(value = { "reponses", "topic", "user", "message" }, allowSetters = true)
    private Message message;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Message id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return this.subject;
    }

    public Message subject(String subject) {
        this.setSubject(subject);
        return this;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return this.content;
    }

    public Message content(String content) {
        this.setContent(content);
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPostDate() {
        return this.postDate;
    }

    public Message postDate(LocalDate postDate) {
        this.setPostDate(postDate);
        return this;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public Set<Message> getReponses() {
        return this.reponses;
    }

    public void setReponses(Set<Message> messages) {
        if (this.reponses != null) {
            this.reponses.forEach(i -> i.setMessage(null));
        }
        if (messages != null) {
            messages.forEach(i -> i.setMessage(this));
        }
        this.reponses = messages;
    }

    public Message reponses(Set<Message> messages) {
        this.setReponses(messages);
        return this;
    }

    public Message addReponses(Message message) {
        this.reponses.add(message);
        message.setMessage(this);
        return this;
    }

    public Message removeReponses(Message message) {
        this.reponses.remove(message);
        message.setMessage(null);
        return this;
    }

    public Topic getTopic() {
        return this.topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Message topic(Topic topic) {
        this.setTopic(topic);
        return this;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message user(User user) {
        this.setUser(user);
        return this;
    }

    public Message getMessage() {
        return this.message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message message(Message message) {
        this.setMessage(message);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Message)) {
            return false;
        }
        return id != null && id.equals(((Message) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Message{" +
            "id=" + getId() +
            ", subject='" + getSubject() + "'" +
            ", content='" + getContent() + "'" +
            ", postDate='" + getPostDate() + "'" +
            "}";
    }
}
