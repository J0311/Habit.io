//package com.juggernauts.todoapp.services;

//import com.juggernauts.todoapp.models.EmailVerification;
//import com.juggernauts.todoapp.models.GroupMember;
//import com.juggernauts.todoapp.repos.EmailVerificationRepo;
//import com.juggernauts.todoapp.repos.GroupMemberRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class GroupMemberService {
//    private GroupMemberRepo groupMemberRepo;
//
//    @Autowired
//    public void setGroupMemberRepo(GroupMemberRepo groupMemberRepo) {this.groupMemberRepo = groupMemberRepo;}
//
//    public String addGroupMember(GroupMember groupMember) {
//        groupMemberRepo.save(groupMember);
//        return groupMember.toString();
//    };
//}
