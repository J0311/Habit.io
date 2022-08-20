//package com.juggernauts.todoapp.models;
//
//import lombok.*;
//import org.hibernate.annotations.LazyCollection;
//import org.hibernate.annotations.LazyCollectionOption;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "groups")
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//public class Group {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "group_id")
//    private int groupId;
//
//    @Column(nullable = false, columnDefinition = "VARCHAR(32)")
//    private String name;
//
//    // taken out due to many to many
////    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "group")
////    @JoinColumn(name = "group_member_id")
////    List<GroupMember> groupMembers;
//
//    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "group")
//    @LazyCollection(LazyCollectionOption.FALSE)
//    List<Task> tasks;
//
////    @OneToMany(cascade = CascadeType.MERGE,  mappedBy = "group")
////    @LazyCollection(LazyCollectionOption.FALSE)
////    List<GroupMember> groupMembers;
//
//    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//    List<User> users;
//
//    public Group(String name) {
//        this.name = name;
//    }
//}
