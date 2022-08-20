//<<<<<<< HEAD
//////package com.juggernauts.todoapp.models;
//////
//////import lombok.*;
//////
//////import javax.persistence.*;
//////
//////@Entity
//////@Table(name = "group_members")
//////@Getter
//////@Setter
//////@ToString
//////@NoArgsConstructor
//////@AllArgsConstructor
//////public class GroupMember {
//////
////<<<<<<< HEAD
////=======
//////    // NON-RELATIONAL FIELDS
//////
////>>>>>>> f7791cd5abc766eb0f668e623c688b21a342ebcb
//////    @Id
//////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//////    @Column(name="group_member_id")
//////    private int groupMemberId;
//////
//////    @Column(name = "is_admin",columnDefinition = "BOOLEAN DEFAULT FALSE")
//////    private boolean isAdmin;
//////
////<<<<<<< HEAD
//////    @Column(name = "user_id",nullable = false, columnDefinition = "INTEGER")
//////    private int userId;
//////
//////    @Column(name = "group_id", nullable = false, columnDefinition = "INTEGER")
//////    private int groupId;
//////}
////=======
//////
//////    // RELATIONAL FIELDS
//////
//////    // used in previous version
////////    @Column(name = "user_id",nullable = false, columnDefinition = "INTEGER")
////////    private int userId;
////////
////////    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
////////    @JoinColumn(name = "user_id", referencedColumnName = "user_id", columnDefinition = "INTEGER")
////////    private User user;
//////
//////    // used in previous version
////////    @Column(name = "group_id", nullable = false, columnDefinition = "INTEGER")
////////    private int groupId;
//////
////////    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
////////    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
////////    private Group group;
////////
////////    public GroupMember(boolean isAdmin, User user) {
////////        this.isAdmin = isAdmin;
////////        this.user = user;
////////    }
//////}
////>>>>>>> f7791cd5abc766eb0f668e623c688b21a342ebcb
//=======
////package com.juggernauts.todoapp.models;
////
////import lombok.*;
////
////import javax.persistence.*;
////
////@Entity
////@Table(name = "group_members")
////@Getter
////@Setter
////@ToString
////@NoArgsConstructor
////@AllArgsConstructor
////public class GroupMember {
////
////    // NON-RELATIONAL FIELDS
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    @Column(name="group_member_id")
////    private int groupMemberId;
////
////    @Column(name = "is_admin",columnDefinition = "BOOLEAN DEFAULT FALSE")
////    private boolean isAdmin;
////
////
////    // RELATIONAL FIELDS
////
////    // used in previous version
//////    @Column(name = "user_id",nullable = false, columnDefinition = "INTEGER")
//////    private int userId;
//////
//////    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//////    @JoinColumn(name = "user_id", referencedColumnName = "user_id", columnDefinition = "INTEGER")
//////    private User user;
////
////    // used in previous version
//////    @Column(name = "group_id", nullable = false, columnDefinition = "INTEGER")
//////    private int groupId;
////
//////    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//////    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
//////    private Group group;
//////
//////    public GroupMember(boolean isAdmin, User user) {
//////        this.isAdmin = isAdmin;
//////        this.user = user;
//////    }
////}
////>>>>>>> 796e809eed8afdfde397ebaebd71459a8e78e6d5
