package com.demo.hibernate.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Author: hemraj
 * Date:  2/20/18.
 */
@Entity
@Table(name = "instructor_detail", schema = "hb-01-one-to-one-uni", catalog = "")
public class InstructorDetailEntity {
    private int id;
    private String youtubeChannel;
    private String hobby;

    //    Add field for instructor and getter/setter
    private InstructorEntity instructor;


    public InstructorDetailEntity(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }


    public InstructorDetailEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "youtube_channel")
    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    @Basic
    @Column(name = "hobby")
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    public InstructorEntity getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorEntity instructor) {
        this.instructor = instructor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorDetailEntity that = (InstructorDetailEntity) o;
        return id == that.id &&
                Objects.equals(youtubeChannel, that.youtubeChannel) &&
                Objects.equals(hobby, that.hobby);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, youtubeChannel, hobby);
    }

    @Override
    public String toString() {
        return "InstructorDetailEntity{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
